package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PersonModelTest {
    @Test
    public void testPersonModelExists() {
        try {
            Class.forName("Main.model.Personmodel");
        } catch (ClassNotFoundException e) { 
            fail("Class personModel does not exist.");
        }
    }
}
