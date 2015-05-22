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
        //Persiste o objeto//
        
        //Trocar para find
        Promocao promocao = new Promocao(visitante.getIdPromocao());
        
        Voucher voucher = new Voucher();
        voucher.setCodigo(codigo);
        voucher.setPromocao(promocao);
        voucher.setUsuario(usuario);
        //super.create(voucher);
        
        return voucher;
    }
    
    @Override
    protected abstract EntityManager getEntityManager();
}
