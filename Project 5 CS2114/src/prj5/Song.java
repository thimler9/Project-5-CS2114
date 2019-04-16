/**
 * 
 */
package prj5;

/**
 * @author Tom
 *
 */
public class Song 
{
    private String name;
    private String artist;
    private int releaseYear;
    private String genre;
    private int index;
    
    public Song()
    {
        
    }
    
    public String getArtist()
    {
        return artist;
    }
    
    public String getSong()
    {
        return name;
    }
    
    public int getYear()
    {
        return releaseYear;
    }
    
    public String getGenre()
    {
        return genre;
    }
    
    public int getIndex(){
        return index;
    }
}
