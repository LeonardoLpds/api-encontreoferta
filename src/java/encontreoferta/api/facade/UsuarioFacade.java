package encontreoferta.api.facade;

import encontreoferta.api.model.Usuario;

public abstract class UsuarioFacade extends AbstractFacade<Usuario>{

    public UsuarioFacade(Class<Usuario> entityClass) {
        super(entityClass);
    }
    
    
    public String register(Usuario usuario) {
        if(findByEmail(usuario.getEmail()) != null){
            if(findByEmail(usuario.getEmail()).getSenha() != null){
                return "{\"result\":\"erro\",\"cause\":\"Usuário já cadastrado\",\"message\":\"O email digitado já existe em nossa base de dados, tente fazer login!\"}";
            }
            edit(usuario);
            return "{\"result\":\"pre\",\"cause\":\"Pré cadastro encontrado\",\"message\":\"Obrigado por finalizar seu cadastro! Todos os seus vouchers podem ser encontrados em 'meus vouchers' em sua área de usuário\"}";
        }
        create(usuario);
        return "{\"result\":\"registered\",\"cause\":\"Usuário cadastrado com sucesso\",\"message\":\"Bem vindo! Aqui você encontra uma oferta e perde a preocupação!\"}";
    }
    
    private Usuario findByEmail(String email){
        Usuario usuario = null;
        try{
            usuario = (Usuario) getEntityManager()
                    .createNamedQuery("Usuario.findByEmail")
                    .setParameter("email", email)
                    .getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }
        return usuario;
    }
    
    private Usuario findBySenha(String senha){
        Usuario usuario = null;
        try{
            usuario = (Usuario) getEntityManager()
                    .createNamedQuery("Usuario.findBySenha")
                    .setParameter("senha", senha)
                    .getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }
        return usuario;
    }
    
    
}
