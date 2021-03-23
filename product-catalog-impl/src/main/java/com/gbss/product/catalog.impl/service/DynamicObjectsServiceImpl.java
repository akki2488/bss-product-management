package com.gbss.product.catalog.impl.service;

import com.gbss.framework.core.model.Base;
import com.gbss.framework.core.model.DynamicObject;
import com.gbss.product.catalog.api.service.DynamicObjectsService;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DynamicObjectsServiceImpl implements DynamicObjectsService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<DynamicObject> getDynamicObjects(String collectionName) {
        Assert.notNull(collectionName, "'collectionName' must not be null.");
        return mongoTemplate.findAll(DynamicObject.class, collectionName);
    }

    @Override
    public DynamicObject getDynamicObjectById(String id, String collectionName) {
        Assert.notNull(collectionName, "'collectionName' must not be null.");
        Assert.notNull(id, "Object id must not be null.");
        return mongoTemplate.findById(id, DynamicObject.class, collectionName);
    }

    @Override
    public List<DynamicObject> getDynamicObjectsByParentId(String collectionName, String parentId) {
        Assert.notNull(collectionName, "'collectionName' must not be null.");
        return mongoTemplate.find(Query.query(Criteria.where("parentId").is(parentId)),
                DynamicObject.class, collectionName);
    }

    @Override
    public String createDynamicObject(DynamicObject object) {
        String objectId = null;
        DynamicObject dbObject = null;
        System.out.println("createDynamicObject, CollectionName: " + object.getCollectionName());
        if (!StringUtils.isEmpty(object.getCollectionName())) {
            if (!mongoTemplate.getCollectionNames().contains(object.getCollectionName())) {
                mongoTemplate.createCollection(object.getCollectionName());
            }
            dbObject = mongoTemplate.save(object, object.getCollectionName());
            objectId = dbObject.getId();
            dbObject = null;
        }

        System.out.println("createDynamicObject, catalog objectId: " + objectId);
        return objectId;
    }

    @Override
    public boolean updateDynamicObject(DynamicObject object) {
        boolean updated = false;
        if (!StringUtils.isEmpty(object.getCollectionName())) {
            DynamicObject dynamicObjectDB = mongoTemplate.findById(object.getId(), DynamicObject.class,
                    object.getCollectionName());
            handleAudit(dynamicObjectDB, object);
            mongoTemplate.save(object, object.getCollectionName());
            updated = true;
        }

        return updated;
    }

    @Override
    public boolean deleteDynamicObjectById(String id, String collectionName) {
        DeleteResult result = mongoTemplate.remove(id, collectionName);
        return result.wasAcknowledged();
    }


    @Override
    public void handleAudit(Base fromDB, Base fromUI) {
        if (fromDB != null) {
            fromUI.setCreatedAt(fromDB.getCreatedAt());
            fromUI.setVersion(fromDB.getVersion());
            if (fromDB.getParentId() != null) {
                fromUI.setParentId(fromDB.getParentId());
            }
            if (fromDB.getObjectTypeId() != null) {
                fromUI.setObjectTypeId(fromDB.getObjectTypeId());
            }
        }
    }
}
