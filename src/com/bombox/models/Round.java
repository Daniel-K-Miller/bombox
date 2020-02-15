package com.bombox.models;

import java.util.ArrayList;

import com.bombox.utils.AnyKey;
import com.bombox.utils.Formatter;
import com.bombox.utils.Styling;

public class Round {

    int roundNumber = 0;
    int totalRounds = 0;
    int bombNumber = 0;
    ArrayList<Character> allPlayers = new ArrayList<Character>();
    ArrayList<Integer> previousGuesses = new ArrayList<Integer>();
    int maxNumberGuess = 0;
    int amountOfTurns = 0;
    Character characterThatTriggeredBomb = null;
    boolean hasBombTriggered = false;

    public Round(int roundNumber, ArrayList<Player> players, ArrayList<Bot> bots, int totalRounds, int maxNumberGuess) {
        this.roundNumber =  roundNumber;
        this.totalRounds = totalRounds;
        this.bombNumber = 0;
        // building up all players list
        this.allPlayers.addAll(players);
        this.allPlayers.addAll(bots);
        this.maxNumberGuess = maxNumberGuess;


        this.Init();
    }

    private void Init() {
        this.PrintRoundNumber();
        this.GenerateBombNumber();
        this.TriggerRoundGuesses();
        this.PrintScores();
    }

    private void PrintRoundNumber() {
        System.out.printf("%sRound %s of %s started%s\n", Styling.ANSI_CYAN, this.roundNumber, this.totalRounds, Styling.ANSI_RESET);
    }

    private void GenerateBombNumber() {
        this.bombNumber = (int) Math.ceil(Math.random() * this.maxNumberGuess);
    }

    private void TriggerRoundGuesses() {
        while (this.hasBombTriggered == false) {
            for (Character character : this.allPlayers) {
                // displaying previous guesses if they exit
                if (this.previousGuesses.size() > 0) {
                    Formatter.List(this.previousGuesses);
                }

                int guess = character.MakeGuess(this.previousGuesses, this.bombNumber, this.maxNumberGuess);
                this.previousGuesses.add(guess);
                if (guess == this.bombNumber) {
                    this.hasBombTriggered = true;
                    this.characterThatTriggeredBomb = character;
                    break;
                }
                this.amountOfTurns++;
            }
        }
    }

    private void PrintScores() {

        System.out.printf("\n%sEnd of Round %s Scores...%s\n", Styling.ANSI_PURPLE, this.roundNumber, Styling.ANSI_RESET);
        for (Character character : this.allPlayers) {
            if (character != this.characterThatTriggeredBomb) {
                character.Score += amountOfTurns;
            }

            if (character != this.characterThatTriggeredBomb) {
                System.out.printf("%s: %s\n", character.getName(), character.Score);
            } else {
                System.out.printf("%s%s: %s%s\n", Styling.ANSI_RED, character.getName(), character.Score, Styling.ANSI_RESET);
            }

        }
        System.out.println("\n");
        AnyKey.pressAnyKeyToContinue();

    }
}
