package com.zara.prices.infraestructure.datasource.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "BRANDS")
public class BrandsEntity {

    private static final String ID_SEQUENCE = "ID_SEQUENCE";
    @Id
    @GeneratedValue(generator = ID_SEQUENCE, strategy= GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
}
