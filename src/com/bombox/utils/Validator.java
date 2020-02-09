package com.bombox.utils;

import java.util.Scanner;

public class Validator {

    public static int Number() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");

        int number = scanner.nextInt();

        System.out.println(number);

        return 2;
    }

}
