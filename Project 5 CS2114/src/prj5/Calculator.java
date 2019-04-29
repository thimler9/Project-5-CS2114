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
        //reading
        CompareEnums comp = new CompareByHobby(Hobby.READING);
        getPercent(hobbProp, comp);
        //art
        ((CompareByHobby)comp).setHobby(Hobby.ART);
        getPercent(hobbProp, comp);
        //sport
        ((CompareByHobby)comp).setHobby(Hobby.SPORTS);
        getPercent(hobbProp, comp);
        //music
        ((CompareByHobby)comp).setHobby(Hobby.MUSIC);
        getPercent(hobbProp, comp);
    }


    /**
     * redo of getHPercent
     */
    private void getPercent(LinkedList<int[][]> prop, CompareEnums e) {
        int heardCount = 0;
        int likesCount = 0;
        int heardTotal = 0;
        int likesTotal = 0;
        for (int i = 0; i < songs.getSize(); i++) {
            for (int j = 0; j < students.getSize(); j++) {
                Student s = students.get(j);
                if (e.compare(s)) {
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
            prop.get(i)[0][0] = 0;
            if (heardTotal > 0) {
                prop.get(i)[0][0] = heardCount * 100 / heardTotal;
            }

            prop.get(i)[0][1] = 0;
            if (likesTotal > 0) {
                prop.get(i)[0][1] = likesCount * 100 / likesTotal;
            }
            heardCount = 0;
            likesCount = 0;
            heardTotal = 0;
            likesTotal = 0;
        }
    }


    /**
     * 
     * @author Eriq Taing (eriq12)
     *         to replicate comparator
     */
    private interface CompareEnums {
        /**
         * to allow usage of the same code across different enums
         * 
         * @param s
         *            student comparing enum
         * @return if the enums are the same
         */
        public abstract boolean compare(Student s);
    }


    /**
     * 
     * @author Eriq Taing (eriq12)
     *         compares regions
     */
    private class CompareByRegion implements CompareEnums {
        private Region r;


        /**
         * constructor
         * 
         * @param region
         *            original region to set
         */
        private CompareByRegion(Region region) {
            setRegion(region);
        }


        /**
         * to reuse object
         * 
         * @param region
         *            new region to set
         */
        private void setRegion(Region region) {
            r = region;
        }


        /**
         * to allow usage of the same code across different enums
         * 
         * @param s
         *            student comparing Region
         * @return if the regions are the same
         */
        public boolean compare(Student s) {
            return s.getRegion() == r;
        }
    }


    /**
     * 
     * @author Eriq Taing (eriq12)
     *         compares hobby
     */
    private class CompareByHobby implements CompareEnums {
        private Hobby h;


        /**
         * constructor
         * 
         * @param hobby
         *            original hobby to set
         */
        private CompareByHobby(Hobby hobby) {
            setHobby(hobby);
        }


        /**
         * to reuse object
         * 
         * @param hobby
         *            new hobby to set
         */
        private void setHobby(Hobby hobby) {
            h = hobby;
        }


        /**
         * to allow usage of the same code across different enums
         * 
         * @param s
         *            student comparing Hobby
         * @return if the hobbys are the same
         */
        public boolean compare(Student s) {
            return s.getHobby() == h;
        }
    }


    /**
     * 
     * @author Eriq Taing (eriq12)
     *         compares Major
     */
    private class CompareByMajor implements CompareEnums {
        private Major m;


        /**
         * constructor
         * 
         * @param major
         *            original major to set
         */
        private CompareByMajor(Major major) {
            setHobby(major);
        }


        /**
         * to reuse object
         * 
         * @param major
         *            new major to set
         */
        private void setHobby(Major major) {
            m = major;
        }


        /**
         * to allow code reusage across
         * 
         * @param s
         *            Student to compare
         */
        public boolean compare(Student s) {
            return s.getMajor() == m;
        }
    }


    // ----------------------------------------------------------------------------

    /**
     * Calculates the percentages for each region
     */
    private void regionPercent() {
        // NE
        CompareEnums comp = new CompareByRegion(Region.NORTHEAST);
        getPercent(regionProp, comp);
        // OUT
        ((CompareByRegion)comp).setRegion(Region.OUTSIDE_OF_UNITED_STATES);
        getPercent(regionProp, comp);
        // SE
        ((CompareByRegion)comp).setRegion(Region.SOUTHEAST);
        getPercent(regionProp, comp);
        // NotSEorNW
        ((CompareByRegion)comp)
            .setRegion(Region.UNITED_STATES_OTHER_THAN_SOUTHEAST_OR_NORTHWEST);
        getPercent(regionProp, comp);
    }


    // ----------------------------------------------------------------------------

    /**
     * Calculates the percentages for each major
     */
    private void majorPercent() {
        // CompSci
        CompareEnums comp = new CompareByMajor(Major.COMPUTER_SCIENCE);
        getPercent(majorProp, comp);
        // Math/CMDA
        ((CompareByMajor)comp).setHobby(Major.MATH_OR_CMDA);
        getPercent(majorProp, comp);
        // Other Engineering
        ((CompareByMajor)comp).setHobby(Major.OTHER_ENGINEERING);
        getPercent(majorProp, comp);
        // Other
        ((CompareByMajor)comp).setHobby(Major.MATH_OR_CMDA);
        getPercent(majorProp, comp);
    }
}
