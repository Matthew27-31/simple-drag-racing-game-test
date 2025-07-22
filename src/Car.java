/**
 * Represents a car in the drag race, with attributes for speed, gears, and distance traveled.
 */
public class Car {
    private String name;
    private int speed;
    private int gear;
    private int distance;
    /**
     * Constructs a car with a given name, initializing speed, gear, and distance.
     *
     * @param name The model name of the car.
     */
    public Car(String name) {
        this.name = name;
        this.speed = 0;
        this.gear = 1;
        this.distance = 0;
    }
    /**
     * Accelerates the car based on the current gear level.
     * Speed increases, and distance covered is updated accordingly.
     */
    public void accelerate() {
        speed += gear * 10;
        distance += speed;
        System.out.println(name + " accelerates! Speed: " + speed + " | Distance: " + distance + "m");
    }
    /**
     * Shifts the car to the next gear, if it is not already at the max gear level.
     * Gear shifting increases acceleration efficiency.
     */
    public void shiftGear() {
        if (gear < 5) {
            gear++;
            System.out.println(name + " shifts to gear " + gear + "!");
        } else {
            System.out.println(name + " is already at max gear!");
        }
    }
    /**
     * Checks whether the car has reached the race's finish line.
     *
     * @param finishLine The total distance required to finish the race.
     * @return True if the car has traveled at least the finish line distance, false otherwise.
     */
    public boolean hasFinished(int finishLine) {
        return distance >= finishLine;
    }
    /**
     * Retrieves the car's model name.
     * @return The model name of the car.
     */
    public String getName() {
        return name;
    }
}
