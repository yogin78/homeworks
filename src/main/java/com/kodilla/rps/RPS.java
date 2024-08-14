package com.kodilla.rps;
import java.util.Random;
import java.util.Scanner;

public class RPS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Set player's name
        System.out.println("Enter your name: ");
        String playerName = scanner.nextLine();

        // Set the number of rounds required to win
        System.out.println("Enter the number of rounds to win: ");
        int roundsToWin = scanner.nextInt();

        int playerScore = 0;
        int computerScore = 0;

        // Main game loop
        while (playerScore < roundsToWin && computerScore < roundsToWin) {
            // Get player's move
            System.out.println("Enter your move (1 for Rock, 2 for Paper, 3 for Scissors): ");
            int playerMove = scanner.nextInt();

            // Generate computer's move
            int computerMove = random.nextInt(3) + 1;

            // Show moves
            System.out.println(playerName + " chose " + moveToString(playerMove));
            System.out.println("Computer chose " + moveToString(computerMove));

            // Determine the winner of this round
            if (playerMove == computerMove) {
                System.out.println("It's a tie!");
            } else if ((playerMove == 1 && computerMove == 3) ||
                    (playerMove == 2 && computerMove == 1) ||
                    (playerMove == 3 && computerMove == 2)) {
                System.out.println(playerName + " wins this round!");
                playerScore++;
            } else {
                System.out.println("Computer wins this round!");
                computerScore++;
            }

            // Show the current score
            System.out.println("Score: " + playerName + " " + playerScore + " - " + computerScore + " Computer");
        }

        // Determine the overall winner
        if (playerScore == roundsToWin) {
            System.out.println("Congratulations, " + playerName + "! You won the game!");
        } else {
            System.out.println("Computer wins the game! Better luck next time, " + playerName + ".");
        }

        scanner.close();
    }

    // Method to convert move number to move name
    private static String moveToString(int move) {
        switch (move) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "Invalid move";
        }
    }
}
