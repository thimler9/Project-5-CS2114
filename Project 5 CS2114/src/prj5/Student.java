package prj5;

/**
 * 
 * @author Eriq Taing (eriq12)
 *
 */
public class Student {
    private String name;
    private Hobby hobby;
    private Major major;
    private Region region;
    // 2d, first index is song, second index is heard, then liked
    private boolean[][] responses;
    
    
    public Student(String n, Hobby h, Major m, Region r, boolean[][] res){
        name = n;
        hobby = h;
        region = r;
        responses = res;
    }
}
