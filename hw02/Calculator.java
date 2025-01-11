import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");

        String operation = scanner.nextLine().trim().toLowerCase();

        switch (operation) {
            case "add":
            case "subtract":
                System.out.println("Enter two integers:");
                if (scanner.hasNextInt()) {
                    int num1 = scanner.nextInt();
                    if (scanner.hasNextInt()) {
                        int num2 = scanner.nextInt();
                        if (operation.equals("add")) {
                            System.out.println("Answer: " + (num1 + num2));
                        } else {
                            System.out.println("Answer: " + (num1 - num2));
                        }
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                    }
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            case "multiply":
            case "divide":
                System.out.println("Enter two doubles:");
                if (scanner.hasNextDouble()) {
                    double num1 = scanner.nextDouble();
                    if (scanner.hasNextDouble()) {
                        double num2 = scanner.nextDouble();
                        if (operation.equals("multiply")) {
                            System.out.printf("Answer: %.2f\n", num1 * num2);
                        } else {
                            if (num2 == 0) {
                                System.out.println("Invalid input entered. Terminating...");
                            } else {
                                System.out.printf("Answer: %.2f\n", num1 / num2);
                            }
                        }
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                    }
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            case "alphabetize":
                System.out.println("Enter two words:");
                if (scanner.hasNext()) {
                    String word1 = scanner.next();
                    if (scanner.hasNext()) {
                        String word2 = scanner.next();
                        int comparison = word1.compareToIgnoreCase(word2);
                        if (comparison == 0) {
                            System.out.println("Answer: Chicken or Egg.");
                        } else if (comparison < 0) {
                            System.out.printf("Answer: %s comes before %s alphabetically.\n", word1, word2);
                        } else {
                            System.out.printf("Answer: %s comes before %s alphabetically.\n", word2, word1);
                        }
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                    }
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            default:
                System.out.println("Invalid input entered. Terminating...");
                break;
        }
    }
}
