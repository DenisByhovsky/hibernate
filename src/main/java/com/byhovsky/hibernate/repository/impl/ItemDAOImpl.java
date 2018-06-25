package com.byhovsky.hibernate.repository.impl;

import com.byhovsky.hibernate.model.Cart;
import com.byhovsky.hibernate.model.Items;
import com.byhovsky.hibernate.repository.DAOInterface;
import com.byhovsky.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemDAOImpl implements DAOInterface<Items> {

    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;

    /**
     * {@inheritDoc}
     */
    public void create(Items items) {
        Cart cart = new Cart();
        cart.setName(cart.getName());
        cart.setTotal(cart.getTotal());
        cart.setId(cart.getId());
        items.setItemId(items.getItemId());
        items.setItemTotal(items.getItemTotal());
        items.setQuantity(items.getQuantity());
        items.setCart(cart);
        Set<Items> itemsSet = new HashSet<Items>();
        itemsSet.add(items);
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
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
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Items items = (Items) session.get(Items.class, id);
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
    public List<Items> read() {
        List<Items> items = new ArrayList<Items>();
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            items = session.createCriteria(Items.class).list();
            for (Items items1 : items) {
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
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Items items1 = (Items) session.get(Items.class, id);
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

