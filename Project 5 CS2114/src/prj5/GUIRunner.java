/**
 * 
 */
package prj5;

/**
 * @author Tom Himler (thimler9)
 * @version 4.30.2019
 * 
 * Creates the window
 */
public class GUIRunner {
    
    /**
     * Main method, creates a sample window from the given files
     * 
     * @param args not used
     */
    public static void main(String[] args)
    {
        Calculator windowTest = 
            new Calculator("MusicSurveyData.csv", "SongList.csv");
        GUI testGUI = new GUI(windowTest);
    }
}
