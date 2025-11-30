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

  @Test
  public void testGetAge() {
      String testInput = "30";
      System.setIn(new java.io.ByteArrayInputStream(testInput.getBytes()));
      displayView = new DisplayView();
      
      int age = displayView.getAge();
      assertEquals(30, age);
  }

  @Test
  public void testGetAgeWithInvalidAndEdgeInputs() {
      // Input sequence: 
      // 1. "0.5" (Invalid integer, should be handled/ignored)
      // 2. "-5" (Valid integer, should be returned)
      // 3. "0" (Valid integer, should be returned)
      String input = "0.5" + System.lineSeparator() + "-5" + System.lineSeparator() + "0" + System.lineSeparator();
      System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
      displayView = new DisplayView();

      // First call should skip "0.5" and return -5
      int age1 = displayView.getAge();
      assertEquals(-5, age1, "Should return -5 after skipping invalid 0.5");

      // Second call should return 0
      int age2 = displayView.getAge();
      assertEquals(0, age2, "Should return 0");
  }
}

