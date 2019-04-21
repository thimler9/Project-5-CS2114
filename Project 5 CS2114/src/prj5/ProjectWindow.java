/**
 * 
 */
package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * @author Tom
 *
 */
public class ProjectWindow {
    LinkedList<Song> songs;
    String[] studentNames;
    Major[] studentMajors;
    Region[] studentRegions;
    Hobby[] studentHobbies;
    boolean[][] responseData;
    LinkedList<Chart> chargs;
    private Window window;
    private Shape legend;


    /**
     * creates a new project window
     * 
     */
    public ProjectWindow() {
        window = new Window();
        window.setTitle("Project 5");
        Button prev = new Button("<- Prev");
        Button art = new Button("Sort by Artist Name");
        Button title = new Button("Sort by Song Title");
        Button rel = new Button("Sort by Release Year");
        Button genre = new Button("Sort by Genre");
        Button next = new Button("-> Next");
        Button hobby = new Button("Represent Hobby");
        Button major = new Button("Represent Major");
        Button region = new Button("Represent Region");
        Button quit = new Button("Quit");
        window.addButton(prev, WindowSide.NORTH);
        window.addButton(art, WindowSide.NORTH);
        window.addButton(title, WindowSide.NORTH);
        window.addButton(rel, WindowSide.NORTH);
        window.addButton(genre, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);
        window.addButton(hobby, WindowSide.SOUTH);
        window.addButton(major, WindowSide.SOUTH);
        window.addButton(region, WindowSide.SOUTH);
        window.addButton(quit, WindowSide.SOUTH);
        prev.onClick(this, "clickedPrev");
        art.onClick(this, "clickedArtiest");
        title.onClick(this, "clickedSong");
        rel.onClick(this, "clickedYear");
        genre.onClick(this, "clickedGenre");
        next.onClick(this, "clickedNext");
        hobby.onClick(this, "clickedhobby");
        major.onClick(this, "clickedMajor");
        region.onClick(this, "clickedRegion");
        quit.onClick(this, "clickedQuit");

        legend = new Shape(820, 325, 135, 180);
        legend.setBackgroundColor(Color.WHITE);
        legend.setForegroundColor(Color.BLACK);
        window.addShape(legend);
    }


    /**
     * action when hobby button is clicked
     * 
     * @param hobby
     *            is the hobby button
     */
    public void clickedHobby(Button hobby) {

    }


    /**
     * action when major button is clicked
     * 
     * @param major
     *            is the hobby button
     */
    public void clickedMajor(Button major) {

    }


    /**
     * action when region button is clicked
     * 
     * @param region
     *            is the hobby button
     */
    public void clickedRegion(Button region) {

    }


    /**
     * action when art button is clicked
     * 
     * @param art
     *            is the hobby button
     */
    public void clickedArtist(Button art) {

    }


    /**
     * action when song button is clicked
     * 
     * @param song
     *            is the hobby button
     */
    public void clickedSong(Button song) {

    }


    /**
     * action when year button is clicked
     * 
     * @param year
     *            is the hobby button
     */
    public void clickedYear(Button year) {

    }


    /**
     * action when genre button is clicked
     * 
     * @param genre
     *            is the hobby button
     */
    public void clickedGenre(Button genre) {

    }


    /**
     * action when prev button is clicked
     * 
     * @param prev
     *            is the hobby button
     */
    public void clickedPrev(Button prev) {

    }


    /**
     * action when quit button is clicked
     * 
     * @param quit
     *            is the hobby button
     */
    public void clickedQuit(Button quit) {
        System.exit(0);
    }


    /**
     * action when next button is clicked
     * 
     * @param next
     *            is the hobby button
     */
    public void clickedNext(Button next) {

    }


    /**
     * creates legend
     */
    public void makeLengend() {

    }
}
