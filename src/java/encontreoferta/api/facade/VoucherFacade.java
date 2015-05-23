package encontreoferta.api.facade;

import encontreoferta.api.model.Voucher;
import java.util.Date;
import javax.persistence.EntityManager;
import com.google.gson.Gson;
import encontreoferta.api.lib.HibernateUtil;
import encontreoferta.api.model.Promocao;
import encontreoferta.api.model.Usuario;
import encontreoferta.api.model.Visitante;

public abstract class VoucherFacade extends AbstractFacade<Voucher>{

    public VoucherFacade(Class<Voucher> entityClass) {
        super(entityClass);
    }
    
    public Voucher gerar(String json) {
        Visitante visitante = new Gson().fromJson(json, Visitante.class);
        
        Usuario usuario = createNewUser(visitante.getEmail());
        Promocao promocao = getPromocaoById(visitante.getIdPromocao());
        String codigo = String.valueOf(new Date().getTime());
        
        Voucher voucher = new Voucher();
        voucher.setCodigo(codigo);
        voucher.setPromocao(promocao);
        voucher.setUsuario(usuario);
        super.create(voucher);
        
        return voucher;
    }
    
    private Usuario createNewUser(String email){
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        HibernateUtil.persistObject(usuario);
        return getUserByEmail(email);
    }
    
    private Usuario getUserByEmail(String email){
        return (Usuario) getEntityManager()
                .createNamedQuery("Usuario.findByEmail")
                .setParameter("email", email)
                .getSingleResult();
    }
    
    private Promocao getPromocaoById(Integer id){
        return (Promocao) getEntityManager()
                .createNamedQuery("Promocao.findById")
                .setParameter("id", id)
                .getSingleResult();
    }
    
    @Override
    protected abstract EntityManager getEntityManager();
}
