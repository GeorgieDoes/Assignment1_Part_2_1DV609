import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.assertEquals;

public class AppTest {
    private App app;

    @BeforeAll
    private void setup() {
        this.app = new App();
    }

    @Test
    public void TestForInitialInput() {
        assertEquals(1, 2, app.input(1, 2));
    }
}
