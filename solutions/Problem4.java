package solutions;

import java.util.Scanner;

public class Problem4 {
    public static void solve() {
        Scanner console = new Scanner(System.in);
        char choice;
        boolean running = true;
        int num1;
        int num2;
        int res;
        int sum = 0;
        int squared;
        char firstLet, secondLet;

        while (running) {
            System.out.println(
                "\nWhat do you want to do?\n" +
                "a. Odd numbers\n" +
                "b. Even numbers\n" +
                "c. Factorial\n" +
                "d. Sum of squares\n" +
                "e. Uppercase and lowercase letters\n" +
                "f. Exit"
            );
            choice = console.next().charAt(0);

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
                System.out.println("");
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
                System.out.println("");
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

                System.out.printf("Factorial of %d is %d\n", num1, res);
                break;

            case 'D':
                System.out.print("Enter an integer: ");
                num1 = console.nextInt();
                if (num1 < 0) num1 *= -1;   // Make it positive

                for (int i = 1; i <= num1; i++) {
                    squared = i * i;
                    sum += squared;
                }

                System.out.println("The sum of the squared numbers from 1 to " + num1 + " is " + sum);
                break;
                
            case 'E':
                System.out.print("Enter two letters: ");
                firstLet = console.next().charAt(0);
                secondLet = console.next().charAt(0);

                // Output uppercase letters
                for (char chr = Character.toUpperCase(firstLet); chr <= Character.toUpperCase(secondLet); chr++) {
                    System.out.print(chr + " ");
                }

                // Output lowercase letters
                for (char chr = Character.toLowerCase(firstLet); chr <= Character.toLowerCase(secondLet); chr++) {
                    System.out.print(chr + " ");
                }
                System.out.println("");
                break;
            case 'F':
                running = false;
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                break;
            }
        }

        console.close();
    }
}
