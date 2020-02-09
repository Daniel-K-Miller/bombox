package com.bombox.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bot {

    List<String> names = new ArrayList<>(Arrays.asList("Caleb", "Zac", "Temi", "Ava", "Mason", "Jack", "Albie", "Tess", "Fin", "Alex", "Matilda", "William", "Lucas", "Charlie", "Jamie", "Mario"));

    public Bot(ArrayList<String> takenNames) {

        int random = (int)Math.floor(Math.random() * names.size());

        System.out.println(names.get(random));

    }


}