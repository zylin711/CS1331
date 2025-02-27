import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Clinic {
    private File patientFile;
    private int day;

    public Clinic(String fileName) {

        this(new File(fileName));
    }
    

    public Clinic(File file) {
        this.patientFile = file;
        this.day = 1;
    }

    public String nextDay(File f) throws FileNotFoundException {
        StringBuilder updatedInfo = new StringBuilder();
        Scanner fileScanner = new Scanner(f);
        Scanner inputScanner = new Scanner(System.in);

        while (fileScanner.hasNextLine()) {
            String[] details = fileScanner.nextLine().split(",");
            String name = details[0];
            String petType = details[1];
            String petAttr = details[2];
            String timeIn = details[3];

            if (!(petType.equals("Dog") || petType.equals("Cat"))) {
                fileScanner.close();
                throw new InvalidPetException("Invalid Pet Type: " + petType);
            }

            System.out.printf("Consultation for %s the %s at %s.\n", name, petType, timeIn);

            System.out.printf("What is the health of %s?\n", name);
            double health = getInputDouble(inputScanner, "", 0.0, 1.0);
            System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);
            int painLevel = getInputInt(inputScanner, "", 1, 10);

            Pet patient = petType.equals("Dog")
                    ? new Dog(name, health, painLevel, Double.parseDouble(petAttr))
                    : new Cat(name, health, painLevel, Integer.parseInt(petAttr));

            patient.speak();

            updatedInfo.append(String.format("%s,%s,%s,Day %d,%s,%s,%.2f,%d\n",
                    patient.getName(), petType, petAttr, this.day,
                    timeIn, addTime(timeIn, patient.treat()),
                    health, painLevel));
        }

        fileScanner.close();
        this.day++;
        return updatedInfo.toString();
    }

    public String nextDay(String fileName) throws FileNotFoundException {
        return nextDay(new File(fileName));
    }


    public boolean addToFile(String patientInfo) {
        try {
            Scanner fileScanner = new Scanner(patientFile);
            StringBuilder allContent = new StringBuilder();
            String[] newInfo = patientInfo.split(",");
            boolean isExistingPatient = false;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.startsWith(newInfo[0] + ",")) {
                    isExistingPatient = true;
                    allContent.append(line.trim())
                            .append(String.format(",%s,%s,%s,%s,%s\n", newInfo[3], newInfo[4], newInfo[5], newInfo[6], newInfo[7]));
                } else {
                    allContent.append(line).append("\n");
                }
            }
            fileScanner.close();

            if (!isExistingPatient) {
                allContent.append(patientInfo).append("\n");
            }

            PrintWriter writer = new PrintWriter(patientFile);
            writer.print(allContent.toString());
            writer.close();

            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + patientFile.getName());
            return false;
        }
    }

    private double getInputDouble(Scanner scanner, String message, double min, double max) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                double value = Double.parseDouble(input);
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.printf("Please enter a number between %.1f and %.1f.\n", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a decimal number.");
            }
        }
    }

    private int getInputInt(Scanner scanner, String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.printf("Please enter an integer between %d and %d.\n", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    private String addTime(String timeIn, int treatmentTime) {
        int hour = Integer.parseInt(timeIn.substring(0, 2));
        int minute = Integer.parseInt(timeIn.substring(2, 4));
        minute += treatmentTime;
        hour += minute / 60;
        minute = minute % 60;
        return String.format("%02d%02d", hour, minute);
    }
}