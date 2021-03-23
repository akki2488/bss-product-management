package com.gbss.product.catalog.api.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Created by Akshay Misra on 09-08-2018.
 */
//@Document(collection="products")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Product extends CatalogEntity {

    //@AttributeId(CatalogConstants.Product.PRODUCT_TEMPLATE)
    private String templateId;

    @DBRef(lazy = true)
    @NotBlank
    private Set<ProductCategory> productCategories;

    @DBRef(lazy = true)
    private Set<ProductLite> variants;

    private Set<String> tags;

    @NotBlank
    private double basePrice;

    private Map<String, Object> filters;

    @DBRef(lazy = true)
    private Price price;

    //@AttributeId(CatalogConstants.Product.CHARACTERISTIC_VALUES)
    private Map<String, Object> characteristicValues;

    public void addProductCategory(ProductCategory productCategory) {
        this.productCategories.add(productCategory);
    }

    public void addProductCategories(Collection<ProductCategory> productCategories) {
        this.productCategories.addAll(productCategories);
    }

    public void addTag(String tag) {
        if (tags == null) {
            tags = new HashSet<>();
        }
        tags.add(tag);
    }

    @Override
    public String toString() {
        return "Product{" +
                "templateId='" + templateId + '\'' +
                ", productCategories=" + productCategories +
                ", variants=" + variants +
                ", tags=" + tags +
                ", basePrice=" + basePrice +
                ", filters=" + filters +
                ", price=" + price +
                ", characteristicValues=" + characteristicValues +
                '}';
    }
}
