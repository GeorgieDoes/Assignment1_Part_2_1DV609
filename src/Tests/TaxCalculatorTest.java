package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Main.controller.TaxCalculator;
import Main.controller.PersonModelController;

public class TaxCalculatorTest {
    private TaxCalculator calc;

    @BeforeEach
    public void setUp() {
        calc = new TaxCalculator();
    }

    @Test 
    public void testObjectCreation() {
        assertNotNull(calc);
    }

    @Test
    public void testCalculateTaxForZeroIncome() {
        PersonModelController person = new PersonModelController();
        person.setIncome(0);

        double expectedTax = 0.0;
        double actualTax = calc.calculateTaxes(person);

        assertEquals(expectedTax, actualTax);
    }


    @Test
    public void testCalculateTaxForLowIncome() {
        PersonModelController person = new PersonModelController();
        person.setIncome(10000);
        double expectedTax = 0.0; // Swedish system: below ~20k is tax free
        
        assertEquals(expectedTax, calc.calculateTaxes(person));
    }

    @Test
    public void testCalculateTaxForMunicipalBracket() {
        PersonModelController person = new PersonModelController();
        person.setIncome(100000);
        double expectedTax = 24000.0; // Assuming 30% municipal tax
        
        assertEquals(expectedTax, calc.calculateTaxes(person));
    }
  
    @Test
    public void testCalculateTaxForHighIncome() {
        PersonModelController person = new PersonModelController();
        person.setIncome(50000);
        double expectedTax = 9000.0; // Assuming 30% municipal tax
        
        assertEquals(expectedTax, calc.calculateTaxes(person));
    }

    @Test
    public void testCalculateTaxWithBasicDeduction() {
        PersonModelController person = new PersonModelController();
        person.setIncome(25000);
        // Income 25,000. Basic Deduction 20,000. Taxable: 5,000.
        // Tax: 5,000 * 0.30 = 1,500.
        double expectedTax = 1500.0; 
        
        assertEquals(expectedTax, calc.calculateTaxes(person));
    }
}