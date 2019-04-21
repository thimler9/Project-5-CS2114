**
 * 
 */
package prj5;

import java.awt.Color;
import java.util.Random;
import CS2114.Shape;
import CS2114.SquareShape;
import CS2114.TextShape;
import CS2114.Window;

/**
 * @author Tom
 *
 */
public class Chart {
    private final int width = 300;
    private final int beginwidth = 150;

    private final int lengthY = 150;
    private final int beginLengthY = 125;
    private final int yMargin = 15;
    private final int yBar = 35;

    private TextShape title;
    private TextShape artist;

    private final int space = 15;

    private Shape blackBar;

    private Input input;

    private int[][] heard;
    private int[][] likes;

    private int[] hear;
    private int[] like;

    private int songs;

    private Window window;


    public Chart(
        Song song,
        int X,
        int Y,
        int songs,
        Window window,
        Input input) {
        this.window = window;
        this.input = input;

        //heard =
        // likes ==
        //h = 
        //l =
        
        this.songs = songs;

        title = new TextShape(X * width - beginwidth, Y * lengthY
            - beginLengthY, song.getSong());
        int move = title.getWidth() / 2;
        title.setBackgroundColor(Color.WHITE);
        window.addShape(title);
        title.move(move, 0);

        artist = new TextShape(X * width - beginwidth, Y * lengthY
            - beginLengthY + yMargin, "by " + song.getArtist());
        int moves = artist.getWidth() / 2;
        artist.setBackgroundColor(Color.WHITE);
        window.addShape(artist);
        artist.move(moves, 0);

        int Xblack = X * width - beginwidth;
        int Yblack = Y * lengthY - beginLengthY + yBar;
        blackBar = new Shape(Xblack, Yblack, 5, 60, Color.BLACK);
        window.addShape(blackBar);
        window.moveToFront(blackBar);

        for (int i = 0; i <= 3; i++) {
            Random r = new Random();
            int c1 = r.nextInt(255);
            int c2 = r.nextInt(255);
            int c3 = r.nextInt(255);
            int barLx = X * width - beginwidth + 5;
            int barLy = Y * lengthY - beginLengthY + yBar
                + space * i;
            Shape bars = new Shape(barLx, barLy, like[i], 15, new Color(c1, c2,
                c3));
            window.addShape(bars);
        }

        for (int i = 0; i <= 3; i++) {
            Random r = new Random();
            int c1 = r.nextInt(255);
            int c2 = r.nextInt(255);
            int c3 = r.nextInt(255);
            int barHx = X * width - beginwidth - hear[i];
            int barHy = Y * lengthY - beginLengthY + yBar
                + space * i;
            Shape bars = new Shape(barHx, barHy, hear[i], 15, new Color(c2, c2,
                c3));
            window.addShape(bars);
        }
    }


    public void removeAll() {
        window.removeAllShapes();
    }
}
