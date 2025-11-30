package Main.controller;

import Main.controller.PersonModelController;

public class TaxCalculator {
    private static final int TAX_FREE_LIMIT = 20000;
    private static final int STATE_TAX_LIMIT = 600000;
    private static final double MUNICIPAL_TAX_RATE = 0.30;
    private static final double STATE_TAX_RATE = 0.20;
    private static final double PENSION_RATE = 0.07;

    public TaxCalculator() {}

    public double calculateTaxes(PersonModelController person) {
        if (person == null) {
            throw new IllegalArgumentException("PersonModelController does not exist.");
        }

        int income = person.getIncome();
        double tax = 0.0;

        if (income < TAX_FREE_LIMIT) {
            return 0.0;
        }

        // Municipal Tax
        tax = (income - TAX_FREE_LIMIT) * MUNICIPAL_TAX_RATE;
        
        // State Tax
        if (income > STATE_TAX_LIMIT) {
            tax += (income - STATE_TAX_LIMIT) * STATE_TAX_RATE;
        }

        return tax;
    }

    public double calculateNetIncome(PersonModelController person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        double tax = calculateTaxes(person);
        return person.getIncome() - tax;
    }

    public double calcuatePensionFee(PersonModelController person) {
        return person.getIncome() * PENSION_RATE;
    }
}
