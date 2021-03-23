package com.gbss.product.catalog.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gbss.framework.core.model.Base;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//@Document(collection="productTemplates")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class ProductTemplate extends Base {

    //@AttributeId(CatalogConstants.ProductTemplate.CHARACTERISTICS)
    private List<Characteristic> characteristics;

    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }
}
