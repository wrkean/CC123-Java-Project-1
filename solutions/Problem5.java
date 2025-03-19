package solutions;

import java.util.Scanner;

public class Problem5 {
    public static void solve() {
        Scanner console = new Scanner(System.in);
        int m;
        int n;
        int num;
        int sumProperDivisors;
        boolean repeat = true;

        while (repeat) {
            System.out.print("Enter an integer: ");
            num = console.nextInt();
            if (num < 0) {
                System.out.println("Only enter positive integers.");
                continue;
            }
            
            for (n = 1; n <= num; n++) {
                sumProperDivisors = 0;      // Ensure for each iteration, this starts at 0

                // Another for loop to check if n is a perfect integer
                for (m = 1; m <= n; m++) {
                    if ((n % m == 0) && (m < n))
                        sumProperDivisors += m;     // Here, m is a proper divisor, so I included it in summation
                }
                
                // If this is true, n is perfect, so print
                if (sumProperDivisors == n) 
                    System.out.print(n + " ");
            }

            System.out.println("");
            System.out.print("Do you want to repeat again? (y/n): ");

            switch (Character.toUpperCase(console.next().charAt(0))) {
            case 'Y':
                repeat = true;
                break;
            
            case 'N':
                repeat = false;
                break;

            default:
                System.out.println("Invalid choice!");
                repeat = false;
                break;
            }
        }
    }
}
