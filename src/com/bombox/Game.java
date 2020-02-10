package com.bombox;

import java.util.ArrayList;
import java.util.Scanner;

import com.bombox.utils.Enums.*;
import com.bombox.models.*;
import com.bombox.utils.AnyKey;
import com.bombox.utils.Validator;
import com.bombox.models.Round;

public class Game {

    // config
    static ArrayList<Player> Players = new ArrayList<Player>();
    static ArrayList<Bot> Bots = new ArrayList<Bot>();
    static int TotalRounds = 0;
    static ArrayList<Round> Rounds = new ArrayList<Round>();
    static int NumberOfPlayers = 0;
    static int NumberOfBots = 0;
    static int MaxNumberGuess = 10;
    static Mode GameMode = Mode.DEFAULT;
    static boolean IsModeSet = false;
    static boolean ArePlayersSet = false;
    static boolean AreBotsSet = false;
    static boolean AreRoundsSet = false;

    // state
    static int CurrentRound = 0;

    public static void Init() {

        Game.ExplainRules();
        Game.SetMode();
        Game.GeneratePlayers();
        if (Game.GameMode == Mode.SINGLEPLAYER) {
            GenerateBots();
        }

        Round test = new Round(1, Players, Bots, 3, 10);
    }

    private static void ExplainRules() {
        // series of strings printed to console explaining rules
        System.out.printf("\n             WELCOME TO BOMB BLAST!!!!!!!!!!!!\n\n ");
        AnyKey.pressAnyKeyToContinue();
        System.out.printf("- Your object is to survive as long as possible, and accumlate the most points.\n- You accumulate points by not triggering the bomb and therefore surviving the round.\nWhere is the bomb? Within a random box\n- All boxes are empty apart from ONE\n- If you select the bomb ridden box you will receive NO POINTS!\nAnd the survivors will receive points based on how long it took the group to find the bomb\n- After a selected amount of rounds whoever has survived the most amount of attempts wins!!\n\n");
        System.out.printf("Press 'Any Key' to start setting up the game...\n");
    }

    private  static void SetMode() {

        // array using Enums to be used for validation
        Enum[] modes = {Mode.SINGLEPLAYER, Mode.MULTIPLAYER};
        // setting GameMode by passing in array to validator which will prompt what Enum is wanted
        Game.GameMode = (Mode) Validator.Mode(modes);

        // TODO could possibily rewrite so it's not an enum array but the actual enum
    }

    private static void GenerateBots() {

        System.out.println("Enter how many bots you want to play against...");
        Game.NumberOfBots = Validator.Number(1, 3);

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

    private static void GeneratePlayers() {

        if (Game.GameMode == Mode.SINGLEPLAYER) {
            Game.NumberOfPlayers = 1;
        } else if (Game.GameMode == Mode.MULTIPLAYER) {
            System.out.println("Enter how many players are going to participate...");
            Game.NumberOfPlayers = Validator.Number(2, 4);
        }

        //  validating a name String by making sure it is
        //  between a certain length, then creating an instance
        //  of Player using the validated name.
        for (int i = 0; i < Game.NumberOfPlayers; i++) {

            // doing a print to signify a name input
            System.out.printf("Player %s ", i + 1);
            // name inputted and validated
            String name = Validator.Name(3, 12);
            // new instance of player created
            Player player = new Player(name);
            // adding player instance to Player List
            Game.Players.add(player);
        }
    }

    private static void GenerateRounds() {

        System.out.printf("How many rounds do you want to play?");

        int rounds = Validator.Number(1, 10);
        Game.TotalRounds = rounds;

        for (int i = 0; i < rounds; i++) {
            Round round = new Round(i, Game.Players, Game.Bots, Game.TotalRounds, Game.MaxNumberGuess);
            // TODO trigger round guesses method
        }

    }
}