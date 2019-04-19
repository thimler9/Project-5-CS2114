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
    public int numOfSongs;

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
     * @param fileName name of student file
     * @return a linked list of the students
     * @throws Exception through missing file exception
     */
    @SuppressWarnings("resource")
    private LinkedList<Student> extractStudents(String fileName) 
        throws Exception {
        
        LinkedList<Student> result = new LinkedList<Student>();
        Scanner sc = new Scanner(new File(fileName));
        Scanner counter = new Scanner(new File(fileName));
        sc.nextLine(); //Skipping the headers line
        int numberOfLines = 0;
        
        //Counts the number of lines
        while(counter.hasNextLine())
        {
            numberOfLines++;
            sc.nextLine();
        }
        
        //Checks to see if the two files match each other
        if (numberOfLines - 1 != numOfSongs)
        {
            throw new Exception("Differing number of songs from the file"
                + " and the survey");
        }
        
        while(sc.hasNextLine()) {
            
            String[] data = sc.nextLine().split(",");
            int index = Integer.valueOf(data[0]);
            String date = data[1];
            Major maj = null;
            Region reg = null;
            Hobby hob = null;
            boolean[][] responses = new boolean[numOfSongs][2];
            
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
                    responses[(i - 5) / 2][i % 2] = true;
                }
                else{
                    responses[(i - 5) / 2][i % 2] = false;
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
        numOfSongs = result.getSize();
        return result;
    }
}
