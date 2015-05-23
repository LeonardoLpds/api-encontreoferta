package encontreoferta.api.facade;

import encontreoferta.api.model.Voucher;
import java.util.Date;
import javax.persistence.EntityManager;
import com.google.gson.Gson;
import encontreoferta.api.model.Promocao;
import encontreoferta.api.model.Usuario;
import encontreoferta.api.model.Visitante;

public abstract class VoucherFacade extends AbstractFacade<Voucher>{

    public VoucherFacade(Class<Voucher> entityClass) {
        super(entityClass);
    }
    
    public Voucher gerar(String json) {
        String codigo = String.valueOf(new Date().getTime());
        
        Visitante visitante = new Gson().fromJson(json, Visitante.class);
        
        Usuario usuario = new Usuario();
        usuario.setEmail(visitante.getEmail());
        getEntityManager().createNamedQuery("Usuario.preRegister")
                .setParameter("email", usuario.getEmail());
        
        usuario = (Usuario) getEntityManager()
                .createNamedQuery("Usuario.findByEmail")
                .setParameter("email", usuario.getEmail())
                .getSingleResult();
        
        Promocao promocao = (Promocao) getEntityManager()
                .createNamedQuery("Promocao.findById")
                .setParameter("id", visitante.getIdPromocao())
                .getSingleResult();
        
        Voucher voucher = new Voucher();
        voucher.setCodigo(codigo);
        voucher.setPromocao(promocao);
        voucher.setUsuario(usuario);
        super.create(voucher);
        
        return voucher;
    }
    
    @Override
    protected abstract EntityManager getEntityManager();
}
