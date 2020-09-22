package me.intriguing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private Board board;
    private Player playerOne;
    private Player playerTwo;
    static Scanner s;

    public Game(Board board, Player playerOne, Player playerTwo, Scanner s) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        Game.s = s;
        start();
    }

    public void start() {
        System.out.println("Hey! Let's get started. I'm Bill, and I'll be the host of this TicTacToe game.");
        System.out.printf("%s VS %s%n%n", playerOne.getName().toUpperCase(), playerTwo.getName().toUpperCase());

        Player currentPlayer = playerOne;
        while (true) {
            // Print Board
            board.printBoard();

            // Enter number task
            System.out.println(currentPlayer.getName() + "'s turn: ");
            while (true) {
                int responseIndNumber;
                try {
                    System.out.println("Enter an index (1 - 9)");
                    responseIndNumber = s.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("You entered an invalid integer. Please try again.");
                    s.next();
                    continue;
                }

                if (responseIndNumber < 1 || responseIndNumber > 9) continue;
                String userResponse = board.getIndex(responseIndNumber);
                int[] value = getIndexProperty(userResponse);
                if (board.checkExists(value[0], value[1])) {
                    System.out.println("Invalid! Character already exists at that index. Try again:");
                    continue;
                }

                board.setIndex(value[0], value[1], currentPlayer.getLetter());
                break;
            }

            if (board.checkWin(currentPlayer)) {
                board.printBoard();
                System.out.println(currentPlayer.getName() + " has won the game!");
                break;
            }
            System.out.println(board.checkTie());
            if (board.checkTie()) {
                board.printBoard();
                System.out.println("Game was tied!");
                break;
            }

            if (currentPlayer == playerOne) currentPlayer = playerTwo;
            else currentPlayer = playerOne;

        }


    }

    private int[] getIndexProperty(String response) {
        int[] organizedValue = new int[2];
        for (int i = 0; i <= 1; i++) {
            organizedValue[i] = Integer.parseInt(response.split(";")[i].split("=")[1]);
        }

        return organizedValue;
    }



}
