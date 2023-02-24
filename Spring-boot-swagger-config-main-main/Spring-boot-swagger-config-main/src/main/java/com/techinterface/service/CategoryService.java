package com.techinterface.service;

import com.techinterface.model.Category;
import com.techinterface.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> saveCategories(List<Category> categories){return categoryRepository.saveAll(categories);}
    public List<Category> getCategory(){
        return categoryRepository.findAll();
    }
    public Category getCategoryById(int id){
        return categoryRepository.findById(id).orElse(null);

    }
    public Category getCategoryByName(String name){
        return categoryRepository.findByName(name).orElse(null);

    }

    public String deleteCategory(int id){
        categoryRepository.deleteById(id);
        return "category removed";

    }
    public Category updateCategory(Category category){
        Category existingCategory=categoryRepository.findById(category.getId()).orElse(null);
        existingCategory.setName(category.getName());
        existingCategory.setParent(category.getParent());
        return categoryRepository.save(existingCategory);
    }
}
