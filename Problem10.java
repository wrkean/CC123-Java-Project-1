

import java.util.Scanner;

public class Problem10 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int num;
        int guess;
        int diff;
        int tries = 5;

        num = (int) (Math.random() * 100);

        while (tries > 0) {
            System.out.println("You have " + tries + " tries left");
            System.out.print("Enter a number from 0 to 99 inclusive: ");
            guess = console.nextInt();
            if (guess < 0 || guess > 99) {
                System.out.println("Error! Only enter numbers from 0 to 99.");
                continue;
            }

            diff = Math.abs(num - guess);
            if (diff == 0) {
                System.out.println("You guessed it right!");
                console.close();
                return;
            }

            if (guess > num) {
                if (diff >= 50) {
                    System.out.println("Guess is very high.");
                } else if (diff >= 30) {
                    System.out.println("Guess is high.");
                } else if (diff >= 15) {
                    System.out.println("Guess is moderately high.");
                } else if (diff > 0) {
                    System.out.println("Guess is somewhat high.");
                }
            } else if (guess < num) {
                if (diff >= 50) {
                    System.out.println("Guess is very low.");
                } else if (diff >= 30) {
                    System.out.println("Guess is low.");
                } else if (diff >= 15) {
                    System.out.println("Guess is moderately low.");
                } else if (diff > 0) {
                    System.out.println("Guess is somewhat low.");
                }
            }

            tries--;
        }

        System.out.println("You ran out of tries! The correct number is " + num);
        console.close();
    }
}
