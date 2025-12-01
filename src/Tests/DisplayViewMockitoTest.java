package Tests;

import Main.view.DisplayView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DisplayViewMockitoTest {

    @Mock
    private Scanner scanner;

    @Test
    public void testGetName() {
        // Setup
        when(scanner.hasNextLine()).thenReturn(true);
        when(scanner.nextLine()).thenReturn("Mockito User");

        DisplayView view = new DisplayView(scanner);
        
        // Execute
        String name = view.getName();

        // Verify
        assertEquals("Mockito User", name);
        verify(scanner, times(1)).nextLine();
    }

    @Test
    public void testGetAge() {
        // Setup
        when(scanner.hasNextInt()).thenReturn(true);
        when(scanner.nextInt()).thenReturn(30);
        // Note: getAge calls nextLine() after nextInt() to consume newline
        
        DisplayView view = new DisplayView(scanner);

        // Execute
        int age = view.getAge();

        // Verify
        assertEquals(30, age);
        verify(scanner, times(1)).nextInt();
        verify(scanner, times(1)).nextLine();
    }

    @Test
    public void testGetIncome() {
        // Setup
        when(scanner.hasNextInt()).thenReturn(true);
        when(scanner.nextInt()).thenReturn(50000);
        
        DisplayView view = new DisplayView(scanner);

        // Execute
        int income = view.getIncome();

        // Verify
        assertEquals(50000, income);
        verify(scanner, times(1)).nextInt();
        verify(scanner, times(1)).nextLine();
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

        when(scanner.hasNextInt()).thenReturn(false, true);
        when(scanner.hasNext()).thenReturn(true);
        when(scanner.next()).thenReturn("abc");
        when(scanner.nextInt()).thenReturn(25);

        DisplayView view = new DisplayView(scanner);

        int age = view.getAge();

        assertEquals(25, age);
        verify(scanner, times(1)).next(); // consumed "abc"
        verify(scanner, times(1)).nextInt(); // consumed 25
    }
}
