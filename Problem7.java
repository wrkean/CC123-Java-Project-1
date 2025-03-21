

import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long popTownA;               // Population of town A
        long popTownB;               // Population of town B
        double grTownA;             // Growth rate of town A
        double grTownB;             // Growth rate of town B
        int years = 0;
        boolean repeat = true;

        while (repeat) {
            System.out.print("Enter population and growth rate (in %) for Town A: ");
            popTownA = console.nextInt();
            grTownA = console.nextInt() / 100.0f;

            System.out.print("Enter population and growth rate (in %) for Town B: ");
            popTownB = console.nextInt();
            grTownB = console.nextInt() / 100.0f;

            if (grTownB >= grTownA) {
                System.out.println("Town A will never outgrow Town B in population.");
                continue;
            }

            while (popTownA < popTownB) {
                popTownA += popTownA * grTownA;
                popTownB += popTownB * grTownB;
                years++;
            }
            
            System.out.printf(
                "Town A's population will be greater than of Town B in %d year/s.\n" +
                "At that time, Town A will have a population of %d\n" +
                "while Town B will have a population of %d",
                years, popTownA, popTownB
            );

            System.out.print("\nDo you want to repeat again? (y/n): ");
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
