package com.gbss.product.catalog.impl.controllers;

import com.gbss.framework.core.model.DynamicObject;
import com.gbss.product.catalog.api.service.ProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Akshay Misra on 20-03-2021.
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductCategoryController {

    @Autowired
    ProductManagementService productManagementService;

    @GetMapping("/all/product-categories")
    public List<DynamicObject> getAllCategories() {
        return productManagementService.getAllCategories();
    }

    @PostMapping("/add/product-category")
    public DynamicObject addCategory(@Valid @RequestBody DynamicObject category) {
        return productManagementService.createProductCategory(category);
    }

    @GetMapping(value="/get/product-category/{id}")
    public DynamicObject getCategoryById(@PathVariable("id") String id) {
        return productManagementService.getProductCategoryById(id);
    }

    @PutMapping(value="/update/product-category")
    public DynamicObject updateCategory(@Valid @RequestBody DynamicObject category) {
        return productManagementService.updateProductCategory(category);
    }

    @DeleteMapping(value="/delete/product-category/{id}")
    public boolean deleteCategory(@PathVariable("id") String id) {
        return productManagementService.deleteProductCategory(id);
    }
}
