/* Nishant Sinha
 * Period 5
 * HiLoGame.java
 * Prompts the user to guess a randomly generated number.
 * Tells the user whether their guess is too high or low until they guess correctly.
 */

import java.util.Scanner;

public class HiLoGame {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Welcome to the HiLo game. Enter a number between 1 and 100 (inclusive)" +
                       " or enter -1 to quit.");
    int tries = 0;
    int playerGuess = sc.nextInt();
    int randNumber = RandomInt();
    boolean contGame = true;


  while (contGame) {
    while (playerGuess != -1) {
      if (playerGuess >= 1 && playerGuess <= 100) {
        if (playerGuess > randNumber) { // Too high
          tries++;
          System.out.println("Too high!");
          playerGuess = sc.nextInt();
        } else if (playerGuess < randNumber) { // Too low
          tries++;
          System.out.println("Too low!");
          playerGuess = sc.nextInt();
        } else { // Guesses number
          System.out.println("Congratulations! You guessed the number in " + tries + " guesses!");
          System.out.println("If you want to play again enter a number between 1 and 100 (inclusive)!\n");
          tries = 0;
          randNumber = RandomInt();
          playerGuess = sc.nextInt();
        }
      } else {
        System.out.println("Your number must be between 1 and 100 (inclusive), or enter -1 to quit.\n");
        playerGuess = sc.nextInt();
      }
    }

    if (playerGuess == -1) { // Confirm the user wants to quit
        System.out.println("Are you sure you want to quit? Enter -1 again to quit or enter a number between" +
                           " 1 and 100 (inclusive) to keep playing\n");
        playerGuess = sc.nextInt();
        if (playerGuess == -1) {
            contGame = false;
        }
    }
  }

  }

  // Generate random integer between 1 and 100 (inclusive)
  public static int RandomInt() {
    return (int) (Math.random() * 100) + 1;
  }

}
