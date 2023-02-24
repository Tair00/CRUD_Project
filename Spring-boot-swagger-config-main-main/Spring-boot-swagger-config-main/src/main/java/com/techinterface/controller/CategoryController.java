package com.techinterface.controller;

import com.techinterface.model.Category;
import com.techinterface.repository.CategoryRepository;
import com.techinterface.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping("/category/insert")
    public List<Category> addCategories(@RequestBody List<Category> categories){
        return service.saveCategories(categories);
    }
    @GetMapping("/category/getById")
    public Category findCategoryById(@PathVariable int id){
        return service.getCategoryById(id);
    }
    @PutMapping("/category/update")
    public Category updateCategory(@RequestBody Category category){
        return service.updateCategory(category);
    }
    @GetMapping("/category/getList")
    public List<Category> findAllCategories(){
        return service.getCategory();
    }
    @DeleteMapping("/category/delete")
    public String deleteCategory(@PathVariable int id){
        return service.deleteCategory(id);
    }


}
