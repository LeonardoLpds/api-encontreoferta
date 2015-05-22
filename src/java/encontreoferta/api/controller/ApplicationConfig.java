package encontreoferta.api.controller;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(encontreoferta.api.controller.CategoriaFacadeREST.class);
        resources.add(encontreoferta.api.controller.NivelFacadeREST.class);
        resources.add(encontreoferta.api.controller.PromocaoFacadeREST.class);
        resources.add(encontreoferta.api.controller.UsuarioFacadeREST.class);
        resources.add(encontreoferta.api.controller.VendedorFacadeREST.class);
    }
    
}
