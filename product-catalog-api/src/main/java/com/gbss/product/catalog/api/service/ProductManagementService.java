package com.gbss.product.catalog.api.service;

import com.gbss.framework.core.model.DynamicObject;

import java.util.List;

/**
 * Created by Akshay Misra on 11/13/2018.
 */
public interface ProductManagementService {

    List<DynamicObject> getAllProducts();

    DynamicObject getProductById(String id);

    DynamicObject createProduct(DynamicObject product);

    DynamicObject updateProduct(DynamicObject product);

    boolean deleteProduct(String id);

    DynamicObject activateProduct(String id);

    List<DynamicObject> getAllCategories();

    DynamicObject getProductCategoryById(String id);

    DynamicObject createProductCategory(DynamicObject category);

    DynamicObject updateProductCategory(DynamicObject category);

    boolean deleteProductCategory(String id);
}
