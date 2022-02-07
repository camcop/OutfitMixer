package com.camcop.outfitmixer.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Item")
public class Item {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String type;

    @Column
    private String brand;

    @Column
    private String colour;

    public Item() {
    }

    public Item(Long id, String name, String type, String brand, String colour) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.colour = colour;
    }

    public Item(String name, String type, String brand, String colour) {
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.colour = colour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }


}
