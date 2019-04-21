/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * @author Tom
 * @autor Pranav Sharma
 */
public class Song {
    private String name;
    private String artist;
    private int releaseYear;
    private String genre;
    private int index;
    // 4 x 4 1st is type of enum, 2nd is the following:
    //0 - heard 1 - answered
    //1 - liked 2 - answered


    public Song(
        String name,
        String artist,
        int year,
        String genre,
        int index) {
        this.name = name;
        this.artist = artist;
        releaseYear = year;
        this.genre = genre;
        this.index = index;
    }


    public String getArtist() {
        return artist;
    }


    public String getSong() {
        return name;
    }


    public int getYear() {
        return releaseYear;
    }


    public String getGenre() {
        return genre;
    }


    public int getIndex() {
        return index;
    }

    public Comparator<Song> getCompareByArtist() {
        return new CompareByArtist();
    }


    public Comparator<Song> getCompareByDate() {
        return new CompareByDate();
    }


    public Comparator<Song> getCompareByGenre() {
        return new CompareByGenre();
    }


    public Comparator<Song> getCompareBySongTitle() {
        return new CompareBySongTitle();
    }


    private class CompareByArtist implements Comparator<Song> {

        /**
         * This method compares the songs alphabetically.
         * 
         * @param song1
         *            represents the first song.
         * @param song2
         *            represents the second song.
         */
        @Override
        public int compare(Song song1, Song song2) {
            return song1.getArtist().compareToIgnoreCase(song2.getArtist());
        }
    }


    private class CompareByDate implements Comparator<Song> {
        /**
         * This method compares the songs by date in ascending order.
         * 
         * @param song1
         *            represents the first song.
         * @param song2
         *            represents the second song.
         */
        @Override
        public int compare(Song song1, Song song2) {
            int date1 = song1.getYear();
            int date2 = song2.getYear();

            return date1 - date2;
        }
    }


    private class CompareByGenre implements Comparator<Song> {

        /**
         * This method compares the songs by genre alphabetically.
         * 
         * @param song1
         *            represents the first song.
         * @param song2
         *            represents the second song.
         */
        @Override
        public int compare(Song song1, Song song2) {
            return song1.getGenre().compareToIgnoreCase(song2.getGenre());
        }

    }


    private class CompareBySongTitle implements Comparator<Song> {

        /**
         * This method compares the songs by title alphabetically.
         * 
         * @param song1
         *            represents the first song.
         * @param song2
         *            represents the second song.
         */
        @Override
        public int compare(Song song1, Song song2) {
            return song1.getSong().compareToIgnoreCase(song2.getSong());
        }

    }
}
