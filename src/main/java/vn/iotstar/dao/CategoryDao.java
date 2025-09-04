package vn.iotstar.dao;

import vn.iotstar.entity.Category;

import java.util.List;

public interface CategoryDao {
    void create(Category category);

    Category update(Category category);

    Category findById(int id);

    List<Category> findAll();

}
