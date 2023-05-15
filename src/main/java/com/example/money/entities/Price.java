package com.example.money.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "table_price")
@Getter
@Setter
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_crypt")
    private int id_crypt;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "price")
    private double price;

}
