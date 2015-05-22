package encontreoferta.api.facade;

import encontreoferta.api.model.Voucher;
import java.util.Date;
import javax.persistence.EntityManager;
import com.google.gson.Gson;
import java.util.ArrayList;

public abstract class VoucherFacade extends AbstractFacade<Voucher>{

    public VoucherFacade(Class<Voucher> entityClass) {
        super(entityClass);
    }
    
    public Voucher gerar(String json) {
        String codigo = String.valueOf(new Date().getTime());
        Voucher v = new Voucher(1, codigo);
        return v;
    }
    
    @Override
    protected abstract EntityManager getEntityManager();
}
