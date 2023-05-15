package com.example.money.dao;

import com.example.money.entities.Money;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyDAO extends JpaRepository<Money, Long> {
}
