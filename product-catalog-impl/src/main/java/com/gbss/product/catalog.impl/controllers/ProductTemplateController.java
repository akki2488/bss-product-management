package com.gbss.product.catalog.impl.controllers;

import com.gbss.framework.core.model.DynamicObject;
import com.gbss.product.catalog.api.constants.CatalogConstants;
import com.gbss.product.catalog.api.service.ProductTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Akshay Misra on 20-03-2021.
 */
@RestController
@RequestMapping("/application/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductTemplateController {

    @Autowired
    ProductTemplateService productTemplateService;

    @GetMapping("/" + CatalogConstants.ObjectTypes.PRODUCT_TEMPLATE + "/load/all")
    public List<DynamicObject> getProductTemplates() {
        return productTemplateService.getProductTemplates();
    }

    @GetMapping(value="/" + CatalogConstants.ObjectTypes.PRODUCT_TEMPLATE + "/load/{id}")
    public DynamicObject getProductTemplateById(@PathVariable("id") String id) {
        return productTemplateService.getProductTemplateById(id);
    }

    @GetMapping(value="/" + CatalogConstants.ObjectTypes.PRODUCT_TEMPLATE + "/load/by/parent/{parentId}")
    public List<DynamicObject> getProductTemplatesByParentId(@PathVariable("parentId") String parentId) {
        return productTemplateService.getProductTemplatesByParentId(parentId);
    }

    @PostMapping("/" + CatalogConstants.ObjectTypes.PRODUCT_TEMPLATE + "/add")
    public String createProductTemplate(@RequestBody DynamicObject Catalog) {
        return productTemplateService.createProductTemplate(Catalog);
    }

    @PutMapping(value="/" + CatalogConstants.ObjectTypes.PRODUCT_TEMPLATE + "/update")
    public boolean updateProductTemplate(@Valid @RequestBody DynamicObject Catalog) {
        return productTemplateService.updateProductTemplate(Catalog);
    }

    @DeleteMapping(value="/" + CatalogConstants.ObjectTypes.PRODUCT_TEMPLATE + "/delete/{id}")
    public boolean deleteProductTemplate(@PathVariable("id") String id) {
        return productTemplateService.deleteProductTemplate(id);
    }
}
