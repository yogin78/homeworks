package com.kodilla;

public class SudokuBoard {
    private final int[][] board;

    public SudokuBoard() {
        board = new int[9][9];
    }

    public int getNumber(int row, int col) {
        return board[row - 1][col - 1];
    }

    public void setNumber(int row, int col, int number) {
        board[row - 1][col - 1] = number;
    }

    public boolean canPlaceNumber(int row, int col, int number) {
        return isRowValid(row, number) && isColValid(col, number) && isBlockValid(row, col, number);
    }

    private boolean isRowValid(int row, int number) {
        for (int col = 0; col < 9; col++) {
            if (board[row - 1][col] == number) {
                return false;
            }
        }
        return true;
    }

    private boolean isColValid(int col, int number) {
        for (int row = 0; row < 9; row++) {
            if (board[row][col - 1] == number) {
                return false;
            }
        }
        return true;
    }

    private boolean isBlockValid(int row, int col, int number) {
        int blockRowStart = (row - 1) / 3 * 3;
        int blockColStart = (col - 1) / 3 * 3;

        for (int r = blockRowStart; r < blockRowStart + 3; r++) {
            for (int c = blockColStart; c < blockColStart + 3; c++) {
                if (board[r][c] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0 && r != 0) {
                System.out.println("------+-------+------");
            }
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0 && c != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[r][c] == 0 ? "." : board[r][c]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solve() {
        for (int row = 1; row <= 9; row++) {
            for (int col = 1; col <= 9; col++) {
                if (getNumber(row, col) == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (canPlaceNumber(row, col, num)) {
                            setNumber(row, col, num);
                            if (solve()) {
                                return true;
                            } else {
                                setNumber(row, col, 0);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
