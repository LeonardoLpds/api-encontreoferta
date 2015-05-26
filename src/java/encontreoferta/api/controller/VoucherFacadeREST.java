package encontreoferta.api.controller;

import encontreoferta.api.facade.VoucherFacade;
import encontreoferta.api.model.Voucher;
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

@Stateless
@Path("voucher")
public class VoucherFacadeREST extends VoucherFacade{
    @PersistenceContext(unitName = "api.encontreofertaPU")
    private EntityManager em;

    public VoucherFacadeREST() {
        super(Voucher.class);
    }
    
    @POST
    @Override
    @Consumes("application/json")
    public void create(Voucher entity) {
        super.create(entity);
    }
    
    @POST
    @Override
    @Path("gerar")
    @Consumes("application/json")
    @Produces("application/json")
    public Voucher gerar(String json) {
        return super.gerar(json);
    }
    
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void edit(@PathParam("id") String id, Voucher entity) {
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
    public Voucher find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("usuario/{id}")
    @Produces("application/json")
    @Override
    public List<Voucher> getByUser(@PathParam("id") Integer id) {
        return super.getByUser(id);
    }
    
    @GET
    @Override
    @Produces("application/json")
    public List<Voucher> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces("application/json")
    public List<Voucher> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
