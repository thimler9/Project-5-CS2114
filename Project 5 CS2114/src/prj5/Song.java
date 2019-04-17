/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * @author Tom
 *
 */
public class Song {
    private String name;
    private String artist;
    private int releaseYear;
    private String genre;
    private int index;


    public Song() {

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
            int date1 = Integer.valueOf(song1.getYear());
            int date2 = Integer.valueOf(song2.getYear());

            return date1 - date2;
        }
    }


    private class SortByGenre implements Comparator<Song> {

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


    private class SortBySongTitle implements Comparator<Song> {

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
