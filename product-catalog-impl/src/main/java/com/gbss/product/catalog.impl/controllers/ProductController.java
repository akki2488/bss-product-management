package com.gbss.product.catalog.impl.controllers;

import com.gbss.framework.core.model.DynamicObject;
import com.gbss.product.catalog.api.service.ProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Akshay Misra on 09-08-2018.
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

    @Autowired
    ProductManagementService productManagementService;

    @GetMapping("/products")
    public List<DynamicObject> getAllProducts() {
        return productManagementService.getAllProducts();
    }

    @PostMapping("/add")
    public DynamicObject addProduct(@Valid @RequestBody DynamicObject product) {
        return productManagementService.createProduct(product);
    }

    @GetMapping(value="/product/{id}")
    public DynamicObject getProductById(@PathVariable("id") String id) {
        return productManagementService.getProductById(id);
    }

    @PutMapping(value="/update")
    public DynamicObject updateProduct(@Valid @RequestBody DynamicObject product) {
        return productManagementService.updateProduct(product);
    }

    @DeleteMapping(value="/delete/{id}")
    public boolean deleteProduct(@PathVariable("id") String id) {
        return productManagementService.deleteProduct(id);
    }
}
