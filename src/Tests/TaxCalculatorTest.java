package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Main.controller.TaxCalculator;

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
    public void testCalculateTaxes() {
        calc.calculateTaxes();
    }
}


