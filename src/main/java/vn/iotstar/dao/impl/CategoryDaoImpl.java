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
            ex.printStackTrace();
            transaction.rollback();
            throw ex;
        } finally {
            emma.close();
        }
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

}
