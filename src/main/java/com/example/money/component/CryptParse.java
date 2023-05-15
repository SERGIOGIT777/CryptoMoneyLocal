package com.example.money.component;

import com.example.money.config.CryptConfig;
import com.example.money.dao.PriceDAO;
import com.example.money.entities.Price;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
@AllArgsConstructor
public class CryptParse {

    private final CryptConfig cryptConfig;

    private final PriceDAO priceDAO;

    private EntityManager entityManager;

    static final Logger LOGGER =
            Logger.getLogger(CryptParse.class.getName());

    public void parse() {

        LOGGER.info("parse price start... ");

        priceDAO.deleteAll();
        entityManager.createNativeQuery("ALTER TABLE table_price AUTO_INCREMENT = 1").executeUpdate();

        List<Integer> idList = new ArrayList<>();
        List<String> symbolList = new ArrayList<>();
        List<Double> priceList = new ArrayList<>();

        ResponseEntity<String> responseBTC = cryptConfig.responseBTC();
        ResponseEntity<String> responseETH = cryptConfig.responseETH();
        ResponseEntity<String> responseSOL = cryptConfig.responseSOL();
        JSONArray jsonArrayBTC = new JSONArray(responseBTC.getBody());
        JSONArray jsonArrayETH = new JSONArray(responseETH.getBody());
        JSONArray jsonArraySOL = new JSONArray(responseSOL.getBody());
        idList.add(Integer.parseInt(jsonArrayBTC.getJSONObject(0).get("id").toString()));
        idList.add(Integer.parseInt(jsonArrayETH.getJSONObject(0).get("id").toString()));
        idList.add(Integer.parseInt(jsonArraySOL.getJSONObject(0).get("id").toString()));
        symbolList.add(jsonArrayBTC.getJSONObject(0).get("symbol").toString());
        symbolList.add(jsonArrayETH.getJSONObject(0).get("symbol").toString());
        symbolList.add(jsonArraySOL.getJSONObject(0).get("symbol").toString());
        priceList.add(Double.parseDouble(jsonArrayBTC.getJSONObject(0).get("price_usd").toString()));
        priceList.add(Double.parseDouble(jsonArrayETH.getJSONObject(0).get("price_usd").toString()));
        priceList.add(Double.parseDouble(jsonArraySOL.getJSONObject(0).get("price_usd").toString()));

        var i1 = idList.iterator();
        var i2 = priceList.iterator();
        var i3 = symbolList.iterator();

        while (i1.hasNext() && i2.hasNext() && i3.hasNext()) {
            Price obj = new Price();
            obj.setId_crypt(i1.next());
            obj.setPrice(i2.next());
            obj.setSymbol(i3.next());
            priceDAO.save(obj);
        }
    }
}
