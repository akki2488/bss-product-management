package com.gbss.product.catalog.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Currency;

//@Document(collection="prices")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Price {

    private double basePrice;

    private Currency currency;
}
