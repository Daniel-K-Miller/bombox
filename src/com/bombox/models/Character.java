package com.bombox.models;

import com.bombox.utils.Enums.CharacterType;
import java.util.UUID;

public class Character {

    // config
    protected UUID Id = UUID.randomUUID();
    protected String Name = null;
    protected CharacterType Type = CharacterType.DEFAULT;

    // state
    protected int Score = 0;
    protected int CurrentGuess = 0;
    protected int RoundsWon = 0;

    public String getName() {
        return Name;
    }

    public UUID getId() {
        return Id;
    }

    public String setId() {
        return Id.toString();
    }

}