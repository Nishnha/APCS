public class LinearSearch {
    public static void main(String[] args) {
   
        int[] randomIntArray = new int[100];
        int targetNumber;
        int numIterations = 0;
        boolean notFound = true;
        
        // Fill randomIntArray with numbers
        for (int i = 0; i < randomIntArray.length; i++) {
            randomIntArray[i] = (int) (Math.random() * 200) + 1;
        }
        
        // Randomly set the target number
        targetNumber = (int) (Math.random() * 200) + 1;
        
        System.out.println("The droid you are looking for is " + targetNumber);
        // Perform a linear search
        for (int i = 0; i < randomIntArray.length; i++) {
            numIterations++;
            if (randomIntArray[i] == targetNumber){
                System.out.println("The target number was found at index " + i);
                notFound = false;
                break;
            }
        }
        
        if (notFound)
            System.out.println("We ain't found shit!");
        System.out.println("Our storm troopers combed the desert for " + numIterations + " hours!");
        
    }
}