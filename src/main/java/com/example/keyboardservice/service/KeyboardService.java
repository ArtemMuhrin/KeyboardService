package com.example.keyboardservice.service;

import com.example.keyboardservice.model.ButtonAction;
import com.example.keyboardservice.model.Keyboard;
import com.example.keyboardservice.model.KeyboardButton;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class KeyboardService {

    public Keyboard getKeyboard() {
        ArrayList<KeyboardButton> line = new ArrayList<>();
        line.add(new KeyboardButton(new ButtonAction("{\"button\": \"1\"}","text","1"), "primary"));
        line.add(new KeyboardButton(new ButtonAction("{\"button\": \"2\"}","text","2"), "primary"));

        ArrayList<ArrayList<KeyboardButton>> keyboardButtonList = new ArrayList<>();
        keyboardButtonList.add(line);
        return new Keyboard(keyboardButtonList, true);
    }
}
