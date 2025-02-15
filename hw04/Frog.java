public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = "Rare Pepe";

    // Constructor chaining
    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        this.isFroglet = age > 1 && age < 7;
    }

    public Frog(String name, double ageInYears, double tongueSpeed) {
        this(name, (int) (ageInYears * 12), tongueSpeed);
    }

    public Frog(String name) {
        this(name, 5, 5);
    }

    // Setters
    public static void setSpecies(String newSpecies) {
        species = newSpecies;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getTongueSpeed() {
        return tongueSpeed;
    }

    public static String getSpecies() {
        return species;
    }

    // grow method with a whole number parameter
    public void grow(int months) {
        for (int i = 0; i < months; i++) {
            if (age < 12) {
                tongueSpeed += 1;
            } else if (age >= 30 && tongueSpeed > 5) {
                tongueSpeed -= 1;
            }
            age += 1;
            isFroglet = age > 1 && age < 7;
        }
    }

    // grow method with no parameters
    public void grow() {
        grow(1);
    }

    // eat method
    public void eat(Fly fly) {
        if (fly.isDead()) {
            return;
        }
        if (tongueSpeed > fly.getSpeed()) {
            if (fly.getMass() >= 0.5 * age) {
                grow();
            }
            fly.setMass(0);
        } else {
            fly.grow(1);
        }
    }

    // toString method
    public String toString() {
        if (isFroglet) {
            return String.format("My name is %s and I’m a rare froglet! I’m %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        } else {
            return String.format("My name is %s and I’m a rare frog. I’m %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        }
    }
}