package com.bombox.models;

import com.bombox.utils.Enums.CharacterType;

public class Player extends Character  {

    public Player(String name) {
        super.Name = name;
        super.Type = CharacterType.PLAYER;
    }

}