package com.example.archiLogicielleApiRest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {
    private @Id
    @GeneratedValue
    @Column(name="ID")
    int id;

    private @Column(name = "NAME") String name;
    private @Column(name = "DESCRIPTION") String description;
    private @Column(name = "STOCK") int stock;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Transient
    @JsonIgnore
    public boolean isNotValid(){
        return stock < 0 || name.isBlank() || description.isBlank();
    }
}

