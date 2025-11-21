package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Main.model.PersonModel;

public class PersonModelTest {
    @Test
    public void testPersonModelExists() {
        PersonModel person = new PersonModel();
        assertNotNull(person);
    }
}
