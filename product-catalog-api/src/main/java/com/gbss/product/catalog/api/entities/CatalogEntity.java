package com.gbss.product.catalog.api.entities;

/**
 * Created by Akshay Misra on 06-04-2020.
 * All entities extends from this class will have parentId as catalogId.
 */
public class CatalogEntity {

    private boolean active;

    private String imageUrl;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
