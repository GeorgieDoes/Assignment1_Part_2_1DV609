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
    public void testPersonModelNameProperty() {
        person.SetName("Alice");
        assertEquals("Alice", person.GetName());
    }
}
