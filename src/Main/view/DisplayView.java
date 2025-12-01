package Main.view;

import java.util.Scanner;

public class DisplayView {
    private Scanner scanner;

    public DisplayView() {
        this(new Scanner(System.in));
    }

    public DisplayView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to the Tax Calculator");
    }

    public void printInstructions() {
        System.out.println("Please enter your Age, Name and Income to calculate your taxes.");
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
        int age = -1;
        while (age <= 0) {
            System.out.print("Please enter your age: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (age <= 0) {
                    System.out.println("Age cannot be negative or zero. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid age.");
                if (scanner.hasNext()) {
                    scanner.next(); // consume the invalid input
                    scanner.nextLine(); // consume newline
                } else {
                    break;
                }
            }
        }
        return age;
    }

    public String getName() {
      String name = "";
      while (name.trim().isEmpty()) {
        System.out.print("Please enter your name: ");
        if (scanner.hasNextLine()) {
          name = scanner.nextLine();
          if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty or just whitespace. Please try again.");
          }
        } else {
          break;
        }
      }
      return name;
    }

    public int getIncome() {
        int income = -1;
        while (income <= 0) {
            System.out.print("Please enter your income: ");
            if (scanner.hasNextInt()) {
                income = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (income < 0) {
                    System.out.println("Income cannot be negative. Please try again.");
                } else if (income == 0) {
                    System.out.println("Income cannot be zero. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid income.");
                if (scanner.hasNext()) {
                    scanner.next(); // consume invalid token
                    scanner.nextLine(); // consume newline
                } else {
                    break;
                }
            } 
        }
        return income;
    }

    public void printResults(double tax) {
        System.out.println("Your calculated tax is: " + tax);
    }

}