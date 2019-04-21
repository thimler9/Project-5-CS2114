/**
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
public class Chart 
{   
    private final int xSpacer = 300;
    private final int starterXInc = 150;

    private final int ySpacer = 150;
    private final int starterYInc = 125;
    private final int yArtistSpacer = 15;
    private final int yBlackBarSpace = 35;

    private Shape bar1Likes;
    private Shape bar2Likes;
    private Shape bar3Likes;
    private Shape bar4Likes;

    private Shape bar1Heard;
    private Shape bar2Heard;
    private Shape bar3Heard;
    private Shape bar4Heard;
    
    private TextShape title;
    private TextShape artist;

    private final int barSpacer = 15;

    private Shape blackBar;

    private Input input;

    private int[][] heard;
    private int[][] likes;
    
    private int[] h;
    private int[] l;

    private int songPos;
    
    private Window window;


    public Chart(
        Song song,
        int xpos,
        int ypos,
        int songPos,
        Window window,
        Input input) {
        this.window = window;
        this.input = input;
        h = song.getHeardPerc();
        l = song.getLikedPerc();
        
        /*System.out.println(song.getTitle());
        System.out.println("Heard percent 1:" + h[0]);
        System.out.println("Heard percent 2:" + h[1]);
        System.out.println("Heard percent 3:" + h[2]);
        System.out.println("Heard percent 4:" + h[3]);
        System.out.println("");*/

        this.songPos = songPos;

        heard = input.getHeard();
        likes = input.getLiked();

        /*
         * System.out.println(likes[0][0]);
         * System.out.println(likes[0][1]);
         * System.out.println(likes[0][2]);
         * System.out.println(likes[0][3]);
         */
        
        /*System.out.println(h[0]);
        System.out.println(h[1]);
        System.out.println(h[2]);
        System.out.println(h[3]);
        System.out.println(l[0]);
        System.out.println(l[1]);
        System.out.println(l[2]);
        System.out.println(l[3]);*/

        title = new TextShape(xpos * xSpacer - starterXInc, ypos
            * ySpacer - starterYInc, song.getSong());
        int moveXt = title.getWidth() / 2;
        title.setBackgroundColor(Color.WHITE);
        window.addShape(title);
        title.move(-moveXt, 0);

        artist = new TextShape(xpos * xSpacer - starterXInc, ypos
            * ySpacer - starterYInc + yArtistSpacer, "by " + song.getArtist());
        int moveXa = artist.getWidth() / 2;
        artist.setBackgroundColor(Color.WHITE);
        window.addShape(artist);
        artist.move(-moveXa, 0);

        int blackBarX = xpos * xSpacer - starterXInc;
        int blackBarY = ypos * ySpacer - starterYInc + yBlackBarSpace;
        blackBar = new Shape(blackBarX, blackBarY, 5, 60, Color.BLACK);
        window.addShape(blackBar);
        window.moveToFront(blackBar);
        
        for (int i = 0; i <= 3; i++) {
            Random r = new Random();
            int c1 = r.nextInt(255);
            int c2 = r.nextInt(255);
            int c3 = r.nextInt(255);
            int barLx = xpos * xSpacer - starterXInc + 5;
            int barLy = ypos * ySpacer - starterYInc + yBlackBarSpace + barSpacer * i;
            bar1Likes = new Shape(barLx, barLy, l[i], 15,
                new Color(c1, c2, c3));
            window.addShape(bar1Likes);
        }

        /*int bar1Lx = xpos * xSpacer - starterXInc + 5;
        int bar1Ly = ypos * ySpacer - starterYInc + yBlackBarSpace;
        bar1Likes = new Shape(bar1Lx, bar1Ly, l[0], 15,
            Color.MAGENTA);
        window.addShape(bar1Likes);

        int bar2Lx = xpos * xSpacer - starterXInc + 5;
        int bar2Ly = ypos * ySpacer - starterYInc + yBlackBarSpace + barSpacer;
        bar2Likes = new Shape(bar2Lx, bar2Ly, l[1], 15,
            Color.BLUE);
        window.addShape(bar2Likes);

        int bar3Lx = xpos * xSpacer - starterXInc + 5;
        int bar3Ly = ypos * ySpacer - starterYInc + yBlackBarSpace + (barSpacer
            * 2);
        bar3Likes = new Shape(bar3Lx, bar3Ly, l[2], 15,
            Color.ORANGE);
        window.addShape(bar3Likes);

        int bar4Lx = xpos * xSpacer - starterXInc + 5;
        int bar4Ly = ypos * ySpacer - starterYInc + yBlackBarSpace + (barSpacer
            * 3);
        bar4Likes = new Shape(bar4Lx, bar4Ly, l[3], 15,
            Color.GREEN);
        window.addShape(bar4Likes);
        */
        
        for (int i = 0; i <= 3; i++) {
            Random r = new Random();
            int c1 = r.nextInt(255);
            int c2 = r.nextInt(255);
            int c3 = r.nextInt(255);
            int barHx = xpos * xSpacer - starterXInc - h[i];
            int barHy = ypos * ySpacer - starterYInc + yBlackBarSpace + barSpacer * i;
            bar1Heard = new Shape(barHx, barHy, h[i], 15,
                new Color(c2, c2, c3));
            window.addShape(bar1Heard);
        }

        /*int bar1Hx = xpos * xSpacer - starterXInc - h[0];
        int bar1Hy = ypos * ySpacer - starterYInc + yBlackBarSpace;
        bar1Heard = new Shape(bar1Hx, bar1Hy, h[0], 15,
            Color.MAGENTA);
        window.addShape(bar1Heard);

        int bar2Hx = xpos * xSpacer - starterXInc - h[1];
        int bar2Hy = ypos * ySpacer - starterYInc + yBlackBarSpace + barSpacer;
        bar2Heard = new Shape(bar2Hx, bar2Hy, h[1], 15,
            Color.BLUE);
        window.addShape(bar2Heard);

        int bar3Hx = xpos * xSpacer - starterXInc - h[2];
        int bar3Hy = ypos * ySpacer - starterYInc + yBlackBarSpace + (barSpacer
            * 2);
        bar3Heard = new Shape(bar3Hx, bar3Hy, h[2], 15,
            Color.ORANGE);
        window.addShape(bar3Heard);

        int bar4Hx = xpos * xSpacer - starterXInc - h[3];
        int bar4Hy = ypos * ySpacer - starterYInc + yBlackBarSpace + (barSpacer
            * 3);
        bar4Heard = new Shape(bar4Hx, bar4Hy, h[3], 15,
            Color.GREEN);
        window.addShape(bar4Heard);
        */

    }
    
    public void removeAll()
    {
        /*window.removeShape(bar1Likes);
        window.removeShape(bar2Likes);
        window.removeShape(bar3Likes);
        window.removeShape(bar4Likes);
        
        window.removeShape(bar1Heard);
        window.removeShape(bar2Heard);
        window.removeShape(bar3Heard);
        window.removeShape(bar4Heard);

        window.removeShape(title);
        window.removeShape(artist);
        window.removeShape(blackBar);
        */
        
        window.removeAllShapes();     
    }
}
