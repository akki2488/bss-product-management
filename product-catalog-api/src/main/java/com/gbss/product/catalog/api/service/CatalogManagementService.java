package com.gbss.product.catalog.api.service;

import com.gbss.framework.core.model.DynamicObject;

import java.util.List;

public interface CatalogManagementService {

    List<DynamicObject> getCatalogs();

    DynamicObject getCatalogById(String id);

    String createCatalog(DynamicObject catalog);

    boolean updateCatalog(DynamicObject catalog);

    boolean deleteCatalog(String id);

}
