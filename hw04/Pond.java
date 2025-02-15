public class Pond {
    public static void main(String[] args) {
        // Creating 4 Frog objects
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw", 4.6, 5);
        Frog myFrog = new Frog("Kermit", 3, 7);

        // Creating 3 Fly objects
        Fly fly1 = new Fly(1, 3);
        Fly fly2 = new Fly(6);
        Fly fly3 = new Fly(2, 4);

        // 1. Set species
        Frog.setSpecies("1331 Frogs");

        // 2. Print Peepo's description
        System.out.println(peepo);

        // 3. Peepo attempts to eat fly2 (mass 6)
        peepo.eat(fly2);

        // 4. Print description of fly2
        System.out.println(fly2);

        // 5. Peepo grows by 8 months
        peepo.grow(8);

        // 6. Peepo attempts to eat fly2 again
        peepo.eat(fly2);

        // 7. Print description of fly2 again
        System.out.println(fly2);

        // 8. Print Peepo's description again
        System.out.println(peepo);

        // 9. Print description of my own Frog (Kermit)
        System.out.println(myFrog);

        // 10. Peepaw grows by 4 months
        peepaw.grow(4);

        // 11. Print description of Peepaw
        System.out.println(peepaw);

        // 12. Print Pepe's description
        System.out.println(pepe);
    }
}