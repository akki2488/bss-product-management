package com.gbss.product.catalog.impl.repositories;

import com.gbss.framework.core.model.DynamicObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Akshay Misra on 09-08-2018.
 */
@Repository
public interface ProductRepository  extends MongoRepository<DynamicObject, String> {
}
