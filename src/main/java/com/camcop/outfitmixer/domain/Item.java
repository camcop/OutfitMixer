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

}
