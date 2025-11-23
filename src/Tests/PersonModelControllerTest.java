package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Main.controller.PersonModelController;

public class PersonModelControllerTest {
    private PersonModelController controller;

    @BeforeEach
    public void setUp() {
        controller = new PersonModelController();
    }

    @Test
    public void testControllerCreation() {
        assertNotNull(controller);
    }

    @Test
    public void testControllerSetter() {
        controller.setName("Anton");
        controller.setIncome(0);
        controller.setAge(49);
    }
}
