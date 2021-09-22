package lektion2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Maze3 {

    static Point start, goal;

    static Scanner in = new Scanner(System.in);

    static ArrayList<Point> sol = new ArrayList<>();

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

    static void clearMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (!(maze[i][j].equals("S") || maze[i][j].equals("G") || maze[i][j].equals("¤")))
                    maze[i][j] = " ";
            }
        }
    }

    static void showPath() {
        for (int i = 0; i < sol.size() - 1; i++) {
            maze[sol.get(i).x][sol.get(i).y] = ".";
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

    static boolean solve(Point pos) {
        int x = pos.getX();
        int y = pos.getY();
        ArrayList<Point> order = new ArrayList<>();
        String n = in.nextLine();
        printmatrix(maze);

        if (maze[x][y].equals("G"))
            return true;
        if (!(maze[x][y].equals("S") || maze[x][y].equals("G"))) {
            maze[x][y] = "v";
        }
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
                sol.add(order.get(0));
                return true;
            }
        } else {
            for (int j = 0; j < 2; j++) {
                for (int i = 1; i < order.size(); i++) {
                    if (order.get(i-1).distance(goal) > order.get(i).distance(goal)) {
                        Collections.swap(order, i-1, i);
                    }
                }
            }
            for (Point point : order) {
                if (solve(point)) {
                    sol.add(point);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        if (findS(maze)) {
            Point p = new Point(start.getX(),start.getY());
            if (solve(p)) {
                Collections.reverse(sol);
                clearMaze();
                showPath();
                System.out.println(sol);
                System.out.println("Solved!");
            } else {
                System.out.println("No solution!");
            }
            printmatrix(maze);
        }
    }

}