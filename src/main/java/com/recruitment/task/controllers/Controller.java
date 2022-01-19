package com.recruitment.task.controllers;

import com.recruitment.task.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private AppService transactionsAppService;

    @GetMapping("/gettransactionsdetails/getbyid")
    public ResponseEntity getTransactionsDetails(@RequestParam String customer_id) {
        return ResponseEntity.ok().body(transactionsAppService.getTransactionsDetails(customer_id));
    }

    @GetMapping("/gettransactionsdetails")
    public ResponseEntity getTransactionsDetails() {
        return ResponseEntity.ok().body(transactionsAppService.getTransactionsDetails());
    }

}

