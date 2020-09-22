package me.intriguing;

import java.util.Scanner;

public class TicTacToe {

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Before we start the game...");
        System.out.println("What is Player 1's name? (X)");
        Player player1 = new Player(s.nextLine(), 'X');
        System.out.println("What is Player 2's name? (O)");
        Player player2 = new Player(s.nextLine(), 'O');
        System.out.println("Starting game...");

        Board board = new Board();
        Game game = new Game(board, player1, player2, s);
        s.close();

    }




}
