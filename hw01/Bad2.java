public class Bad2 {
    public static void main(String[] args) {
        int a = 1331;
        int b = 4; // Fixed the value b to avoid division by zero
        System.out.println("Welcome to \nCS 1331!");
        int c = a / b;
        System.out.println("c is equal to: " + c);
    }
}