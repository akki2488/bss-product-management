package com.gbss.framework.core.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.core.annotation.Order;
import org.springframework.data.annotation.Version;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Akshay Misra on 15-06-2019.
 */
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Base extends BaseLite {

    @Version
    private Long version;

    @NotBlank
    @Size(max=100)
    @Indexed(name = "object_name_index")
    private String name;

    @Size(max=1000)
    @Indexed(name = "object_desc_index")
    private String description;

    @Nullable
    @Order
    private int order;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date lastModifiedAt;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(Date lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Base{"
                + super.toString()
                + ", version=" + version
                + ", name= " + name
                + ", description= " + description
                + ", order=" + order
                + ", createdAt=" + createdAt
                + ", lastModifiedAt=" + lastModifiedAt +
                '}';
    }
}
