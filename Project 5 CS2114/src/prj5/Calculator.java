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

    private int[][] heardHobby;
    private int[][] likedHobby;
    private int[][] heardMajor;
    private int[][] likedMajor;
    private int[][] heardRegion;
    private int[][] likedRegion;


    // ~ Constructor
    /**
     * new a hobby.toLowerCase()Count
     * 
     */
    public Calculator() {
        heardHobby = new int[4][2];
        likedHobby = new int[4][2];
        heardMajor = new int[4][2];
        likedMajor = new int[4][2];
        heardRegion = new int[4][2];
        likedRegion = new int[4][2];
    } 


    // ~ Methods
    /**
     * Increment the results
     * 
     * @param hobby.toLowerCase()
     *            represent the hobby.toLowerCase() of a student
     * @param hasHeard
     *            whether that student has heard this song or not
     * @param hasLike
     *            whether that student likes that song or not
     */
    public void increment(String hobby, String major, String region, String hasHeard, String hasLiked) {
        heardHobby(hobby, hasHeard);
        likedHobby(hobby, hasLiked);
        heardMajor(major, hasHeard);
        likedMajor(major, hasLiked);
        heardRegion(region, hasHeard);
        likedRegion(region, hasLiked);
    }

    

    /**
     * increase the heard part
     * 
     * @param hobby.toLowerCase()
     *            represents the hobby.toLowerCase() of the student
     * @param answer
     *            answer to like or not
     */
    private void heardHobby(String hobby, String answer) {
        if (answer == "Yes") {
            if (hobby.toLowerCase() == "reading") {
                heardHobby[0][1]++;
            }
            else if (hobby.toLowerCase() == "art") {
                heardHobby[1][1]++;
            }
            else if (hobby.toLowerCase() == "sports") {
                heardHobby[2][1]++;
            }
            else if (hobby.toLowerCase() == "music") {
                heardHobby[3][1]++;
            }
        }
        else if (answer == "No") {
            if (hobby.toLowerCase() == "reading") {
                heardHobby[0][0]++;
            }
            else if (hobby.toLowerCase() == "art") {
                heardHobby[1][0]++;
            }
            else if (hobby.toLowerCase() == "sports") {
                heardHobby[2][0]++;
            }
            else if (hobby.toLowerCase() == "music") {
                heardHobby[3][0]++;
            }
        }

    }


    /**
     * Increase the like part.
     * 
     * @param hobby.toLowerCase()
     *            the student's hobby.toLowerCase()
     * @param answer
     *            answer to like or not
     */
    private void likedHobby(String hobby, String answer) {
        if (answer == "Yes") {
            if (hobby.toLowerCase() == "reading") {
                likedHobby[0][1]++;
            }
            else if (hobby.toLowerCase() == "art") {
                likedHobby[1][1]++;
            }
            else if (hobby.toLowerCase() == "sports") {
                likedHobby[2][1]++;
            }
            else if (hobby.toLowerCase() == "music") {
                likedHobby[3][1]++;
            }
        }
        else if (answer == "No") {
            if (hobby.toLowerCase() == "reading") {
                likedHobby[0][0]++;
            }
            else if (hobby.toLowerCase() == "art") {
                likedHobby[1][0]++;
            }
            else if (hobby.toLowerCase() == "sports") {
                likedHobby[2][0]++;
            }
            else if (hobby.toLowerCase() == "music") {
                likedHobby[3][0]++;
            }
        }
    }
    

    private void heardMajor (String major, String answer) {
        if (answer == "Yes") {
            if (major.toLowerCase() == "computer science") {
                heardMajor[0][1]++;
            }
            else if (major.toLowerCase() == "other engineering") {
                heardMajor[1][1]++;
            }
            else if (major.toLowerCase() == "math or cmda") {
                heardMajor[2][1]++;
            }
            else if (major.toLowerCase() == "other") {
                heardMajor[3][1]++;
            }
        }
        else if (answer == "No") {
            if (major.toLowerCase() == "computer science") {
                heardMajor[0][0]++;
            }
            else if (major.toLowerCase() == "other engineering") {
                heardMajor[1][0]++;
            }
            else if (major.toLowerCase() == "math or cmda") {
                heardMajor[2][0]++;
            }
            else if (major.toLowerCase() == "other") {
                heardMajor[3][0]++;
            }
        }

    }


    /**
     * Increase the like part.
     * 
     * @param hobby.toLowerCase()
     *            the student's hobby.toLowerCase()
     * @param answer
     *            answer to like or not
     */
    private void likedMajor (String major, String answer) {
        if (answer == "Yes") {
            if (major.toLowerCase() == "computer science") {
                likedMajor[0][1]++;
            }
            else if (major.toLowerCase() == "other engineering") {
                likedMajor[1][1]++;
            }
            else if (major.toLowerCase() == "math or cmda") {
                likedMajor[2][1]++;
            }
            else if (major.toLowerCase() == "other") {
                likedMajor[3][1]++;
            }
        }
        else if (answer == "No") {
            if (major.toLowerCase() == "computer science") {
                likedMajor[0][0]++;
            }
            else if (major.toLowerCase() == "other engineering") {
                likedMajor[1][0]++;
            }
            else if (major.toLowerCase() == "math or cmda") {
                likedMajor[2][0]++;
            }
            else if (major.toLowerCase() == "other") {
                likedMajor[3][0]++;
            }
        }
    }

    private void heardRegion (String region, String answer) {
        if (answer == "Yes") {
            if (region.toLowerCase() == "northeast") {
                heardRegion[0][1]++;
            }
            else if (region.toLowerCase() == "southeast") {
                heardRegion[1][1]++;
            }
            else if (region.toLowerCase() == "united states other than southeast or northeast") {
                heardRegion[2][1]++;
            }
            else if (region.toLowerCase() == "outside of united states") {
                heardRegion[3][1]++;
            }
        }
        else if (answer == "No") {
            if (region.toLowerCase() == "northeast") {
                heardRegion[0][0]++;
            }
            else if (region.toLowerCase() == "southeast") {
                heardRegion[1][0]++;
            }
            else if (region.toLowerCase() == "united states other than southeast or northeast") {
                heardRegion[2][0]++;
            }
            else if (region.toLowerCase() == "outside of united states") {
                heardRegion[3][0]++;
            }
        }

    }


    /**
     * Increase the like part.
     * 
     * @param hobby.toLowerCase()
     *            the student's hobby.toLowerCase()
     * @param answer
     *            answer to like or not
     */
    private void likedRegion (String region, String answer) {
        if (answer == "Yes") {
            if (region.toLowerCase() == "northeast") {
                likedRegion[0][1]++;
            }
            else if (region.toLowerCase() == "southeast") {
                likedRegion[1][1]++;
            }
            else if (region.toLowerCase() == "united states other than southeast or northeast") {
                likedRegion[2][1]++;
            }
            else if (region.toLowerCase() == "outside of united states") {
                likedRegion[3][1]++;
            }
        }
        else if (answer == "No") {
            if (region.toLowerCase() == "northeast") {
                likedRegion[0][0]++;
            }
            else if (region.toLowerCase() == "southeast") {
                likedRegion[1][0]++;
            }
            else if (region.toLowerCase() == "united states other than southeast or northeast") {
                likedRegion[2][0]++;
            }
            else if (region.toLowerCase() == "ouside of unites states") {
                likedRegion[3][0]++;
            }
        }
    }


    /**
     * get the heard or not results in percentages
     * 
     * @return the heard or not results
     */
    public int[] getHeardHobby() {
        int[] result = new int[4];
        for (int i = 0; i <= 3; i++) {
            double heards = (heardHobby[i][1] * 1.0);
            int all = heardHobby[i][0] + heardHobby[i][1];
            result[i] = (int) ((heards / all) * 100);
        }
        return result;
    }

    /**
     * get the like or not results
     * 
     * @return the like or not results
     */
    public int[] getLikeHobby() {
        int[] result = new int[4];
        for (int i = 0; i <= 3; i++) {
            double like = (likedHobby[i][1] * 1.0);
            int all = likedHobby[i][0] + likedHobby[i][1];
            result[i] = (int) ((like / all) * 100);
        }
        return result;
    }

    /**
     * get the heard or not results in percentages
     * 
     * @return the heard or not results
     */
    public int[] getHeardMajor() {
        int[] result = new int[4];
        for (int i = 0; i <= 3; i++) {
            double heards = (heardMajor[i][1] * 1.0);
            int all = heardMajor[i][0] + heardMajor[i][1];
            result[i] = (int) ((heards / all) * 100);
        }
        return result;
    }

    /**
     * get the like or not results
     * 
     * @return the like or not results
     */
    public int[] getLikeMajor() {
        int[] result = new int[4];
        for (int i = 0; i <= 3; i++) {
            double like = (likedMajor[i][1] * 1.0);
            int all = likedMajor[i][0] + likedMajor[i][1];
            result[i] = (int) ((like / all) * 100);
        }
        return result;
    }

    /**
     * get the heard or not results in percentages
     * 
     * @return the heard or not results
     */
    public int[] getHeardRegion() {
        int[] result = new int[4];
        for (int i = 0; i <= 3; i++) {
            double heards = (heardRegion[i][1] * 1.0);
            int all = heardRegion[i][0] + heardRegion[i][1];
            result[i] = (int) ((heards / all) * 100);
        }
        return result;
    }

    /**
     * get the like or not results
     * 
     * @return the like or not results
     */
    public int[] getLikeRegion() {
        int[] result = new int[4];
        for (int i = 0; i <= 3; i++) {
            double like = (likedRegion[i][1] * 1.0);
            int all = likedRegion[i][0] + likedRegion[i][1];
            result[i] = (int) ((like / all) * 100);
        }
        return result;
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
