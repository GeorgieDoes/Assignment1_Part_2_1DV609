import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AppTest {
    private App app;

    @BeforeAll
    private void setup() {
        
    }

    @Test
    public void TestAppObjectCreation() {
        App app = new App(1, 2);
        assertNotNull("Object should be non empty", app);
    }
}
