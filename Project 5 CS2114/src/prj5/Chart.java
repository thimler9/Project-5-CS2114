/**
 * 
 */
package prj5;

import java.awt.Color;
import java.util.Random;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

/**
 * @author Tom
 *
 */
public class Chart {
    private final int xSpace = 300;
    private final int starterXInc = 150;

    private final int ySpace = 150;
    private final int starterYInc = 125;
    private final int yArtistSpacer = 15;
    private final int yBlackBarSpace = 35;

    private Shape barLikes;

    private Shape barHeard;

    private TextShape title;
    private TextShape artist;

    private final int barSpacer = 15;

    private Shape blackBar;

    private int[] h;
    private int[] l;

    private Window window;


    /**
     * creates a new Chart
     * 
     * @param song
     *            is the song we are looking at
     * @param xPos
     *            is the x position
     * @param yPos
     *            is the y position
     * @param songNum
     *            is the song position
     * @param window
     *            is a new window
     * @param input
     *            is the input being used
     * 
     */
    public Chart(
        Song song,
        int xPos,
        int yPos,
        int songNum,
        Window window,
        Input input) {
        this.window = window;

        title = new TextShape(xPos * xSpace - starterXInc, yPos * ySpace
            - starterYInc, song.getSong());
        int moveXt = title.getWidth() / 2;
        title.setBackgroundColor(Color.WHITE);
        window.addShape(title);
        title.move(-moveXt, 0);

        artist = new TextShape(xPos * xSpace - starterXInc, yPos * ySpace
            - starterYInc + yArtistSpacer, "by " + song.getArtist());
        int moveXa = artist.getWidth() / 2;
        artist.setBackgroundColor(Color.WHITE);
        window.addShape(artist);
        artist.move(-moveXa, 0);

        int blackBarX = xPos * xSpace - starterXInc;
        int blackBarY = yPos * ySpace - starterYInc + yBlackBarSpace;
        blackBar = new Shape(blackBarX, blackBarY, 5, 60, Color.BLACK);
        window.addShape(blackBar);
        window.moveToFront(blackBar);

        for (int i = 0; i <= 3; i++) {
            Random r = new Random();
            int c1 = r.nextInt(255);
            int c2 = r.nextInt(255);
            int c3 = r.nextInt(255);
            int barLx = xPos * xSpace - starterXInc + 5;
            int barLy = yPos * ySpace - starterYInc + yBlackBarSpace + barSpacer
                * i;
            barLikes = new Shape(barLx, barLy, l[i], 15, new Color(c1, c2, c3));
            window.addShape(barLikes);
        }

        for (int i = 0; i <= 3; i++) {
            Random r = new Random();
            int c1 = r.nextInt(255);
            int c2 = r.nextInt(255);
            int c3 = r.nextInt(255);
            int barHx = xPos * xSpace - starterXInc - h[i];
            int barHy = yPos * ySpace - starterYInc + yBlackBarSpace + barSpacer
                * i;
            barHeard = new Shape(barHx, barHy, h[i], 15, new Color(c2, c2, c3));
            window.addShape(barHeard);
        }

    }


    /**
     * removes then entire chart 
     */
    public void removeAll() {

        window.removeAllShapes();
    }
}
