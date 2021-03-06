/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author Aditya
 *
 */
public class StudentTest extends TestCase {

    private Student student;


    public void setUp() {
        Response[][] twice = new Response[10][10];
        twice[5][5] = Response.YES;
        student = new Student(0, "04/20/19", Major.MATH_OR_CMDA,
            Region.NORTHEAST, Hobby.MUSIC, twice);
    }
    
    public void testGetIndex() {
        assertEquals(0, student.getIndex());
    }
    
    
    public void testGetDate() {
        assertEquals("04/20/19", student.getDate());
    }
    
    public void testGetHobby() {
        assertEquals(Hobby.MUSIC, student.getHobby());
    }
    
    
    public void testGetMajor() {
        assertEquals(Major.MATH_OR_CMDA, student.getMajor());
    }
    
    public void testGetRegion() {
        assertEquals(Region.NORTHEAST, student.getRegion());
    }
    
    
    public void testGetResponse() {
        assertEquals(Response.YES, student.getResponse(5, 5));
    }
    
}
