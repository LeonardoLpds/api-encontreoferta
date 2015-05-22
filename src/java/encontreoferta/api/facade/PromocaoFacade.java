package encontreoferta.api.facade;

import encontreoferta.api.model.Promocao;
import java.util.List;
import javax.persistence.EntityManager;

public abstract class PromocaoFacade extends AbstractFacade<Promocao>{

    public PromocaoFacade(Class<Promocao> entityClass) {
        super(entityClass);
    }
    
    public List<Promocao> findByCategoria(Integer idCategoria){
        return getEntityManager().createNamedQuery("Promocao.findByCategoria")
                .setParameter("idCategoria", idCategoria)
                .getResultList();
    }
    
    @Override
    protected abstract EntityManager getEntityManager();
    
}
