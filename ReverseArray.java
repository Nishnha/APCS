import java.util.Scanner;
import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {

        int lengthArray;
        int[] array;
        int tempValue;

        Scanner sc = new Scanner(System.in);

        System.out.println("How many values would you like to enter?");
        lengthArray = sc.nextInt();
        array = new int[lengthArray];

        sc.nextLine(); // Clear the newline character

        System.out.println("Enter " + lengthArray + " values");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println( "Your values are " + Arrays.toString(array) );

        for (int i = 0; i < array.length/2; i++) {
            tempValue = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tempValue;
        }

        System.out.println( "Your values reversed are " + Arrays.toString(array) );

    }
}
