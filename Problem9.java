

import java.util.Scanner;

public class Problem9 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        final int TSAVINGS_CHARGE = 10;         // Account of savings type charge amount
        final int TCHECKING_CHARGE = 25;        // Account of checking type charge amount

        char accType;
        int accNumber;
        int minBal;
        int curBal;

        System.out.println("Enter account number, account type, minimum balance, and current balance, seperated by space:");
        accNumber = console.nextInt();
        accType = console.next().charAt(0);
        minBal = console.nextInt();
        curBal = console.nextInt();

        switch (Character.toUpperCase(accType)) {
            case 'S':
                if (curBal < minBal) {
                    curBal -= TSAVINGS_CHARGE;
                    System.out.println("Current balance is below minimum balance. Charging " + TSAVINGS_CHARGE);
                } else {
                    curBal += curBal * 0.04f;
                    System.out.printf("Received %d.\n", (int) (curBal * 0.04f));
                }
                break;
            case 'C':
                if (curBal < minBal) {
                    curBal -= TCHECKING_CHARGE;
                    System.out.println("Current balance is below minimum balance. Charging " + TCHECKING_CHARGE);
                } else {
                    if (curBal > minBal + 5000) {
                        curBal += curBal * 0.03f;
                        System.out.printf("Received %d.\n", (int) (curBal * 0.03f));
                    } else {
                        curBal += curBal * 0.05f;
                        System.out.printf("Received %d.\n", (int) (curBal * 0.05f));
                    }
                }
                break;
            default:
                break;
        }

        System.out.printf(
            "%d    %c    %d\n" +
            "Account no. %d will receive %d by the end of the month.\n",
            accNumber, Character.toUpperCase(accType), curBal, accNumber, curBal
        );
        System.out.println("");



        console.close();
    }
}
