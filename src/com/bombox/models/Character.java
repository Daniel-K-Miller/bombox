package com.bombox.models;

import com.bombox.utils.Enums.CharacterType;

public class Character {

    // config
    protected String Id = null;
    protected String Name = null;
    protected CharacterType Type = CharacterType.DEFAULT;

    // state
    private int Score = 0;
    private int CurrentGuess = 0;
    private int RoundsWon = 0;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

}