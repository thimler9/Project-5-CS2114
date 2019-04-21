/**
 * 
 */
package prj5;

import java.io.File;
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
     * default constructor
     * 
     * @param fileName
     *            name of file to import
     */
    public FileReader(String studentFileName, String songFileName) {
        try {
            songs = extractSongs(songFileName);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            students = extractStudents(studentFileName);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Parses through the students file and puts them in a 
     * LinkedList
     * 
     * Note: Students will be null if the number of songs in the song
     * file is different than the number of songs assumed in the student
     * file.
     * 
     * @param fileName name of student file
     * @return a linked list of the students
     * @throws Exception through missing file exception
     */
    @SuppressWarnings("resource")
    private LinkedList<Student> extractStudents(String fileName) 
        throws Exception {
        
        LinkedList<Student> result = new LinkedList<Student>();
        Scanner sc = new Scanner(new File(fileName));
        sc.nextLine(); //Skipping the headers line
        
        while(sc.hasNextLine()) {
            
            String[] data = sc.nextLine().split(",");
            int index = Integer.valueOf(data[0]);
            String date = data[1];
            Major maj = null;
            Region reg = null;
            Hobby hob = null;
            Response[][] responses = new Response[numOfSongs()][2];
            
            for (int i = 0; i < numOfSongs(); i++) {
                for (int j = 0; j < 2; j++) {
                    responses[i][j] = Response.NEITHER;
                }
            }
            
            //Assigning the maj, reg, and hob values
            if (data.length > 2) {
                if (!data[2].equals("")) {
                    maj = Major.valueOf(data[2].replaceAll(" ", "_").toUpperCase());
                }
                if (!data[3].equals("")) {
                    reg = Region.valueOf(data[3].replaceAll(" ",  "_")
                        .replaceAll("[()]", "").toUpperCase());
                }
                if (!data[4].equals("")) {
                    hob = Hobby.valueOf(data[4].toUpperCase());
                }
            }
            
            //The true or falses being put into the response array
            for(int i = 5; i < data.length; i++) {
                if (data[i].equals("Yes")) {
                    responses[(i - 5) / 2][i % 2] = Response.YES;
                }
                else if (data[i].equals("No")) {
                    responses[(i - 5) / 2][i % 2] = Response.NO;
                }
            }
            
            Student newEntry = new Student(index, date, maj, 
                reg, hob, responses);
            result.add(newEntry);
        }
        return result;
    }
    
    /**
     * Parses through the data to return a linked list
     * of all of the songs
     * 
     * @param fileName name of input file
     * @return LinkedList with all the songs
     * @throws Exception through missing file exception
     */
    @SuppressWarnings("resource")
    private LinkedList<Song> extractSongs(String fileName) 
        throws Exception {
        
        LinkedList<Song> result = new LinkedList<Song>();
        Scanner sc = new Scanner(new File(fileName));
        sc.nextLine();
        
        while (sc.hasNextLine()) {
            
            String[] data = sc.nextLine().split(",");
            int index = 0;
            Song newSong = new Song(data[0], data[1], 
                Integer.valueOf(data[2]), data[3], index);
            result.add(newSong);
            index++;
        }
        return result;
    }
    
    /**
     * Gets the extracted songs
     * 
     * @return songs
     */
    public LinkedList<Song> getSongs()
    {
        return songs;
    }
    
    public int numOfSongs(){
        return songs.size();
    }
    
    /**
     * Gets the extracted students
     * 
     * @return students
     */
    public LinkedList<Student> getStudents()
    {
        return students;
    }
}
