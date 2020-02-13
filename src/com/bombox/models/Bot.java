package com.bombox.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bombox.utils.Enums.CharacterType;

public class Bot extends Character {

    List<String> names = new ArrayList<>(Arrays.asList("Caleb", "Zac", "Temi", "Ava", "Mason", "Jack", "Albie", "Tess", "Fin", "Alex", "Matilda", "William", "Lucas", "Charlie", "Jamie", "Mario"));

    public Bot(ArrayList<String> takenNames) {

        // setting random non-duplicate name
        for (String takenName : takenNames) {
            names.removeIf(name -> takenName == name);
        }
        int random = (int)Math.floor(Math.random() * names.size());
        super.Name = "bot_" + names.get(random);

        // setting character type
        super.Type = CharacterType.BOT;
    }

    public int MakeGuess(ArrayList<Integer> previousGuesses, int bombNumber, int maxNumberGuess) {

        ArrayList<Integer> availableGuesses = new ArrayList<Integer>();

        // filling available guesses with all possible answers
        for (int i = 0; i < maxNumberGuess; i++) {
            availableGuesses.add(i + 1);
        }

        // looping through previous guesses
        for (int previousGuess : previousGuesses) {
            // if previousGuess is in available guesses remove it from that arrayList
            if (availableGuesses.contains(previousGuess)) {
                int index = availableGuesses.indexOf(previousGuess);
                availableGuesses.remove(index);
                // TODO might still be bugged not tested
            }
        }

        int randomIndex = (int) Math.floor(Math.random() * availableGuesses.size());
        int randomGuess = availableGuesses.get(randomIndex);

        if (randomGuess != bombNumber) {
            System.out.printf("%s guessed %s and avoided the bomb!\n", this.Name, randomGuess);
        } else if (randomGuess == bombNumber) {
            System.out.printf("%s guessed %s and DETONATED THE BOMB!!\n", this.Name, randomGuess);
        }

        return randomGuess;
    }
}