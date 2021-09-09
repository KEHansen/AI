package lektion1;

import java.util.Scanner;

public class Power {

    static int power(int a, int b) {
        if (b == 0)
            return 1;
        else
            return power(a*a,b-1, a);
    }

    static int power(int a, int b, int x) {
        if (b == 1)
            return a;
        else
            return power(a*x,b-1, x);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a, b;

        while (true) {
            a = in.nextInt();
            b = in.nextInt();

            if (b == 0) {
                System.out.println(1);
                break;
            }

            System.out.println(power(a, b));
        }
    }
}
