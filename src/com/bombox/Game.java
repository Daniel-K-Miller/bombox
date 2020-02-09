package com.bombox;

import java.util.ArrayList;

import com.bombox.utils.Enums.Mode;
import com.bombox.models.*;
import com.bombox.utils.Validator;
import com.bombox.utils.Validator.*;

public class Game {

    // config
    static ArrayList<Player> Players = new ArrayList<Player>();
    static ArrayList<Bot> Bots = new ArrayList<Bot>();
    static int TotalRound = 0;
    static ArrayList<Round> Rounds = new ArrayList<Round>();
    static int NumberOfPlayer = 0;
    static int NumberOfBots = 3;
    static int MaxNumberGuess = 10;
    static Mode GameMode = Mode.DEFAULT;
    static boolean IsModeSet = false;
    static boolean ArePlayersSet = false;
    static boolean AreBotsSet = false;
    static boolean AreRoundsSet = false;

    // state
    static int CurrentRound = 0;

    public static void Init() {
        System.out.println("Game initiated");
        Game.GeneratePlayer();
    }

    private static void GenerateBot() {

        ArrayList<String> takenNames = new ArrayList<>();

        //      name of bot is added to takenNames ArrayList
        //      and passed into every new instance of Bot
        //      to prevent same name being reused
        for (int i = 0; i < Game.NumberOfBots; i++) {
            // creating instance of bot
            Bot newBot = new Bot(takenNames);
            // adding bot to static Bot ArrayList
            Game.Bots.add(newBot);
            // adding bot name field of instance to takenNames ArrayList
            takenNames.add(newBot.getName());
        }
    }

    private static void GeneratePlayer() {

        Player player = new Player("Charlie");

        ArrayList<Integer> previousGuesses = new ArrayList<Integer>();

        previousGuesses.add(1);
        previousGuesses.add(2);



    }

}