package lektion1;

import java.util.Scanner;

public class Factorial {

    static int fac(int n, int x) {
        if (n == 1)
            return x;
          else
            return fac(n-1,x*n);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n;

        while(true) {
            n = in.nextInt();

            if (n == 0)
                break;

            System.out.println(fac(n, 1));
        }
    }
}
