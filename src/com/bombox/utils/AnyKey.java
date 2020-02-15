package com.bombox.utils;

public class AnyKey {
    public static void pressAnyKeyToContinue()
    {
        System.out.printf("Press %s'Enter'%s key to continue...\n", Styling.ANSI_GREEN, Styling.ANSI_RESET);
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}

    }
}
