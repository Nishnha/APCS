/* Nishant Sinha, Period 5
 * RockPaperScissors.java
 * Lets the user input either rock, paper, or scissors
 * and play against the computer for a single instance.
 */

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        int playerChoice = 10, compChoice;
        String playerInput, compOutput;

        Scanner sc = new Scanner(System.in);

        System.out.println("Greetings, Nishant Sinha!");
        System.out.println("Enter rock, paper, or scissors");
        playerInput = sc.nextLine();

        //takes the user's input, converting it to a number so that the
        //winner can be mathematically determined
        if (playerInput.equalsIgnoreCase("rock")) {
          playerChoice = 0;
        } else if (playerInput.equalsIgnoreCase("paper")) {
          playerChoice = 1;
        } else if (playerInput.equalsIgnoreCase("scissors")) {
          playerChoice = 2;
        } else {
          playerChoice = 10;
          System.out.println("Enter something valid next time!");
        }

        //calls the function to generate the computer's decision
        compChoice = compRand();

        //assigns names to the values generated by the computer
         if (compChoice ==  0) {
            compOutput = "rock";
        } else if (compChoice == 1) {
            compOutput = "paper";
        } else {
            compOutput = "scissors";
        }

        //prints out the decisions of the player and computer
        System.out.println("You chose " + playerInput + "\nThe computer chose " + compOutput);

        //calculates the winner
        if (playerChoice == compChoice) {
            System.out.println("It's a tie!");
        } else if (playerChoice + 2 == compChoice || playerChoice - 1 == compChoice) {
            System.out.println("Player wins!");
        } else if (playerChoice - 2 == compChoice || playerChoice + 1 == compChoice) {
            System.out.println("Computer wins!");
        }

    }
    //generates a random int between 0 and 2
    public static int compRand() {
        return (int) (Math.random() * 3);
    }

}