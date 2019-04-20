/**
 * 
 */
package prj5;

/**
 * @author Tom
 * @author Eriq Taing (eriq12)
 * @version 4/20/2019
 */
public class Input {

    public static void main(String[] args) {
        FileReader reader = null;
        if (args.length == 2) {
            try {
                reader = new FileReader(args[0], args[1]);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (reader != null) {
            
        }
    }
}
