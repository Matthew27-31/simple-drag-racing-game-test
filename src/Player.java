import java.util.Scanner;

/**
 * Represents the player in the drag race.
 * The player selects a car and chooses actions during the race.
 */
public class Player {
    private String name;  // The player's name
    private Car car;      // The player's car
    private Scanner scanner; // Scanner for user input
    /**
     * Constructs a Player object with a given name.
     * The player is prompted to enter their car model.
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        this.scanner = new Scanner(System.in);
        this.car = chooseCustomCar();
    }
    /**
     * Prompts the player to enter a custom car model name.
     * Creates a new Car object using the entered model name.
     * @return A Car object with the specified model name.
     */
    private Car chooseCustomCar() {
        System.out.println("Enter your car's model name:");
        String carModel = scanner.nextLine();
        return new Car(carModel);
    }

    /**
     * Allows the player to take a turn by selecting an action.
     * The player can accelerate, shift gears, or default to acceleration if an invalid input is given.
     */
    public void takeTurn() {
        System.out.println(name + ", choose an action:");
        System.out.println("1 - Accelerate");
        System.out.println("2 - Shift Gears");

        int action = scanner.nextInt();
        if (action == 1) {
            car.accelerate();
        } else if (action == 2) {
            car.shiftGear();
        } else {
            System.out.println("Invalid action. Defaulting to accelerating.");
            car.accelerate();
        }
    }
    /**
     * Checks whether the player's car has crossed the finish line.
     * @param finishLine The required race distance to win.
     * @return True if the car has reached or exceeded the finish line, false otherwise.
     */
    public boolean hasFinished(int finishLine) {
        return car.hasFinished(finishLine);
    }
    /**
     * Retrieves the player's car.
     * @return The car associated with the player.
     */
    public Car getCar() {
        return car;
    }
}
