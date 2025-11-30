package Main.controller;

import Main.model.PersonModel;

public class TaxCalculator {
    private static final int TAX_FREE_LIMIT = 20000;
    private static final int STATE_TAX_LIMIT = 600000;
    private static final double MUNICIPAL_TAX_RATE = 0.30;
    private static final double STATE_TAX_RATE = 0.20;
    private static final double PENSION_RATE = 0.07;
    private static final int SENIOR_AGE = 65;
    private static final double SENIOR_DISCOUNT = 0.05;

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

    public double calculatePensionFee(PersonModelController person) {
        if (person == null)
            throw new IllegalArgumentException("Person cannot be null");
        return person.getIncome() * PENSION_RATE;
    }

    public double calculateTotalBurden(PersonModelController person) {
        if (person == null)
            throw new IllegalArgumentException("Person cannot be null");
        double tax = calculateTaxes(person);
        double pension = calculatePensionFee(person);
        return tax + pension;
    }

    public double calculateNetIncomeAfterPension(PersonModelController person) {
        if (person == null)
            throw new IllegalArgumentException("Person cannot be null");
        double totalBurden = calculateTotalBurden(person);
        return person.getIncome() - totalBurden;
    }

    public double calculateTaxesWithDeductions(PersonModelController person) {
        if (person == null)
            throw new IllegalArgumentException("Person cannot be null");

        double tax = calculateTaxes(person);
        int totalDeductions = person.getTotalDeduction();
        double deductionEffect = totalDeductions * MUNICIPAL_TAX_RATE;
        return Math.max(0, tax - deductionEffect);
    }

    public double calculateTaxesWithAge(PersonModelController person) {
        double tax = calculateTaxes(person);
        tax *= (1 - SENIOR_DISCOUNT);
        return tax;
    }
}
