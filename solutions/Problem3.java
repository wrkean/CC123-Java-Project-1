package solutions;

import java.util.Scanner;

public class Problem3 {
    public static void solve() {
        Scanner console = new Scanner(System.in);

        // Constants
        final double REG = 10.00;                   // Regular service fee
        final int FREE_REG_MINS = 50;               // Plus Free for 50 mins, no additioal pee for 50 minutes
        final double REG_CHARGE_OVER = 0.20;        // If over 50 mins, charges 0.20 per min
        final double PREM = 25.00;                  // Premium service fee
        final int FREE_DAY_MINS = 75;               // Free premium service minutes at day 
        final int FREE_NIGHT_MINS = 100;            // Free premium service minutes at night
        final double DAY_CHARGE_OVER = 0.10;        // If over 75 mins in the day, charges 0.10 per min
        final double NIGHT_CHARGE_OVER = 0.05;      // If over 100 mins at night, charges 0.05 per min

        int regServiceMins;
        int regChargedMins;                         // Determines the charged minutes. Example: Regular service minutes = 51 then charged minutes is 1
        double regFee = REG;                        // Regular fee depending on the mins, initialize to REG first
        int serviceMinsDay;
        int serviceMinsNight;
        int dayChargedMins;
        int nightChargedMins;
        double premFee = PREM;                      // Premium fee depending on the mins, initialize to PREM first
        int accountNumber;
        char serviceCode;
        double amountDue;                           // Total amount to pay
        int serviceMins;
        String serviceType;
        boolean repeat = true;
        
        while (repeat) {
            // Input
            System.out.print("Enter your account number: ");
            accountNumber = console.nextInt();

            System.out.print("What type of service? Enter P (premium) or R (regular): ");
            serviceCode = console.next().charAt(0);
            
            switch (Character.toUpperCase(serviceCode)) {
            case 'P':
                System.out.print("Enter number of service minutes used in the day: ");
                serviceMinsDay = console.nextInt();
                dayChargedMins = serviceMinsDay - FREE_DAY_MINS;
                if (dayChargedMins < 0) dayChargedMins = 0;     // Prevent negative

                System.out.print("Enter number of service minutes used in the night: ");
                serviceMinsNight = console.nextInt();
                nightChargedMins = serviceMinsNight - FREE_NIGHT_MINS;
                if (nightChargedMins < 0) nightChargedMins = 0;

                premFee += (dayChargedMins * DAY_CHARGE_OVER) + (nightChargedMins * NIGHT_CHARGE_OVER);
                amountDue = premFee;
                serviceMins = serviceMinsDay + serviceMinsNight;
                serviceType = "Premium";
                break;
            case 'R':
                System.out.print("Enter number of service minutes used: ");
                regServiceMins = console.nextInt();
                regChargedMins = regServiceMins - FREE_REG_MINS;
                if (regChargedMins < 0) regChargedMins = 0;

                regFee += regChargedMins * REG_CHARGE_OVER;
                amountDue = regFee;
                serviceMins = regServiceMins;
                serviceType = "Regular";
                break;
        
            default:
                System.out.println("Error! Only enter P or R, case-insensitive.");
                console.close();
                return;
            }

            // Output
            System.out.printf(
                "Account number: %d\n" +
                "Type of service: %s\n" +
                "Total number of minutes used: %d\n" +
                "Amount due: %f\n",
                accountNumber, serviceType, serviceMins, amountDue
            );
            System.out.print("Do you want to repeat? (y/n): ");

            // Determine if the user wants to repeat or not
            switch (Character.toUpperCase(console.next().charAt(0))) {
            case 'Y':
                repeat = true;
                break;
            case 'N':
                repeat = false;
                break;
            }
            System.out.println("");
        }
        console.close();
    }
}