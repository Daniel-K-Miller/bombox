package com.bombox.utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Validator {

    // asks for an int input; validates it is an int and between 2 int parameters; otherwise recurse
    public static int Number(int minNum, int maxNum) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");

        try {
            int guess = input.nextInt();
            // if not between minNum & maxNum
            if (guess < minNum || guess > maxNum) {
                System.out.printf("ERROR! Number has to be between %s and %s\n", minNum, maxNum);
                return Validator.Number(minNum, maxNum);
            } else {
                // return valid input between minNum & maxNum with no errors
                System.out.println("\n");
                return guess;
            }
        }
        // input exception re-run method
        catch (Exception e) {
            return Validator.Number(minNum, maxNum);
        }
    }

    // asks for an int input; validates it is an int and between 2 int parameters; checks is not already within ArrayList;
    public static int Number(int minNum, int maxNum, ArrayList previousGuesses) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");

        try {
            int guess = input.nextInt();
            // if not between minNum & maxNum
            if (guess < minNum || guess > maxNum) {
                System.out.printf("ERROR! Number has to be between %s and %s\n", minNum, maxNum);
                return Validator.Number(minNum, maxNum, previousGuesses);
            } else {
                if (!previousGuesses.contains(guess)) {
                    // return valid input between minNum & maxNum with no errors
                    return guess;
                } else {
                    System.out.printf("%s has already been guessed!\n", guess);
                    return Validator.Number(minNum, maxNum, previousGuesses);
                }
            }
        }
        // input exception re-run method
        catch (Exception e) {
            return Validator.Number(minNum, maxNum, previousGuesses);
        }
    }

    // asks for an input; checks whether length is between 2 parameters; otherwise recurse
    public static String Name(int minLength, int maxLength) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a name: ");

        String guess = input.next();
        // if not between minNum & maxNum
        if (guess.length() < minLength || guess.length() > maxLength) {
            System.out.printf("ERROR! Name has to be between %s and %s characters\n", minLength, maxLength);
            return Validator.Name(minLength, maxLength);
        } else {
            // return valid input between minNum & maxNum with no errors
            System.out.println("\n");
            return guess;
        }
    }

    public static Enum Mode (Enum[] enums) {
        String message = "";

        for (int i = 0; i < enums.length; i++) {
            if (i != enums.length - 1) {
                message += "Enter " + (i + 1) + " for " + enums[i] + ", ";
            } else if (i == enums.length - 1) {
                message += "Enter " + (i + 1) + " for " + enums[i] + ".";
            }
        }
        System.out.println(message);
        Scanner input = new Scanner(System.in);

        try {
            int number = input.nextInt();
            // if not between minNum & maxNum
            if (number < 1 || number > enums.length) {
                System.out.printf("ERROR! Number has to be between %s and %s\n", 1, enums.length);
                return Validator.Mode(enums);
            } else {
                // return valid input between minNum & maxNum with no errors
                System.out.println("\n");
                return enums[number - 1];
            }
        }
        // input exception re-run method
        catch (Exception e) {
            return Validator.Mode(enums);
        }

    }
}


