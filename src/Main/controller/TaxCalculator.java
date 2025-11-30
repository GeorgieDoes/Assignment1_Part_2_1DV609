package Main.controller;

import Main.controller.PersonModelController;

public class TaxCalculator {
    public double calculateTaxes(PersonModelController person) {
        int income = person.getIncome();
        double tax;

        if (income <= 10000) {
            tax = income * 0.10; // 10% tax for income up to 10,000
        } else {
            tax = 0;
        }

        return tax;
    }
}
