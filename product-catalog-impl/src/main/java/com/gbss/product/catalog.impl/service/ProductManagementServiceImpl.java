package com.gbss.product.catalog.impl.service;

import com.gbss.framework.core.model.DynamicObject;
import com.gbss.product.catalog.api.service.ProductManagementService;
import com.gbss.product.catalog.impl.repositories.ProductCategoryRepository;
import com.gbss.product.catalog.impl.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Akshay Misra on 11/13/2018.
 */
@Service
public class ProductManagementServiceImpl implements ProductManagementService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository categoryRepository;

    @Override
    public List<DynamicObject> getAllProducts() {
        System.out.println("ProductManagementServiceImpl getAllProducts.");
        Sort sortByCreatedAtDesc = Sort.by(Sort.Direction.DESC, "createdAt");
        return productRepository.findAll(sortByCreatedAtDesc);
    }

    @Override
    public DynamicObject getProductById(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public DynamicObject createProduct(DynamicObject product) {
        return productRepository.save(product);
    }

    @Override
    public DynamicObject updateProduct(DynamicObject product) {
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(String id) {
        Optional<DynamicObject> product = productRepository.findById(id);
        if(product != null){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public DynamicObject activateProduct(String id) {
        Optional<DynamicObject> productOpt = productRepository.findById(id);
        if (productOpt.isPresent()) {
            DynamicObject product = productOpt.get();
            product.getExtendedParameters().put("", true);//add attributeId
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public List<DynamicObject> getAllCategories() {
        System.out.println("ProductManagementServiceImpl getAllCategories.");
        Sort sortByCreatedAtDesc = Sort.by(Sort.Direction.DESC, "createdAt");
        return categoryRepository.findAll(sortByCreatedAtDesc);
    }

    @Override
    public DynamicObject getProductCategoryById(String id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public DynamicObject createProductCategory(DynamicObject category) {
        return categoryRepository.save(category);
    }

    @Override
    public DynamicObject updateProductCategory(DynamicObject category) {
        return categoryRepository.save(category);
    }

    @Override
    public boolean deleteProductCategory(String id) {
        Optional<DynamicObject> product = categoryRepository.findById(id);
        if(product != null){
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
