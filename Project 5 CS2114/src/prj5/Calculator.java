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
 * Add the class description here.
 *
 * @author Pranav Sharma pranavsharma
 * @version 04/17/2019
 */
public class Calculator implements Comparator<String> {

    private int[][] heard;
    private int[][] liked;


    // ~ Constructor
    /**
     * new a HobbyCount
     * 
     */
    public Calculator() {
        heard = new int[4][2];
        liked = new int[4][2];
    }


    // ~ Methods
    /**
     * Increment the results
     * 
     * @param hobby
     *            represent the hobby of a student
     * @param answerHeard
     *            whether that student has heard this song or not
     * @param answerLike
     *            whether that student likes that song or not
     */
    public void increment(String hobby, String hasHeard, String hasLiked) {
        heard(hobby, hasHeard);
        liked(hobby, hasLiked);
    }


    /**
     * increase the heard part
     * 
     * @param hobby
     *            represents the hobby of the student
     * @param answer
     *            answer to like or not
     */
    private void heard(String hobby, String answer) {
        if (answer == "Yes") {
            if (hobby == "reading") {
                heard[0][1]++;
            }
            else if (hobby == "art") {
                heard[1][1]++;
            }
            else if (hobby == "sports") {
                heard[2][1]++;
            }
            else if (hobby == "music") {
                heard[3][1]++;
            }
        }
        else if (answer == "No") {
            if (hobby == "reading") {
                heard[0][0]++;
            }
            else if (hobby == "art") {
                heard[1][0]++;
            }
            else if (hobby == "sports") {
                heard[2][0]++;
            }
            else if (hobby == "music") {
                heard[3][0]++;
            }
        }

    }


    /**
     * Increase the like part.
     * 
     * @param hobby
     *            the student's hobby
     * @param answer
     *            answer to like or not
     */
    private void liked(String hobby, String answer) {
        if (answer == "Yes") {
            if (hobby == "reading") {
                liked[0][1]++;
            }
            else if (hobby == "art") {
                liked[1][1]++;
            }
            else if (hobby == "sports") {
                liked[2][1]++;
            }
            else if (hobby == "music") {
                liked[3][1]++;
            }
        }
        else if (answer == "No") {
            if (hobby == "reading") {
                liked[0][0]++;
            }
            else if (hobby == "art") {
                liked[1][0]++;
            }
            else if (hobby == "sports") {
                liked[2][0]++;
            }
            else if (hobby == "music") {
                liked[3][0]++;
            }
        }
    }


    /**
     * get the heard or not results in percentages
     * 
     * @return the heard or not results
     */
    public int[] getHeard() {
        int[] result = new int[4];
        for (int i = 0; i <= 3; i++) {
            double heards = (heard[i][1] * 1.0);
            int all = heard[i][0] + heard[i][1];
            result[i] = (int) ((heards / all) * 100);
        }
        return result;
        /*result[0] = (int)((1.0 * heard[0][1] / (heard[0][0] + heard[0][1]))
            * 100);
        result[1] = (int)((1.0 * heard[1][1] / (heard[1][0] + heard[1][1]))
            * 100);
        result[2] = (int)((1.0 * heard[2][1] / (heard[2][0] + heard[2][1]))
            * 100);
        result[3] = (int)((1.0 * heard[3][1] / (heard[3][0] + heard[3][1]))
            * 100);3
        return result;
        */
    }


    /**
     * get the like or not results
     * 
     * @return the like or not results
     */
    public int[] getLike() {
        int[] result = new int[4];
        for (int i = 0; i <= 3; i++) {
            double like = (liked[i][1] * 1.0);
            int all = liked[i][0] + liked[i][1];
            result[i] = (int) ((like / all) * 100);
        }
        return result;
        /*result[0] = (int)((1.0 * liked[0][1] / (liked[0][0] + liked[0][1]))
            * 100);
        result[1] = (int)((1.0 * liked[1][1] / (liked[1][0] + liked[1][1]))
            * 100);
        result[2] = (int)((1.0 * liked[2][1] / (liked[2][0] + liked[2][1]))
            * 100);
        result[3] = (int)((1.0 * liked[3][1] / (liked[3][0] + liked[3][1]))
            * 100);
        return result;
        */
    }


    /**
     * Compare the two strings
     * 
     * @return 0, negative, or positive value int
     */
    @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }

}
