package com.byhovsky.hibernate.repository.impl;

import com.byhovsky.hibernate.model.annotation.Cart1;
import com.byhovsky.hibernate.model.annotation.Items1;
import com.byhovsky.hibernate.repository.DAOInterface;
import com.byhovsky.hibernate.util.HibernateAnnotationUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemAnnotationDAOImpl implements DAOInterface<Items1> {

    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;

    /**
     * {@inheritDoc}
     */
    public void create(Items1 items) {
        Cart1 cart = new Cart1();
        cart.setName(cart.getName());
        cart.setTotal(cart.getTotal());
        cart.setId(cart.getId());
        items.setItemId(items.getItemId());
        items.setItemTotal(items.getItemTotal());
        items.setQuantity(items.getQuantity());
        items.setCart1(cart);
        Set<Items1> itemsSet = new HashSet<Items1>();
        itemsSet.add(items);
        try {
            sessionFactory = HibernateAnnotationUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            session.save(cart);
            session.save(items);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!sessionFactory.isClosed()) {
                sessionFactory.close();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void delete(long id) {
        try {
            sessionFactory = HibernateAnnotationUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Items1 items = (Items1) session.get(Items1.class, id);
            session.delete(items);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!sessionFactory.isClosed()) {
                sessionFactory.close();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<Items1> read() {
        List<Items1> items = new ArrayList<Items1>();
        try {
            sessionFactory = HibernateAnnotationUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            items = session.createCriteria(Items1.class).list();
            for (Items1 items1 : items) {
                System.out.println(items1);
            }
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!sessionFactory.isClosed()) {
                sessionFactory.close();
            }
        }
        return items;
    }

    /**
     * {@inheritDoc}
     */
    public void update(long id) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateAnnotationUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Items1 items1 = (Items1) session.get(Items1.class, id);
            items1.setQuantity(9999);
            session.update(items1);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!sessionFactory.isClosed()) {
                sessionFactory.close();
            }
        }
    }
}
