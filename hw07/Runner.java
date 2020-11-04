import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The race will consist of many runners. Each runner will be a thread.
 *
 * @author Chase Lewis
 */
public class Runner extends Thread {

    /**
     * integer representing the speed of the runner
     */
    private int speed;

    /**
     *  integer representing the period of time a runner must rest.
     */
    private int rest;

    /**
     *  string name of the runner.
     */
    private String name;

    /**
     *  integer distance of the race to run.
     */
    private int distance;

    /**
     * constructer that creates a runner with a speed, rest time, name of the runner, and distance to run
     * @param speed speed of runner
     * @param rest rest time of runner
     * @param name name of runner
     * @param distance distance to be ran by runner
     */
    public Runner(int speed, int rest, String name, int distance){
        this.speed = speed;
        this.rest = rest;
        this.name = name;
        this.distance = distance;
    }


    /**
     * This is the run method for the Thread class that is overwritten.
     * This will simulate the runner running the race.
     */
    @Override
    public void run() {
        System.out.println(this.name + " has started the race...");

        int start = 0;

        while (start < this.distance) {
            try {
                this.sleep(this.rest * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            start += this.speed;
            System.out.println(this.name + ": " + start + "/" + this.distance);
        }
        System.out.println(this.name + " has finished the race...");
    }

    /**
     * Obtain a file name from the command line.
     * Read in a file and create Runner threads. (See below for the file format).
     * Once all threads are created it will start all of them.
     * Once all threads are started it will wait until all threads have finished
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String fName = args[0];
        FileReader fr = new FileReader(fName);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<Runner> runners = new ArrayList<>();
        while ((line = br.readLine()) != null){
            String grid[] = line.split(",");
            Runner run = new Runner(Integer.parseInt(grid[1].trim()), Integer.parseInt(grid[2].trim())
                    ,grid[0],1000);
            runners.add(run);
        }
        for (Runner run: runners){
            run.start();
        }


    }
}
