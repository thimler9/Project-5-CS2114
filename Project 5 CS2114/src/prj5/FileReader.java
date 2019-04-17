/**
 * 
 */
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Tom
 * @author Eriq Taing (eriq12)
 *
 */
public class FileReader {
    private LinkedList<Song> songs;
    private LinkedList<Student> students;
    /**
     * amount of songs
     */
    public static final int NUM_OF_SONGS = 59;

    /**
     * default constructor
     * 
     * @param fileName
     *            name of file to import
     */
    public FileReader(String studentFileName, String songFileName) {

    }
    
    private LinkedList<Student> extractStudents(String fileName) throws Exception{
        LinkedList<Student> result = new LinkedList<Student>();
        Scanner sc = new Scanner(new File(fileName));
        while(sc.hasNextLine()){
            String[] data = sc.nextLine().split(",");
            if(data.length != (5 + NUM_OF_SONGS * 2)){
                throw new Exception("Invalid given data, improper amount of entries");
            }
            int index = Integer.valueOf(data[0]);
            String date = data[1];
            Major maj = Major.valueOf((data[2].replaceAll(" ", "_")));
            Region reg = Region.valueOf(data[3].toUpperCase());
            Hobby hob = Hobby.valueOf(data[4].toUpperCase());
            boolean[][] responses = new boolean[NUM_OF_SONGS][2];
            for(int i = 0; i < responses.length * 2; i++){
                responses[i/2][i%2] = Boolean.valueOf(data[i+5]); 
            }
            Student newEntry = new Student(index, date, maj, reg, hob, responses);
            result.add(newEntry);
        }
        return result;
    }

}
