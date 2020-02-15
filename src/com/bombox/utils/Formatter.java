package com.bombox.utils;

import java.util.ArrayList;
import java.util.Collections;

public class Formatter {

    public static void List(ArrayList previousGuesses) {

        Collections.sort(previousGuesses);

        String message = "Previous guesses are: " + Styling.ANSI_PURPLE;

        for (int i = 0; i < previousGuesses.size(); i++) {
            Object guess = previousGuesses.get(i);
            if (i < previousGuesses.size() - 1) {
                message += guess.toString() + ", ";
            } else {
                message += guess.toString() + Styling.ANSI_RESET + ".\n";
            }
        }
        System.out.print(message);
    }
}
