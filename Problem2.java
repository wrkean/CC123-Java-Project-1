

import java.io.*;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        Scanner inFile = new Scanner(new FileReader("EmployeeData.txt"));
        PrintWriter outFile = new PrintWriter("EmployeeData.dat");

        final int NUM_EMPLOYEES = 10;

        String lastName, firstName;
        double salary;
        char rank;

        // Iterate through each line
        for (int i = 0; i < NUM_EMPLOYEES; i++) {
            lastName = inFile.next();
            firstName = inFile.next();
            salary = inFile.nextDouble();
            rank = inFile.next().charAt(0);

            switch (rank) {
            case 'A':
                salary += salary * 0.1f;
                break;
            case 'B':
                salary += salary * 0.085f;
                break;
            case 'C':
                salary += salary * 0.075f;
                break;
            case 'D':
                salary += salary * 0.05f;
                break;
            case 'E':
                salary += salary * 0.04f;
                break;
            }

            outFile.printf(
                "%s %s %.2f\n",
                firstName, lastName, salary
            );
        }
        inFile.close();
        outFile.close();
    }
}
