/**
 * Implementation of the RealEstateDAO interface.
 */

package org.realestate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.realestate.model.RealEstate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class RealEstateDAOImpl implements RealEstateDAO {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(1);
    private static Map<Integer, RealEstate> realEstates = new HashMap<>();

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<RealEstate> allRealEstates(int page) {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from RealEstate").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @Override
    public int realEstatesCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from RealEstate", Number.class).getSingleResult().intValue();
    }

    @Override
    public void add(RealEstate realEstate) {

        Session session = sessionFactory.getCurrentSession();
        session.persist(realEstate);
    }

    @Override
    public void delete(RealEstate realEstate) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(realEstate);
    }

    @Override
    public void edit(RealEstate realEstate) {

        Session session = sessionFactory.getCurrentSession();
        session.update(realEstate);
    }

    @Override
    public RealEstate getById(int id) {

        Session session = sessionFactory.getCurrentSession();
        return session.get(RealEstate.class, id);
    }
}
