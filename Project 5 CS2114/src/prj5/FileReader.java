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
     * default constructor
     * 
     * @param fileName
     *            name of file to import
     * @throws Exception
     *             if invalid data
     */
    public FileReader(String studentFileName, String songFileName)
        throws Exception {
        songs = extractSongs(songFileName);
        students = extractStudents(studentFileName);
    }


    /**
     * 
     * @param fileName
     *            file location
     * @return list of students
     * @throws Exception
     *             if the amount of entries doesn't correlate to amount of songs
     */
    private LinkedList<Student> extractStudents(String fileName)
        throws Exception {
        LinkedList<Student> result = new LinkedList<Student>();
        Scanner sc = new Scanner(new File(fileName));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String[] data = sc.nextLine().split(",");
            if (data.length != (5 + songs.size() * 2)) {
                throw new Exception(
                    "Invalid given data, improper amount of entries");
            }
            int index = Integer.valueOf(data[0]);
            String date = data[1];
            Major maj = Major.valueOf((data[2].replaceAll(" ", "_").toUpperCase()));
            Region reg = Region.valueOf(data[3].replaceAll(" ", "_").toUpperCase());
            Hobby hob = Hobby.valueOf(data[4].toUpperCase());
            Response[][] responses = new Response[songs.size()][2];
            for (int i = 0; i < responses.length * 2; i++) {
                try {
                    responses[i / 2][i % 2] = Response.valueOf(data[i + 5]);
                }
                catch (Exception e) {
                    responses[i / 2][i % 2] = Response.NEITHER;
                }
            }
            Student newEntry =
                new Student(index, date, maj, reg, hob, responses);
            result.add(newEntry);
        }
        return result;
    }


    /**
     * Parses through the data to return a linked list
     * of all of the songs
     * 
     * @param fileName
     *            name of input file
     * @return LinkedList with all the songs
     * @throws Exception
     *             through missing file exception
     */
    private LinkedList<Song> extractSongs(String fileName) throws Exception {

        LinkedList<Song> result = new LinkedList<Song>();
        Scanner sc = new Scanner(new File(fileName));
        sc.nextLine();

        while (sc.hasNextLine()) {

            String[] data = sc.nextLine().split(",");
            int index = 0;
            Song newSong =
                new Song(data[0], data[1], Integer.valueOf(data[2]), data[3],
                    index);
            result.add(newSong);
            index++;
        }
        return result;
    }


    /**
     * get amount of songs
     * 
     * @return number of songs
     */
    public int numOfSongs() {
        return songs.size();
    }

}
