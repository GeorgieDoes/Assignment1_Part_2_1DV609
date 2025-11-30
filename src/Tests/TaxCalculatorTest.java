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
        double expectedTax = 30000.0; // Assuming 30% municipal tax
        
        assertEquals(expectedTax, calc.calculateTaxes(person));
    }
  
    @Test
    public void testCalculateTaxForHighIncome() {
        PersonModelController person = new PersonModelController();
        person.setIncome(50000);
        double expectedTax = 15000.0; // Assuming 30% municipal tax
        
        assertEquals(expectedTax, calc.calculateTaxes(person));
    }
}