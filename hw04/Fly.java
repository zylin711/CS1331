public class Fly {
    private double mass;
    private double speed;

    // Constructor chaining
    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public Fly(double mass) {
        this(mass, 10);
    }

    public Fly() {
        this(5, 10);
    }

    // Setters
    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    // Getters
    public double getMass() {
        return mass;
    }

    public double getSpeed() {
        return speed;
    }


    // toString method
    public String toString() {
        if (mass == 0) {
            return String.format("I’m dead, but I used to be a fly with a speed of %.2f.", speed);
        } else {
            return String.format("I’m a speedy fly with %.2f speed and %.2f mass.", speed, mass);
        }
    }

    // grow method
    public void grow(int addedMass) {
        for (int i = 0; i < addedMass; i++) {
            if (mass < 20) {
                speed += 1;
            } else {
                speed -= 0.5;
            }
            mass += 1;
        }
    }

    // isDead method
    public boolean isDead() {
        return mass == 0;
    }
}