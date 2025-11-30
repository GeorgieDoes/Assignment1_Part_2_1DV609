package Main.view;

import java.util.Scanner;

public class DisplayView {
    private Scanner scanner;

    public DisplayView() {
        this.scanner = new Scanner(System.in);
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to the Tax Calculator");
    }

    public void printInstructions() {
        System.out.println("Please enter your name, income, and age to calculate your taxes.");
    }

    
    public String getInput() {
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return "";
    }

    public void close() {
        scanner.close();
    }

    public int getAge() {
        scanner = new Scanner(System.in);
        int age = -1;
        while (age < 0) {
            System.out.print("Please enter your age: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                if (age < 0) {
                    System.out.println("Age cannot be negative. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid age.");
                scanner.next(); // consume the invalid input
            }
        }
        return age;
    }
}