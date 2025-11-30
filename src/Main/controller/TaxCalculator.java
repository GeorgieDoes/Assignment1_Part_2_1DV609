package Main.controller;

import Main.controller.PersonModelController;

public class TaxCalculator {
    public double calculateTaxes(PersonModelController person) {
        int income = person.getIncome();
        double tax = 0.0;

        if (income < 20000) {
            tax = 0.0;
        } else {
            tax = (income - 20000) * 0.30;
            
            if (income > 600000) {
                tax += (income - 600000) * 0.20;
            }
        }
        


        return tax;
    }
}
