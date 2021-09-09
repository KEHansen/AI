package lektion2;

import java.awt.*;

public class Maze {

    static Point start;

    static String[][] maze = {  {"¤","¤","¤","¤","¤","¤","¤","¤","¤","¤","¤","¤","¤"},
                                {"¤"," ","¤"," ","¤"," ","¤"," "," "," "," "," ","¤"},
                                {"¤"," ","¤"," "," "," ","¤"," ","¤","¤","¤"," ","¤"},
                                {"¤"," "," ","S","¤","¤","¤"," "," "," "," "," ","¤"},
                                {"¤"," ","¤"," "," "," "," "," ","¤","¤","¤"," ","¤"},
                                {"¤"," ","¤"," ","¤","¤","¤"," ","¤"," "," "," ","¤"},
                                {"¤"," ","¤"," ","¤"," "," "," ","¤","¤","¤"," ","¤"},
                                {"¤"," ","¤"," ","¤","¤","¤"," ","¤"," ","¤"," ","¤"},
                                {"¤"," "," "," "," "," "," "," "," "," ","¤","G","¤"},
                                {"¤","¤","¤","¤","¤","¤","¤","¤","¤","¤","¤","¤","¤"}};

    static boolean findS(String[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j].equals("S")) {
                    start = new Point(i,j);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean solve(Point pos) {
        if (maze[pos.x][pos.y].equals("G"))
            return true;
        if (maze[pos.x+1][pos.y].equals(" ") || maze[pos.x+1][pos.y].equals("G"))

        return false;
    }

    public static void main(String[] args) {



        if (findS(maze))
            System.out.println(start);


    }
}
