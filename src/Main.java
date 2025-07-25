import java.util.Random;
import java.util.Scanner;

/**
 * This is the main class that controls the flow of the game.
 * It initializes the player, AI, and drag race conditions.
 * @author Matthew Guzman
 * @version 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Drag Race!");

        // Get the player's name.
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        // Create the Player instance. The player's car is chosen by entering a custom name.
        Player player = new Player(playerName);

        // Define an array of available cars for the AI.
        String[] aiCarOptions = {
                "2019 Shelby GT500",
                "2019 Chevy Corvette ZR1",
                "Modified 1993 Ford Mustang Cobra Foxbody 5.0",
                "2023 Dodge Demon 170",
                "2019 Toyota Supra Mk.5",
                "1969 Chevy 'Yenko' Camaro - 427 Cubic Inch Upgrade ",
                "2014 Dodge Viper T/A Twin Turbo (Cammed)"
        };
        String aiCarChoice = aiCarOptions[random.nextInt(aiCarOptions.length)];
        Car aiCar = new Car(aiCarChoice);
        AI opponent = new AI("AI Racer", aiCar);

        // Ask for the drag race finish line distance.
        System.out.print("Enter the drag race distance (in meters): ");
        int finishLine = scanner.nextInt();
        if (finishLine <= 0) {
            System.out.println("No valid finish line defined. Setting default finish line to 402 meters.");
            finishLine = 402;
        }

        System.out.println("Race Begins!");

        // Main game loop.
        while (!player.hasFinished(finishLine) && !opponent.hasFinished(finishLine)) {
            player.takeTurn();
            if (player.hasFinished(finishLine)) {
                break;
            }
            opponent.takeTurn();
        }

        // Announcing the winner.
        if (player.hasFinished(finishLine)) {
            System.out.println(playerName + " wins the drag race in the " + player.getCar().getName() + "!");
        } else {
            System.out.println(opponent.getName() + " wins the drag race in the " + opponent.getCar().getName() + "!");
        }
    }
}
