package com.byhovsky.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateAnnotationUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate-annotation.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Getter for property 'sessionFactory'.
     *
     * @return Value for property 'sessionFactory'.
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
