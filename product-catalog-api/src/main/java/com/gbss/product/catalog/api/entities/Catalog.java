package com.gbss.product.catalog.api.entities;


import javax.validation.constraints.NotNull;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by Akshay Misra on 06-04-2020.
 */
//@Document(collection="catalogs")
public class Catalog {

    @NotNull
    private boolean active;

    private Locale defaultLocale;

    private Currency defaultCurrency;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Locale getDefaultLocale() {
        return defaultLocale;
    }

    public void setDefaultLocale(Locale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }
}
