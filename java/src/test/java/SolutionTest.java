import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static final double DELTA = 1e-9;

    @Test
    void testWindowFillsThenEvicts() {
        Solution.MovingAverage ma = new Solution.MovingAverage(3);
        assertEquals(1.0,       ma.next(1),  DELTA);
        assertEquals(5.5,       ma.next(10), DELTA);
        assertEquals(14.0 / 3, ma.next(3),  DELTA);
        assertEquals(6.0,       ma.next(5),  DELTA);
        assertEquals(13.0 / 3, ma.next(5),  DELTA);
    }

    @Test
    void testWindowSizeOne() {
        Solution.MovingAverage ma = new Solution.MovingAverage(1);
        assertEquals(7.0,  ma.next(7),  DELTA);
        assertEquals(42.0, ma.next(42), DELTA);
    }

    @Test
    void testWindowNotYetFull() {
        Solution.MovingAverage ma = new Solution.MovingAverage(5);
        assertEquals(4.0, ma.next(4), DELTA);
        assertEquals(5.0, ma.next(6), DELTA);
    }

    @Test
    void testNegativeAndFractionalValues() {
        Solution.MovingAverage ma = new Solution.MovingAverage(2);
        assertEquals(-4.0, ma.next(-4.0), DELTA);
        assertEquals(-1.0, ma.next(2.0),  DELTA);
        assertEquals(2.5,  ma.next(3.0),  DELTA);
    }
}
