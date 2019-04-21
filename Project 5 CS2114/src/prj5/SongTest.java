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


    public void setUp() {
        song = new Song("Happy", "Mike", 1980, "Rock", 0);
        song1 = new Song("Sad", "John", 1982, "Pop", 1);
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
