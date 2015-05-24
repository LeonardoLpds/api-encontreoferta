package encontreoferta.api.lib;

import encontreoferta.api.model.Usuario;
import encontreoferta.api.model.Visitante;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public final class UsuarioUtil extends HibernateUtil{
    @PersistenceContext(unitName = "api.encontreofertaPU")
    private static EntityManager em;
    
    public static Usuario convertVisitorInUser(Visitante visitante){
        if(visitante.getIdUsuario() != null){
            return getUserById(visitante.getIdUsuario());
        }
        return createNewUser(visitante.getEmail());
    }
    
    private static Usuario createNewUser(String email){
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        persistObject(usuario);
        return getUserByEmail(email);
    }
    
    private static Usuario getUserByEmail(String email){
        return (Usuario) em
                .createNamedQuery("Usuario.findByEmail")
                .setParameter("email", email)
                .getSingleResult();
    }
    
    private static Usuario getUserById(Integer id){
        return (Usuario) em
                .createNamedQuery("Usuario.findById")
                .setParameter("id", id)
                .getSingleResult();
    }
}
