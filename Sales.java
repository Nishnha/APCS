// ****************************************************************
// Sales.java
//
// Reads in and stores sales for each of 5 salespeople.  Displays
// sales entered by salesperson id and total sales for all salespeople.
//
// ****************************************************************
import java.util.Scanner;

public class Sales {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("How many salespeople would you like to enter?");
        int salesPeople = scan.nextInt();
        int[] sales = new int[salesPeople];

        int sum = 0;
        int maxSale = 0, minSale = 10000;
        int maxPerson = -1, minPerson = -1;
        int atLeastUserMin = 0;

        for (int i = 0; i < sales.length; i++) {
            System.out.print("Enter sales for salesperson " + (i+1) + ": ");
            sales[i] = scan.nextInt();

            if (sales[i] > maxSale) {
                maxSale = sales[i];
                maxPerson = i+1;
            }
            if (sales[i] < minSale) {
                minSale = sales[i];
                minPerson = i+1;
            }
        }

        System.out.println("\nSalesperson   Sales");
        System.out.println("--------------------");
        for (int i = 0; i < sales.length; i++) {
            System.out.println("     " + (i+1) + "         " + sales[i]);
            sum += sales[i];
        }

        System.out.println("\nTotal sales: " + sum);
        System.out.println("Average sales: " + sum/sales.length);
        System.out.println("Maximum sale: " + maxSale + " by Salesperson " + maxPerson);
        System.out.println("Minimum sale: " + minSale + " by Salesperson " + minPerson);

        System.out.println("\nEnter a number to find which salespeople sold at least that many.");
        int userMin = scan.nextInt();

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] > userMin) {
                System.out.println("\tSalesperson " + (i+1) + ",");
                atLeastUserMin++;
            }
         }
        System.out.println(atLeastUserMin + " salespeople sold more than " + userMin + " items");

    }
}
