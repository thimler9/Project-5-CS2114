/**
 * 
 */
package prj5;

import CS2114.Button;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * @author Tom
 *
 */
public class ProjectWindow 
{
    LinkedList<Song> songs;
    String[] studentNames;
    Major[] studentMajors;
    Region[] studentRegions;
    Hobby[] studentHobbies;
    boolean[][] responseData;
    LinkedList<Chart> chargs;
    private Window window;
    
    public ProjectWindow()
    {
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
    }
    
    public void clickedHobby(Button hobby)
    {
        
    }
    
    public void clickedMajor(Button major)
    {
        
    }
    
    public void clickedRegion(Button region)
    {
        
    }
    
    public void clickedArtist(Button art)
    {
        
    }
    
    public void clickedSong(Button song)
    {
        
    }
    
    public void clickedYear(Button year)
    {
        
    }
    
    public void clickedGenre(Button genre)
    {
        
    }
    
    public void clickedPrev(Button prev)
    {
        
    }
    
    public void clickedQuit(Button quit)
    {
        System.exit(0);
    }
    
    public void clickedNext(Button next)
    {
        
    }
    
    public void makeLengend()
    {
        
    }
}
