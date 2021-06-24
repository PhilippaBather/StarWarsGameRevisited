package com.philippa.Main;

import domain.*;

import java.util.Scanner;

/**
 * Menu class controls the game's logic.
 */
public class Menu {

    private static int player = 1;  // keeps track of player
    private static final Scanner scanner = new Scanner(System.in);

    public static void executeMenu() {
        boolean quit;
        // create player objects and their respective boards
        Player yoda = new Yoda();
        Board yodaBoard = new Board(yoda);
        Player darthVader = new DarthVader();
        Board darthBoard = new Board(darthVader);

        // print opening blurb
        openingMessage();

        // begin do-while loop
        do {
            // print lives score
            printLivesScore(yoda, darthVader);

            // adjust player and their board using a copy of the appropriate player and board objects
            Player currentPlayer = (player == 1) ? yoda : darthVader;
            Board currentBoard = (player == 1) ? yodaBoard : darthBoard;

            // print current player's board
            printBoard(currentBoard);

            // get next move from current player
            getNextMove();

            // check for win
            quit = checkGameState(currentPlayer);

            // change player
            player = (player == 1) ? 2 : 1;

        } while(!quit);
    }

    /**
     * Prints to console the opening message for the game.
     */
    private static void openingMessage() {
        System.out.println("*************************************JUEGO DE YODA Y DARTH VADER****************************************************");
        System.out.println("*******************************************************************************************************************");
        System.out.println();
        System.out.println("Jugador 1...YODA: Mueva la ficha y evita los DARTH MAULS (D) escondidos.  Si caiga con un vaquero pierdes una vida.");
        System.out.println();
        System.out.println("Jugador 2...DARTH VADER: Mueva la ficha y evita los R2 D2s (R) escondidos.  Si caiga con un indio, pierdes una vida.");
        System.out.println();
        System.out.println("Ambos jugadores teneís 3 vidas.  El perdedor es el primer a perder sus vidas.");
        System.out.println();
        System.out.println("Movimientos: Derecha (D), Izquierda (A), Arriba (W) y Abajo (S)");
        System.out.println("Movimientos: Derecha-Arriba (E), Izquierda-Arriba (Q), Derecha-Abajo (X) y Izquerida-Abajo (Z)");
        System.out.println();
        System.out.println("Pero recuerda: podeis aparecer por el lado contrario del tablero, ya que 'THE FORCE IS WITH YOU',"
                + "\npero para que no hagais trampas, no podeis aparecer por el otro lado del tablero en 3 ocasiones: 0,0, 4,0, y 0,4");
        System.out.println();
        System.out.println("Hay tres pocimas en cada tabla.  Si caigas sobre la casilla de una pocima, ganas una vida y hay una pocima menos por la tabla.\n"
                + "Pero recuerda: las pocimas saltan con cada jugador;");
        System.out.println("*******************************************************************************************************************");
        System.out.println();
    }

    /**
     * Prints to console the number of lives remaining for each player.
     */
    private static void printLivesScore(Player player1, Player player2 ) {
        System.out.println("*********************Vidas*********************\n"
                + "Jugador 1: Yoda - " + player1.getLives() +
                "\nJugador 2: Darth Vader - " + player2.getLives() + "\n"
                + "***********************************************");
    }

    /**
     * Prints to console the board of the specified player.
     */
    private static void printBoard(Board board) {
        board.print();
    }

    /**
     * Repopulates player's board if move is valid.
     */
    private static void repopulateBoard() {
        // TODO
    }

    /**
     * Obtains user move.
     */
    private static void getNextMove() {
        boolean isValid = false;

        System.out.println("\nEnter move: ");
        String move = scanner.nextLine().toUpperCase();

        while (!isValid) {
            switch (move) {
                case "D":       // right
                    isValid = checkMoveValid();
                    break;
                case "A":       // left
                    break;
                case "W":       // up
                    break;
                case "S":       // down
                    break;
                default:
                    System.out.println("\nIntroduzca un movimiento válido\nD (derecha), A (izquierda), W (arriba), S (abajo)");
                    isValid = true; // CHANGE THIS - UNNECESSARY; HERE TO STOP AN INFINITE LOOP

            }
        }
    }

    /**
     * Determines if move valid.
     */
    private static boolean checkMoveValid() {
        // TODO
        // out of bounds: false
        // life lost: true (but decrement lives and enemy coutners)
        // potion received: true (but increment lives)
        // life lost?: true (but lives need adjusting)
        return false;

    }

    /**
     * Checks that the move is within the bounds of the board.
     */
    private static void checkOutOfBounds() {
        // TODO
    }

    /**
     * Checks if enemy is on the coordinate destination.
     */
    private static void checkForEnemy() {
        // TODO
        // if enemy: decrement player's life counter
        // if enemy: decrement player's enemy counter
    }

    /**
     * Checks if potion is on the coordinate destination.
     */
    private static void checkForPotion() {
        // TODO
        // if potion: increment player's life counter
        // if potion: decrement potions
    }

    /**
     * Removes life if player lands on an enemy.
     */
    private static void deleteLife() {
        // TODO
    }

    /**
     * Adds life if player lands on a potion.
     */
    private static void addLife() {
        // TODO
    }

    private static boolean checkGameState(Player currentPlayer) {
        if (currentPlayer.isWinner()) {     // if true
            System.out.println("\n" + currentPlayer.getName() + " GANA!!!!");
            return true;
        }
        return false;
    }
}
