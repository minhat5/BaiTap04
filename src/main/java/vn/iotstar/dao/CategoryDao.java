package vn.iotstar.dao;

import vn.iotstar.entity.Category;

import java.util.List;

public interface CategoryDao {
    void create(Category category);

    void update(Category category);

    void delete(int id);

    Category findById(int id);

    List<Category> findAll();

}
