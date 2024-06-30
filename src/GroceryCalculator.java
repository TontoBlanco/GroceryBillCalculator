/*------------------------------------------------------------------------------------
Program Name: CSC320_CTA3_Option2.java
Author: Cole Miller
Date: 06/30/24
---------------------------------------------------------------------------------------
Psuedocode:
    1. Start
    2. Prompt the user for the coupon amount as a decimal.
    3. Validate the coupon amount to ensure it's between 0 and 1. If not, set it to 0.1 (10%).
    4. Display the coupon amount and ask the user to verify it.
    5. If the user confirms, proceed. If not, prompt the user to re-enter the coupon amount and repeat the validation and confirmation steps.
    6. Declare an array to store grocery bills for four weeks.
    7. Prompt the user to enter grocery bills for weeks 1 to 4 and store them in the array.
    8. Calculate the total and average grocery bill for the month without the coupon.
    9. Calculate the total and average grocery bill for the month with the coupon.
    10. Display the monthly total and weekly average without the coupon.
    11. Display the monthly total and weekly average with the coupon.
    12. End

---------------------------------------------------------------------------------------
Program Inputs: Coupon Amount
Program Outputs: Display monthly total and weekly average with and without the coupon.
---------------------------------------------------------------------------------------

 */
import java.util.Scanner;

public class GroceryCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double coupon;

        // Prompt the user for the coupon amount and validate
        while (true) {
            System.out.print("Enter the coupon amount as a decimal (example: 0.25 for 25%): ");
            coupon = scanner.nextDouble();

            if (coupon <= 0 || coupon > 1) {
                coupon = 0.10;
            }

            System.out.println("You entered a coupon amount of: " + coupon * 100 +
                    "% or the amount you entered was not a 1-100 percentage in decimal form.");
            System.out.print("Is this correct? (yes/no): ");
            String confirmation = scanner.next();

            if (confirmation.equalsIgnoreCase("yes")) {
                break;
            } else {
                System.out.println("Please re-enter the coupon amount.");
            }
        }

        //Declare an array to store grocery bills for four weeks
        double[] weeklyBills = new double[4];
        double totalBillWithoutCoupon = 0.0;

        // Prompt the user for weeks 1-4 grocery bills
        for (int i = 0; i < 4; i++) {
            System.out.print("Enter grocery bill for week " + (i + 1) + ":");
            weeklyBills[i] = scanner.nextDouble();
            totalBillWithoutCoupon += weeklyBills[i];
        }

        // Calculate the monthly and weekly average for groceries without coupon
        double weeklyAverageWithoutCoupon = totalBillWithoutCoupon / 4;
        double monthlyTotalWithoutCoupon = totalBillWithoutCoupon;

        // Calculate the monthly and weekly average for groceries with coupon
        double monthlyTotalWithCoupon = totalBillWithoutCoupon * (1 - coupon);
        double weeklyAverageWithCoupon = monthlyTotalWithCoupon / 4;

        //Display results
        System.out.println("\nMonthly total without coupon: $" + monthlyTotalWithoutCoupon);
        System.out.println("Weekly average without coupon: $" + weeklyAverageWithoutCoupon);
        System.out.println("Monthly total with coupon: $" + monthlyTotalWithCoupon);
        System.out.println("Weekly average with coupon: $" + weeklyAverageWithCoupon);

        scanner.close();
    }
}
