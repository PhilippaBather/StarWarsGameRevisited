package domain;

import java.util.Random;

/**
 * Class creates game board object and contains methods to populate and
 * repopulate the board according to the game play.
 */
public class Board {

    // member fields
    private static final Random randomNumberGenerator = new Random();
    private static final String FREE = "L";
    private static final int COLUMNS = 5;
    private static final int ROWS = 5;

    // instance fields
    private String[][] board;
    Player player;

    // constructor      // player passed to populate board with counters specific to character
    public Board(Player player) {
        this.board = new String[ROWS][COLUMNS];
        this.player = player;
        // populate board to start game
        fillBoardFree();
        addPlayer();
        addEnemies();
        addPotions();
    }

    // getters and setters

    public static int getCOLUMNS() {
        return COLUMNS;
    }

    public static int getROWS() {
        return ROWS;
    }


    // other methods

    public String getBoardCounter(int row, int col) {
        return board[row][col];
    }

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
     * Populates board initially with a player counter placed
     * randomly.
     */
    private void addPlayer() {
        int col, row;
        boolean isValidCoordinate = false;

        while (!isValidCoordinate) {
            col = randomNumberGenerator.nextInt(COLUMNS);
            row = randomNumberGenerator.nextInt(ROWS);
            if (this.board[row][col].equals(FREE)) {
                this.board[row][col] = player.getPlayerCounter();
                int[] coordinates = {row, col};
                player.setCoordinates(coordinates);
                isValidCoordinate = true;
            }
        }
    }

    /**
     * Populates the board with enemies using Random
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
     * Populates board with Potions.  The coordinate to be populated
     * must be a Free square.
     */
    private void addPotions() {
        int col, row;
        int count = 0;

        while (count < player.getPotions()) {
            col = randomNumberGenerator.nextInt(COLUMNS);
            row = randomNumberGenerator.nextInt(ROWS);
            if (this.board[row][col].equals(FREE)) {
                this.board[row][col] = player.getPotionCounter();
                count++;
            }
        }
    }

    /**
     * Repopulate board with player in new position.
     */
    public void repopulateBoard() {
        int row = player.getCoordinateRow();
        int col = player.getCoordinatesColumn();

        fillBoardFree();
        board[row][col] = player.getPlayerCounter();    // reposition player
        addEnemies();
        addPotions();
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
