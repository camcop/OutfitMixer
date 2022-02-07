package com.camcop.outfitmixer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
public class Item {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
