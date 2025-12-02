package Tests;

import Main.view.DisplayView;
import Main.view.InputProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DisplayViewMockitoTest {

    @Mock
    private InputProvider inputProvider;

    @Test
    public void testGetName() {
        // Setup
        when(inputProvider.hasNextLine()).thenReturn(true);
        when(inputProvider.nextLine()).thenReturn("Mockito User");

        DisplayView view = new DisplayView(inputProvider);
        
        // Execute
        String name = view.getName();

        // Verify
        assertEquals("Mockito User", name);
        verify(inputProvider, times(1)).nextLine();
    }

    @Test
    public void testGetAge() {
        // Setup
        when(inputProvider.hasNextInt()).thenReturn(true);
        when(inputProvider.nextInt()).thenReturn(30);
        // Note: getAge calls nextLine() after nextInt() to consume newline
        
        DisplayView view = new DisplayView(inputProvider);

        // Execute
        int age = view.getAge();

        // Verify
        assertEquals(30, age);
        verify(inputProvider, times(1)).nextInt();
        verify(inputProvider, times(1)).nextLine();
    }

    @Test
    public void testGetIncome() {
        // Setup
        when(inputProvider.hasNextInt()).thenReturn(true);
        when(inputProvider.nextInt()).thenReturn(50000);
        
        DisplayView view = new DisplayView(inputProvider);

        // Execute
        int income = view.getIncome();

        // Verify
        assertEquals(50000, income);
        verify(inputProvider, times(1)).nextInt();
        verify(inputProvider, times(1)).nextLine();
    }
    
    @Test
    public void testGetAgeWithInvalidInput() {
        // Simulate: "abc" (invalid), then "25" (valid)
        // 1. hasNextInt() -> false (for "abc")
        // 2. hasNext() -> true (to consume "abc")
        // 3. next() -> "abc"
        // 4. nextLine() -> "" (consume newline after "abc")
        // 5. hasNextInt() -> true (for "25")
        // 6. nextInt() -> 25
        // 7. nextLine() -> "" (consume newline after 25)

        when(inputProvider.hasNextInt()).thenReturn(false, true);
        when(inputProvider.hasNext()).thenReturn(true);
        when(inputProvider.next()).thenReturn("abc");
        when(inputProvider.nextInt()).thenReturn(25);

        DisplayView view = new DisplayView(inputProvider);

        int age = view.getAge();

        assertEquals(25, age);
        verify(inputProvider, times(1)).next(); // consumed "abc"
        verify(inputProvider, times(1)).nextInt(); // consumed 25
    }
}
