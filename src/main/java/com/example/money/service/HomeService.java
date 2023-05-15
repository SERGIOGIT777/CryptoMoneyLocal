package com.example.money.service;


import com.example.money.entities.Money;
import com.example.money.entities.Price;
import com.example.money.entities.Users;

import java.util.List;

public interface HomeService {

    List<Money> getAllProducts();

    void postCrypt();

    List<Price> getActualCrypt(int crypt);

    void notify(String symbol, Users users);

    void getResult();
}
