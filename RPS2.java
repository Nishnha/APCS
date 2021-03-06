/* *Nishant Sinha, Period 5
 * RockPaperScissors.java
 * Lets the user input either rock, paper, or scissors
 * and play against the computer until the user quits by entering
 * 'quit'. Also keeps a tally of how many wins, losses, and ties
 * there are each time the game is run.
 */

import java.util.Scanner;

public class RPS2 {
  public static void main(String[] args) {

    int playerChoice = 10, compChoice;
    int pWins = 0, cWins = 0, ties = 0;
    String playerInput, compOutput;

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter rock, paper, or scissors, or type \'quit\' to quit.");
    playerInput = sc.nextLine();

    While (!playerInput.equalsIgnoreCase("quit") ) {

      // Takes the user's input, converting it to a number so that the
      // Winner can be mathematically determined
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

      // Calls the function to generate the computer's decision
      compChoice = compRand();

      // Assigns names to the values generated by the computer
      if (compChoice == 0) {
        compOutput = "rock";
      } else if (compChoice == 1) {
        compOutput = "paper";
      } else {
        compOutput = "scissors";
      }

      // Calculates the winner
      if (playerChoice == compChoice) { // Case tie
          System.out.println("> You chose " + playerInput + "!");
          System.out.println("> The computer chose " + compOutput + "!");
          System.out.println("> It's a tie!");
          ties++;
          System.out.println("The player has " + pWins + " wins while the computer has " + cWins +
                             " and there are " + ties + " ties!\n");
      } else if (playerChoice + 2 == compChoice || playerChoice - 1 == compChoice) { // Case player win
          System.out.println("> You chose " + playerInput + "!");
          System.out.println("> The computer chose " + compOutput + "!");
          System.out.println("> Player wins!");
          pWins++;
          System.out.println("The player has " + pWins + " wins while the computer has " + cWins +
                             " and there are " + ties + " ties!\n");
      } else if (playerChoice - 2 == compChoice || playerChoice + 1 == compChoice) { // Case computer win
          System.out.println("> You chose " + playerInput + "!");
          System.out.println("> The computer chose " + compOutput + "!");
          System.out.println("> Computer wins!");
          cWins++;
          System.out.println("The player has " + pWins + " wins while the computer has " + cWins +
                             " and there are " + ties + " ties!\n");
      } else {
          System.out.println();
      }

      System.out.println("Enter rock, paper, or scissors, or type \'quit\' to quit.");
      playerInput = sc.nextLine();

    } // End while loop

    System.out.println("The player has " + pWins + " wins while the computer has " + cWins +
                       " and there are " + ties + " ties!");

  }
  // Generates a random int between 0 and 2
  public static int compRand() {
    return (int) (Math.random() * 3);
  }
}
