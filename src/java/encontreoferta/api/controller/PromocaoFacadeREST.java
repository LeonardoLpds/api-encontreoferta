package encontreoferta.api.controller;

import encontreoferta.api.model.Promocao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import encontreoferta.api.facade.PromocaoFacade;

@Stateless
@Path("promocao")
public class PromocaoFacadeREST extends PromocaoFacade{
    @PersistenceContext(unitName = "api.encontreofertaPU")
    private EntityManager em;

    public PromocaoFacadeREST() {
        super(Promocao.class);
    }

    @POST
    @Override
    @Consumes("application/json")
    public void create(Promocao entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void edit(@PathParam("id") String id, Promocao entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Promocao find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces("application/json")
    public List<Promocao> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces("application/json")
    public List<Promocao> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
