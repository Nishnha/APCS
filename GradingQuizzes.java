import java.util.Scanner;

public class GradingQuizzes {
    public static void main(String[] args) {

        int numAnswers;
        int[] key;
        //student;
        boolean contGrading = true;
        char anotherQuiz;

        Scanner sc = new Scanner(System.in);

        System.out.println("How many questions are in the quiz?");
        numAnswers = sc.nextInt();

        // create a key array the same length as numAnswers
        key = new int[numAnswers];
        //student = new int[numAnswers];

        // populate the key array
        System.out.println("Enter the answer key");
        for (int i = 0; i < key.length; i++) {
           key[i] = sc.nextInt();
        }

        for(;;) {
            int numCorrect = 0;

            System.out.println("Enter the student's answers.");
            for (int i : key) {
                if (sc.nextInt() == i) // Check the student's grades as they are entered
                    numCorrect++;
            }

            System.out.println("This student has " + numCorrect + " correct answers");

            System.out.println("Do you wish to grade another quiz? (y/n)");
            sc.nextLine(); // Clear newline character
            anotherQuiz = sc.nextLine().charAt(0);
            if (anotherQuiz == 'n')
                break;
        }

    }
}
