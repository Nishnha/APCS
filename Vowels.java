/* Nishant Sinha
 * Period 5
 * Vowels.java
 * Takes a user entered string and then declares how many vowels, punctuation marks
 * spaces, and consonants it contains.
 */ 

import java.util.Scanner;

public class Vowels {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter a lowercase string to learn about its composition!");
    String str = sc.nextLine();
    int vowelA = 0, vowelE = 0, vowelI = 0, vowelO = 0, vowelU = 0;
    int charSpace = 0, charPunct = 0, charConso = 0;
    
    for (int i = 0; i < str.length(); i++) {
      
      if (str.charAt(i) == 'a') {
        vowelA++;
      } else if (str.charAt(i) == 'e') {
        vowelE++;
      } else if (str.charAt(i) == 'i') {
        vowelI++;
      } else if (str.charAt(i) == 'o') {
        vowelO++;
      } else if (str.charAt(i) == 'u') {
        vowelU++;
      } else if (str.charAt(i) == ' ') {
        charSpace++;
      } else if (str.charAt(i) == '.') {
        charPunct++;
      } else if (str.charAt(i) == '!') {
        charPunct++;
      } else if (str.charAt(i) == ';') {
        charPunct++;
      } else if (str.charAt(i) == ',') {
        charPunct++;
      } else if (str.charAt(i) == '\'') {
        charPunct++;
      } else if (str.charAt(i) == '?') {
        charPunct++;
      } else if (str.charAt(i) == ':') {
        charPunct++;
      } else if (str.charAt(i) == '\"') {
        charPunct++;
      } else {
        charConso++;
      }
      
    }
    
    System.out.println("The string \"" + str + "\" contains " + vowelA + " letter \'a\'s, " +
                       vowelE + " letter \'e\'s, " + vowelI + " letter \'i\'s, " + vowelO + " letter \'o\'s, " + 
                       vowelU + " letter \'u\'s, has " + charSpace + " space characters, " + charPunct +
                       " punctuation marks, and " + charConso + " consonants!");
    
  }
}