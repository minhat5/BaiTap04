package vn.iotstar.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.iotstar.configs.JPAConfig;
import vn.iotstar.dao.CategoryDao;
import vn.iotstar.entity.Category;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public void create(Category category) {
        EntityManager emma = JPAConfig.getEntityManager();
        EntityTransaction transaction = emma.getTransaction();
        try {
            transaction.begin();
            emma.persist(category);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            emma.close();
        }
    }

    @Override
    public void update(Category category) {
        EntityManager emma = JPAConfig.getEntityManager();
        EntityTransaction transaction = emma.getTransaction();
        try {
            transaction.begin();
            emma.merge(category);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            emma.close();
        }
    }

    @Override
    public void delete(int id) {
        EntityManager emma = JPAConfig.getEntityManager();
        EntityTransaction transaction = emma.getTransaction();
        try {
            transaction.begin();
            Category category = emma.find(Category.class, id);
            if (category != null) {
                emma.remove(category);
            }
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            throw ex;
        } finally {
            emma.close();
        }
    }

    @Override
    public Category findById(int id) {
        EntityManager emma = JPAConfig.getEntityManager();
        try {
            return emma.find(Category.class, id);
        } finally {
            emma.close();
        }
    }


    @Override
    public List<Category> findAll() {
        EntityManager emma = JPAConfig.getEntityManager();
        try {
            return emma.createQuery("SELECT c FROM Category c JOIN FETCH c.user", Category.class).getResultList();
        } finally {
            emma.close();
        }
    }

    @Override
    public List<Category> findByUserId(int id) {
        EntityManager emma = JPAConfig.getEntityManager();
        try {
            return emma.createQuery("SELECT c FROM Category c JOIN FETCH c.user WHERE c.user.id = :id ORDER BY c.id DESC", Category.class).setParameter("id", id).getResultList();
        } finally {
            emma.close();
        }
    }
}
