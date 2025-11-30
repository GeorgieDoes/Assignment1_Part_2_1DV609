package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import Main.view.DisplayView;

public class DisplayViewTest {
  private DisplayView displayView;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outContent));
    this.displayView = new DisplayView();
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  public void testDisplayViewIsNotNull() {
    assertNotNull(this.displayView);
  }

  @Test
  public void testWelcomeMessage() {
      displayView.printWelcomeMessage();
      assertEquals("Welcome to the Tax Calculator" + System.lineSeparator(), outContent.toString());
  }

  @Test
  public void testGetInput() {
      String testInput = "Test User Input";
      // Simulate user input by setting System.in
      System.setIn(new java.io.ByteArrayInputStream(testInput.getBytes()));
      
      // Re-initialize DisplayView to pick up the new System.in
      displayView = new DisplayView();
      
      String userInput = displayView.getInput();
      assertEquals(testInput, userInput);
  }

  @Test
  public void closeGetInput() 
  {
      // Just ensure no exceptions are thrown when calling getInput
      System.setIn(new java.io.ByteArrayInputStream("".getBytes()));
      displayView = new DisplayView();
      assertDoesNotThrow(() -> {
          displayView.getInput();
      });
  }

  @Test
  public void testInstructions() {
    displayView.printInstructions();
    String expectedOutput = "Please enter your name, income, and age to calculate your taxes." + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString());
  }
}