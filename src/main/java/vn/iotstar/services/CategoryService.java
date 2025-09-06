package vn.iotstar.services;

import vn.iotstar.entity.Category;

import java.util.List;

public interface CategoryService {
    void insert(Category category);

    Category findById(int id);

    void update(Category category);

    List<Category> findAll();

    void deleteById(int id);

    List<Category> findByUserId(int id);

    void delete(Category category);
}
