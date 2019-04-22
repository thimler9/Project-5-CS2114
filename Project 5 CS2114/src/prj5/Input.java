/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * @author Tom
 * @author Eriq Taing (eriq12)
 * @version 4/20/2019
 */
public class Input {

    /**
     * main method where files are read and things are made
     * 
     * @param args
     */
    public static void main(String[] args) {
        Calculator test = new Calculator(args[0], args[1]);
        FileReader reader = test.getFileReader();
        LinkedList<Song> songs = reader.getSongs().clone();
        LinkedList<int[][]> hobbPerc = test.getHobbyPercent();

        
        Comparator<Song> genreCompare = songs.get(0).getCompareByGenre();
        songs.sort(genreCompare);
        test.updateCalc(songs);
        hobbPerc = test.getHobbyPercent();

        for (int i = 0; i < songs.getSize(); i++) {
            Song s = songs.get(i);
            System.out.println("song title " + s.getSong());
            System.out.println("song artist " + s.getArtist());
            System.out.println("song genre " + s.getGenre());
            System.out.println("song year " + String.valueOf(s.getYear()));
            System.out.println("heard");
            int index = s.getIndex();
            System.out.println("reading"
                + String.valueOf(hobbPerc.get(index)[0][0]) + " art"
                + String.valueOf(hobbPerc.get(index)[1][0]) + " sports"
                + String.valueOf(hobbPerc.get(index)[2][0]) + " music"
                + String.valueOf(hobbPerc.get(index)[3][0]));
            System.out.println("likes");
            System.out.println("reading"
                + String.valueOf(hobbPerc.get(index)[0][1]) + " art"
                + String.valueOf(hobbPerc.get(index)[1][1]) + " sports"
                + String.valueOf(hobbPerc.get(index)[2][1]) + " music"
                + String.valueOf(hobbPerc.get(index)[3][1]));
            System.out.println("");
        }

        Comparator<Song> nameCompare = songs.get(0).getCompareBySongTitle();
        songs.sort(nameCompare);
        test.updateCalc(songs);
        hobbPerc = test.getHobbyPercent();

        for (int i = 0; i < songs.getSize(); i++) {
            Song s = songs.get(i);
            System.out.println("song title " + songs.get(i).getSong());
            System.out.println("song artist " + songs.get(i).getArtist());
            System.out.println("song genre " + songs.get(i).getGenre());
            System.out.println("song year "
                + String.valueOf(songs.get(i).getYear()));
            System.out.println("heard");
            int index = s.getIndex();
            System.out.println("reading"
                + String.valueOf(hobbPerc.get(index)[0][0]) + " art"
                + String.valueOf(hobbPerc.get(index)[1][0]) + " sports"
                + String.valueOf(hobbPerc.get(index)[2][0]) + " music"
                + String.valueOf(hobbPerc.get(index)[3][0]));
            System.out.println("likes");
            System.out.println("reading"
                + String.valueOf(hobbPerc.get(index)[0][1]) + " art"
                + String.valueOf(hobbPerc.get(index)[1][1]) + " sports"
                + String.valueOf(hobbPerc.get(index)[2][1]) + " music"
                + String.valueOf(hobbPerc.get(index)[3][1]));
            System.out.println("");
            }
        
    }
}
