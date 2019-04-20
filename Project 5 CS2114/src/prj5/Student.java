package prj5;

/**
 * 
 * @author Eriq Taing (eriq12)
 * @version 4/17/2019
 */
public class Student {
    private int index;
    private String date;
    private Hobby hobby;
    private Major major;
    private Region region;
    // 2d, first index is song, second index is heard, then liked
    private boolean[][] responses;


    /**
     * constructor
     * 
     * @param i
     *            index
     * @param d
     *            date
     * @param h
     *            hobby
     * @param m
     *            major
     * @param r
     *            region
     * @param res
     *            responses for each song
     */
    public Student(int i, String d, Major m, Region r, Hobby h, boolean[][] res) {
        index = i;
        date = d;
        hobby = h;
        major = m;
        region = r;
        responses = res;
    }


    /**
     * getter
     * 
     * @return index
     */
    public int getIndex() {
        return index;
    }


    /**
     * getter
     * 
     * @return date
     */
    public String getDate() {
        return date;
    }


    /**
     * getter
     * 
     * @return hobby
     */
    public Hobby getHobby() {
        return hobby;
    }


    /**
     * getter
     * 
     * @return major
     */
    public Major getMajor() {
        return major;
    }


    /**
     * getter
     * 
     * @return region
     */
    public Region getRegion() {
        return region;
    }


    /**
     * getter
     * 
     * @param songIndex
     *            gets responses for song
     * @param whatResponse
     *            which type of response wanted (0 for heard, 1 for liked)
     * @return boolean for response
     */
    public boolean getResponse(int songIndex, int whatResponse) {
        return responses[songIndex][whatResponse];
    }
}
