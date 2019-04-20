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
        boolean[][] twice = new boolean[10][10];
        twice[5][5] = true;
        student = new Student(0, "04/20/19", Major.MATH_OR_CMDA,
            Region.NORTHEAST_US, Hobby.MUSIC, twice);
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
        assertEquals(Region.NORTHEAST_US, student.getRegion());
    }
    
    
    public void testGetResponse() {
        assertEquals(true, student.getResponse(5, 5));
    }
    
}
