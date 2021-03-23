package com.gbss.product.catalog.api.entities;


import javax.validation.constraints.NotNull;

//@Document(collection="characteristics")
public class Characteristic {

    @NotNull
    private boolean useAsFilter;

    @NotNull
    private boolean useAsVariant;

    public boolean isUseAsFilter() {
        return useAsFilter;
    }

    public void setUseAsFilter(boolean useAsFilter) {
        this.useAsFilter = useAsFilter;
    }

    public boolean isUseAsVariant() {
        return useAsVariant;
    }

    public void setUseAsVariant(boolean useAsVariant) {
        this.useAsVariant = useAsVariant;
    }
}
