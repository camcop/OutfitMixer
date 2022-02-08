package com.camcop.outfitmixer.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Item")
public class Item {

    @Id
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

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id) && name.equals(item.name) && type.equals(item.type) && Objects.equals(brand, item.brand) && Objects.equals(colour, item.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, brand, colour);
    }
}
