package encontreoferta.api.facade;

import encontreoferta.api.model.Categoria;
import encontreoferta.api.model.Nivel;
import encontreoferta.api.model.Promocao;
import java.util.List;
import javax.persistence.EntityManager;

public abstract class PromocaoFacade extends AbstractFacade<Promocao>{

    public PromocaoFacade(Class<Promocao> entityClass) {
        super(entityClass);
    }
    
    public List<Promocao> findByCategoria(Integer idCategoria){
        List<Promocao> promocoes = null;
        try{
            Categoria categoria = (Categoria) getEntityManager()
                .createNamedQuery("Categoria.findById")
                .setParameter("id", idCategoria)
                .getSingleResult();
        
            promocoes = getEntityManager().createNamedQuery("Promocao.findByCategoria")
                .setParameter("categoria", categoria)
                .getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return promocoes;
    }
    
    public List<Promocao> findByNivel(Integer idNivel){
        List<Promocao> promocoes = null;
        try{
            Nivel nivel = (Nivel) getEntityManager()
                .createNamedQuery("Nivel.findById")
                .setParameter("id", idNivel)
                .getSingleResult();
        
            promocoes = getEntityManager().createNamedQuery("Promocao.findByNivel")
                .setParameter("nivel", nivel)
                .getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return promocoes;
    }
    
    @Override
    protected abstract EntityManager getEntityManager();
    
}
