package encontreoferta.api.facade;

import encontreoferta.api.model.Voucher;
import java.util.Date;
import javax.persistence.EntityManager;
import com.google.gson.Gson;
import encontreoferta.api.model.Promocao;
import encontreoferta.api.model.Usuario;
import encontreoferta.api.model.Visitante;
import java.util.List;
import javax.inject.Inject;

public abstract class VoucherFacade extends AbstractFacade<Voucher>{
    @Inject AbstractFacade<Usuario> abstractFacade;
    public VoucherFacade(Class<Voucher> entityClass) {
        super(entityClass);
    }
    
    public Voucher gerar(String json) {
        Visitante visitante = new Gson().fromJson(json, Visitante.class);
        
        Usuario usuario = convertToUser(visitante);
        
        Promocao promocao = getPromocaoById(visitante.getIdPromocao());
        String codigo = String.valueOf(new Date().getTime());
        
        Voucher voucher = new Voucher();
        voucher.setCodigo(codigo);
        voucher.setPromocao(promocao);
        voucher.setUsuario(usuario);
        super.create(voucher);
        return voucher;
    }
    
    public List<Voucher> getByUser(Integer idUsuario){
        List<Voucher> vouchers = null;
        try{
            Usuario usuario = (Usuario) getEntityManager()
                    .createNamedQuery("Usuario.findById")
                    .setParameter("id", idUsuario)
                    .getSingleResult();
            
            vouchers = getEntityManager()
                    .createNamedQuery("Voucher.findByUser")
                    .setParameter("usuario", usuario)
                    .getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return vouchers;
    }
    
    private Usuario convertToUser(Visitante visitante){
        if(visitante.getIdUsuario() != null){
            return getUserById(visitante.getIdUsuario());
        }
        if(getUserByEmail(visitante.getEmail()) != null){
            return getUserByEmail(visitante.getEmail());
        }
        return createNewUser(visitante.getEmail());
    }
    
    private Usuario createNewUser(String email){
        try{
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            abstractFacade.create(usuario);
        }finally{
            return getUserByEmail(email);
        }
    }
    
    private Usuario getUserByEmail(String email){
        Usuario usuario = null;
        try{
            usuario =  (Usuario) getEntityManager()
                .createNamedQuery("Usuario.findByEmail")
                .setParameter("email", email)
                .getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }
        return usuario;
    }
    
    private Usuario getUserById(Integer id){
        Usuario usuario = null;
        try{
        usuario = (Usuario) getEntityManager()
                .createNamedQuery("Usuario.findById")
                .setParameter("id", id)
                .getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }
        return usuario;
    }
    
    private Promocao getPromocaoById(Integer id){
        Promocao promocao = null;
        try{
            promocao = (Promocao) getEntityManager()
                    .createNamedQuery("Promocao.findById")
                    .setParameter("id", id)
                    .getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }
        return promocao;
    }
    
    @Override
    protected abstract EntityManager getEntityManager();
}
