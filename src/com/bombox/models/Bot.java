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
        super.Name = names.get(random);

        // setting character type
        super.Type = CharacterType.BOT;
    }


}