public class Car {
    private String make;
    private String model;
    private int year;
    private int speed;
    private int x;
    private int y;

    public Car(String make, String model, int year, int speed, int x, int y) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.speed = speed;
        this.x = x;
        this.y = y;
    }

    public void accelerate(int speed_increment) {
        this.speed += speed_increment;
    }

    public void brake(int speed_decrement) {
        this.speed -= speed_decrement;
    }

    public void move() {
        this.x += this.speed;
        this.y += this.speed;
    }

    public boolean detect_collision(Car car2) {
        return (this.x == car2.x && this.y == car2.y);
    }

    public double time_to_collision(Car car2) {
        int dx = car2.x - this.x;
        int dy = car2.y - this.y;
        int combinedSpeed = this.speed - car2.speed;
        double time = (double) (dx * dx + dy * dy) / (combinedSpeed * combinedSpeed);
        return time;
    }


public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Hyundai", "Creta", 2021, 60, 0, 0);
        Car car2 = new Car("Maruti", "Swift", 2018, 70, 100, 100);

        // Accelerate car1 and move it
        car1.accelerate(10);
        car1.move();

        // Brake car2 and move it
        car2.brake(20);
        car2.move();

        // Detect collision
        if (car1.detect_collision(car2)) {
            System.out.println("Cars have collided!");
        } else {
            System.out.println("Cars have not collided.");
        }

        // Calculate time to collision
        double time = car1.time_to_collision(car2);
        System.out.println("Time to collision: " + time + " seconds.");
    }
}
}
