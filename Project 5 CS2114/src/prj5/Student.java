package prj5;

/**
 * 
 * @author Eriq Taing (eriq12)
 *
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
}
