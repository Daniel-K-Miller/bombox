package com.bombox.models;

import com.bombox.utils.Enums.CharacterType;
import com.bombox.utils.Validator;

import java.util.ArrayList;

public class Player extends Character  {

    public Player(String name) {

        // setting name
        super.Name = name;
        // setting character type
        super.Type = CharacterType.PLAYER;
    }

    public int MakeGuess(ArrayList<Integer> previousGuesses, int bombNumber, int maxNumberGuess) {

        System.out.printf("%s make a guess between 1 - %s\n", this.Name, maxNumberGuess);

        int guess = Validator.Number(1, 10);

        if (guess != bombNumber) {
            System.out.printf("%s guessed %s and avoided the bomb!\n", this.Name, guess);
        } else if (guess == bombNumber) {
            System.out.printf("%s guessed %s and DETONATED THE BOMB!!\n", this.Name, guess);
        }

        return guess;
    }

}