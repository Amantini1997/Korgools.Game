import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class KazanTest{

    @Test
    public void increaseKorgoolsByTest(){
        Kazan k1 = new Kazan();
        Kazan k2 = new Kazan();
        Kazan k3 = new Kazan();
        Kazan k4 = new Kazan();

        k1.increaseKorgoolsBy(0);
        assertEquals(0,k1.getKorgools());
        k2.increaseKorgoolsBy(91);
        assertEquals(91,k2.getKorgools());
        k3.increaseKorgoolsBy(1000);
        assertEquals(1000,k3.getKorgools());
        k4.increaseKorgoolsBy(-10000);
        assertEquals(-10000,k4.getKorgools());
    }

    @Test
    public void isWinningShouldReturnTrue(){
        Kazan k1 = new Kazan();
        Kazan k2 = new Kazan();
        Kazan k3 = new Kazan();
        Kazan k4 = new Kazan();

        k1.increaseKorgoolsBy(82);
        assertEquals(true,k1.isWinning());
        k2.increaseKorgoolsBy(100);
        assertEquals(true,k2.isWinning());
        k3.increaseKorgoolsBy(234234);
        assertEquals(true,k3.isWinning());
        k4.increaseKorgoolsBy(122);
        assertEquals(true,k4.isWinning());
  	}

    @Test
    public void isWinningShouldReturnFalse(){
        Kazan k1 = new Kazan();
        Kazan k2 = new Kazan();
        Kazan k3 = new Kazan();
        Kazan k4 = new Kazan();

        k1.increaseKorgoolsBy(81);
        assertEquals(false,k1.isWinning());
        k2.increaseKorgoolsBy(80);
        assertEquals(false,k2.isWinning());
        k3.increaseKorgoolsBy(-3746);
        assertEquals(false,k3.isWinning());
        k4.increaseKorgoolsBy(12);
        assertEquals(false,k4.isWinning());
  	}
}
