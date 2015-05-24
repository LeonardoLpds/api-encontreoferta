package encontreoferta.api.lib;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

public abstract class HibernateUtil{
    protected final static SessionFactory sessionFactory = buildSessionFactory();
    protected final static Session session = sessionFactory.openSession();
    
    protected static SessionFactory buildSessionFactory()
    {
        try
        {
            SessionFactory s = new AnnotationConfiguration()
                    .configure().buildSessionFactory();
            return s;
        }
        catch (HibernateException ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    protected static void persistObject(Object object){
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        shutdown();
    }
  
    protected static void shutdown() {
        sessionFactory.close();
    }
}
