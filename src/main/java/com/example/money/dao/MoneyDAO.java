package com.example.money.dao;

import com.example.money.entities.Money;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Tag(name = "MoneyRepository")
@Hidden
public interface MoneyDAO extends JpaRepository<Money, Long> {
}
