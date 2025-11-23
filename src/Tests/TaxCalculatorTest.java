package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Main.controller.PersonModelController;

public class TaxCalculatorTest {
    private PersonModelController controller;

    @BeforeEach
    public void setUp() {
        controller = new PersonModelController();
    }

    @Test void testObjectCreation() {
        assertNotNull(controller);
    }
}
