/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author Tom Himler (thimler9)
 * @version 2019.4.20
 *          Tests the calculator class
 */
public class CalculatorTest extends TestCase {

    private Calculator calc; // Test calc
    private LinkedList<int[][]> hobbPerc; // Hobby percentages
    private LinkedList<int[][]> regionPerc; // Region percentages
    private LinkedList<int[][]> majorPerc; // Major percentages


    /**
     * Sets up the test class by initializing the field variables
     */
    public void setUp() {
        calc = new Calculator("MusicSurveyData.csv", "SongList.csv");
        hobbPerc = calc.getHobbyPercent();
        regionPerc = calc.getRegionPercent();
        majorPerc = calc.getMajorPercent();
        calc.getFileReader();
    }


    /**
     * Tests the calc with the first input files
     */
    public void testCalculator1() {
        assertEquals(hobbPerc.getSize(), 59);
        assertEquals(regionPerc.getSize(), 59);
        assertEquals(majorPerc.getSize(), 59);

        for (int i = 0; i < hobbPerc.getSize(); i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    assertTrue(hobbPerc.get(i)[j][k] <= 100);
                    assertTrue(regionPerc.get(i)[j][k] <= 100);
                    assertTrue(majorPerc.get(i)[j][k] <= 100);
                }
            }
        }
    }


    /**
     * Tests the calc with the second two input files
     */
    public void testCalculator2() {
        calc = new Calculator("MusicSurveyDataTest1.csv", "SongListTest1.csv");
        hobbPerc = calc.getHobbyPercent();
        regionPerc = calc.getRegionPercent();
        majorPerc = calc.getMajorPercent();
        calc.getFileReader();
        assertEquals(hobbPerc.getSize(), 5);
        assertEquals(regionPerc.getSize(), 5);
        assertEquals(majorPerc.getSize(), 5);

        for (int i = 0; i < hobbPerc.getSize(); i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    assertTrue(hobbPerc.get(i)[j][k] <= 100);
                    assertTrue(regionPerc.get(i)[j][k] <= 100);
                    assertTrue(majorPerc.get(i)[j][k] <= 100);
                }
            }
        }
    }


    /**
     * Tests the calc with the third two input files
     */
    public void testCalculator3() {
        calc = new Calculator("MusicSurveyDataTest2.csv", "SongListTest2.csv");
        hobbPerc = calc.getHobbyPercent();
        regionPerc = calc.getRegionPercent();
        majorPerc = calc.getMajorPercent();
        calc.getFileReader();
        assertEquals(hobbPerc.getSize(), 1);
        assertEquals(regionPerc.getSize(), 1);
        assertEquals(majorPerc.getSize(), 1);

        for (int i = 0; i < hobbPerc.getSize(); i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    assertTrue(hobbPerc.get(i)[j][k] <= 100);
                    assertTrue(regionPerc.get(i)[j][k] <= 100);
                    assertTrue(majorPerc.get(i)[j][k] <= 100);
                }
            }
        }
    }


    /**
     * Tests the calc with the fourth two input files
     */
    public void testCalculator4() {
        calc =
            new Calculator("MusicSurveyDataNoGenreRepeats.csv",
                "SongListNoGenreRepeats.csv");
        hobbPerc = calc.getHobbyPercent();
        regionPerc = calc.getRegionPercent();
        majorPerc = calc.getMajorPercent();
        calc.getFileReader();
        assertEquals(hobbPerc.getSize(), 17);
        assertEquals(regionPerc.getSize(), 17);
        assertEquals(majorPerc.getSize(), 17);

        for (int i = 0; i < hobbPerc.getSize(); i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    assertTrue(hobbPerc.get(i)[j][k] <= 100);
                    assertTrue(regionPerc.get(i)[j][k] <= 100);
                    assertTrue(majorPerc.get(i)[j][k] <= 100);
                }
            }
        }
    }
}
