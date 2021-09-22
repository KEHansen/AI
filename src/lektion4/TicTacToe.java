package lektion4;

public class TicTacToe {

    static String[][] board = {{" "," "," "},{" "," "," "},{" "," "," "}};






    static Boolean isValid(int x, int y) {
        return  (x >= 0 && x < 3 && y >= 0 && y < 3 && board[x][y].equals(" "));
    }

    public static void main(String[] args) {

    }

}
