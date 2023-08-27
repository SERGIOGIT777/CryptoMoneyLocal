package com.example.money.dao;

import com.example.money.entities.Price;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Tag(name = "PriceRepository")
@Hidden
public interface PriceDAO extends JpaRepository<Price, Long> {

    @Query("select obj from Price obj where obj.id_crypt=:id_crypt")
    List<Price> getActualPrice(@Param("id_crypt") int crypt);

    @Query("select obj from Price obj where obj.symbol=:symbol")
    Price findByPrice(String symbol);

    @Query("select obj from Price obj where obj.id_crypt=:price")
    Price findByPriceInt(int price);

}
