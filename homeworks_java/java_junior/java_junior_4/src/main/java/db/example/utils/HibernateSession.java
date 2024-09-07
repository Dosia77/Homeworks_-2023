package db.example.utils;

import db.example.models.Person;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {

    private static SessionFactory sessionFactory;

    private HibernateSession() {

    }
    public static SessionFactory getSessionFactory() {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();
        return sessionFactory;
    }
}
