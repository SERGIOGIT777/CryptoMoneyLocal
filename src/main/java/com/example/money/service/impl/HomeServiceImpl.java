package com.example.money.service.impl;

import com.example.money.component.CryptParse;
import com.example.money.dao.MoneyDAO;
import com.example.money.dao.PriceDAO;
import com.example.money.dao.UsersDAO;
import com.example.money.entities.Money;
import com.example.money.entities.Price;
import com.example.money.entities.Users;
import com.example.money.service.HomeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
@AllArgsConstructor
public class HomeServiceImpl implements HomeService {

    private MoneyDAO moneyDAO;

    private CryptParse cryptParse;

    private PriceDAO priceDAO;

    private UsersDAO usersDAO;

    static final Logger LOGGER =
            Logger.getLogger(HomeServiceImpl.class.getName());

    @Override
    public List<Money> getAllProducts() {
        return moneyDAO.findAll().stream().toList();
    }

    @Override
    public void postCrypt() {
        cryptParse.parse();
    }

    @Override
    public List<Price> getActualCrypt(int crypt) {
        return priceDAO.getActualPrice(crypt);
    }

    @Override
    public void notify(String symbol, Users users) {
        var price_id = priceDAO.findByPrice(symbol);
        users.setId_crypt(price_id.getId_crypt());
        users.setPrice(price_id.getPrice());
        users.setSymbol(price_id.getSymbol());
        usersDAO.saveAndFlush(users);
    }

    @Override
    public void getResult() {
        var col = usersDAO.findAll().stream().count();
        if (col > 0) {
            for (long i = 1; i <= col; i++) {
                var item1 = usersDAO.findByID(i);
                var price_price = priceDAO.findByPriceInt(item1.getId_crypt());
                var count = 0.0;
                if (item1.getPrice() > price_price.getPrice()) {
                    count = 100 - ((price_price.getPrice() / item1.getPrice()) * 100);
                }
                if (item1.getPrice() < price_price.getPrice()) {
                    count = 100 - ((item1.getPrice() / price_price.getPrice()) * 100);
                }
                if (count > 1) {
                    LOGGER.warning("Код валюты: " + item1.getSymbol() + " пользователь: " + item1.getName()
                            + " процент: " + count);
                }
            }
        }
    }
}
