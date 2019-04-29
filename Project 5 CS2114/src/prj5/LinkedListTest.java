/**
 * 
 */
package prj5;

import java.util.Comparator;
import student.TestCase;

/**
 * @author Tom Himler (thimler9)
 * @version 2019.4.20
 * 
 *          LinkedList test class
 */
public class LinkedListTest extends TestCase {
    private LinkedList<String> test;


    /**
     * Initializes the test field
     */
    public void setUp() {
        test = new LinkedList<String>();
    }


    /**
     * Tests the add method
     */
    public void testAdd() {
        assertEquals(test.getSize(), 0);
        test.add("Hi");
        assertEquals(test.getSize(), 1);
        assertEquals(test.get(0), "Hi");
    }


    /**
     * Tests the clone method
     */
    public void testClone() {
        test.add("A");
        test.add("B");
        test.add("C");
        test.add("D");
        LinkedList<String> test2 = test.clone();
        for (int index = 0; index < test.getSize(); index++) {
            assertEquals(test2.get(index), test.get(index));
        }
    }


    /**
     * Tests the get method
     */
    public void testGet() {
        String[] values = { "A", "B", "C" };
        test.add("A");
        test.add("B");
        test.add("C");
        assertEquals(test.get(0), "A");
        assertEquals(test.get(1), "B");
        assertEquals(test.get(2), "C");

        int i = -1;
        Exception exception = null;
        try {
            test.get(i);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

        int size = test.getSize();
        for (++i; i < size; i++) {
            assertEquals(values[i], test.get(i));
        }

        exception = null;
        try {
            test.get(i);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests the isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(test.isEmpty());
        test.add("0");
        assertFalse(test.isEmpty());
    }


    /**
     * Tests the remove(int) method
     */
    public void testRemoveInt() {
        String[] values = { "A", "B", "C" };

        test.add("A");
        assertEquals(test.getSize(), 1);
        assertEquals(test.remove(0), "A");
        assertEquals(test.getSize(), 0);
        test.add("B");
        test.add("A");
        assertEquals(test.getSize(), 2);
        assertEquals(test.remove(1), "A");
        assertEquals(test.getSize(), 1);
        test.remove(0);
        test.add("A");
        test.add("B");
        test.add("C");

        int i = test.getSize();
        int size = i;

        Exception exception = null;
        try {
            test.remove(i);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

        for (--i; i > -1; i--) {
            assertEquals(values[size - 1 - i], test.remove(0));
        }

        exception = null;
        try {
            test.remove(i);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests the remove(T) method
     */
    public void testRemoveT() {
        test.add("A");
        test.add("B");
        test.add("A");
        assertEquals(test.get(0), "A");
        assertEquals(test.getSize(), 3);
        assertTrue(test.remove("A"));
        assertEquals(test.getSize(), 2);
        assertEquals(test.get(0), "B");
        assertFalse(test.remove("C"));
    }


    /**
     * Tests the sort method
     */
    public void testSort() {
        LinkedList<Song> test3 = new LinkedList<Song>();
        test3.add(new Song("C", "B", 2019, "C", 5));
        test3.add(new Song("B", "C", 2019, "D", 5));
        test3.add(new Song("B", "B", 2018, "E", 5));
        test3.add(new Song("A", "B", 2014, "E", 5));
        Comparator<Song> comparator = test3.get(0).getCompareBySongTitle();
        test3.sort(comparator);
        assertEquals(test3.get(2).getSong(), "B");
    }
}
