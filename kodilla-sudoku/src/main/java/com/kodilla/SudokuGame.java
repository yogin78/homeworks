package com.kodilla;

import java.util.Scanner;

public class SudokuGame {
    private final SudokuBoard board;
    private final Scanner scanner;

    public SudokuGame() {
        board = new SudokuBoard();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to the Sudoku Game!");
        board.printBoard();

        while (true) {
            System.out.println("Enter a command (e.g., 1 1 5 to place 5 at (1, 1), SUDOKU to solve, QUIT to quit):");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("QUIT")) {
                System.out.println("Goodbye!");
                break;
            }

            if (input.equals("SUDOKU")) {
                if (board.solve()) {
                    System.out.println("Sudoku Solved!");
                } else {
                    System.out.println("This Sudoku cannot be solved.");
                }
                board.printBoard();
                continue;
            }

            String[] parts = input.split(" ");
            if (parts.length == 3) {
                try {
                    int row = Integer.parseInt(parts[0]);
                    int col = Integer.parseInt(parts[1]);
                    int number = Integer.parseInt(parts[2]);

                    if (row >= 1 && row <= 9 && col >= 1 && col <= 9 && number >= 1 && number <= 9) {
                        if (board.canPlaceNumber(row, col, number)) {
                            board.setNumber(row, col, number);
                            System.out.println("Number placed.");
                        } else {
                            System.out.println("Invalid move: " + number + " cannot be placed at (" + row + ", " + col + ")");
                        }
                        board.printBoard();
                    } else {
                        System.out.println("Invalid input. Row, column, and number must be between 1 and 9.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter numbers in the format: row column number.");
                }
            } else {
                System.out.println("Invalid input format.");
            }
        }
    }
}
