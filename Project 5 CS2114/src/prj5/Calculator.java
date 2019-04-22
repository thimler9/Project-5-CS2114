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

/**
 * Calculates the percentages for each song
 *
 * @author Pranav Sharma pranavsharma
 * @author Thomas Himler (thimler9)
 * @version 04/17/2019
 */
public class Calculator {

    private LinkedList<Song> songs; // List of songs
    private LinkedList<Student> students; // List of students
    private LinkedList<int[][]> hobbProp; // List of hobby percentages
    private LinkedList<int[][]> regionProp; // List of region percentages
    private LinkedList<int[][]> majorProp; // List of major percentages
    private FileReader reader; // The file reader


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
     * @param studentFileName
     *            is the name of student file
     * @param songFileName
     *            is the file with the song information
     */
    public Calculator(String studentFileName, String songFileName) {

        reader = new FileReader(studentFileName, songFileName);
        songs = reader.getSongs();
        students = reader.getStudents();
        hobbProp = new LinkedList<int[][]>();
        regionProp = new LinkedList<int[][]>();
        majorProp = new LinkedList<int[][]>();

        for (int i = 0; i < songs.getSize(); i++) {
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
     * 
     * @return linkedlist of hobb percentages
     */
    public LinkedList<int[][]> getHobbyPercent() {
        return hobbProp;
    }


    /**
     * Returns the list of region percentages
     * 
     * @return the list of region percentages
     */
    public LinkedList<int[][]> getRegionPercent() {
        return regionProp;
    }


    /**
     * Returns the list of major percentages
     * 
     * @return the list of major percentages
     */
    public LinkedList<int[][]> getMajorPercent() {
        return majorProp;
    }


    /**
     * Returns the file reader
     * 
     * @return file reader
     */
    public FileReader getFileReader() {
        return reader;
    }


// ----------------------------------------------------------------------------

    /**
     * Calculates the percentages for each hobby
     */
    private void hobbyPercent() {
        readingPercent();
        artPercent();
        sportsPercent();
        musicPercent();
    }


    /**
     * Calculates the percentage of people who read
     * and whether or not they like each song and have heard of it
     */
    private void readingPercent() {
        int heardCount = 0;
        int likesCount = 0;
        int heardTotal = 0;
        int likesTotal = 0;
        for (int i = 0; i < songs.getSize(); i++) {
            for (int j = 0; j < students.getSize(); j++) {
                if (students.get(j).getHobby() == Hobby.READING) {
                    if (students.get(j).getResponse(i, 0) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 0) == Response.YES) {
                            heardCount++;
                        }
                        heardTotal++;
                    }
                    if (students.get(j).getResponse(i, 1) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 1) == Response.YES) {
                            likesCount++;
                        }
                        likesTotal++;
                    }
                }
            }
            if (heardTotal == 0) {
                hobbProp.get(i)[0][0] = 0;
            }
            else {
                hobbProp.get(i)[0][0] = heardCount * 100 / heardTotal;
            }

            if (likesTotal == 0) {
                hobbProp.get(i)[0][1] = 0;
            }
            else {
                hobbProp.get(i)[0][1] = likesCount * 100 / likesTotal;
            }
            heardCount = 0;
            likesCount = 0;
            heardTotal = 0;
            likesTotal = 0;
        }
    }


    /**
     * Calculates the percentage of people who like art
     * and whether or not they like each song and have heard of it
     */
    private void artPercent() {
        int heardCount = 0;
        int likesCount = 0;
        int heardTotal = 0;
        int likesTotal = 0;
        for (int i = 0; i < songs.getSize(); i++) {
            for (int j = 0; j < students.getSize(); j++) {
                if (students.get(j).getHobby() == Hobby.ART) {
                    if (students.get(j).getResponse(i, 0) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 0) == Response.YES) {
                            heardCount++;
                        }
                        heardTotal++;
                    }
                    if (students.get(j).getResponse(i, 1) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 1) == Response.YES) {
                            likesCount++;
                        }
                        likesTotal++;
                    }
                }
            }
            if (heardTotal == 0) {
                hobbProp.get(i)[1][0] = 0;
            }
            else {
                hobbProp.get(i)[1][0] = heardCount * 100 / heardTotal;
            }

            if (likesTotal == 0) {
                hobbProp.get(i)[1][1] = 0;
            }
            else {
                hobbProp.get(i)[1][1] = likesCount * 100 / likesTotal;
            }
            heardCount = 0;
            likesCount = 0;
            heardTotal = 0;
            likesTotal = 0;
        }
    }


    /**
     * Calculates the percentage of people who like sports
     * and whether or not they like each song and have heard of it
     */
    private void sportsPercent() {
        int heardCount = 0;
        int likesCount = 0;
        int heardTotal = 0;
        int likesTotal = 0;
        for (int i = 0; i < songs.getSize(); i++) {
            for (int j = 0; j < students.getSize(); j++) {
                if (students.get(j).getHobby() == Hobby.SPORTS) {
                    if (students.get(j).getResponse(i, 0) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 0) == Response.YES) {
                            heardCount++;
                        }
                        heardTotal++;
                    }
                    if (students.get(j).getResponse(i, 1) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 1) == Response.YES) {
                            likesCount++;
                        }
                        likesTotal++;
                    }
                }
            }
            if (heardTotal == 0) {
                hobbProp.get(i)[2][0] = 0;
            }
            else {
                hobbProp.get(i)[2][0] = heardCount * 100 / heardTotal;
            }

            if (likesTotal == 0) {
                hobbProp.get(i)[2][1] = 0;
            }
            else {
                hobbProp.get(i)[2][1] = likesCount * 100 / likesTotal;
            }
            heardCount = 0;
            likesCount = 0;
            heardTotal = 0;
            likesTotal = 0;
        }
    }


    /**
     * Calculates the percentage of people who like music
     * and whether or not they like each song and have heard of it
     */
    private void musicPercent() {
        int heardCount = 0;
        int likesCount = 0;
        int heardTotal = 0;
        int likesTotal = 0;
        for (int i = 0; i < songs.getSize(); i++) {
            for (int j = 0; j < students.getSize(); j++) {
                if (students.get(j).getHobby() == Hobby.MUSIC) {
                    if (students.get(j).getResponse(i, 0) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 0) == Response.YES) {
                            heardCount++;
                        }
                        heardTotal++;
                    }
                    if (students.get(j).getResponse(i, 1) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 1) == Response.YES) {
                            likesCount++;
                        }
                        likesTotal++;
                    }
                }
            }
            if (heardTotal == 0) {
                hobbProp.get(i)[3][0] = 0;
            }
            else {
                hobbProp.get(i)[3][0] = heardCount * 100 / heardTotal;
            }

            if (likesTotal == 0) {
                hobbProp.get(i)[3][1] = 0;
            }
            else {
                hobbProp.get(i)[3][1] = likesCount * 100 / likesTotal;
            }
            heardCount = 0;
            likesCount = 0;
            heardTotal = 0;
            likesTotal = 0;
        }
    }


// ----------------------------------------------------------------------------

    /**
     * Calculates the percentages for each region
     */
    private void regionPercent() {
        northeastPercent();
        outsidePercent();
        southeastPercent();
        notSEorNE();
    }


    /**
     * Calculates the percentage of people who are from the NE
     * and whether or not they like each song and have heard of it
     */
    private void northeastPercent() {
        int heardCount = 0;
        int likesCount = 0;
        int heardTotal = 0;
        int likesTotal = 0;
        for (int i = 0; i < songs.getSize(); i++) {
            for (int j = 0; j < students.getSize(); j++) {
                if (students.get(j).getRegion() == Region.NORTHEAST) {
                    if (students.get(j).getResponse(i, 0) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 0) == Response.YES) {
                            heardCount++;
                        }
                        heardTotal++;
                    }
                    if (students.get(j).getResponse(i, 1) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 1) == Response.YES) {
                            likesCount++;
                        }
                        likesTotal++;
                    }
                }
            }
            if (heardTotal == 0) {
                regionProp.get(i)[0][0] = 0;
            }
            else {
                regionProp.get(i)[0][0] = heardCount * 100 / heardTotal;
            }

            if (likesTotal == 0) {
                regionProp.get(i)[0][1] = 0;
            }
            else {
                regionProp.get(i)[0][1] = likesCount * 100 / likesTotal;
            }
            heardCount = 0;
            likesCount = 0;
            heardTotal = 0;
            likesTotal = 0;
        }
    }


    /**
     * Calculates the percentage of people who are from outside the US
     * and whether or not they like each song and have heard of it
     */
    private void outsidePercent() {
        int heardCount = 0;
        int likesCount = 0;
        int heardTotal = 0;
        int likesTotal = 0;
        for (int i = 0; i < songs.getSize(); i++) {
            for (int j = 0; j < students.getSize(); j++) {
                if (students.get(j)
                    .getRegion() == Region.OUTSIDE_OF_UNITED_STATES) {
                    if (students.get(j).getResponse(i, 0) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 0) == Response.YES) {
                            heardCount++;
                        }
                        heardTotal++;
                    }
                    if (students.get(j).getResponse(i, 1) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 1) == Response.YES) {
                            likesCount++;
                        }
                        likesTotal++;
                    }
                }
            }
            if (heardTotal == 0) {
                regionProp.get(i)[1][0] = 0;
            }
            else {
                regionProp.get(i)[1][0] = heardCount * 100 / heardTotal;
            }

            if (likesTotal == 0) {
                regionProp.get(i)[1][1] = 0;
            }
            else {
                regionProp.get(i)[1][1] = likesCount * 100 / likesTotal;
            }
            heardCount = 0;
            likesCount = 0;
            heardTotal = 0;
            likesTotal = 0;
        }
    }


    /**
     * Calculates the percentage of people who are from the SE
     * and whether or not they like each song and have heard of it
     */
    private void southeastPercent() {
        int heardCount = 0;
        int likesCount = 0;
        int heardTotal = 0;
        int likesTotal = 0;
        for (int i = 0; i < songs.getSize(); i++) {
            for (int j = 0; j < students.getSize(); j++) {
                if (students.get(j).getRegion() == Region.SOUTHEAST) {
                    if (students.get(j).getResponse(i, 0) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 0) == Response.YES) {
                            heardCount++;
                        }
                        heardTotal++;
                    }
                    if (students.get(j).getResponse(i, 1) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 1) == Response.YES) {
                            likesCount++;
                        }
                        likesTotal++;
                    }
                }
            }
            if (heardTotal == 0) {
                regionProp.get(i)[2][0] = 0;
            }
            else {
                regionProp.get(i)[2][0] = heardCount * 100 / heardTotal;
            }

            if (likesTotal == 0) {
                regionProp.get(i)[2][1] = 0;
            }
            else {
                regionProp.get(i)[2][1] = likesCount * 100 / likesTotal;
            }
            heardCount = 0;
            likesCount = 0;
            heardTotal = 0;
            likesTotal = 0;
        }
    }


    /**
     * Calculates the percentage of people who live in the US but not the
     * SE or NE
     * and whether or not they like each song and have heard of it
     */
    private void notSEorNE() {
        int heardCount = 0;
        int likesCount = 0;
        int heardTotal = 0;
        int likesTotal = 0;
        for (int i = 0; i < songs.getSize(); i++) {
            for (int j = 0; j < students.getSize(); j++) {
                if (students.get(j)
                    .getRegion() == 
                    Region.UNITED_STATES_OTHER_THAN_SOUTHEAST_OR_NORTHWEST) {
                    if (students.get(j).getResponse(i, 0) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 0) == Response.YES) {
                            heardCount++;
                        }
                        heardTotal++;
                    }
                    if (students.get(j).getResponse(i, 1) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 1) == Response.YES) {
                            likesCount++;
                        }
                        likesTotal++;
                    }
                }
            }
            if (heardTotal == 0) {
                regionProp.get(i)[3][0] = 0;
            }
            else {
                regionProp.get(i)[3][0] = heardCount * 100 / heardTotal;
            }

            if (likesTotal == 0) {
                regionProp.get(i)[3][1] = 0;
            }
            else {
                regionProp.get(i)[3][1] = likesCount * 100 / likesTotal;
            }
            heardCount = 0;
            likesCount = 0;
            heardTotal = 0;
            likesTotal = 0;
        }
    }


// ----------------------------------------------------------------------------

    /**
     * Calculates the percentages for each major
     */
    private void majorPercent() {
        compSciPercent();
        mathCMDAPercent();
        otherEnginePercent();
        otherPercent();
    }


    /**
     * Calculates the percentage of people who study Comp Sci
     * and whether or not they like each song and have heard of it
     */
    private void compSciPercent() {
        int heardCount = 0;
        int likesCount = 0;
        int heardTotal = 0;
        int likesTotal = 0;
        for (int i = 0; i < songs.getSize(); i++) {
            for (int j = 0; j < students.getSize(); j++) {
                if (students.get(j).getMajor() == Major.COMPUTER_SCIENCE) {
                    if (students.get(j).getResponse(i, 0) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 0) == Response.YES) {
                            heardCount++;
                        }
                        heardTotal++;
                    }
                    if (students.get(j).getResponse(i, 1) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 1) == Response.YES) {
                            likesCount++;
                        }
                        likesTotal++;
                    }
                }
            }
            if (heardTotal == 0) {
                majorProp.get(i)[0][0] = 0;
            }
            else {
                majorProp.get(i)[0][0] = heardCount * 100 / heardTotal;
            }

            if (likesTotal == 0) {
                majorProp.get(i)[0][1] = 0;
            }
            else {
                majorProp.get(i)[0][1] = likesCount * 100 / likesTotal;
            }
            heardCount = 0;
            likesCount = 0;
            heardTotal = 0;
            likesTotal = 0;
        }
    }


    /**
     * Calculates the percentage of people who study math or CMDA
     * and whether or not they like each song and have heard of it
     */
    private void mathCMDAPercent() {
        int heardCount = 0;
        int likesCount = 0;
        int heardTotal = 0;
        int likesTotal = 0;
        for (int i = 0; i < songs.getSize(); i++) {
            for (int j = 0; j < students.getSize(); j++) {
                if (students.get(j).getMajor() == Major.MATH_OR_CMDA) {
                    if (students.get(j).getResponse(i, 0) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 0) == Response.YES) {
                            heardCount++;
                        }
                        heardTotal++;
                    }
                    if (students.get(j).getResponse(i, 1) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 1) == Response.YES) {
                            likesCount++;
                        }
                        likesTotal++;
                    }
                }
            }
            if (heardTotal == 0) {
                majorProp.get(i)[1][0] = 0;
            }
            else {
                majorProp.get(i)[1][0] = heardCount * 100 / heardTotal;
            }

            if (likesTotal == 0) {
                majorProp.get(i)[1][1] = 0;
            }
            else {
                majorProp.get(i)[1][1] = likesCount * 100 / likesTotal;
            }
            heardCount = 0;
            likesCount = 0;
            heardTotal = 0;
            likesTotal = 0;
        }
    }


    /**
     * Calculates the percentage of people who study other engineerings
     * and whether or not they like each song and have heard of it
     */
    private void otherEnginePercent() {
        int heardCount = 0;
        int likesCount = 0;
        int heardTotal = 0;
        int likesTotal = 0;
        for (int i = 0; i < songs.getSize(); i++) {
            for (int j = 0; j < students.getSize(); j++) {
                if (students.get(j).getMajor() == Major.OTHER_ENGINEERING) {
                    if (students.get(j).getResponse(i, 0) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 0) == Response.YES) {
                            heardCount++;
                        }
                        heardTotal++;
                    }
                    if (students.get(j).getResponse(i, 1) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 1) == Response.YES) {
                            likesCount++;
                        }
                        likesTotal++;
                    }
                }
            }
            if (heardTotal == 0) {
                majorProp.get(i)[2][0] = 0;
            }
            else {
                majorProp.get(i)[2][0] = heardCount * 100 / heardTotal;
            }

            if (likesTotal == 0) {
                majorProp.get(i)[2][1] = 0;
            }
            else {
                majorProp.get(i)[2][1] = likesCount * 100 / likesTotal;
            }
            heardCount = 0;
            likesCount = 0;
            heardTotal = 0;
            likesTotal = 0;
        }
    }


    /**
     * Calculates the percentage of people who study
     * something other than the rest
     * and whether or not they like each song and have heard of it
     */
    private void otherPercent() {
        int heardCount = 0;
        int likesCount = 0;
        int heardTotal = 0;
        int likesTotal = 0;
        for (int i = 0; i < songs.getSize(); i++) {
            for (int j = 0; j < students.getSize(); j++) {
                if (students.get(j).getMajor() == Major.OTHER) {
                    if (students.get(j).getResponse(i, 0) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 0) == Response.YES) {
                            heardCount++;
                        }
                        heardTotal++;
                    }
                    if (students.get(j).getResponse(i, 1) != Response.NEITHER) {
                        if (students.get(j).getResponse(i, 1) == Response.YES) {
                            likesCount++;
                        }
                        likesTotal++;
                    }
                }
            }
            if (heardTotal == 0) {
                majorProp.get(i)[3][0] = 0;
            }
            else {
                majorProp.get(i)[3][0] = heardCount * 100 / heardTotal;
            }

            if (likesTotal == 0) {
                majorProp.get(i)[3][1] = 0;
            }
            else {
                majorProp.get(i)[3][1] = likesCount * 100 / likesTotal;
            }
            heardCount = 0;
            likesCount = 0;
            heardTotal = 0;
            likesTotal = 0;
        }
    }
}
