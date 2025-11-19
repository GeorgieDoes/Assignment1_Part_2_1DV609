import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    public void inputTest() {
        App app = new App();
        assertEquals("Hello, World!", app.input("Hello, world!"));
    }
}
