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
        double expectedTax = 1000.0; // Assuming 10% tax rate for low income
        
        assertEquals(expectedTax, calc.calculateTaxes(person));
    }
  
}
