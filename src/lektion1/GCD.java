package lektion1;

import java.util.Scanner;

public class GCD {

    static int gcd(int a, int b) {
        if (a == b)
            return a;
        if (a > b)
            return gcd(a-b,b);
        else
            return gcd(a,b-a);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a, b;

        while (true) {
            a = in.nextInt();
            b = in.nextInt();

            if (a == 0 || b == 0)
                break;

            System.out.println(gcd(a, b));
        }
    }
}

