import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HoleTest{

    @Test
    public void setKorgoolsToZeroTest(){
        Hole h1 = new Hole(true,0);
        Hole h2 = new Hole(true,9);
        Hole h3 = new Hole(false,-5);
        Hole h4 = new Hole(false,1000);

        h1.setKorgoolsToZero();
        assertEquals(0,h1.getKorgools());
        h2.setKorgoolsToZero();
        assertEquals(0,h2.getKorgools());
        h3.setKorgoolsToZero();
        assertEquals(0,h3.getKorgools());
        h4.setKorgoolsToZero();
        assertEquals(0,h4.getKorgools());
    }

    @Test
    public void KorgoolsPlusOneTest(){
        Hole h1 = new Hole(true,0);
        Hole h2 = new Hole(true,-1);
        Hole h3 = new Hole(false,-11);
        Hole h4 = new Hole(false,1000);

        h1.KorgoolsPlusOne();
        assertEquals(1,h1.getKorgools());
        h2.KorgoolsPlusOne();
        assertEquals(-0,h2.getKorgools());
        h3.KorgoolsPlusOne();
        assertEquals(-10,h3.getKorgools());
        h4.KorgoolsPlusOne();
        assertEquals(1001,h4.getKorgools());
  	}
}
