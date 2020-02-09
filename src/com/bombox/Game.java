package com.bombox;

import java.util.ArrayList;

import com.bombox.models.Character;
import com.bombox.utils.Enums.Mode;
import com.bombox.models.*;

public class Game {

    // config
    ArrayList<Player> Players = new ArrayList<Player>();
    ArrayList<Bot> Bots = new ArrayList<Bot>();
    int TotalRound = 0;
    ArrayList<Round> Rounds = new ArrayList<Round>();
    int NumberOfPlayer = 0;
    int NumberOfBots = 0;
    int MaxNumberGuess = 10;
    Mode GameMode = Mode.DEFAULT;
    boolean IsModeSet = false;
    boolean ArePlayersSet = false;
    boolean AreBotsSet = false;
    boolean AreRoundsSet = false;

    // state
    int CurrentRound = 0;

    public static void Init() {
        System.out.println("Game initiated");
        Game.GenerateBot();
    }

    private static void GenerateBot() {

        ArrayList<String> takenNames = new ArrayList<>();

        Bot test = new Bot(takenNames);
    }

    private static void GeneratePlayer() {

        Player player = new Player("Charlie");

        System.out.println(player.getName());

    }

}