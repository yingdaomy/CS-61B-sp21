package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    /** Adds a few things to the Deque, checking if the isEmpty and size method are correct,
     *  finally printing the results.
     * */
    public void addIsEmptySizeTest() {
        ArrayDeque<String> lld1 = new ArrayDeque<>();
        assertTrue("A newly initialized LLdeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());
        lld1.addLast("middle");
        assertEquals(2, lld1.size());
        lld1.addLast("back");
        assertEquals(3, lld1.size());
        System.out.println("Printing out deque: ");
        lld1.printDeque();
    }

    @Test
    /** Adds an item, then remove an item, and ensures that dll is empty afterward. */
    public void addRemoveTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());
        lld1.addFirst(10);
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());
        lld1.removeFirst();
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /** Testing remove from an empty deque. */
    public void removeEmptyTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        assertNull(lld1.removeFirst());
        assertNull(lld1.removeLast());
    }

    @Test
    /** Check if you can creat different types deque. */
    public void multipleTypeTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        ArrayDeque<Double> lld2 = new ArrayDeque<>();
        ArrayDeque<String> lld3 = new ArrayDeque<>();
        ArrayDeque<Boolean> lld4 = new ArrayDeque<>();

        lld1.addFirst(1);
        lld2.addFirst(1.0);
        lld3.addFirst("Hello");
        lld4.addFirst(true);

        assertEquals(1, (int) lld1.removeFirst());
        assertEquals(1.0, (double) lld2.removeFirst(), 0.01);
        assertEquals("Hello", lld3.removeFirst());
        assertEquals(true, lld4.removeFirst());
    }
}
