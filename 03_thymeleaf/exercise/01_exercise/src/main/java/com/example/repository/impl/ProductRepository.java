package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product ").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        Session session = null;
        Transaction transaction = null;

        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(product);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            if(session !=null){
                session.close();
            }

        }
    }

    @Override
    public void update(Product product) {
        Session session = null;
        Transaction transaction = null;

        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(product);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            if(session !=null){
                session.close();
            }

        }
    }

    @Override
    public Product findById(int id) {
        Session session = null;
        Product product;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
             product = (Product) session.createQuery("FROM Product WHERE id = :id").setParameter("id", id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public void delete(int id) {
        Session session = null;
        Transaction transaction = null;

        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.remove(findById(id));
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            if(session !=null){
                session.close();
            }

        }
    }

    @Override
    public List<Product> findByName(String name) {
        Session session = null;
        List<Product> productList;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product where name =:name").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }
}
