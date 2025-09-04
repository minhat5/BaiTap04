package vn.iotstar.services;

import vn.iotstar.entity.Category;

public interface CategoryService {
    void insert(Category category);

    List<Category> findAll();
    
}
