package com.buutcamp.dao;

import com.buutcamp.entity.*;
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
    public List<AsianCountry> getAsianCountries(){
        Session session = sessionFactory.getCurrentSession();
        //session.beginTransaction();
        Query<AsianCountry> query = session.createQuery("from AsianCountry", AsianCountry.class);
        //session.getTransaction().commit();
        List<AsianCountry> list = query.getResultList();
        //session.close();
        System.out.println(list);
        return list;
    }
    @Transactional
    public List<AfricanCountry> getAfricanCountries(){
        Session session = sessionFactory.getCurrentSession();
        //session.beginTransaction();
        Query<AfricanCountry> query = session.createQuery("from AfricanCountry", AfricanCountry.class);
        //session.getTransaction().commit();
        List<AfricanCountry> list = query.getResultList();
        //session.close();
        return list;
    }
    @Transactional
    public List<EuropanCountry> getEuropanCountries(){
        Session session = sessionFactory.getCurrentSession();
        //session.beginTransaction();
        Query<EuropanCountry> query = session.createQuery("from EuropanCountry", EuropanCountry.class);
        //session.getTransaction().commit();
        List<EuropanCountry> list = query.getResultList();
        //session.close();
        return list;
    }
    @Transactional
    public List<SouthAmericanCountry> getSouthAmericanCountries(){
        Session session = sessionFactory.getCurrentSession();
        //session.beginTransaction();
        Query<SouthAmericanCountry> query = session.createQuery("from SouthAmericanCountry", SouthAmericanCountry.class);
        //session.getTransaction().commit();
        List<SouthAmericanCountry> list = query.getResultList();
        //session.close();
        return list;
    }
    @Transactional
    public List<NorthAmericanCountry> getNorthAmericanCountries(){
        Session session = sessionFactory.getCurrentSession();
        //session.beginTransaction();
        Query<NorthAmericanCountry> query = session.createQuery("from NorthAmericanCountry", NorthAmericanCountry.class);
        //session.getTransaction().commit();
        List<NorthAmericanCountry> list = query.getResultList();
        //session.close();
        return list;
    }
    @Transactional
    public List<OceanianCountry> getOceanianCountries(){
        Session session = sessionFactory.getCurrentSession();
        //session.beginTransaction();
        Query<OceanianCountry> query = session.createQuery("from OceanianCountry", OceanianCountry.class);
        //session.getTransaction().commit();
        List<OceanianCountry> list = query.getResultList();
        //session.close();
        return list;
    }
    @Transactional
    public void saveCountry(VisitedCountry visitedCountry) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(visitedCountry);

    }
    @Transactional
    public void saveYear(Year vuosi) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(vuosi);

    }
    @Transactional
    public void saveAll(VisitedCountry visitedCountry,Year vuosi) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(vuosi);
        session.saveOrUpdate(visitedCountry);

    }
}
