package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Main.controller.TaxCalculator;
import Main.controller.PersonModelController;

public class TaxCalculatorTest {
    private TaxCalculator calc;
    private PersonModelController person;

    @BeforeEach
    public void setUp() {
        calc = new TaxCalculator();
        person = new PersonModelController();
    }

    @Test 
    public void testObjectCreation() {
        assertNotNull(calc);
    }

    @Test
    public void testCalculateTaxForZeroIncome() {
        person.setIncome(0);

        double expectedTax = 0.0;
        double actualTax = calc.calculateTaxes(person);

        assertEquals(expectedTax, actualTax);
    }


    @Test
    public void testCalculateTaxForLowIncome() {
        person.setIncome(10000);
        double expectedTax = 0.0; // Swedish system: below ~20k is tax free
        
        assertEquals(expectedTax, calc.calculateTaxes(person));
    }

    @Test
    public void testCalculateTaxForMunicipalBracket() {
        person.setIncome(100000);
        double expectedTax = 24000.0; // Assuming 30% municipal tax
        
        assertEquals(expectedTax, calc.calculateTaxes(person));
    }
  
    @Test
    public void testCalculateTaxForHighIncome() {
        person.setIncome(50000);
        double expectedTax = 9000.0; // Assuming 30% municipal tax
        
        assertEquals(expectedTax, calc.calculateTaxes(person));
    }

    @Test
    public void testCalculateTaxWithBasicDeduction() {
        person.setIncome(25000);
        // Income 25,000. Basic Deduction 20,000. Taxable: 5,000.
        // Tax: 5,000 * 0.30 = 1,500.
        double expectedTax = 1500.0; 
        
        assertEquals(expectedTax, calc.calculateTaxes(person));
    }

    @Test
    public void testCalculateTaxForStateTaxBracket() {
        person.setIncome(700000);
        // Municipal tax: (700,000 - 20,000) * 0.30 = 204,000
        // State tax: (700,000 - 600,000) * 0.20 = 20,000
        // Total: 224,000
        double expectedTax = 224000.0; 
        
        assertEquals(expectedTax, calc.calculateTaxes(person));
    }

    @Test
    public void testEdgeCaseAtStartThreshold() {
        person.setIncome(600000);
        // Municipal: (600K - 20K) * 0.30 = 580K * 0.30 = 174,000
        // Stat: 0

        double expectedTax = 174000.0;
        assertEquals(expectedTax, calc.calculateTaxes(person));
    }

    @Test
    public void testNullPersonThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calculateTaxes(null);
        });
    }

    @Test
    public void testNetIncomeCalculation() {
        person.setIncome(100000);
        double tax = calc.calculateTaxes(person);
        double netIncome = calc.calculateNetIncome(person);
        assertEquals(100000 - tax, netIncome);
    }

    @Test
    public void testNetIncomeCalculationNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calculateNetIncome(null);
        });
    }

    @Test
    public void testPensionFeeCalculation() {
        person.setIncome(100000);
        assertEquals(7000, calc.calcuatePensionFee(person), 0.001);
    }
}


