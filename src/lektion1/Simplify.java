package lektion1;

import java.util.Scanner;

public class Simplify {



    static void simp(int a, int b) {
        if (a % 5 == 0 && b % 5 == 0)
            simp(a / 5, b / 5);
        else if (a % 4 == 0 && b % 4 == 0)
            simp(a / 4, b / 4);
        else if (a % 3 == 0 && b % 3 == 0)
            simp(a / 3, b / 3);
        else if (a % 2 == 0 && b % 2 == 0)
            simp(a / 2, b / 2);
        else
            System.out.println(a + "/" + b);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a, b;

        while (true) {
            a = in.nextInt();
            b = in.nextInt();

            if (b == 0)
                break;

            simp(a, b);
        }
    }
}
