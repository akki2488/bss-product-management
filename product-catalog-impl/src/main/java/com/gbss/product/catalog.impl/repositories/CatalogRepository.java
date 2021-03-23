package com.gbss.product.catalog.impl.repositories;

import com.gbss.framework.core.model.DynamicObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Akshay Misra on 16-03-2021.
 */
@Repository
public interface CatalogRepository extends MongoRepository<DynamicObject, String> {
}
