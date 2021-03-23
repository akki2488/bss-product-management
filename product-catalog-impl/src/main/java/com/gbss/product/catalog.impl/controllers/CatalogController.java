package com.gbss.product.catalog.impl.controllers;

import com.gbss.framework.core.model.DynamicObject;
import com.gbss.product.catalog.api.service.CatalogManagementService;
import com.gbss.product.catalog.api.constants.CatalogConstants;
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
 * Created by Akshay Misra on 09-08-2018.
 */
@RestController
@RequestMapping("/application/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CatalogController {

    @Autowired
    CatalogManagementService catalogManagementService;

    @GetMapping("/" + CatalogConstants.ObjectTypes.CATALOG + "/load/all")
    public List<DynamicObject> getCatalogs() {
        return catalogManagementService.getCatalogs();
    }

    @GetMapping(value="/" + CatalogConstants.ObjectTypes.CATALOG + "/load/{id}")
    public DynamicObject getCatalogById(@PathVariable("id") String id) {
        return catalogManagementService.getCatalogById(id);
    }

    /*@GetMapping(value="/" + CatalogConstants.ObjectTypes.CATALOG + "/load/by/parent/{parentId}")
    public List<Catalog> getCatalogByParentId(@PathVariable("parentId") String parentId) {
        return catalogManagementService.getCatalogByParentId(parentId);
    }*/

    @PostMapping("/" + CatalogConstants.ObjectTypes.CATALOG + "/add")
    public String createCatalog(@RequestBody DynamicObject Catalog) {
        return catalogManagementService.createCatalog(Catalog);
    }

    @PutMapping(value="/" + CatalogConstants.ObjectTypes.CATALOG + "/update")
    public boolean updateCatalog(@Valid @RequestBody DynamicObject Catalog) {
        return catalogManagementService.updateCatalog(Catalog);
    }

    @DeleteMapping(value="/" + CatalogConstants.ObjectTypes.CATALOG + "/delete/{id}")
    public boolean deleteCatalog(@PathVariable("id") String id) {
        return catalogManagementService.deleteCatalog(id);
    }
}
