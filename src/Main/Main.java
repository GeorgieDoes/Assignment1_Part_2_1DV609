package Main;

import Main.view.DisplayView;
import Main.controller.PersonModelController;
import Main.controller.TaxCalculator;

public class Main {
    public static void main(String[] args) {
        DisplayView view = new DisplayView();
        PersonModelController controller = new PersonModelController();
        TaxCalculator calculator = new TaxCalculator();

        view.printWelcomeMessage();
        view.printInstructions();

        String name = view.getName();
        controller.setName(name);

        int income = view.getIncome();
        controller.setIncome(income);

        int age = view.getAge();
        controller.setAge(age);

        double tax = calculator.calculateTaxesWithAge(controller);
        view.printResults(tax);
        
        view.close();
    }
}