package lektion2;

import java.util.ArrayList;
import java.util.Scanner;

public class Maze2 {

    static Scanner in = new Scanner(System.in);

    static Point start;

    static ArrayList<Point> route = new ArrayList<>();
    static ArrayList<Point> solution = new ArrayList<>();

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
                if (maze[i][j].equals("S")) {
                    start = new Point(i,j);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean solve(Point pos) {
        //String n = in.nextLine();
        //printmatrix(maze);
        int x = pos.getX();
        int y = pos.getY();
        Point temp = new Point(x,y);
        System.out.println();
        if (maze[x][y].equals("G"))
            return true;
        if (!(maze[x][y].equals("S"))) {
            maze[x][y] = "v";
        }
        if (maze[x][y+1].equals(" ") || maze[x][y+1].equals("G")) {
            pos.setY(y + 1);
            route.add(temp);
            if (solve(pos)) {
                solution.add(pos);
                return true;
            }
        }
        if (maze[x+1][y].equals(" ") || maze[x+1][y].equals("G")) {
            pos.setX(x + 1);
            route.add(temp);
            if (solve(pos)) {
                solution.add(pos);
                return true;
            }
        }
        if (maze[x][y-1].equals(" ") || maze[x][y-1].equals("G")) {
            pos.setY(y - 1);
            route.add(temp);
            if (solve(pos)) {
                solution.add(pos);
                return true;
            }
        }
        if (maze[x-1][y].equals(" ") || maze[x-1][y].equals("G")) {
            pos.setX(x - 1);
            route.add(temp);
            if (solve(pos)) {
                solution.add(pos);
                return true;
            }
        }
        if (!(maze[x][y].equals("S"))) {
            maze[x][y] = "x";
            route.remove(route.size()-1);
            return solve(route.get(route.size() - 1));
        }
        if (maze[x][y].equals("S")) {
            return false;
        }
        return false;
    }

    public static void main(String[] args) {


        if (findS(maze)) {
            System.out.println(start);
            Point p = new Point(start.getX(),start.getY());
            if (solve(p)) {
                System.out.println("Solved!");
                System.out.println(solution);
                printmatrix(maze);
            } else
                System.out.println("No solution!");
        }
    }
}
