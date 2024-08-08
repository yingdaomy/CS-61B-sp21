package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    /** A practice JUnit test as a warmup */
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> A = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        for (int i = 1; i <= 6; i += 1) {
            A.addLast(i);
            B.addLast(i);
        }
        for(int i = 1; i <= 3; i += 1) {
            assertEquals(A.removeLast(), B.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1 && L.size() > 0 && B.size() > 0) {
                int item = L.getLast();
                int itemB = B.getLast();
                assertEquals(item, itemB);
            } else if (operationNumber == 2 && L.size() > 0 && B.size() > 0) {
                int item = L.removeLast();
                int itemB = B.removeLast();
                assertEquals(item, itemB);
            }
        }
    }
}
