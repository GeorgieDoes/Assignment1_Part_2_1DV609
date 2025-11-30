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
      String testInput = "30" + System.lineSeparator();
      System.setIn(new java.io.ByteArrayInputStream(testInput.getBytes()));
      displayView = new DisplayView();
      
      int age = displayView.getAge();
      assertEquals(30, age);
  }

  @Test
  public void testGetAgeWithInvalidAndEdgeInputsMOCK() {
      // Input sequence: 
      // 1. "0.5" (Invalid integer)
      // 2. "-5" (Negative, invalid)
      // 3. "0" (Zero, invalid)
      // 4. "25" (Valid)
      String input = "0.5" + System.lineSeparator() + "-5" + System.lineSeparator() + "0" + System.lineSeparator() + "25" + System.lineSeparator();
      System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
      displayView = new DisplayView();

      // Should skip all invalid inputs and return 25
      int age = displayView.getAge();
      assertEquals(25, age, "Should return 25 after skipping invalid inputs");
  }

  @Test
  public void testGetAgeWithNonIntegerInputMOCK() {
      // Input sequence:
      // 1. "abc" (Non-integer, invalid)
      // 2. "40" (Valid)
      String input = "abc" + System.lineSeparator() + "40" + System.lineSeparator();
      System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
      displayView = new DisplayView();

      // Should skip the non-integer input and return 40
      int age = displayView.getAge();
      assertEquals(40, age, "Should return 40 after skipping non-integer input");
  }

  @Test
  public void testGetName() {
      String testInput = "John Doe" + System.lineSeparator();
      System.setIn(new java.io.ByteArrayInputStream(testInput.getBytes()));
      displayView = new DisplayView();

      String name = displayView.getName();
      assertEquals("John Doe", name);
  }

  @Test
  public void testGetNameWithDifferentInvalidMOCK() {
      // Input sequence:
      // 1. "" (Empty string, invalid)
      // 2. "   " (Whitespace only, invalid)
      // 3. "Alice" (Valid)
      // 4. Number input "123" (invalid for name, but our method will accept it as a string)
      String input = "" + System.lineSeparator() + "   " + System.lineSeparator() + "Alice" + System.lineSeparator();
      System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
      displayView = new DisplayView();

      String name = displayView.getName();
      assertEquals("Alice", name, "Should return 'Alice' after skipping invalid name inputs");
  }

}