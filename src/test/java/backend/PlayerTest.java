package backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import java.util.Arrays;

public class PlayerTest{

  private String getHolesList(Hole[] holes){
    int[] list = new int[holes.length];
    for(int i = 0; i<holes.length;i++){
      list[i]=(holes[i].getKorgools());
    }
    return Arrays.toString(list);
  }

  @Test
  public void actTest(){
    Player p = new Player();

    p.act(3);
    int[] list = new int[]{9,9,9,1,10,10,10,10,10};
    assertEquals(Arrays.toString(list),getHolesList(p.getHoles()));

    p.act(0);
    list = new int[]{1,10,10,2,11,11,11,11,11};
    assertEquals(Arrays.toString(list),getHolesList(p.getHoles()));

    p.act(0);
    list = new int[]{1,10,10,2,11,11,11,11,11};
    assertEquals(Arrays.toString(list),getHolesList(p.getHoles()));

    p.act(7);
    list = new int[]{1,10,10,2,11,11,11,1,12};
    assertEquals(Arrays.toString(list),getHolesList(p.getHoles()));

    p.act(6);
    list = new int[]{1,10,10,2,11,11,1,2,13};
    assertEquals(Arrays.toString(list),getHolesList(p.getHoles()));
  }

  @Test
  public void hasTuzOptionTest(){
      Player p = new Player();
      p.act(8);// 9 9 9 9 9 9 9 9 1
      p.act(7);// 9 9 9 9 9 9 9 1 2
      p.act(0);// 1 x x x x x x 2 3
      assertEquals(false,p.hasTuzOption(8));//last hole can't be tuz


               // 0 1 2 3 4 5 6 7 8
      p.act(5);// 1 x x x x 1 e 3 4
      p.act(6);// 1 x x x x 1 1 4 5
      p.act(7);// 1 x x x x 1 1 1 6
      p.act(4);// 1 x x x 1 2 2 2 7
      p.act(5);// 1 x x x 1 1 3 2 7
      assertEquals(false,p.hasTuzOption(6));

               // 0 1 2 3 4 5 6 7 8
      p.act(2);// 1 x 1 x 2 2 4 3 8
      p.act(7);// 1 x 1 x 2 2 4 1 9
      p.act(6);// 1 x x x 2 2 1 2 x
      p.act(4);// 1 x x x 1 3 1 2 x
      assertEquals(false,p.hasTuzOption(5));
  }

}
