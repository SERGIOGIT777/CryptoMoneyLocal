package com.example.money.entities;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "table_money")
@Getter
@Setter
public class Money {
    @Id
    private Long id;

    @Column(name = "symbol")
    private String symbol;

}
