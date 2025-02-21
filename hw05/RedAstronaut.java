import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    private String skill;

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill.toLowerCase();
    }

    public RedAstronaut(String name) {
        this(name, 15, "experienced");
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

        for (int i = maxNotFrozenIndex + 1; i < ptr.length; i++) {
            if (!ptr[i].isFrozen() && ptr[i].getSusLevel() == ptr[maxNotFrozenIndex].getSusLevel()) {
                return;
            }
        }

        ptr[maxNotFrozenIndex].setFrozen(true);
        gameOver();
    }

    @Override
    public void freeze(Player p) {
        if (p == null || this.isFrozen() || p instanceof Impostor || p.isFrozen()) {
            return;
        }

        if (this.compareTo(p) < 0) {
            p.setFrozen(true);
        } else {
            this.setSusLevel(this.getSusLevel() * 2);
        }

        gameOver();
    }

    @Override
    public void sabotage(Player p) {
        if (p == null || this.isFrozen() || p instanceof Impostor || p.isFrozen()) {
            return;
        }

        int newSusLevel;
        if (this.getSusLevel() < 20) {
            newSusLevel = (int) (p.getSusLevel() * 1.5);
        } else {
            newSusLevel = (int) (p.getSusLevel() * 1.25);
        }

        p.setSusLevel(newSusLevel);
    }

    public String getSkill(){
        return skill;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Impostor) {
            RedAstronaut another = (RedAstronaut) o;
            return this.compareTo(another) == 0 &&
                    this.getName().equals(another.getName()) &&
                    this.skill.equals(another.getSkill()) &&
                    this.isFrozen() == another.isFrozen();
        }
        return false;
    }

    @Override
    public String toString() {
        String lowercase = super.toString() + " I am an " + skill + " player!";
        return getSusLevel() > 15 ? lowercase.toUpperCase() : lowercase;
    }

}