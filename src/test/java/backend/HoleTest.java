package backend;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HoleTest{

    @Test
    public void setKorgoolsToZeroTest(){
        Hole h1 = new Hole();
        Hole h2 = new Hole();
        Hole h3 = new Hole();
        Hole h4 = new Hole();

        h1.setKorgoolsToZero();
        assertEquals(0,h1.getKorgools());

        for(int i = 0; i<10;i++)h2.korgoolsPlusOne();
        h2.setKorgoolsToZero();
        assertEquals(0,h2.getKorgools());

        for(int i = 0; i<100;i++)h3.korgoolsPlusOne();
        h3.setKorgoolsToZero();
        assertEquals(0,h3.getKorgools());

        for(int i = 0; i<1000;i++)h4.korgoolsPlusOne();
        h4.setKorgoolsToZero();
        assertEquals(0,h4.getKorgools());
    }

    @Test
    public void KorgoolsPlusOneTest(){
        Hole h1 = new Hole();
        Hole h2 = new Hole();
        Hole h3 = new Hole();
        Hole h4 = new Hole();

        h1.korgoolsPlusOne();
        assertEquals(10,h1.getKorgools());

        for(int i = 0; i<10;i++)h2.korgoolsPlusOne();
        assertEquals(19,h2.getKorgools());

        for(int i = 0; i<100;i++)h3.korgoolsPlusOne();
        assertEquals(109,h3.getKorgools());

        for(int i = 0; i<10000;i++)h4.korgoolsPlusOne();
        assertEquals(10009,h4.getKorgools());
  	}

    @Test
    public void isTuzzableTest(){
          Hole h1 = new Hole();
          Hole h2 = new Hole();
          Hole h3 = new Hole();
          Hole h4 = new Hole();


          //positive test
          h1.setKorgoolsToZero();
          for(int i = 0; i<3;i++)h1.korgoolsPlusOne();
          assertEquals(true,h1.isTuzzable());

          //negative tests
          h2.setKorgoolsToZero();
          for(int i = 0; i<3;i++)h2.korgoolsPlusOne();
          h2.setTuz();//HERE
          assertEquals(false,h2.isTuzzable());

          h3.setKorgoolsToZero();
          for(int i = 0; i<4;i++)h3.korgoolsPlusOne();//HERE
          assertEquals(false,h3.isTuzzable());

          h4.setKorgoolsToZero();
          for(int i = 0; i<4;i++)h4.korgoolsPlusOne();//HERE AND
          h4.setTuz();                                //HERE
          assertEquals(false,h4.isTuzzable());

    }
}
