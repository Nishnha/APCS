// ***************************************************************
//   Nishant Sinha Period 5
//   Salary.java
//   Computes the amount of a raise and the new salary for an
//   employee.  The current salary and a performance rating
//   (a String: "Excellent", "Good", or "Poor") are input.
// ***************************************************************
import java.util.Scanner;
import java.text.NumberFormat;

public class Salary {
  public static void main (String[] args) {
        double currentSalary;  // employee's current salary
        double raise = 0;          // amount of the raise
        double newSalary;      // new salary for the employee
        String rating;         // performance rating

        Scanner scan = new Scanner(System.in);

        System.out.print ("Enter the current salary: ");
        currentSalary = scan.nextDouble();
        System.out.print ("Enter the performance rating (Excellent, "
                           + " Good, or Poor): ");
        rating = scan.next();

        // Compute the raise
        if (rating.equalsIgnoreCase("Excellent")) {
          raise = currentSalary * .06;
        } else if (rating.equalsIgnoreCase("Good")) {
          raise = currentSalary * .04;
        } else if (rating.equalsIgnoreCase("Poor")) {
          raise = currentSalary * .015;
        } else {
          System.out.println("Enter a valid rating!");
        }

        // Compute new salary
        newSalary = currentSalary + raise;

        // Print the results
        NumberFormat money = NumberFormat.getCurrencyInstance();
        System.out.println("Current Salary:       " + money.format(currentSalary));
        System.out.println("Amount of your raise: " + money.format(raise));
        System.out.println("Your new salary:      " + money.format(newSalary));
  }
}

