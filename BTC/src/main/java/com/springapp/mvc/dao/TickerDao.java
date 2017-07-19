package com.springapp.mvc.dao;

import com.springapp.mvc.model.Ticker;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TickerDao {

    @Autowired
    protected SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public void add(Ticker ticker) {
        getSession().persist(ticker);
    }

    public void update(Ticker ticker) {
        getSession().update(ticker);
    }

    public void removeById(int id) {
        Session session = getSession();
        Ticker ticker = (Ticker) session.load(Ticker.class, new Integer(id));
        if (ticker != null) {
            session.delete(ticker);
        }
    }

    @SuppressWarnings("unchecked")
    public Ticker getById(int id) {
        Criteria criteria = getSession().createCriteria(Ticker.class);
        criteria.add(Restrictions.eq("id", id));
        return (Ticker) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Ticker> getAll() {
        Criteria criteria = getSession().createCriteria(Ticker.class);
        return criteria.list();
    }

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
}