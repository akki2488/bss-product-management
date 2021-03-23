package com.gbss.product.catalog.impl.repositories;

import com.gbss.framework.core.model.DynamicObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Akshay Misra on 06-04-2020.
 */
@Repository
public interface ProductCategoryRepository extends MongoRepository<DynamicObject, String> {
}
