/* Aline Francisco - 2025 - Algortihms
 * Linear Search Algorithm, recursive implementation
 * 1
 * Develop a guessing game, 
 * the user tries to guess one of 10 magic numbers
 * the user enters an integer, their guess
 * 2
 * The program uses a recursive implementation of 
 *  the linear search algorithm to search through the array
 *  of 10 magic numbers to see if the user's guess is match
 * 3
 * the array of 10 magic numbers can either be randomly 
 * generated or hardcoded by the programmer
 * -randomly generated is a better solution
 * 
 * the magic numbers lie in the range of 1 to 100.
 */
import java.util.Random;
import java.util.Scanner;


public class GuessingGame {
    public static void main(String[] args) {
        //1
        int[] magicNumbers = new int[10];
        Random random = new Random();
        for (int i = 0; i < magicNumbers.length; i++) {
            magicNumbers[i] = random.nextInt(100) + 1;
        }

        //3 input user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess (1-100): ");
        int guess = scanner.nextInt();

        //2recursive linear search
        boolean isCorrect = recursiveLinearSearch(magicNumbers, guess, 0);

        if (isCorrect) {
            System.out.println("YES! You ROCK, lets play Lottery shall we!");
        } else {
            System.out.println("noooo not this time");
        }
    }
    
    //recursive Linear Search
    public static boolean recursiveLinearSearch(int[] array, int guess, int index) {
        if (index >= array.length) {
            return false;
        }
        if (array[index] == guess) {
            return true;
        }
        return recursiveLinearSearch(array, guess, index + 1);
    }
}