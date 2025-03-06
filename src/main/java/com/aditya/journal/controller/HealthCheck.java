package com.aditya.journal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/get_health_status")
    public String healthStatus(){
       return ("OK");
    }
}
