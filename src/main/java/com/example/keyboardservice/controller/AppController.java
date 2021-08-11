package com.example.keyboardservice.controller;

import com.example.keyboardservice.model.ButtonAction;
import com.example.keyboardservice.model.Keyboard;
import com.example.keyboardservice.model.KeyboardButton;
import com.example.keyboardservice.model.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@RestController
@RequestMapping("keyboard")
public class AppController {

    @PostMapping("/key")
    public Mono<Message> handleMessage(@RequestBody Message message) {
        return Mono.just(message).doOnNext(m -> m.setText("Вы нажали: " + m.getText()));
    }

    @GetMapping()
    public Mono<Keyboard> getKeyboard() {
        return Mono.just(createKeyboard());
    }

    private Keyboard createKeyboard() {
        ArrayList<KeyboardButton> line = new ArrayList<>();
        line.add(new KeyboardButton(new ButtonAction("{\"button\": \"1\"}", "text", "1"), "primary"));
        line.add(new KeyboardButton(new ButtonAction("{\"button\": \"2\"}", "text", "2"), "primary"));

        ArrayList<ArrayList<KeyboardButton>> keyboardButtonList = new ArrayList<>();
        keyboardButtonList.add(line);
        return new Keyboard(keyboardButtonList, true);
    }
}
