/**
 * 
 */
package prj5;

import java.awt.Color;
import java.util.Comparator;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * @author Tom Himler (thimler9)
 * @version 2019.4.28
 * 
 * Creates the project window and displays the charts for each song
 */
public class ProjectWindow {
    
    //Main window and calculator information
    private Window window;
    private LinkedList<int[][]> hobbPerc;
    private LinkedList<int[][]> majPerc;
    private LinkedList<int[][]> regPerc;
    private LinkedList<Song> songs;
    private int songIndex; // Keeps track of which 5 songs for the next and prev
    // methods
    private String currentEnum; // Keeps track of the enum for
    // the percent method
    
    //Legend text and shapes
    private Shape legend;
    private TextShape legendFirst;
    private TextShape legendSecond;
    private TextShape legendThird;
    private TextShape legendFourth;

    //Text and bars for the charts
    private TextShape songTitle;
    private TextShape songArtist;
    private Shape firstHeardPerc;
    private Shape secondHeardPerc;
    private Shape thirdHeardPerc;
    private Shape fourthHeardPerc;
    private Shape firstLikesPerc;
    private Shape secondLikesPerc;
    private Shape thirdLikesPerc;
    private Shape fourthLikesPerc;

    //The prev and next button (to disable and enable when necessary)
    private Button prev;
    private Button next;

    /**
     * Creates the project window
     * 
     * @param calc the project calculator
     */
    public ProjectWindow(Calculator calc) {
        // Initializes variables for the charts
        songs = calc.getFileReader().getSongs();
        hobbPerc = calc.getHobbyPercent();
        majPerc = calc.getMajorPercent();
        regPerc = calc.getRegionPercent();
        songIndex = 0;
        currentEnum = "Hobby"; // default enum

        // Creates window, adds buttons
        window = new Window();
        window.setSize(1200, 750);
        window.setTitle("Project 5");
        prev = new Button("<- Prev");
        Button art = new Button("Sort by Artist Name");
        Button title = new Button("Sort by Song Title");
        Button rel = new Button("Sort by Release Year");
        Button genre = new Button("Sort by Genre");
        next = new Button("-> Next");
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
        art.onClick(this, "clickedArtist");
        title.onClick(this, "clickedSong");
        rel.onClick(this, "clickedYear");
        genre.onClick(this, "clickedGenre");
        next.onClick(this, "clickedNext");
        hobby.onClick(this, "clickedHobby");
        major.onClick(this, "clickedMajor");
        region.onClick(this, "clickedRegion");
        quit.onClick(this, "clickedQuit");
        disableCheck();

        // Sets the default window
        updateWindow("Hobby");

    }


// This section implements all of the button methods
// ----------------------------------------------------------------------------

    /**
     * Updates the legend with hobby information
     * 
     * @param hobby the button
     */
    public void clickedHobby(Button hobby) {
        updateWindow("Hobby");
        currentEnum = "Hobby";
    }

    /**
     * Updates the legend with major information
     * 
     * @param major the button
     */
    public void clickedMajor(Button major) {
        updateWindow("Major");
        currentEnum = "Major";
    }

    /**
     * Updates the legend with region information
     * 
     * @param region the button
     */
    public void clickedRegion(Button region) {
        updateWindow("Region");
        currentEnum = "Region";
    }

    /**
     * Sorts the charts by artist
     * 
     * @param art the button
     */
    public void clickedArtist(Button art) {
        Comparator<Song> artistSort = songs.get(0).getCompareByArtist();
        songs.sort(artistSort);
        songIndex = 0;
        updateWindow(currentEnum);
        disableCheck();
    }

    /**
     * Sorts the charts by song title
     * 
     * @param song the button
     */
    public void clickedSong(Button song) {
        Comparator<Song> artistSort = songs.get(0).getCompareBySongTitle();
        songs.sort(artistSort);
        songIndex = 0;
        updateWindow(currentEnum);
        disableCheck();
    }

    /**
     * Sorts the charts by year of release
     * 
     * @param year the button
     */
    public void clickedYear(Button year) {
        Comparator<Song> artistSort = songs.get(0).getCompareByDate();
        songs.sort(artistSort);
        songIndex = 0;
        updateWindow(currentEnum);
        disableCheck();
    }

    /**
     * Sorts the charts by genre
     * 
     * @param genre the button
     */
    public void clickedGenre(Button genre) {
        Comparator<Song> artistSort = songs.get(0).getCompareByGenre();
        songs.sort(artistSort);
        songIndex = 0;
        updateWindow(currentEnum);
        disableCheck();
    }

    /**
     * Displays the next songs in the list
     * 
     * @param next the button
     */
    public void clickedNext(Button next) {
        if (songIndex < songs.getSize() / 5) {
            songIndex++;
        }
        updateWindow(currentEnum);
        disableCheck();
    }

    /**
     * Displays the previous songs in the list
     * 
     * @param prev the button
     */
    public void clickedPrev(Button prev) {
        if (songIndex > 0) {
            songIndex--;
        }
        updateWindow(currentEnum);
        disableCheck();
    }

    /**
     * Checks to see if the next or previous buttons should be
     * disabled (i.e. there are no more songs to show)
     */
    private void disableCheck() {
        if (songs.getSize() - songIndex * 5 < 5) {
            next.disable();
        }
        else {
            next.enable();
        }
        if (songIndex == 0) {
            prev.disable();
        }
        else {
            prev.enable();
        }
    }

    /**
     * Closes the window
     * 
     * @param quit the button
     */
    public void clickedQuit(Button quit) {
        System.exit(0);
    }


// This section adds all of the shapes for when the window is cleared
// ----------------------------------------------------------------------------

    /**
     * Adds the legend and charts to the window
     */
    public void addShapes() {
        addLegend();
        addCharts();
    }

    /**
     * Adds the legend to the window
     */
    public void addLegend() {
        // Adds the updated legend names
        window.addShape(legendFirst);
        window.addShape(legendSecond);
        window.addShape(legendThird);
        window.addShape(legendFourth);

        // Creates the chart diagram in legend
        TextShape sampleTitle = new TextShape(1025, 425, "Song Title");
        TextShape sampleHeard = new TextShape(1000, 475, "Heard");
        TextShape sampleLikes = new TextShape(1075, 475, "Likes");
        Shape sampleBar = new Shape(1050, 450, 20, 100);
        sampleTitle.setBackgroundColor(Color.WHITE);
        sampleHeard.setBackgroundColor(Color.WHITE);
        sampleLikes.setBackgroundColor(Color.WHITE);
        sampleBar.setForegroundColor(Color.BLACK);
        sampleBar.setBackgroundColor(Color.BLACK);

        window.addShape(sampleBar);
        window.addShape(sampleTitle);
        window.addShape(sampleHeard);
        window.addShape(sampleLikes);

        // Adds title and outline to legend
        legend = new Shape(950, 340, 200, 230);
        legend.setBackgroundColor(Color.WHITE);
        legend.setForegroundColor(Color.BLACK);
        window.addShape(legend);
        TextShape legendTitle = new TextShape(1000, 325, "Hobby Legend");
        window.addShape(legendTitle);
        legendTitle.setBackgroundColor(Color.WHITE);
        legendTitle.setForegroundColor(Color.BLACK);
    }

    /**
     * Adds the charts to the window
     */
    public void addCharts() {
        int max = 5;
        if (songs.getSize() - songIndex * 5 < 5) {
            max = songs.getSize() - songIndex * 5;
        }
        for (int i = 0; i < max; i++) {
            if (i < 3) {
                songTitle = new TextShape(203 + 350 * i - songs.get(songIndex
                    * 5 + i).getSong().length() * 3, 25, songs.get(songIndex * 5
                        + i).getSong());
                songArtist = new TextShape(203 + 350 * i - songs.get(songIndex
                    * 5 + i).getArtist().length() * 3, 50, songs.get(songIndex
                        * 5 + i).getArtist());
                songTitle.setBackgroundColor(Color.WHITE);
                songArtist.setBackgroundColor(Color.WHITE);
                window.addShape(songTitle);
                window.addShape(songArtist);

                Shape bar = new Shape(200 + 350 * i, 74, 20, 202);
                bar.setForegroundColor(Color.WHITE);
                bar.setBackgroundColor(Color.BLACK);
                window.addShape(bar);
            }
            else {
                songTitle = new TextShape(203 + 350 * (i - 3) - songs.get(
                    songIndex * 5 + i).getSong().length() * 3, 325, songs.get(
                        songIndex * 5 + i).getSong());
                songArtist = new TextShape(203 + 350 * (i - 3) - songs.get(
                    songIndex * 5 + i).getArtist().length() * 3, 350, songs.get(
                        songIndex * 5 + i).getArtist());
                songTitle.setBackgroundColor(Color.WHITE);
                songArtist.setBackgroundColor(Color.WHITE);
                window.addShape(songTitle);
                window.addShape(songArtist);

                Shape bar = new Shape(200 + 350 * (i - 3), 374, 20, 202);
                bar.setForegroundColor(Color.WHITE);
                bar.setBackgroundColor(Color.BLACK);
                window.addShape(bar);
            }
        }
    }


// This section updates all of the shapes
// ----------------------------------------------------------------------------

    /**
     * Updates the window when a button is pressed
     * 
     * @param enumeration the type of enum that is currently being displayed
     */
    public void updateWindow(String enumeration) {
        window.removeAllShapes();
        updateLegend(enumeration);
        updatePercents(enumeration);
        addShapes();
    }

    /**
     * Updates the legend based on the enum being passed
     * 
     * @param string the enum being passed
     */
    public void updateLegend(String string) {
        if (string.equals("Region")) {
            legendFirst = new TextShape(960, 350, "Northeast");
            legendSecond = new TextShape(960, 370, "Ouside the US");
            legendThird = new TextShape(960, 390, "Southeast");
            legendFourth = new TextShape(960, 410,
                "Not Southeast or Northeast");
        }
        if (string.equals("Hobby")) {
            legendFirst = new TextShape(960, 350, "Read");
            legendSecond = new TextShape(960, 370, "Art");
            legendThird = new TextShape(960, 390, "Sport");
            legendFourth = new TextShape(960, 410, "Music");
        }
        if (string.equals("Major")) {
            legendFirst = new TextShape(960, 350, "Computer Science");
            legendSecond = new TextShape(960, 370, "Math or CMDA");
            legendThird = new TextShape(960, 390, "Other Engineering");
            legendFourth = new TextShape(960, 410, "Other");
        }

        legendFirst.setBackgroundColor(Color.WHITE);
        legendSecond.setBackgroundColor(Color.WHITE);
        legendThird.setBackgroundColor(Color.WHITE);
        legendFourth.setBackgroundColor(Color.WHITE);
        legendFirst.setForegroundColor(Color.BLUE);
        legendSecond.setForegroundColor(Color.GREEN);
        legendThird.setForegroundColor(Color.RED);
        legendFourth.setForegroundColor(Color.ORANGE);
    }

    /**
     * Updates the percentage bars based on the enum that is passed
     * 
     * @param string the enum being passed
     */
    public void updatePercents(String string) {
        LinkedList<int[][]> enumList = getEnumList(string);
        int max = 5;
        if (songs.getSize() - songIndex * 5 < 5) {
            max = songs.getSize() - songIndex * 5;
        }

        for (int i = 0; i < max; i++) {

            Song s = songs.get(i + songIndex * 5);
            int index = s.getIndex();
            if (i < 3) {
                // Heard percentages first
                firstHeardPerc = new Shape(201 - enumList.get(index)[0][0] + i
                    * 350, 75, enumList.get(index)[0][0], 50);
                secondHeardPerc = new Shape(201 - enumList.get(index)[1][0] + i
                    * 350, 125, enumList.get(index)[1][0], 50);
                thirdHeardPerc = new Shape(201 - enumList.get(index)[2][0] + i
                    * 350, 175, enumList.get(index)[2][0], 50);
                fourthHeardPerc = new Shape(201 - enumList.get(index)[3][0] + i
                    * 350, 225, enumList.get(index)[3][0], 50);

                // Likes percentages
                firstLikesPerc = new Shape(219 + i * 350, 75, enumList.get(
                    index)[0][1], 50);
                secondLikesPerc = new Shape(219 + i * 350, 125, enumList.get(
                    index)[1][1], 50);
                thirdLikesPerc = new Shape(219 + i * 350, 175, enumList.get(
                    index)[2][1], 50);
                fourthLikesPerc = new Shape(219 + i * 350, 225, enumList.get(
                    index)[3][1], 50);
            }
            else {
                // Heard percentages first
                firstHeardPerc = new Shape(201 - enumList.get(index)[0][0] + (i
                    - 3) * 350, 375, enumList.get(index)[0][0], 50);
                secondHeardPerc = new Shape(201 - enumList.get(index)[1][0] + (i
                    - 3) * 350, 425, enumList.get(index)[1][0], 50);
                thirdHeardPerc = new Shape(201 - enumList.get(index)[2][0] + (i
                    - 3) * 350, 475, enumList.get(index)[2][0], 50);
                fourthHeardPerc = new Shape(201 - enumList.get(index)[3][0] + (i
                    - 3) * 350, 525, enumList.get(index)[3][0], 50);

                // Likes percentages
                firstLikesPerc = new Shape(219 + (i - 3) * 350, 375, enumList
                    .get(index)[0][1], 50);
                secondLikesPerc = new Shape(219 + (i - 3) * 350, 425, enumList
                    .get(index)[1][1], 50);
                thirdLikesPerc = new Shape(219 + (i - 3) * 350, 475, enumList
                    .get(index)[2][1], 50);
                fourthLikesPerc = new Shape(219 + (i - 3) * 350, 525, enumList
                    .get(index)[3][1], 50);
            }

            // Changes and adds the heard and likes bars
            firstHeardPerc.setBackgroundColor(Color.BLUE);
            firstHeardPerc.setForegroundColor(Color.BLUE);
            secondHeardPerc.setBackgroundColor(Color.GREEN);
            secondHeardPerc.setForegroundColor(Color.GREEN);
            thirdHeardPerc.setBackgroundColor(Color.RED);
            thirdHeardPerc.setForegroundColor(Color.RED);
            fourthHeardPerc.setBackgroundColor(Color.ORANGE);
            fourthHeardPerc.setForegroundColor(Color.ORANGE);

            window.addShape(firstHeardPerc);
            window.addShape(secondHeardPerc);
            window.addShape(thirdHeardPerc);
            window.addShape(fourthHeardPerc);

            firstLikesPerc.setBackgroundColor(Color.BLUE);
            firstLikesPerc.setForegroundColor(Color.BLUE);
            secondLikesPerc.setBackgroundColor(Color.GREEN);
            secondLikesPerc.setForegroundColor(Color.GREEN);
            thirdLikesPerc.setBackgroundColor(Color.RED);
            thirdLikesPerc.setForegroundColor(Color.RED);
            fourthLikesPerc.setBackgroundColor(Color.ORANGE);
            fourthLikesPerc.setForegroundColor(Color.ORANGE);

            window.addShape(firstLikesPerc);
            window.addShape(secondLikesPerc);
            window.addShape(thirdLikesPerc);
            window.addShape(fourthLikesPerc);
        }
    }


    private LinkedList<int[][]> getEnumList(String string) {
        if (string.equals("Hobby")) {
            return hobbPerc;
        }
        if (string.equals("Region")) {
            return regPerc;
        }
        else {
            return majPerc;
        }
    }
}
