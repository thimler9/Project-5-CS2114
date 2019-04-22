/*
 * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Pranav Sharma (pranavsharma)
 */
package prj5;

import java.util.Comparator;

/**
 * Calculates the percentages for each song
 *
 * @author Pranav Sharma pranavsharma
 * @author Thomas Himler (thimler9)
 * @version 04/17/2019
 */
public class Calculator {

    private LinkedList<Song> songs; //List of songs
    private LinkedList<Student> students; //List of students
    private LinkedList<int[][]> hobbProp; //List of hobby precentages
    private LinkedList<int[][]> regionProp; //List of region percentages
    private LinkedList<int[][]> majorProp; //List of major percentages


    // ~ Constructor
    /**
     * For the int[][]
     * [0][] is the first for the enum (i.e. hobby -> reading)
     * [1][] is the second
     * [2][] is the third
     * [3][] is the fourth
     * 
     * [][0] is for heard
     * [][1] is for liked
     * 
     * The linked lists are the prop for each song, so a given index in the
     * list list is related to the index in the linked list "songs"
     * 
     * @param studentFileName is the name of student file
     * @param songFileName is the file with the song information
     */
    public Calculator(String studentFileName, String songFileName) {
        
        FileReader reader = new FileReader(studentFileName, songFileName);
        songs = reader.getSongs();
        students = reader.getStudents();
        hobbProp = new LinkedList<int[][]>();
        regionProp = new LinkedList<int[][]>();
        majorProp = new LinkedList<int[][]>();
        
        for (int i = 0; i < songs.getSize(); i++)
        {
            hobbProp.add(new int[4][2]);
            regionProp.add(new int[4][2]);
            majorProp.add(new int[4][2]);
        }
        
        hobbyPercent();
        regionPercent();
        majorPercent();
        
    }
    
    /**
     * Returns the list of hobby percentages
     * @return linkedlist of hobb percentages
     */
    public LinkedList<int[][]> getHobbyPercent()
    {
        return hobbProp;
    }
    
    /**
     * Returns the list of region percentages
     * @return the list of region percentages
     */
    public LinkedList<int[][]> getRegionPercent()
    {
        return regionProp;
    }
    
    /**
     * Returns the list of major percentages
     * @return the list of major percentages
     */
    public LinkedList<int[][]> getMajorPercent()
    {
        return majorProp;
    }
    
//-------------------------------------------------------------------
    
    /**
     * Calculates the percentages for each hobby
     */
    private void hobbyPercent()
    {
        readingPercent();
        artPercent();
        sportsPercent();
        musicPercent();
    }
    
    /**
     * Calculates the percentage of people who read
     * and whether or not they like each song and have heard of it
     */
    private void readingPercent()
    {
        int heardCount = 0;
        int likesCount = 0;
        int totalCount = 0;
        for (int i = 0; i < songs.getSize(); i++)
        {
            for (int j = 0; j < students.getSize(); j++)
            {
                if (students.get(j).getHobby() == Hobby.READING)
                {
                    if (students.get(j).getResponse(i, 0) == Response.YES)
                    {
                        heardCount++;
                    }
                    if (students.get(j).getResponse(i, 1) == Response.YES)
                    {
                        likesCount++;
                    }
                    totalCount++;
                }
            }
            hobbProp.get(i)[0][0] = heardCount * 100 / totalCount;
            hobbProp.get(i)[0][1] = likesCount * 100 / totalCount;
            heardCount = 0;
            likesCount = 0;
        }
