import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Chase Lewis
 */
public class BattleRoyale {
    /**
     * reads the file passed in and creates instructors from it and adds them to a list
     * @param filename the filename passed in
     * @return an arraylist of the instructors added to it
     * @throws IOException
     */
    public static ArrayList<Instructor> readFile(File filename) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(filename));
        String line;
        ArrayList<Instructor> instructors = new ArrayList<>();
        //ArrayList<Battle> battles = new ArrayList<>();

        while((line = bf.readLine()) != null)
        {
            String grid[] = line.split(",");

            Instructor i = new Instructor(grid[0], Integer.parseInt(grid[1].trim()), Integer.parseInt(grid[2].trim()),
                    Integer.parseInt(grid[3].trim()),Integer.parseInt(grid[4].trim()));
            instructors.add(i);
        }
        return instructors;
    }

    /**
     * Obtain a file name from the command line, not user input.
     * Read the file and construct a list of the instructors participating in the Battle Royale.
     * Run the Battle Royale.
     * State the winner.
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String args[]) throws IOException, InterruptedException {
        System.out.println("The battle royal is about to begin");
        ArrayList<Instructor> instructors = readFile(new File(args[0]));
        ArrayList<Battle> battles = new ArrayList<>();
        int currBat = 0;
        boolean flag = true;
        int round = 1;
        while(flag) {
            System.out.println("Round " + round + " is starting...");
            Collections.shuffle(instructors);
            for(int i = 0; i < instructors.size(); i += 2)
            {
                int t = i ++;
                Battle  b = new Battle(instructors.get(i), instructors.get(t));
                battles.add(b);
                currBat ++;
                instructors.remove(0);
                instructors.remove(0);
            }
            round ++;

            for (int j = 0; j < currBat; j++) {
                battles.get(j).start();
            }
            for (int k = 0; k < currBat; k ++) {
                battles.get(k).join();
                instructors.add(battles.get(k).getWinner());
            }
            battles.removeAll(battles);

            if(instructors.size() == 1)
            {
                flag = false;
            }
            currBat = 0;
        }
        System.out.println(instructors.get(0).getName() + " is victorious!!!");
    }
}

