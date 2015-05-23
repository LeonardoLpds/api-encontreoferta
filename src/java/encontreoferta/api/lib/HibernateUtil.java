package encontreoferta.api.lib;

import java.io.File;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

public final class HibernateUtil{
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final Session session = sessionFactory.openSession();
    
    private static SessionFactory buildSessionFactory()
    {
        try
        {
            return new AnnotationConfiguration()
                    .configure(new File("hibernate.cgf.xml"))
                    .buildSessionFactory();
        }
        catch (HibernateException ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static void persistObject(Object object){
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        shutdown();
    }
  
    private static void shutdown() {
        sessionFactory.close();
    }
}
