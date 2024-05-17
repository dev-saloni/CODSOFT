import java.util.Random;
import java.util.Scanner;

public class NumberGame{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Welcome to the Number Guessing Game!");
        
        System.out.println("Enter no. of guess attempts");
        int x=scanner.nextInt();
        int Attempts = x; // Change this value to adjust the maximum number of attempts
        int score = 0;
        boolean play= true;

        while (play) {
            int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0;
            boolean Correctguess = false;

            System.out.println("\nNew Round");

            while (attempts < Attempts) {
                System.out.print("Enter your guess (1-100): ");
                int guess = scanner.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the Number.");
                    score += (Attempts - attempts);
                    Correctguess = true;
                    System.out.println("\nGame Over!");
                    System.out.println("Your final score: " + score);
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                attempts++;
            }

            if (!Correctguess) {
                System.out.println("Sorry, you ran out of attempts. The number was " + randomNumber + ".");
            }

            System.out.print("\nDo you want to play again? (y/n): ");
            String choice = scanner.next();
            play = choice.equalsIgnoreCase("y");
        }

        System.out.println("\nGame Over!");
        System.out.println("Your final score: " + score);
        scanner.close();
    }
}      

