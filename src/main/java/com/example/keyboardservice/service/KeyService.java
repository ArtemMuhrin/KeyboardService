package com.example.keyboardservice.service;

import com.example.keyboardservice.model.Message;
import org.springframework.stereotype.Service;

@Service
public class KeyService {
    public Message handleMessage(Message message) {
        message.setText("Вы нажали: " + message.getText());
        return message;
    }
}
