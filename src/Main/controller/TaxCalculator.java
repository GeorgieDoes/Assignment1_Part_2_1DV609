package Main.controller;

import Main.controller.PersonModelController;

public class TaxCalculator {
    public double calculateTaxes(PersonModelController person) {
        int income = person.getIncome();
        double tax = 0.0;

        if (income < 20000) {
            tax = 0.0;
        } else {
            tax = income * 0.30;
        }

        return tax;
    }
}
