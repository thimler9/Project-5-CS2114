/**
 * 
 */
package prj5;

import java.util.Comparator;
import student.TestCase;

/**
 * @author Aditya
 *
 */
public class SongTest extends TestCase {

    private Song song;
    private Song song1;


    /**
     * This sets up for rest of tests
     */
    public void setUp() {
        song = new Song("Happy", "Mike", 1980, "Rock", 0);
        song1 = new Song("Sad", "John", 1982, "Pop", 1);
    }


    /**
     * checks if getter works
     */
    public void testGetArtist() {
        assertEquals("Mike", song.getArtist());
    }


    /**
     * checks if getter works
     */
    public void testGetSong() {
        assertEquals("Happy", song.getSong());
    }


    /**
     * checks if getter works
     */
    public void testGetYear() {
        assertEquals(1980, song.getYear());
    }


    /**
     * checks if getter works
     */
    public void testGetGenre() {
        assertEquals("Rock", song.getGenre());
    }


    /**
     * checks if getter works
     */
    public void testGetIndex() {
        assertEquals(0, song.getIndex());
    }


    /**
     * checks if Comparator works
     */
    public void testGetCompareByArtist() {
        Comparator<Song> comparor = song.getCompareByArtist();
        assertEquals(3, comparor.compare(song, song1));
    }


    /**
     * checks if comparator works
     */
    public void testGetCompareByDate() {
        Comparator<Song> comparor = song.getCompareByDate();
        assertEquals(-2, comparor.compare(song, song1));
    }


    /**
     * checks if comparator works
     */
    public void testGetCompareByGenre() {
        Comparator<Song> comparor = song.getCompareByGenre();
        assertEquals(2, comparor.compare(song, song1));
    }


    /**
     * checks if comparator works
     */
    public void testGetCompareBySongTitle() {
        Comparator<Song> comparor = song.getCompareBySongTitle();
        assertEquals(-11, comparor.compare(song, song1));
    }
}
