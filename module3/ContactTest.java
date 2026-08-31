import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class ContactTest {

  private Contact c;
  private Contact c2;
  private Contact c3;

  @BeforeEach
  void setUp() {
    c = new Contact("Ada Lovelace", "+1 617 555 0101");
    c2 = new Contact("Grace Hopper", "555-0000");
    c3 = new Contact("Alan Turing", "555-0001");
  }

  @Test
  void constructor_setsNameCorrectly() {
    // Contact c = new Contact("Ada Lovelace", "+1 617 555 0101");
    assertEquals("Ada Lovelace", c.getName());
  }

  @Test
  void constructor_setsPhoneCorrectly() {
    // Contact c = new Contact("Ada Lovelace", "+1 617 555 0101");
    assertEquals("+1 617 555 0101", c.getPhone());
  }

  @Test
  void getName_returnsExactString_notTransformed() {
    // Contact c = new Contact("Grace Hopper", "555-0000");
    assertEquals("Grace Hopper", c2.getName());
  }

  @Test
  void toString_containsName() {
    // Contact c = new Contact("Alan Turing", "555-0001");
    assertTrue(c3.toString().contains("Alan Turing"));
  }

  @Test
  void toString_containsPhone() {
    // Contact c = new Contact("Alan Turing", "555-0001");
    assertTrue(c3.toString().contains("555-0001"));
  }
}
