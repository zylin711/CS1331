public class Dog extends Pet {
    private double droolRate;

    private static final double DEFAULT_DROOL_RATE = 5.0;

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        this.droolRate = droolRate;
    }

    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, DEFAULT_DROOL_RATE);
    }

    public double getDroolRate() {
        return this.droolRate;
    }

    @Override
    public int treat() {
        double originalHealth = getHealth();
        int originalPain = getPainLevel();
        int treatmentTime;
        heal();

        if (droolRate < 3.5) {
            treatmentTime = (int) Math.ceil((originalPain * 2) / originalHealth);
        } else if (droolRate <= 7.5) {
            treatmentTime = (int) Math.ceil(originalPain / originalHealth);
        } else {
            treatmentTime = (int) Math.ceil(originalPain / (originalHealth * 2));
        }

        return treatmentTime;
    }

    @Override
    public void speak() {
        super.speak();
        int times = getPainLevel();
        for (int i = 0; i < times; i++) {
            if (times > 5) {
                System.out.print("BARK ");
            } else {
                System.out.print("bark ");
            }
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Dog) {
            return super.equals(o) && this.droolRate == ((Dog) o).getDroolRate();
        }
        return false;
    }
}