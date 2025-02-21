import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    private int numTasks;
    private int taskSpeed;

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public BlueAstronaut(String name) {
        this(name, 15, 6, 10);
    }

    @Override
    public void emergencyMeeting() {
        if (this.isFrozen()) return;

        Player[] ptr = Player.getPlayers();
        Arrays.sort(ptr, (p1, p2) -> p2.getSusLevel() - p1.getSusLevel());

        int maxNotFrozenIndex = -1;
        for (int i = 0; i < ptr.length; i++) {
            if (!ptr[i].isFrozen()) {
                maxNotFrozenIndex = i;
                break;
            }
        }

        if (maxNotFrozenIndex == -1) return;

        int targetIndex = maxNotFrozenIndex;
        if (ptr[maxNotFrozenIndex] == this) {
            while (targetIndex + 1 < ptr.length && ptr[targetIndex + 1].getSusLevel() == ptr[maxNotFrozenIndex].getSusLevel()) {
                targetIndex++;
            }
            if (targetIndex + 1 >= ptr.length || ptr[targetIndex + 1].isFrozen()) {
                return;
            }
            targetIndex++;
        }

        for (int i = targetIndex + 1; i < ptr.length; i++) {
            if (!ptr[i].isFrozen() && ptr[i].getSusLevel() == ptr[targetIndex].getSusLevel()) {
                return;
            }
        }

        ptr[targetIndex].setFrozen(true);
        gameOver();
    }

    @Override
    public void completeTask() {
        if (isFrozen() || numTasks == 0) {
            if (!isFrozen() && numTasks == 0) {
                setSusLevel((int) (0.5 * getSusLevel()));
            }
            return;
        }

        numTasks -= (taskSpeed > 20) ? 2 : 1;
        if (numTasks < 0) numTasks = 0;

        if (numTasks == 0) {
            System.out.println("I have completed all my tasks");
            setSusLevel((int) (0.5 * getSusLevel()));
        }
    }

    public int getNumTasks(){
        return numTasks;
    }

    public int getTaskSpeed(){
        return taskSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Crewmate) {
            BlueAstronaut another = (BlueAstronaut) o;
            return this.compareTo(another) == 0 &&
                    this.getName().equals(another.getName()) &&
                    this.getTaskSpeed() == another.getTaskSpeed() &&
                    this.getNumTasks() == another.getNumTasks() &&
                    this.isFrozen() == another.isFrozen();
        }
        return false;
    }

    @Override
    public String toString() {
        String lowercase = super.toString() + "I have " + numTasks + " left over.";
        return getSusLevel() > 15 ? lowercase.toUpperCase() : lowercase;
    }
}