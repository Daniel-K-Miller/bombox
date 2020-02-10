package com.bombox.models;

import java.util.ArrayList;
import com.bombox.utils.Formatter;

public class Round {

    int roundNumber = 0;
    int totalRounds = 0;
    int bombNumber = 0;
    ArrayList<Character> allPlayers = new ArrayList<Character>();
    ArrayList<Integer> previousGuesses = new ArrayList<Integer>();
    int maxNumberGuess = 0;
    int amountOfTurns = 0;
    Character characterThatTriggeredBomb = null;
    boolean isBombTriggered = false;

    public Round(int roundNumber, ArrayList<Player> players, ArrayList<Bot> bots, int totalRounds, int maxNumberGuess) {
        this.roundNumber =  roundNumber;
        this.totalRounds = totalRounds;
        this.bombNumber = this.GenerateBombNumber();
        // building up all players list
        this.allPlayers.addAll(players);
        this.allPlayers.addAll(bots);
        this.maxNumberGuess = maxNumberGuess;


        this.Init();
    }

    private void Init() {


    }

    private int GenerateBombNumber() {
        return (int) Math.ceil(Math.random() * this.maxNumberGuess);
    }

    public void displayPreviousGuesses() {

        if (this.previousGuesses.size() > 0) {
            Formatter.List(this.previousGuesses);
        }

    }

    private void triggerRoundGuesses() {
        for (Character character : this.allPlayers) {
            // TODO might need to re-think this, seperate bots/players
        }
    }
}
