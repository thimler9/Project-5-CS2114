/**
 * 
 */
package prj5;

/**
 * @author Tom
 * @author Eriq Taing (eriq12)
 *
 */
public class FileReader {
    private LinkedList<Song> songs;
    private LinkedList<Student> students;


    /**
     * default constructor
     * 
     * @param fileName
     *            name of file to import
     */
    public FileReader(String fileName) {

    }
    
    private LinkedList<Student> extractStudents(){
        LinkedList<Student> result = new LinkedList<Student>();
        //TODO parsing and implementation
        return result;
    }


    /**
     * separates a line into multiple sections
     * 
     * @param original
     *            original list of entries separated by ", "
     * @return a string array with each entry
     */
    private String[] partition(String original, int entries) {
        return original.split(",", entries);
    }

    /**
     * matches index with each
     * 
     * @return the string of the majors
     */
    public Major[] getMajors() {
        return majors;
    }


    /**
     * 
     * @return regions
     */
    public Region[] getRegions() {
        return regions;
    }


    public String[] getArtists() {
        return artists;
    }


    public Hobby[] getHobbies() {
        return hobbies;
    }
    
    */
}
