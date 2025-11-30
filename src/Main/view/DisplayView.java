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


    
    public String getInput() {
        return scanner.nextLine();
    }

}