public class Cat extends Pet {
    private int miceCaught;

    private static final int DEFAULT_MICE_CAUGHT = 0;

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        this.miceCaught = Math.max(miceCaught, DEFAULT_MICE_CAUGHT);
    }

    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, DEFAULT_MICE_CAUGHT);
    }

    public int getMiceCaught() {
        return miceCaught;
    }

    @Override
    public int treat() {
        double originalHealth = getHealth();
        int originalPain = getPainLevel();
        int treatmentTime;

        if (miceCaught < 4) {
            treatmentTime = (int) Math.ceil((originalPain * 2) / originalHealth);
        } else if (miceCaught <= 7) {
            treatmentTime = (int) Math.ceil(originalPain / originalHealth);
        } else {
            treatmentTime = (int) Math.ceil(originalPain / (originalHealth * 2));
        }
        heal();
        return treatmentTime;
    }

    @Override
    public void speak() {
        super.speak();
        String meow = "meow";
        if (getPainLevel() > 5) {
            meow = meow.toUpperCase();
        }
        for (int i = 0; i < miceCaught; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(meow);
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cat) {
            return super.equals(o) && this.miceCaught == ((Cat) o).getMiceCaught();
        }
        return false;
    }
}