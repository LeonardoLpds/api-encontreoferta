package encontreoferta.api.lib;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class RESTServiceResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext parContainerRequestContext, ContainerResponseContext parContainerResponseContext) throws IOException {
        parContainerResponseContext.getHeaders().add( "Access-Control-Allow-Origin", "*" );
        parContainerResponseContext.getHeaders().add( "Access-Control-Allow-Credentials", "true" );
        parContainerResponseContext.getHeaders().add( "Access-Control-Allow-Methods", "GET, POST, DELETE, PUT" );
        parContainerResponseContext.getHeaders().add( "Access-Control-Allow-Headers", "Content-Type" );
    }
}
