/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author Aditya
 *
 */
public class SongTest extends TestCase {

    private Song song;
    private Song song1;
    private int[][] hobby;
    private int[][] major;
    private int[][] state;


    public void setUp() {
        hobby = new int[2][2];
        major = new int[2][2];
        state = new int[2][4];
        song = new Song("Happy", "Mike", 1980, "Rock", 0, hobby, major, state);
        song1 = new Song("Sad", "John", 1982, "Pop", 1, hobby, major, state);
    }


    public void testGetArtist() {
        assertEquals("Mike", song.getArtist());
    }


    public void testGetSong() {
        assertEquals("Happy", song.getSong());
    }


    public void testGetYear() {
        assertEquals(1980, song.getYear());
    }


    public void testGetGenre() {
        assertEquals("Rock", song.getGenre());
    }


    public void testGetIndex() {
        assertEquals(0, song.getIndex());
    }


    public void testGetHobbyInfo() {
        assertEquals(hobby, song.getHobbyInfo());
    }


    public void testGetMajorInfo() {
        assertEquals(major, song.getMajorInfo());
    }


    public void testGetStateInfo() {
        assertEquals(state, song.getStateInfo());
    }
    
    public void testGetCompareByArtist() {
        assertEquals(3, song.getCompareByArtist(song, song1));
    }
    
    public void testGetCompareByDate() {
        assertEquals(-2, song.getCompareByDate(song, song1));
    }
    
    public void testGetCompareByGenre() {
        assertEquals(2, song.getCompareByGenre(song, song1));
    }
    
    public void testGetCompareBySongTitle() {
        assertEquals(-11, song.getCompareBySongTitle(song, song1));
    }
}
