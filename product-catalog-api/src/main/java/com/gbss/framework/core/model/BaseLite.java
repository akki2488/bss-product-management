package com.gbss.framework.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class BaseLite {

    @Id
    private String id;

    @NotBlank
    private String objectTypeId;

    @Indexed(name = "object_parent_index")
    private String parentId;

    private String parentTypeId;

    @Nullable
    @Size(max=100)
    @Indexed(name = "object_public_name_index")
    private String publicName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    public String getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(String objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    @Override
    public String toString() {
        return "BaseLite{" +
                "id='" + id + '\'' +
                ", objectTypeId='" + objectTypeId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", parentTypeId='" + parentTypeId + '\'' +
                ", publicName='" + publicName + '\'' +
                '}';
    }
}
