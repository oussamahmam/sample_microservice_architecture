package com.esolution.users.helper;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity implements Serializable {
    @Id
    @Field(name = "ID")
    private ObjectId id;
    @CreatedDate
    @Field(name = "CREATION_DATE")
    private Date creationDate;
    @LastModifiedDate
    @Field(name = "MODIFICATION_DATE")
    private Date modificationDate;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
