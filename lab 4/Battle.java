import java.io.*;
import java.util.ArrayList;

public class Battle extends Thread {

    /**
     * instructor state number 1
     */
    private Instructor i1;


    /**
     * instructor state number 2
     */
    private Instructor i2;

    /**
     * creates a battle between two instructors
     * @param i1 instructor 1
     * @param i2 instructor 2
     */
    public Battle(Instructor i1, Instructor i2){
        this.i1 = i1;
        this.i2 = i2;
    }

    /**
     * will handle the battle between the two instructors  and allows to fight until there's a winner
     */
    public void run(){
        System.out.println("The battle between " + this.i1.getName() + " and " + this.i2.getName() + " has begun!!!");
        int time = 1;
        while (i1.isAlive() && i2.isAlive()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(time % i1.getTimeToAtk() == 0)
            {
                System.out.println("Time: " + time);
                System.out.println(i1.getName()+ " attacks " + i2.getName() );
                int dmg = i1.getAtkAmount();
                i2.takeDamage(dmg);
                System.out.println(i1.getName() + " does " + dmg + " to " + i2.getName());
                System.out.println(i2.toString());
            }
            else if(time % i2.getTimeToAtk() == 0)
            {
                System.out.println("Time: " + time);
                System.out.println(i2.getName()+" attacks " + i1.getName());
                int dmg = i2.getAtkAmount();
                i1.takeDamage(dmg);
                System.out.println(i2.getName() + " does " + dmg + " to " + i1.getName());
                System.out.println(i1.toString());
            }
            time ++;
        }
        if(getWinner().equals(i1))
        {
            System.out.println("The battle between " + i1.getName() + " and " + i2.getName() + " has ended!!!");
            System.out.println(i1.getName() + " has defeated " + i2.getName());
            //System.out.println(i1.getName().toUpperCase() + " IS VICTORIOUS!!!");
        }
        else
        {
            System.out.println("The battle between " + i1.getName() + " and " + i2.getName() + " has ended!!!");
            System.out.println(i2.getName() + " has defeated " + i1.getName());
            //System.out.println(i2.getName().toUpperCase() + " IS VICTORIOUS!!!");
        }

    }

    /**
     * will return the winning Instructor. It is assumed this will be called
     * after the battle has completed.
     * @return the instructor that won
     */
    public Instructor getWinner(){
        if (i1.getHP() <= 0){
            i2.resetHP();
            return i2;
        }
        i1.resetHP();
        return i1;
    }

    /**
     * main method that creates instructors and adds them to a battle, then starts them
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<Instructor> lst= new ArrayList<>();
        while ((line = br.readLine()) != null){
            String grid[] = line.split(",");
            Instructor i = new Instructor(grid[0], Integer.parseInt(grid[1].trim()), Integer.parseInt(grid[2].trim()),
                    Integer.parseInt(grid[3].trim()),Integer.parseInt(grid[4].trim()));
            lst.add(i);
        }
        Battle battle = new Battle(lst.get(0), lst.get(1));
        battle.start();
    }
}
