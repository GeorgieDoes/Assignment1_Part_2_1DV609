package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Main.view.DisplayView;

public class DisplayViewTest {
  private DisplayView displayView;

  @BeforeEach
  public void setUp() {
    this.displayView = new DisplayView();
  }

  @Test
  public void testDisplayViewIsNotNull() {
    assertNotNull(this.displayView);
  }
}
