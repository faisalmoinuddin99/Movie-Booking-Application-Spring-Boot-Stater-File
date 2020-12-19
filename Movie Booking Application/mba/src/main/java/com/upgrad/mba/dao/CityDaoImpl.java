package com.upgrad.mba.dao;

import com.upgrad.mba.dao.CityDao;
import com.upgrad.mba.entites.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public class CityDaoImpl implements CityDao {

    private SessionFactory sessionFactory;

    @Autowired // Injecting the Dependency of Session Factory
    public CityDaoImpl(EntityManagerFactory entityManagerFactory){
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }
    @Override
    public City save(City city) {
        Session session = this.sessionFactory.openSession(); // Open a new Session and start a database transaction.
        Transaction transaction = session.beginTransaction() ;

        session.save(city) ; // Save the entity into the database

        transaction.commit();  // Commit the transaction and close the session
        session.close();
        return city ;
    }

    @Override
    public City findById(int id) {
        Session session = this.sessionFactory.openSession() ;
        Transaction transaction = session.beginTransaction();

        City city = session.get(City.class, id);

        transaction.commit();
        session.close();
        return city;
    }

    @Override
    public City update(City city) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(city);

        transaction.commit();
        session.close();
        return city;
    }

    @Override
    public void delete(City city) {

        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        City mergedCity = (City)session.merge(city); // Converting into persistant state
        session.delete(mergedCity);

        transaction.commit();
        session.close();
    }
}
