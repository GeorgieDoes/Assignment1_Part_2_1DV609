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
        person.SetName("Alice");
        person.SetIncome(50000);
        person.SetAge(30);

        // Test getting
        assertEquals("Alice", person.GetName());
        assertEquals(50000, person.GetIncome());
        assertEquals(30, person.GetAge());

        // Test setting new values
        person.SetName("George");
        person.SetIncome(60000);
        person.SetAge(40);

        // Test getting new values
        assertEquals("George", person.GetName());
        assertEquals(60000, person.GetIncome());
        assertEquals(40, person.GetAge());
    }

    @Test
    public void TestConstructionSetting() {
        PersonModel newPerson = new PersonModel("Patrik", 7000, 48);
        assertEquals("Patrik", newPerson.GetName());
        assertEquals(7000, newPerson.GetIncome());
        assertEquals(48, newPerson.GetAge());

        PersonModel newPersonTwo = new PersonModel("Gustav", 14000, 27);
        assertEquals("Gustav", newPersonTwo.GetName());
        assertEquals(14000, newPersonTwo.GetIncome());
        assertEquals(27, newPersonTwo.GetAge());
    }
}
