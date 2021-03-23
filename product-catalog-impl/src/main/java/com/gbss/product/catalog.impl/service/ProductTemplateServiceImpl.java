package com.gbss.product.catalog.impl.service;

import com.gbss.framework.core.model.DynamicObject;
import com.gbss.product.catalog.api.constants.CollectionNames;
import com.gbss.product.catalog.api.service.DynamicObjectsService;
import com.gbss.product.catalog.api.service.ProductTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTemplateServiceImpl implements ProductTemplateService {

    @Autowired
    DynamicObjectsService dynamicObjectsService;

    @Override
    public List<DynamicObject> getProductTemplates() {
        return dynamicObjectsService.getDynamicObjects(CollectionNames.PRODUCT_TEMPLATES);
    }

    @Override
    public DynamicObject getProductTemplateById(String id) {
        return dynamicObjectsService.getDynamicObjectById(id, CollectionNames.PRODUCT_TEMPLATES);
    }

    @Override
    public List<DynamicObject> getProductTemplatesByParentId(String parentId) {
        return dynamicObjectsService.getDynamicObjectsByParentId(CollectionNames.PRODUCT_TEMPLATES, parentId);
    }

    @Override
    public String createProductTemplate(DynamicObject catalog) {
        System.out.println("createCatalog, catalog: " + catalog);
        return dynamicObjectsService.createDynamicObject(catalog);
    }

    @Override
    public boolean updateProductTemplate(DynamicObject catalog) {
        return dynamicObjectsService.updateDynamicObject(catalog);
    }

    @Override
    public boolean deleteProductTemplate(String id) {
        DynamicObject catalog = dynamicObjectsService.getDynamicObjectById(id, CollectionNames.PRODUCT_TEMPLATES);
        if(catalog != null){
            return dynamicObjectsService.deleteDynamicObjectById(id, CollectionNames.PRODUCT_TEMPLATES);
        }

        return false;
    }
}
