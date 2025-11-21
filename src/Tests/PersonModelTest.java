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
    }

    @Test
    public void testPersonModelNewNameProperties() {
        person.SetName("George");
        assertEquals("George", person.GetName());
    }
}
