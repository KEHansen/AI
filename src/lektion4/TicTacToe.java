package lektion4;

import java.util.Scanner;

public class TicTacToe {

    static Scanner in = new Scanner(System.in);

    static String outcome;

    static String[][] board = {{"╺","━","━","━","╸"},{"┃"," "," "," ","┃"},{"┃"," "," "," ","┃"},{"┃"," "," "," ","┃"},{"╺","━","━","━","╸"}};

    static void printmatrix(String[][] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static Boolean gameOver() {
        for (int i = 1; i < board.length-1; i++) {
            if (board[i][1].equals("x") && board[i][2].equals("x") && board[i][3].equals("x")) {
                outcome = "Croos wins";
                return true;
            }
        }

        for (int i = 1; i < board.length-1; i++) {
            if (board[1][i].equals("x") && board[2][i].equals("x") && board[3][i].equals("x")) {
                outcome = "Croos wins";
                return true;
            }
        }

        if ((board[3][3].equals("x") && board[1][1].equals("x") && board[2][2].equals("x")) || (board[1][3].equals("x") && board[2][2].equals("x") && board[3][1].equals("x"))) {
            outcome = "Croos wins";
            return true;
        }

        for (int i = 1; i < board.length-1; i++) {
            if (board[i][3].equals("o") && board[i][1].equals("o") && board[i][2].equals("o")) {
                outcome = "Cirkel wins";
                return true;
            }
        }

        for (int i = 1; i < board.length-1; i++) {
            if (board[3][i].equals("o") && board[1][i].equals("o") && board[2][i].equals("o")) {
                outcome = "Cirkel wins";
                return true;
            }
        }

        if ((board[3][3].equals("o") && board[1][1].equals("o") && board[2][2].equals("o")) || (board[1][3].equals("o") && board[2][2].equals("o") && board[3][1].equals("o"))) {
            outcome = "Cirkel wins";
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(" "))
                    return false;
            }
        }
        outcome = "Tie";
        return true;
    }

    static Boolean isValid(int x, int y) {
        return  (x > 0 && x <= 3 && y > 0 && y <= 3 && board[x][y].equals(" "));
    }

    public static void main(String[] args) {

        int x, y;

        while (!gameOver()) {
            printmatrix(board);
            while (true) {
                x = in.nextInt();
                y = in.nextInt();
                if (isValid(x,y)) {
                    board[x][y] = "x";
                    break;
                } else {
                    System.out.println("Not valid!");
                }
            }

            if (gameOver())
                break;

            printmatrix(board);

            while (true) {
                x = in.nextInt();
                y = in.nextInt();
                if (isValid(x,y)) {
                    board[x][y] = "o";
                    break;
                } else {
                    System.out.println("Not valid!");
                }
            }
        }

        printmatrix(board);
        System.out.println(outcome);

    }

}
