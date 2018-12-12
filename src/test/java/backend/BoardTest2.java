package backend;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BoardTest2 {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                    {null, "9,9,9,9,9,9,9,9,9,0,-1\n" + "9,9,9,9,9,9,9,9,9,0,-1\nw"},
                    {
                        new int[] {6},
                        "10,10,10,10,10,0,9,9,9,0,-1\n" + "9,9,9,9,9,9,1,10,10,10,-1\nb"
                    },
                    {
                        new int[] {0, 0, 1, 0, 2, 0, 8},
                        "2,15,12,12,11,11,11,11,11,0,-1\n" + "2,2,1,12,12,12,12,12,1,0,-1\nb"
                    },
                    {
                        new int[] {0, 0, 0},
                        "1,10,10,10,10,10,10,10,10,0,-1\n" + "0,11,10,10,10,10,10,10,10,0,-1\nb"
                    },
                    {
                        new int[] {0, 0, 0, 0, 0},
                        "0,11,10,10,10,10,10,10,10,0,-1\n" + "0,11,10,10,10,10,10,10,10,0,-1\nw"
                    },
                    {
                        new int[] {4, 4, 5, 4, 6, 4, 0, 2},
                        "13,12,1,3,2,15,12,12,11,13,-1\n" + "2,12,12,2,0,2,2,13,13,10,4\nw"
                    },
                    {
                        new int[] {4, 4, 5, 4, 6, 4, 0, 2, 3, 5},
                        "14,13,1,3,2,1,13,13,12,15,-1\n" + "3,13,13,2,0,3,3,14,14,10,4\nw"
                    },
                    {
                        new int[] {4, 4, 5, 4, 6, 4, 0, 2, 3},
                        "13,12,1,3,2,15,12,12,11,14,-1\n" + "2,12,12,1,0,2,2,13,13,10,4\nb"
                    },
                    {
                        new int[] {8, 0, 1, 6, 1, 8},
                        "1,11,11,11,11,11,1,2,1,10,-1\n" + "2,2,13,12,12,12,12,12,3,12,-1\nw"
                    }
                });
    }

    public String output;
    public int[] moves;
    private Board board;

    public void BoardTest2(int[] moves, String output) {
        board = new Board();
        moves = moves;
        output = output;
    }

    @Test
    public void test() {
        if (moves != null) {
            for (int n : moves) {
                board.makeAMove(n);
            }
        }
        assertEquals(board.toString(), output);
    }
}
