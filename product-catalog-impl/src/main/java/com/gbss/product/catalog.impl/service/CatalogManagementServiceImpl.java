package com.gbss.product.catalog.impl.service;

import com.gbss.framework.core.model.DynamicObject;
import com.gbss.product.catalog.api.constants.CollectionNames;
import com.gbss.product.catalog.api.service.CatalogManagementService;
import com.gbss.product.catalog.api.service.DynamicObjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogManagementServiceImpl implements CatalogManagementService {

    @Autowired
    DynamicObjectsService dynamicObjectsService;

    @Override
    public List<DynamicObject> getCatalogs() {
        return dynamicObjectsService.getDynamicObjects(CollectionNames.CATALOG);
    }

    @Override
    public DynamicObject getCatalogById(String id) {
        return dynamicObjectsService.getDynamicObjectById(id, CollectionNames.CATALOG);
    }

    @Override
    public String createCatalog(DynamicObject catalog) {
        System.out.println("createCatalog, catalog: " + catalog);
        return dynamicObjectsService.createDynamicObject(catalog);
    }

    @Override
    public boolean updateCatalog(DynamicObject catalog) {
        return dynamicObjectsService.updateDynamicObject(catalog);
    }

    @Override
    public boolean deleteCatalog(String id) {
        DynamicObject catalog = dynamicObjectsService.getDynamicObjectById(id, CollectionNames.CATALOG);
        if(catalog != null){
            return dynamicObjectsService.deleteDynamicObjectById(id, CollectionNames.CATALOG);
        }

        return false;
    }
}
