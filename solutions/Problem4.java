package solutions;

import java.util.Scanner;

public class Problem4 {
    public static void solve() {
        Scanner console = new Scanner(System.in);
        char choice;

        System.out.println(
            "What do you want to do?\n" +
            "a. Odd numbers\n" +
            "b. Even numbers\n" +
            "c. Factorial\n" +
            "d. Sum of squares\n" +
            "e. Uppercase and lowercase letters\n" +
            "f. Exit"
        );
        choice = console.next().charAt(0);

        int num1;
        int num2;
        int res;

        switch (Character.toUpperCase(choice)) {
        case 'A':
            System.out.print("Enter two integers, first one must be lesser than the second one: ");
            num1 = console.nextInt();
            num2 = console.nextInt();

            // Ensure num1 < num2
            if (num1 > num2) {
                System.out.println("ERROR! First number is greater than second number!");
                console.close();
                return;
            }
            
            System.out.print("Odd numbers: ");
            for (int i = num1; i <= num2; i++) {
                if (i % 2 == 1) System.out.print(i + " ");
            }
            break;
        case 'B':
            System.out.print("Enter two integers, first one must be lesser than the second one: ");
            num1 = console.nextInt();
            num2 = console.nextInt();

            // Ensure num1 < num2
            if (num1 > num2) {
                System.out.println("ERROR! First number is greater than second number!");
                console.close();
                return;
            }
            
            System.out.print("Odd numbers: ");
            for (int i = num1; i <= num2; i++) {
                if (i % 2 == 0) System.out.print(i + " ");
            }
            break;

        case 'C':
            System.out.print("Enter a positive integer: ");
            num1 = console.nextInt();

            // Ensure it isn't a negative number
            if (num1 < 0) {
                System.out.println("The number is negative!");
                console.close();
                return;
            }
            
            res = num1;
            for (int i = num1; i > 1; i--) {
                res *= i - 1;
            }

            System.out.printf("Factorial of %d is %d", num1, res);
            break;
        
        default:
            break;
        }

        console.close();
    }
}
