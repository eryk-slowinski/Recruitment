package com.recruitment.task.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class ControllerTest {

    //test endpoint with parameter
    @Test
    public void getTransactionsDetailsById() {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String url = "http://localhost:8080/gettransactionsdetails/getbyid?customer_id=3";
        headers.setBasicAuth("digital", "collier");
        HttpEntity<Void> requestEntity = new HttpEntity<>(null, headers);
        ResponseEntity response = template.exchange(url, HttpMethod.GET, requestEntity, List.class);
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(!((List) response.getBody()).isEmpty());
    }

    //test endpoint without parameters
    @Test
    public void getTransactionsDetails() {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String url = "http://localhost:8080/gettransactionsdetails";
        headers.setBasicAuth("digital", "collier");
        HttpEntity<Void> requestEntity = new HttpEntity<>(null, headers);
        ResponseEntity response = template.exchange(url, HttpMethod.GET, requestEntity, List.class);
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(!((List) response.getBody()).isEmpty());
    }

}