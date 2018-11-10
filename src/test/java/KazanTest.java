import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class KazanTest{

    @Test
    public void increaseKorgoolsByTest(){
        Kazan k1 = new Kazan(true,0);
        Kazan k2 = new Kazan(true,9);
        Kazan k3 = new Kazan(false,5);
        Kazan k4 = new Kazan(false,1000);

        k1.increaseKorgoolsBy(0);
        assertEquals(0,k1.getKorgools());
        k2.increaseKorgoolsBy(91);
        assertEquals(100,k2.getKorgools());
        k3.increaseKorgoolsBy(1000);
        assertEquals(1005,k3.getKorgools());
        k4.increaseKorgoolsBy(1000000);
        assertEquals(1001000,k4.getKorgools());
    }

    @Test
    public void isWinningShouldReturnTrue(){
        Kazan k1 = new Kazan(true,82);
        Kazan k2 = new Kazan(true,83);
        Kazan k3 = new Kazan(false,19283);
        Kazan k4 = new Kazan(false,1000);

        assertEquals(true,k1.isWinning());
        assertEquals(true,k2.isWinning());
        assertEquals(true,k3.isWinning());
        assertEquals(true,k4.isWinning());
  	}

    @Test
    public void isWinningShouldReturnFalse(){
        Kazan k1 = new Kazan(true,81);
        Kazan k2 = new Kazan(true,80);
        Kazan k3 = new Kazan(false,-324222);
        Kazan k4 = new Kazan(false,12);

        assertEquals(false,k1.isWinning());
        assertEquals(false,k2.isWinning());
        assertEquals(false,k3.isWinning());
        assertEquals(false,k4.isWinning());
  	}
}

