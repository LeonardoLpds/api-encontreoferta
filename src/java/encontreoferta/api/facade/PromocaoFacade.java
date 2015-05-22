package encontreoferta.api.facade;

import encontreoferta.api.model.Promocao;
import javax.persistence.EntityManager;

public abstract class PromocaoFacade extends AbstractFacade<Promocao>{

    public PromocaoFacade(Class<Promocao> entityClass) {
        super(entityClass);
    }

    @Override
    protected abstract EntityManager getEntityManager();
    
}
