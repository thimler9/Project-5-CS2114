/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author Tom Himler (thimler9)
 * @version 2019.4.20
 * 
 *          Tests the file reader class
 */
public class FileReaderTest extends TestCase {
    private FileReader test1; // test 1 FileReader
    private FileReader test2; // test 2 FileReader


    /**
     * Sets up the file reader test class
     */
    public void setUp() {
        test1 = new FileReader("MusicSurveyData.csv", "SongListTest1.csv");
        test2 = new FileReader("MusicSurveyData.csv", "SongList.csv");
    }


    /**
     * Tests the file reader using the first two files
     */
    public void test1() {
        assertNull(test1.getStudents());
        assertNotNull(test1.getSongs());
        assertEquals(test2.getSongs().getSize(), 59);
        assertEquals(test2.getStudents().getSize(), 209);

        test1 = new FileReader("MusicSurveyDataTest1.csv", "SongListTest1.csv");
        assertEquals(test1.getSongs().getSize(), 5);
        assertEquals(test1.getStudents().getSize(), 6);
    }


    /**
     * Tests the file reader using two different files
     */
    public void test2() {
        assertNull(test1.getStudents());
        assertNotNull(test1.getSongs());
        assertEquals(test2.getSongs().getSize(), 59);
        assertEquals(test2.getStudents().getSize(), 209);

        test1 = new FileReader("MusicSurveyData.csv", "SongList.csv");
        assertEquals(test1.getSongs().getSize(), 59);
        assertEquals(test1.getStudents().getSize(), 209);
    }


    /**
     * Tests the files reader using another two different files
     */
    public void test3() {
        assertNull(test1.getStudents());
        assertNotNull(test1.getSongs());
        assertEquals(test2.getSongs().getSize(), 59);
        assertEquals(test2.getStudents().getSize(), 209);

        test1 = new FileReader("MusicSurveyDataTest2.csv", "SongListTest2.csv");
        assertEquals(test1.getSongs().getSize(), 1);
        assertEquals(test1.getStudents().getSize(), 6);
    }


    /**
     * Tests if the input throws file not found exception
     */
    public void testNoFile() {
        systemOut().clearHistory();
        String none = "nonexistant.csv";
        test1 = new FileReader(none, none);
        String result = systemOut().getHistory();
        String goal =
            "nonexistantcsv no such file or directory"
                + "\nnonexistantcsv no such file or directory";
        assertFuzzyEquals(goal, result);
    }
}
