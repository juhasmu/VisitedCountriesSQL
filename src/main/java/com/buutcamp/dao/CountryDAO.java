package com.buutcamp.dao;

import com.buutcamp.entity.VisitedCountry;
import com.buutcamp.entity.Year;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CountryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    //get all data in the database
    @Transactional
    public List<VisitedCountry> getCountries() {
        Session session = sessionFactory.getCurrentSession();
        //session.beginTransaction();
        Query<VisitedCountry> query = session.createQuery("from VisitedCountry", VisitedCountry.class);
        //session.getTransaction().commit();
        List<VisitedCountry> list = query.getResultList();
        //session.close();
        return list;
    }
    @Transactional
    public void saveCountry(VisitedCountry visitedCountry) {

        Session session = sessionFactory.getCurrentSession();
        session.save(visitedCountry);

    }
    @Transactional
    public void saveYear(Year vuosi) {

        Session session = sessionFactory.getCurrentSession();
        session.save(vuosi);

    }
    @Transactional
    public void saveAll(VisitedCountry visitedCountry,Year vuosi) {

        Session session = sessionFactory.getCurrentSession();
        session.save(vuosi);
        session.save(visitedCountry);

    }
}
