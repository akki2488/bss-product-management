package com.gbss.product.catalog.api.service;

import com.gbss.framework.core.model.DynamicObject;

import java.util.List;

public interface ProductTemplateService {

    List<DynamicObject> getProductTemplates();

    DynamicObject getProductTemplateById(String id);

    List<DynamicObject> getProductTemplatesByParentId(String parentId);

    String createProductTemplate(DynamicObject catalog);

    boolean updateProductTemplate(DynamicObject catalog);

    boolean deleteProductTemplate(String id);
}
