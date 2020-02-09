package com.bombox.models;

import com.bombox.utils.Enums.CharacterType;

public class Player extends Character  {

    public Player(String name) {

        // setting name
        super.Name = name;
        // setting character type
        super.Type = CharacterType.PLAYER;
    }

}