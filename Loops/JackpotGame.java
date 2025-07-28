import java.util.*;

public class JackpotGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int jackpot = rand.nextInt(100) + 1; // random number 1-100

        System.out.println("🎰 Welcome to Jackpot Guessing Game 🎰");
        System.out.println("Select difficulty: 1. Easy 2. Medium 3. Difficult");
        int choice = sc.nextInt();
        
        int attempts = 0;
        if (choice == 1) {
            attempts = 20;
        } else if (choice == 2) {
            attempts = 10;
        } else {
            attempts = 5;
        }

        System.out.println("Guess the number between 1 to 100!");
        
        for (int i = 1; i <= attempts; i++) {
            System.out.print("Attempt " + i + ": ");
            int guess = sc.nextInt();

            if (guess == jackpot) {
                System.out.println("🎉 Correct! You win the jackpot! 🎉");
                break;
            } else if (guess < jackpot) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }

            if (i == attempts) {
                System.out.println("😢 Out of attempts! The jackpot number was: " + jackpot);
            }
        }
        sc.close();
    }
}
