package com.esolution.users.entity;

import com.esolution.users.helper.BaseEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("USERS")
public class UserEntity extends BaseEntity {
    // TODO - Annotation - Cannot be NULL
    // TODO - Password Encryption

    @Field(name = "EMAIL")
    private String email;
    @Field(name = "USERNAME")
    private String username;
    @Field(name = "LAST_NAME")
    private String lastName;
    @Field(name = "FIRST_NAME")
    private String firstName;
    @Field(name = "PASSWORD")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
