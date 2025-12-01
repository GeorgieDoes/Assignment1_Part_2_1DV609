package Main.controller;

import Main.model.PersonModel;

/**
 * Controller class for managing PersonModel data.
 * Handles validation and updates to the person's information.
 */
public class PersonModelController {
    private PersonModel personModel;

    /**
     * Default constructor.
     * Initializes a new PersonModel.
     */
    public PersonModelController() {
        this.personModel = new PersonModel();
    }

    // ==========================
    // Setters with Validation
    // ==========================

    /**
     * Sets the name of the person.
     * @param name The name to set. Cannot be null or empty.
     * @throws IllegalArgumentException if the name is null or empty.
     */
    public void setName(String name) { 
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty.");
        }
        this.personModel.setName(name); 
    }

    /**
     * Sets the annual income of the person.
     * @param income The income to set. Must be non-negative.
     * @throws IllegalArgumentException if the income is negative.
     */
    public void setIncome(int income) { 
        if (income < 0) {
            throw new IllegalArgumentException("Invalid integer value for income.");
        }
        this.personModel.setIncome(income); 
    }
    
    /**
     * Sets the age of the person.
     * @param age The age to set. Must be between 0 and 130.
     * @throws IllegalArgumentException if the age is invalid.
     */
    public void setAge(int age) { 
        if (age < 0 || age > 130) {
            throw new IllegalArgumentException("Invalid integer value for age.");
        }
        this.personModel.setAge(age); 
    }

    /**
     * Adds a deduction to the person's record.
     * @param amount The deduction amount. Must be non-negative.
     * @throws IllegalArgumentException if the amount is negative.
     */
    public void setDeduction(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid integer value for deduction.");
        }
        this.personModel.setDeduction(amount);
    }

    // ==========================
    // Getters
    // ==========================

    /**
     * Gets the name of the person.
     * @return The person's name.
     */
    public String getName() { 
        return this.personModel.getName(); 
    }

    /**
     * Gets the annual income of the person.
     * @return The person's income.
     */
    public int getIncome() { 
        return this.personModel.getIncome(); 
    }

    /**
     * Gets the age of the person.
     * @return The person's age.
     */
    public int getAge() { 
        return this.personModel.getAge(); 
    }

    /**
     * Gets the total deductions for the person.
     * @return The sum of all deductions.
     */
    public int getTotalDeduction() { 
        return this.personModel.getTotalDeduction(); 
    }
}
