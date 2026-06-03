import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1;
        int guess;

        System.out.println("Guess a number between 1 and 100");

        while (true) {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();

            if (guess > secretNumber) {
                System.out.println("Too High!");
            } else if (guess < secretNumber) {
                System.out.println("Too Low!");
            } else {
                System.out.println("Congratulations! You guessed the correct number.");
                break;
            }
        }

        sc.close();
    }
}