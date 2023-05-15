package com.example.money.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
@RequiredArgsConstructor
public class CryptConfig {
    private final RestTemplate restTemplate;

    public ResponseEntity<String> responseBTC(){
        String url= "https://api.coinlore.net/api/ticker/?id=90";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<>("some body", headers);
        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
    }

    public ResponseEntity<String> responseETH(){
        String url= "https://api.coinlore.net/api/ticker/?id=80";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<>("some body", headers);
        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
    }

    public ResponseEntity<String> responseSOL(){
        String url= "https://api.coinlore.net/api/ticker/?id=48543";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<>("some body", headers);
        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
    }
}
