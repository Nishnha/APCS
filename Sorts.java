import java.util.Arrays;

public class Sorts {
    public static void main(String[] args) {

        /////////////////////////
        // selectionSort tests
        /////////////////////////
        System.out.println("selectionSort tests:");

        int[] randomIntArray = new int[20];
        // Fill randomIntArray with random ints from 1 to 100
        for (int i = 0; i < randomIntArray.length; i++) {
            randomIntArray[i] = (int) (Math.random() * 100) + 1;
        }

        // Output the unsorted array and then the sorted array after using selectionSort
        System.out.println( "The unsorted array is " + Arrays.toString(randomIntArray) );
        selectionSort(randomIntArray);
        System.out.println( "The sorted array is " + Arrays.toString(randomIntArray) );

        // use the sorted array in a binary search
        int target = (int) (Math.random() * 100) + 1;
        System.out.println("The target is " + target + " and was found at index " + binarySearch(randomIntArray, target) );


        ////////////////////////
        // insertionSort tests
        ////////////////////////
        System.out.println("\ninsertionSort tests:");

        int[] randomIntArray2 = new int[20];
        // Fill randomIntArray2 with random ints from 1 to 100
        for (int i = 0; i < randomIntArray2.length; i++) {
            randomIntArray2[i] = (int) (Math.random() * 100) + 1;
        }

        // Output the unsorted array and then the sorted array after using insertionSort
        System.out.println( "The unsorted array is " + Arrays.toString(randomIntArray2) );
        insertionSort(randomIntArray2);
        System.out.println( "The sorted array is " + Arrays.toString(randomIntArray2) );

        // use the sorted array in a binary search
        int target2 = (int) (Math.random() * 100) + 1;
        System.out.println("The target is " + target2 + " and was found at index " + binarySearch(randomIntArray2, target2) );

    }

    static void selectionSort(int[] array) {
        int min;
        int swap;

        for (int i = 0; i < array.length; i++) {

            min = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j]  < array[min])
                    min = j;
            }

            // Swap element i with the min
            swap = array[min];
            array[min] = array[i];
            array[i] = swap;
        }
    }

    static void insertionSort(int[] array) {
        int temp;

        for (int i = 1; i < array.length; i++) {
            int min = i;
            // If the element to the left is larger swap as long as the element is within the array bounds
            while ( min > 0  &&  array[min - 1] > array[min] ) {
                temp = array[min];
                array[min] = array[min - 1];
                array[min - 1] = temp;

                min--;
            }
        }
    }

    static int binarySearch(int[] array, int target) {
        int min = 0;
        int max = array.length;

        while (min <= max) {
            int midpoint = (min+max) / 2;

            if (array[midpoint] == target)
                return midpoint;
            else if (array[midpoint] < target)
                min = midpoint + 1;
            else
                max = midpoint - 1;
        }
        return -1;
    }

}
