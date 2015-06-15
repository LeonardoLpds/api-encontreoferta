package encontreoferta.api.facade;

import encontreoferta.api.model.Admin;

public abstract class AdminFacade extends AbstractFacade<Admin>{

    public AdminFacade(Class<Admin> entityClass) {
        super(entityClass);
    }
    
    public Admin login(Admin admin){
        try{
            admin = (Admin) getEntityManager()
                    .createNamedQuery("Admin.login")
                    .setParameter("senha", admin.getSenha())
                    .setParameter("email", admin.getEmail())
                    .getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return admin;
    }
    
    
}
