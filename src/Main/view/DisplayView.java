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
}    
