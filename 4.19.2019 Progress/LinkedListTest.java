/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author Tom
 *
 */
public class LinkedListTest extends TestCase
{
    private LinkedList<String> test;
    
    /**
     * Initializes the test field
     */
    public void setUp()
    {
        test = new LinkedList<String>();
    }
    
    /**
     * Tests the add method
     */
    public void testAdd()
    {
        assertEquals(test.getSize(), 0);
        test.add("Hi");
        assertEquals(test.getSize(), 1);
        assertEquals(test.get(0), "Hi");
    }
    
    /**
     * Tests the clone method
     */
    public void testClone()
    {
        test.add("A");
        test.add("B");
        test.add("C");
        test.add("D");
        LinkedList<String> test2 = test.clone();
        for (int index = 0; index < test.getSize(); index++)
        {
            assertEquals(test2.get(index), test.get(index));
        }
    }
    
    /**
     * Tests the get method
     */
    public void testGet()
    {
        test.add("A");
        test.add("B");
        test.add("C");
        assertEquals(test.get(0), "A");
        assertEquals(test.get(1), "B");
        assertEquals(test.get(2), "C");
        
        Exception exception = null;
        try
        {
            test.get(-1);
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
        
        exception = null;
        try
        {
            test.get(4);
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Tests the isEmpty method
     */
    public void testIsEmpty()
    {
        assertTrue(test.isEmpty());
        test.add("0");
        assertFalse(test.isEmpty());
    }
    
    /**
     * Tests the remove(int) method
     */
    public void testRemoveInt()
    {
        test.add("A");
        assertEquals(test.getSize(), 1);
        assertEquals(test.remove(0), "A");
        assertEquals(test.getSize(), 0);
        test.add("B");
        test.add("A");
        assertEquals(test.getSize(), 2);
        assertEquals(test.remove(1), "A");
        assertEquals(test.getSize(), 1);
        
        Exception exception = null;
        try
        {
            test.get(-1);
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
        
        exception = null;
        try
        {
            test.get(4);
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);        
    }
    
    /**
     * Tests the remove(T) method
     */
    public void testRemoveT()
    {
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
    
    public void testSort() {
        Comparator<String> comp = new CompareStrings();
        test.add("C");
        test.add("B");
        test.add("A");
        LinkedList<String> goal = new LinkedList<String>();
        goal.add("A");
        goal.add("B");
        goal.add("C");
        assertFalse(equal(test, goal));
        test.sort(comp);
        assertTrue(equal(test, goal));
    }


    private boolean equal(LinkedList<String> o1, LinkedList<String> o2){
        if (o1==null || o2==null){
            return false;
        }
        if(o1.getSize() == o2.getSize()){
            for(int i = 0; i < o1.getSize(); i++){
                if(!o1.get(i).equals(o2.get(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    private class CompareStrings implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.compareToIgnoreCase(o2);
        }
    }
}
