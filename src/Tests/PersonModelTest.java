package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Main.model.PersonModel;

public class PersonModelTest {
    private PersonModel person;

    @BeforeEach
    public void setUp() {
        person = new PersonModel();
    }
    
    @Test
    public void testPersonModelExists() {
        assertNotNull(person);
    }

    @Test
    public void testPersonModelProperties() {
        // Test setting
        person.setName("Alice");
        person.setIncome(50000);
        person.setAge(30);

        // Test getting
        assertEquals("Alice", person.getName());
        assertEquals(50000, person.getIncome());
        assertEquals(30, person.getAge());

        // Test setting new values
        person.setName("George");
        person.setIncome(60000);
        person.setAge(40);

        // Test getting new values
        assertEquals("George", person.getName());
        assertEquals(60000, person.getIncome());
        assertEquals(40, person.getAge());
    }

    @Test
    public void TestConstructionSetting() {
        PersonModel newPerson = new PersonModel("Patrik", 7000, 48);
        assertEquals("Patrik", newPerson.getName());
        assertEquals(7000, newPerson.getIncome());
        assertEquals(48, newPerson.getAge());

        PersonModel newPersonTwo = new PersonModel("Gustav", 14000, 27);
        assertEquals("Gustav", newPersonTwo.getName());
        assertEquals(14000, newPersonTwo.getIncome());
        assertEquals(27, newPersonTwo.getAge());
    }

    @Test
    public void TestIllegalSetting() {
        // Setting negative income
        assertThrows(IllegalArgumentException.class, () -> {
            person.setIncome(-5000);
        });

        // Setting overly large income
        assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-23);
        });

        // Setting empty name
        assertThrows(IllegalArgumentException.class, () -> {
            person.setName(null);
        });
    }
}
