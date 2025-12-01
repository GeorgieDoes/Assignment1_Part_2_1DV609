package Main.controller;

public class TaxCalculator {
    // === === === === === === === ===
    // CONSTANTS
    // === === === === === === === ===
    private static final int TAX_FREE_LIMIT = 20000;
    private static final int STATE_TAX_LIMIT = 600000;
    private static final double MUNICIPAL_TAX_RATE = 0.30;
    private static final double STATE_TAX_RATE = 0.20;
    private static final double PENSION_RATE = 0.07;
    private static final int SENIOR_AGE = 65;
    private static final double SENIOR_DISCOUNT = 0.05;

    public TaxCalculator() {}

    // === === === === === === === ===
    // Core calculations
    // === === === === === === === ===

    /**
     * Calculate municipal and state tax before any deduction or age multipliers.
     *
     * @param person    <-- represents the preson we're taxing.
     * @return          <-- tax.
     */
    public double calculateTaxes(PersonModelController person) {
        validatePerson(person);
        int income = person.getIncome();

        if (income <= TAX_FREE_LIMIT)
            return 0.0;

        double municipalTax = (income - TAX_FREE_LIMIT) * MUNICIPAL_TAX_RATE;
        double stateTax = income > STATE_TAX_LIMIT ? (income - STATE_TAX_LIMIT) * STATE_TAX_RATE : 0.0;

        return municipalTax + stateTax;
    }

    /**
     * Pension fee based on income.
     *
     * @param person    <-- represents the preson we're taxing.
     * @return          <-- tax modifier.
     */
    public double calculatePensionFee(PersonModelController person) {
        validatePerson(person);
        return person.getIncome() * PENSION_RATE;
    }

    /**
     * Calculate total burden aka taxes + pension.
     *
     * @param person    <-- represents the preson we're taxing.
     * @return          <-- burden.
     */
    public double calculateTotalBurden(PersonModelController person) {
        validatePerson(person);
        return calculateTaxes(person) + calculatePensionFee(person);
    }

    // === === === === === === === ===
    // Net income calculations
    // === === === === === === === ===

    /**
     * Net income after taxes.
     *
     * @param person    <-- represents the preson we're taxing.
     * @return          <-- net income.
     */
    public double calculateNetIncome(PersonModelController person) {
        validatePerson(person);
        return person.getIncome() - calculateTaxes(person);
    }

    /**
     * Net income after taxes and pension
     * @param person    <-- represents the preson we're taxing.
     * @return          <-- net income.
     */
    public double calculateNetIncomeAfterPension(PersonModelController person) {
        validatePerson(person);
        return person.getIncome() - calculateTotalBurden(person);
    }

    // === === === === === === === ===
    // Deduced income calculations
    // === === === === === === === ===

    /**
     * Taxes reduced by deductions (charity donations and such).
     *
     * @param person    <-- represents the preson we're taxing.
     * @return          <-- Total taxes after deductions.
     */
    public double calculateTaxesWithDeductions(PersonModelController person) {
        validatePerson(person);
        double tax = calculateTaxes(person);
        double deductionEffect = person.getTotalDeduction() * MUNICIPAL_TAX_RATE;
        return Math.max(0, tax - deductionEffect);
    }

    /**
     * Tax adjusted by age.
     * @param person    <-- represents the preson we're taxing.
     * @return          <-- tax with deduction.
     */
    public double calculateTaxesWithAge(PersonModelController person) {
        validatePerson(person);
        double tax = calculateTaxes(person);
        if(person.getAge() >= SENIOR_AGE) {
            tax *= (1 - SENIOR_DISCOUNT);
        }
        if(person.getAge() < 18) {
            tax = 0;
        }
        return tax;
    }

    // === === === === === === === ===
    // Helpers
    // === === === === === === === ===

    /**
     * Simple reusable null check for public methods.
     * @param person    <-- represents the preson we're taxing.
     */
    private void validatePerson(PersonModelController person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null.");
        }
    }
}
