package com.gbss.product.catalog.api.service;

import com.gbss.framework.core.model.Base;
import com.gbss.framework.core.model.DynamicObject;

import java.util.List;

public interface DynamicObjectsService {

    List<DynamicObject> getDynamicObjects(String collectionName);

    DynamicObject getDynamicObjectById(String id, String collectionName);

    List<DynamicObject> getDynamicObjectsByParentId(String collectionName, String parentId);

    String createDynamicObject(DynamicObject object);

    boolean updateDynamicObject(DynamicObject object);

    boolean deleteDynamicObjectById(String id, String collectionName);

    void handleAudit(Base fromDB, Base fromUI);
}
