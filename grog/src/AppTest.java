import org.junit.Test;

public class AppTest {
    @Test
    public void inputTest() {
        App app = new App();
        assertEquals("Hello, World!", app.input("Hello, World!"));
    }
}
