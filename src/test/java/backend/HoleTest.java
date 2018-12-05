package backend;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class HoleTest{
    private Hole h;

    @Before
    public void setUp(){
        h = new Hole();
    }

    @Test
    public void setKorgoolsToZeroTest1(){
        h.setKorgoolsToZero();
        assertEquals(0,h.getKorgools());
    }
    @Test
    public void setKorgoolsToZeroTest2(){
        for(int i = 0; i<100;i++)h.korgoolsPlusOne();
        h.setKorgoolsToZero();
        assertEquals(0,h.getKorgools());
    }
    @Test
    public void setKorgoolsToZeroTest3(){
        for(int i = 0; i<1000;i++)h.korgoolsPlusOne();
        h.setKorgoolsToZero();
        assertEquals(0,h.getKorgools());
    }
    @Test
    public void KorgoolsPlusOneTest1(){
        h.korgoolsPlusOne();
        assertEquals(10,h.getKorgools());
    }

    @Test
    public void KorgoolsPlusOneTest2(){
        for(int i = 0; i<10;i++)h.korgoolsPlusOne();
        assertEquals(19,h.getKorgools());
    }
    @Test
    public void KorgoolsPlusOneTest3(){
        for(int i = 0; i<100;i++)h.korgoolsPlusOne();
        assertEquals(109,h.getKorgools());
    }
    @Test
    public void KorgoolsPlusOneTest4(){
        for(int i = 0; i<10000;i++)h.korgoolsPlusOne();
        assertEquals(10009,h.getKorgools());
    }

    @Test
    public void isTuzzableTestShouldReturnTrue(){
          h.setKorgoolsToZero();
          for(int i = 0; i<3;i++)h.korgoolsPlusOne();
          assertEquals(true,h.isTuzzable());
    }
    @Test
    public void isTuzzableTestShouldReturnFalse1(){
          h.setKorgoolsToZero();
          for(int i = 0; i<3;i++)h.korgoolsPlusOne();
          h.setTuz();//HERE
          assertEquals(false,h.isTuzzable());
    }
    @Test
    public void isTuzzableTestShouldReturnFalse2(){
          h.setKorgoolsToZero();
          for(int i = 0; i<4;i++)h.korgoolsPlusOne();
          assertEquals(false,h.isTuzzable());
    }
    @Test
    public void isTuzzableTestShouldReturnFalse3(){
          h.setKorgoolsToZero();
          for(int i = 0; i<4;i++)h.korgoolsPlusOne();
          h.setTuz();
          assertEquals(false,h.isTuzzable());;
    }
}
