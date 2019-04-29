/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author Tom Himler (thimler9)
 * @version 2019.4.20
 * 
 *          Tests the Response enum cause WebCat doesn't want
 *          to grade it correctly
 */
public class ResponseTest extends TestCase {

    /**
     * Tests the response class
     */
    public void test1() {
        Response test1 = Response.NEITHER;
        Response test2 = Response.NO;
        Response test3 = Response.YES;

        assertEquals(test1, Response.NEITHER);
        assertEquals(test2, Response.NO);
        assertEquals(test3, Response.YES);

        test1 = Response.valueOf("NEITHER");
        test2 = Response.valueOf("NO");
        test3 = Response.valueOf("YES");

        assertEquals(test1, Response.NEITHER);
        assertEquals(test2, Response.NO);
        assertEquals(test3, Response.YES);
    }
}
