

import java.util.Scanner;

public class Problem8 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double dec1;
        double dec2;
        double dec3;
        char op1;
        char op2;
        double result;

        final char ADD = '+',
                   SUB = '-',
                   MULT = '*',
                   DIV = '/';
        
        boolean op1First;       // If true, then operator 1 first, otherwise operator 2

        System.out.print("Enter three decimals, seperated by space: ");
        dec1 = console.nextDouble();
        dec2 = console.nextDouble();
        dec3 = console.nextDouble();

        System.out.print("Enter two operators, seperated by space: ");
        op1 = console.next().charAt(0);
        op2 = console.next().charAt(0);

        // Determine which operation will go first
        if (op1 == MULT || op1 == DIV) op1First = true;
        else op1First = false;

        if (op1First) {
            if (op1 == DIV && dec2 == 0) {
                System.out.println("Division by zero error.");
                console.close();
                return;
            }

            switch (op1) {
                case ADD:
                    result = dec1 + dec2;
                    break;
                case SUB:
                    result = dec1 - dec2;
                    break;
                case MULT:
                    result = dec1 * dec2;
                    break;
                case DIV:
                    if (dec2 == 0) {
                        System.out.println("Divison by zero error");
                        console.close();
                        return;
                    }
                    result = dec1 / dec2;
                    break;
                default:
                    System.out.println("Invalid operator.");
                    console.close();
                    return;
            }

            switch (op2) {
                case ADD:
                    result = result + dec3;
                    break;
                case SUB:
                    result = result - dec3;
                    break;
                case MULT:
                    result = result * dec3;
                    break;
                case DIV:
                    if (dec3 == 0) {
                        System.out.println("Divison by zero error");
                        console.close();
                        return;
                    }
                    result = result / dec3;
                    break;
                default:
                    System.out.println("Invalid operator.");
                    console.close();
                    return;
            }

        } else {
            // Evaluate second operation first
            switch (op2) {
                case ADD:
                    result = dec2 + dec3;
                    break;
                case SUB:
                    result = dec2 - dec3;
                    break;
                case MULT:
                    result = dec2 * dec3;
                    break;
                case DIV:
                    if (dec3 == 0) {
                        System.out.println("Divison by zero error");
                        console.close();
                        return;
                    }
                    result = dec2 / dec3;
                    break;
                default:
                    System.out.println("Invalid operator.");
                    console.close();
                    return;
            }

            switch (op1) {
                case ADD:
                    result = dec3 + result;
                    break;
                case SUB:
                    result = dec3 - result;
                    break;
                case MULT:
                    result = dec3 * result;
                    break;
                case DIV:
                    if (result == 0) {
                        System.out.println("Divison by zero error");
                        console.close();
                        return;
                    }
                    result = dec3 / result;
                    break;
                default:
                    System.out.println("Invalid operator.");
                    console.close();
                    return;
            }
        }

        System.out.printf(
            "%.2f %c %.2f %c %.2f = %.2f",
            dec1, op1, dec2, op2, dec3, result
        );
        console.close();
    }
}
