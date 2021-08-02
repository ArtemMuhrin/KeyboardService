package com.example.keyboardservice.service;

import org.springframework.stereotype.Service;

@Service
public class KeyService {
    public String handleMessage(String value) {
        return "Вы нажали: " + value;
    }
}
