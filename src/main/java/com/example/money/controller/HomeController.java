package com.example.money.controller;

import com.example.money.entities.Money;
import com.example.money.entities.Price;
import com.example.money.entities.Users;
import com.example.money.service.HomeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crypt/")
@Valid
@AllArgsConstructor
@EnableScheduling
@Tag(name = "Home page", description = "this controller with 3 methods to parse crypt")
public class HomeController {

    private HomeService service;

    @GetMapping("/find/all")
    @Operation(summary = "shows all courses")
    public List<Money> getAllCrypts() {
        return service.getAllProducts();
    }

    @Scheduled(fixedRate = 60000)
    public void postCrypt() {
        service.postCrypt();
    }

    @GetMapping("/getActualCrypt/{id_crypt}")
    @Operation(summary = "get only one parse with course")
    public List<Price> getActualPrice(@PathVariable("id_crypt") int crypt) {
        return service.getActualCrypt(crypt);
    }

    @PostMapping("/save/users/{symbol}")
    @Operation(summary = "insert users into database")
    public Users saveUsers(@PathVariable String symbol, @RequestBody Users users) {

        service.notify(symbol, users);

        return users;
    }

    @Scheduled(fixedRate = 66000)
    public void getResult(){
        service.getResult();
    }


}
