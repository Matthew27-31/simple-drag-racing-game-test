import java.util.Random;
/**
 * Represents an AI opponent in the drag race.
 * The AI makes decisions automatically, choosing between acceleration and gear shifting.
 */

public class AI {
    private String name;
    private Car car;
    private Random random;
    /**
     * Constructs an AI racer with a given name and car.
     *
     * @param name The name of the AI opponent.
     * @param car The car assigned to the AI.
     */
    public AI(String name, Car car) {
        this.name = name;
        this.car = car;
        this.random = new Random();
    }
    /**
     * Executes the AI's turn, randomly choosing to either accelerate or shift gears.
     */
    public void takeTurn() {
        // Randomly choose an action: 1 for accelerate, 2 for shifting gears.
        int action = random.nextInt(2) + 1;
        if (action == 1) {
            car.accelerate();
            System.out.println(name + " chooses Accelerate!");
        } else {
            car.shiftGear();
            System.out.println(name + " chooses Shift Gears!");
        }
    }
    /**
     * Checks whether the AI has finished the race by reaching the finish line.
     *
     * @param finishLine The race's finish line distance.
     * @return True if the AI has reached or exceeded the finish line; false otherwise.
     */
    public boolean hasFinished(int finishLine) {
        return car.hasFinished(finishLine);
    }
    /**
     * Retrieves the AI's name.
     * @return The name of the AI opponent.
     */
    public String getName() {
        return name;
    }
    /**
     * Retrieves the AI's car.
     * @return The car associated with the AI.
     */
    public Car getCar() {
        return car;
    }
}