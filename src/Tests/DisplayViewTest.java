package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.stage.Stage;
import Main.view.DisplayView;

public class DisplayViewTest {
  private DisplayView displayView;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeAll
  public static void initJfx() {
      try {
          Platform.startup(() -> {});
      } catch (IllegalStateException e) {
          // Toolkit already initialized
      }
  }

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
  public void testStartMethodJavafx() throws InterruptedException {
      CountDownLatch latch = new CountDownLatch(1);
      Platform.runLater(() -> {
          try {
              displayView.start(new Stage());
          } catch (Exception e) {
              fail("start method threw an exception: " + e.getMessage());
          } finally {
              latch.countDown();
          }
      });
      assertTrue(latch.await(5, TimeUnit.SECONDS), "JavaFX start method timed out");
  }

  @Test
  public void testWindowOpens() throws InterruptedException {
      CountDownLatch latch = new CountDownLatch(1);
      // Use a container to hold any exception thrown on the JavaFX thread
      final Throwable[] threadException = new Throwable[1];

      Platform.runLater(() -> {
          try {
              Stage stage = new Stage();
              displayView.start(stage);
              assertTrue(stage.isShowing(), "Stage should be showing after start()");
              stage.close();
          } catch (Throwable t) {
              threadException[0] = t;
          } finally {
              latch.countDown();
          }
      });
      
      assertTrue(latch.await(5, TimeUnit.SECONDS), "JavaFX test timed out");
      
      // If an exception occurred on the JavaFX thread, re-throw it here to fail the test
      if (threadException[0] != null) {
          if (threadException[0] instanceof AssertionError) {
              throw (AssertionError) threadException[0];
          } else {
              throw new RuntimeException(threadException[0]);
          }
      }
  }
}
