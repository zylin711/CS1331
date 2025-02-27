public abstract class Pet {
    private String name;
    private double health;
    private int painLevel;

    public Pet(String name, double health, int painLevel) {
        this.name = name;
        this.health = Math.max(0.0, Math.min(1.0, health));
        this.painLevel = Math.max(1, Math.min(10, painLevel));
    }

    public String getName() {
        return this.name;
    }

    public double getHealth() {
        return this.health;
    }

    public int getPainLevel() {
        return this.painLevel;
    }

    public abstract int treat();

    public void speak() {
        String message = "Hello! My name is " + this.name;
        System.out.println(this.painLevel > 5 ? message.toUpperCase() : message);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Pet && name.equals(((Pet) o).name);
    }

    protected void heal() {
        this.health = 1.0;
        this.painLevel = 1;
    }
}