package com.example.keyboardservice.controller;

import com.example.keyboardservice.model.Keyboard;
import com.example.keyboardservice.model.Message;
import com.example.keyboardservice.service.KeyService;
import com.example.keyboardservice.service.KeyboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("keyboard")
public class AppController {

    private final KeyboardService keyboardService;
    private final KeyService keyService;

    public AppController(KeyboardService keyboardService, KeyService keyService) {
        this.keyboardService = keyboardService;
        this.keyService = keyService;
    }

    @GetMapping()
    @ResponseBody
    public ResponseEntity<Keyboard> getKeyboard() {
        return ResponseEntity.ok(keyboardService.getKeyboard());
    }

    @PostMapping("/key")
    @ResponseBody
    public ResponseEntity<Message> handleKey(@RequestBody Message message) {
        return ResponseEntity.ok(keyService.handleMessage(message));
    }
}
