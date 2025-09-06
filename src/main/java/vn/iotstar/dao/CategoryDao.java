package vn.iotstar.dao;

import vn.iotstar.entity.Category;

import java.util.List;

public interface CategoryDao {
    void create(Category category);

    void update(Category category);

    void delete(int id);

    void delete(Category category);

    Category findById(int id);

    List<Category> findAll();

    List<Category> findByUserId(int id);
}
