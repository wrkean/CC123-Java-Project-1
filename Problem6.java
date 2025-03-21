

import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int num;
        int cpyNum;                 // Same value as original num
        int reversedNum = 0;
        int remainder;
        boolean repeat = true;
        boolean prime = true;
        boolean emirp = true;

        while (repeat) {
            System.out.print("Enter a positive integer: ");
            num = console.nextInt();
            cpyNum = num;
            if (num < 0) {
                System.out.println("Only enter a positive integer");
                continue;
            }

            // Reverse num
            while (num != 0) {
                remainder = num % 10;
                reversedNum = reversedNum * 10 + remainder;
                num /= 10;
            }

            if (cpyNum < 2) {
                prime = false;
            } else if (cpyNum == 2 || cpyNum == 3) {
                prime = true;
            } else if (cpyNum % 2 == 0 || cpyNum % 3 == 0) {
                prime = false;
            } else {
                int sqrt = (int) Math.sqrt(cpyNum);
                for (int i = 5; i <= sqrt; i += 6) {
                    if (cpyNum % i == 0 || cpyNum % (i + 2) == 0) {
                        prime = false;
                        break;
                    }
                }
            }

            if (reversedNum < 2) {
                emirp = false;
            } else if (reversedNum == 2 || reversedNum == 3) {
                emirp = true;
            } else if (reversedNum % 2 == 0 || reversedNum % 3 == 0) {
                emirp = false;
            } else {
                int sqrt = (int) Math.sqrt(reversedNum);
                for (int i = 5; i <= sqrt; i += 6) {
                    if (reversedNum % i == 0 || reversedNum % (i + 2) == 0) {
                        emirp = false;
                        break;
                    }
                }
            }

            if (prime && !emirp) {
                System.out.printf("%d is prime only.\n", cpyNum);
            } else if (prime && emirp) {
                System.out.printf("%d is both prime and emirp.\n", cpyNum);
            } else if (!prime) {
                System.out.printf("%d is not a prime.\n", cpyNum);
            }

            System.out.print("Do you want to repeat again? (y/n): ");
            switch (Character.toUpperCase(console.next().charAt(0))) {
            case 'Y':
                repeat = true;
                break;
            
            case 'N':
                repeat = false;
                break;
        
            default:
                System.out.print("Invalid choice!");
                break;
            }
        }
        console.close();
    }
}
