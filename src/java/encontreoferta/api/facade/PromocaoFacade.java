package encontreoferta.api.facade;

import encontreoferta.api.model.Categoria;
import encontreoferta.api.model.Promocao;
import java.util.List;
import javax.persistence.EntityManager;

public abstract class PromocaoFacade extends AbstractFacade<Promocao>{

    public PromocaoFacade(Class<Promocao> entityClass) {
        super(entityClass);
    }
    
    public List<Promocao> findByCategoria(Integer idCategoria){
        Categoria categoria = (Categoria) getEntityManager()
                .createNamedQuery("Categoria.findById")
                .setParameter("id", idCategoria)
                .getSingleResult();
        
        return getEntityManager().createNamedQuery("Promocao.findByCategoria")
                .setParameter("idCategoria", categoria)
                .getResultList();
    }
    
    @Override
    protected abstract EntityManager getEntityManager();
    
}
