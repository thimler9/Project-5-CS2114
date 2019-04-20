/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author Tom
 *
 */
public class FileReaderTest extends TestCase
{
    FileReader test1;
    FileReader test2;
    
    public void setUp()
    {
        test1 = new FileReader("MusicSurveyData.csv", "SongListTest1.csv");
        test2 = new FileReader("MusicSurveyData.csv", "SongList.csv");
    }
    
    public void test()
    {
        assertNull(test1.getStudents());
        assertNotNull(test1.getSongs());
        assertEquals(test2.getSongs().getSize(), 59);
        assertEquals(test2.getStudents().getSize(), 209);
        
        test1 = new FileReader("MusicSurveyDataTest1.csv", "SongListTest1.csv");
        assertEquals(test1.getSongs().getSize(), 5);
        assertEquals(test1.getStudents().getSize(), 6);
    }
}
