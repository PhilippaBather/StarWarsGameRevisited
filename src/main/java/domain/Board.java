package domain;

import java.util.Random;

public class Board {

    // member fields
    private static final Random randomNumberGenerator = new Random();
    private static final String FREE = "L";
    private static final int COLUMNS = 5;
    private static final int ROWS = 5;

    // instance fields
    private final String[][] board;
    Player player;

    // constructor      // player passed to populate board with counters specific to character
    public Board(Player player) {
        this.board = new String[ROWS][COLUMNS];
        this.player = player;
        // populate board to start game
        fillBoardFree();
        addPlayer();
        addEnemies();
    }

    // other methods

    /**
     * Populates board with F for Free.
     */
    private void fillBoardFree() {
        for (int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++){
                board[i][j] = FREE;
            }
        }
    }

    /**
     * Populates board with player
     */
    private void addPlayer() {
        int col, row;
        boolean isValidCoordinate = false;

        while (!isValidCoordinate) {
            col = randomNumberGenerator.nextInt(COLUMNS);
            row = randomNumberGenerator.nextInt(ROWS);
            if (this.board[row][col].equals(FREE)) {
                this.board[row][col] = player.getPlayerCounter();
                int[][] coordinates = {{row}, {col}};
                player.setCoordinates(coordinates);
                isValidCoordinate = true;
            }
        }
    }

    /**
     * Populates the board with 5 enemies using Random
     * to generate a coordinate.  The coordinate to be populated
     * must be a Free square.
     */
     private void addEnemies() {
        int col, row;
        int count = 0;

        while(count < player.getEnemies()) {
            col = randomNumberGenerator.nextInt(COLUMNS);
            row = randomNumberGenerator.nextInt(ROWS);
            if (this.board[row][col].equals(FREE)) {
                this.board[row][col] = player.getEnemyCounter();
                count++;
            }
        }
    }

    /**
     * Prints the board to the console.
     */
    public void print() {
        System.out.println("\n");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
