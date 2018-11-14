package frontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import java.awt.Color;
public class HoleTest{

  @Test
  public void testHoleConstructorWithoutListener()
  {
    Hole hole = new Hole(1,9,null);
    assertEquals(hole.getIndex(),1);
    assertEquals(hole.getNumberOfKorgools(),9);
    assertEquals(hole.getText(),"9");
  }

  @Test
  public void testTuzColoring()
  {
    Hole hole = new Hole(1,9,null);
    hole.makeTuz();
    assertEquals(hole.getBackground(),Color.RED);
  }

  @Test
  public void testTuzColoringFalse()
  {
    Hole hole = new Hole(1,9,null);
    hole.makeTuz();
    assertNotEquals(hole.getBackground(),null);
  }

  @Test
  public void testHoleUpdate()
  {
    Hole hole = new Hole(1,9,null);
    hole.update(3);
    assertEquals(hole.getText(),"3");
  }

  @Test
  public void testHoleUpdateNotEquals()
  {
    Hole hole = new Hole(1,9,null);
    hole.update(3);
    assertNotEquals(hole.getText(),"9");
  }
}
