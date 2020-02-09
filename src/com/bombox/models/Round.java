package com.bombox.models;

import java.util.ArrayList;

public class Round {

    int roundNumber = 0;
    int totalRounds = 0;
    int bombNumber = 0;
    ArrayList<Character> allPlayers = new ArrayList<Character>();
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
    }

    private int GenerateBombNumber() {
        return (int) Math.ceil(Math.random() * this.maxNumberGuess);
    }

}
