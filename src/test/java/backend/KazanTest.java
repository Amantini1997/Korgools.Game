package backend;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class KazanTest {
    private Kazan k;

    @Before
    public void setUp() {
        k = new Kazan();
    }

    @Test
    public void increaseKorgoolsByTest1() {
        k.increaseKorgoolsBy(0);
        assertEquals(0, k.getKorgools());
    }

    @Test
    public void increaseKorgoolsByTest2() {
        k.increaseKorgoolsBy(91);
        assertEquals(91, k.getKorgools());
    }

    @Test
    public void increaseKorgoolsByTest3() {
        k.increaseKorgoolsBy(1000);
        assertEquals(1000, k.getKorgools());
    }

    @Test
    public void increaseKorgoolsByTest4() {
        k.increaseKorgoolsBy(-10000);
        assertEquals(-10000, k.getKorgools());
    }

    @Test
    public void isWinningShouldReturnTrue1() {
        k.increaseKorgoolsBy(82);
        assertEquals(true, k.hasWon());
    }

    @Test
    public void isWinningShouldReturnTrue2() {
        k.increaseKorgoolsBy(100);
        assertEquals(true, k.hasWon());
    }

    @Test
    public void isWinningShouldReturnTrue3() {
        k.increaseKorgoolsBy(234234);
        assertEquals(true, k.hasWon());
    }

    @Test
    public void isWinningShouldReturnTrue4() {
        k.increaseKorgoolsBy(122);
        assertEquals(true, k.hasWon());
    }

    @Test
    public void isWinningShouldReturnFalse1() {
        k.increaseKorgoolsBy(81);
        assertEquals(false, k.hasWon());
    }

    @Test
    public void isWinningShouldReturnFalse2() {
        k.increaseKorgoolsBy(80);
        assertEquals(false, k.hasWon());
    }

    @Test
    public void isWinningShouldReturnFalse3() {
        k.increaseKorgoolsBy(-3746);
        assertEquals(false, k.hasWon());
    }

    @Test
    public void isWinningShouldReturnFalse4() {
        k.increaseKorgoolsBy(12);
        assertEquals(false, k.hasWon());
    }
}
