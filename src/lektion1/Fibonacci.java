package lektion1;

import java.util.Scanner;

public class Fibonacci {

    static int fib(int n) {
        return fib(n, 1, 0);
    }

    static int fib(int n, int x, int y) {
        if (n == 1)
            return x;
         else
            return fib(--n,x+y, x);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n;

        while(true) {
            n = in.nextInt();

            if (n == 0)
                break;

            System.out.println(fib(n));
        }
    }
}
