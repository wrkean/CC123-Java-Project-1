import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        final double PAYRATE = 68.75;   // Pay rate per hour
        final int REG_HOURS_PER_WEEK = 40; // Regular working hours per week
        final double PAY_OVER = PAYRATE * 1.5f; // Pay rate per hour of overtime
        final double WITHHELD_SST = 0.07; // Withheld social security tax
        final double WITHHELD_FIT = 0.11; // Withheld federal income tax
        final double WITHHELD_SIT = 0.06; // Withheld state income tax
        final int WITHHELD_UDPW = 100;    // Withheld union dues per week
        final int MAX_DEPENDENTS = 3;
        final int WITHHELD_HI = 350;      // Takes in effect if >=maxDependents

        int hoursWorked;    // Hours worked in a week
        int overtimeHours = 0;
        double overtimePay = 0;
        int dependents;
        double grossPay;
        double whForSST;    // Withholding amount for WITHHELD_SST
        double whForFIT;    // Withholding amount for WITHHELD_FIT
        double whForSIT;    // Withholding amount for WITHHELD_SIT
        int whForHI = 0;     // Withholding amount for WITHHELD_HI
        double takeHomePay;

        System.out.print("Enter number of hours worked: ");
        hoursWorked = console.nextInt();

        System.out.print("Enter number of dependents: ");
        dependents = console.nextInt();

        // Get overtime hours first
        if (hoursWorked > REG_HOURS_PER_WEEK) {
            overtimeHours = hoursWorked - REG_HOURS_PER_WEEK;
            overtimePay = overtimeHours * PAY_OVER;
        }
        
        // Calculate gross pay
        grossPay = PAYRATE * hoursWorked + overtimePay;
        takeHomePay = grossPay;

        if (dependents >= MAX_DEPENDENTS) {
            whForHI += WITHHELD_HI;
        }

        whForSST = grossPay * WITHHELD_SST;
        whForFIT = grossPay * WITHHELD_FIT;
        whForSIT = grossPay * WITHHELD_SIT;

        takeHomePay -= whForSST + whForSIT + whForFIT + WITHHELD_UDPW + whForHI;

        System.out.printf(
            "Gross Pay: %.2f\n" +
            "Withheld amount for Social Security Tax: %.2f\n" +
            "Withheld amount for Federal Income Tax: %.2f\n" +
            "Withheld amount for State Income Tax: %.2f\n" +
            "Withheld amount for Union Dues: %d\n" +
            "Withheld amount for Health Insurance: %d\n" +
            "Take-home pay: %.2f\n",
            grossPay, whForSST, whForFIT, whForSIT, WITHHELD_UDPW, whForHI, takeHomePay
        );

        console.close();
    }
}
