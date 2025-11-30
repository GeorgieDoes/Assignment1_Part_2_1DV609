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
        String name = "Anton";
        int income = 0;
        int age = 49;

        controller.setName(name);
        controller.setIncome(income);
        controller.setAge(age);

        assertEquals(name, controller.getName());
        assertEquals(income, controller.getIncome());
        assertEquals(age, controller.getAge());
    }

    @Test
    public void testControllerSetterAlt() {
        String name = "Oscar";
        int income = 1;
        int age = 119;

        controller.setName(name);
        controller.setIncome(income);
        controller.setAge(age);

        assertEquals(name, controller.getName());
        assertEquals(income, controller.getIncome());
        assertEquals(age, controller.getAge());
    }

    @Test
    public void testControllerSetterForWrongInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            controller.setName(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            controller.setName("");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            controller.setIncome(-5012);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            controller.setAge(-45);
        });
    }

    @Test
    public void testAgeValidationUpperBound() {
        assertThrows(IllegalArgumentException.class, () -> {
            controller.setAge(150);
        });
    }

    @Test
    public void testAgeValidationBound() {
        controller.setAge(130);
        assertEquals(130, controller.getAge());
    }
}
