// Nishant Sinha
// Makes an extendable array
// Because apparently ArrayLists are too mainstream?

import java.util.Scanner;

public class SizableArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nextEntree;
        String[] songs = new String[1];
        String[] resizableArray;

        System.out.println("Enter your favorite songs! When you're done, " +
                "enter an empty entree");

        for (int i = 0; i < songs.length; i++) {
            if (i == songs.length - 1) {
                resize(songs);
                songs = null;
                remake(songs);
            }
            nextEntree = sc.nextLine();
            if (nextEntree.length() == 0)
                break;
            else
                songs[i] = nextEntree;
        }

        System.out.println("Here's your list of favorite songs!");
        for (String s : songs) {
            System.out.println("\t \"" + s + "\",");
        }
    }

    public static String[] resize(String[] array) {
        String[] resizedArray = new String[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            resizedArray[i] = array[i];
        }
        return resizedArray;
    }

    public static String[] remake(String[] array) {
        String[] songs = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            songs[i] = array[i];
        }
        return songs;
    }

}
