package lektion2;

import java.util.ArrayList;
import java.util.Scanner;

public class Maze3 {

    static Scanner in = new Scanner(System.in);

    static Point start, goal;

    static Point[] dir = {   new Point(0, 1), new Point(1, 0),
                                    new Point(0, -1), new Point(-1, 0)};

    static String[][] maze = {
            {"¤", "¤", "¤", "¤", "¤", "¤", "¤", "¤", "¤", "¤", "¤", "¤", "¤"},
            {"¤", " ", "¤", " ", "¤", " ", "¤", " ", " ", " ", " ", " ", "¤"},
            {"¤", " ", "¤", " ", " ", " ", "¤", " ", "¤", "¤", "¤", " ", "¤"},
            {"¤", " ", " ", "S", "¤", "¤", "¤", " ", " ", " ", " ", " ", "¤"},
            {"¤", " ", "¤", " ", " ", " ", " ", " ", "¤", "¤", "¤", " ", "¤"},
            {"¤", " ", "¤", " ", "¤", "¤", "¤", " ", "¤", " ", " ", " ", "¤"},
            {"¤", " ", "¤", " ", "¤", " ", " ", " ", "¤", "¤", "¤", " ", "¤"},
            {"¤", " ", "¤", " ", "¤", "¤", "¤", " ", "¤", " ", "¤", " ", "¤"},
            {"¤", " ", " ", " ", " ", " ", " ", " ", " ", " ", "¤", "G", "¤"},
            {"¤", "¤", "¤", "¤", "¤", "¤", "¤", "¤", "¤", "¤", "¤", "¤", "¤"}};


    static void printmatrix(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean findS(String[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j].equals("S"))
                    start = new Point(i, j);
                if (maze[i][j].equals("G"))
                    goal = new Point(i,j);
            }
        }
        return (start != null && goal != null);
    }

    static ArrayList<Point> check(Point p) {
        double dist = p.distance(goal);
        double temp;
        for (int i = 0; i < dir.length; i++) {
            p.distance(goal);
        }
    }

    static boolean solve(Point pos) {
        int x = pos.getX();
        int y = pos.getY();
        ArrayList<Point> order = new ArrayList<>();

        if (maze[x][y + 1].equals(" ") || maze[x][y + 1].equals("G")) {
            order.add(new Point(pos.x, pos.y + 1));
        }
        if (maze[x + 1][y].equals(" ") || maze[x + 1][y].equals("G")) {
            order.add(new Point(pos.x + 1, pos.y));
        }
        if (maze[x][y - 1].equals(" ") || maze[x][y - 1].equals("G")) {
            order.add(new Point(pos.x, pos.y - 1));
        }
        if (maze[x - 1][y].equals(" ") || maze[x - 1][y].equals("G")) {
            order.add(new Point(pos.x - 1, pos.y));
        }

        if (order.size() == 0)
            return false;

        if (order.size() == 1) {
            if (solve(order.get(0))){
                System.out.print(order.get(0));
                return true;
            }
        } else {
            for (int i = 1; i < order.size(); i++) {
                if (order.get(i-1).distance(goal) > order.get(0).distance(goal)) {
                    order.sort();
                }
            }
            for (Point point : order) {
                if (solve(point)) {
                    System.out.print(point);
                    return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {

    }

}