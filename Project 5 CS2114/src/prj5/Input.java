/**
 * 
 */
package prj5;

/**
 * @author Tom
 *
 */
public class Input {
    
    private SongList songList;
    /**
     * Read song to the songList
     * 
     * @param str
     *            Address of song data
     * @throws FileNotFoundException
     */
    private void readSongFile(String songData) throws FileNotFoundException 
    {
        Scanner input = new Scanner(new File(songData));
        String[] str;

        input.nextLine();

        while (input.hasNextLine()) 
        {
            str = input.nextLine().trim().split(",");
            songList.add(new Song(str[0], str[1], str[2], str[3]));
        }

        input.close();
    }

    /**
     * Read student file and add data to songList
     * 
     * @param studentData
     *            Address of student data
     * @throws FileNotFoundException
     */
    private void readStudentFile(String studentData) throws FileNotFoundException 
    {
        Scanner input = new Scanner(new File(studentData));
        String[] str;
        Song song;
        String hobby;
        String major;
        String region;

        input.nextLine();

        while (input.hasNextLine()) {
            String[] temp = input.nextLine().trim().split(",");
            // get rid of invalid lines
            if (temp.length == (songList.size() * 2 + 4)) {
                str = new String[temp.length + 1];
                for (int i = 0; i < temp.length; i++) {
                    str[i] = temp[i];
                }
                str[temp.length] = "";
            }
            else {
                str = temp;
            }
            if (str.length <= 2) {
                continue;
            }
            
            // record the major, region, and hobby info of a student
            major = str[2];
            region = str[3];
            hobby = str[4];
            
            // update the counts attributes of the song
            for (int i = 5; (i + 1) < str.length; i += 2) {
                song = songList.getAt((i - 5) / 2);
                song.getMajorPercent().increment(major, str[i], str[i + 1]);
                song.getRegionPercent().increment(region, str[i], str[i + 1]);
                song.getHobbyPercent().increment(hobby, str[i], str[i + 1]);
            }
        }
        input.close();
    }
}
