import java.util.Random;

/**
 * @author Chase Lewis
 */
public class Instructor {

    /**
     *  the name of the instructor.
     */
    private String name;

    /**
     *  the max hit points of the instructor.
     */
    private int maxHP;

    /**
     * : the minimum value of their random attack.
     */
    private int minAtk;

    /**
     * the maximum value of their random attack.
     */
    private int maxAtk;

    /**
     * the time between attacks in seconds.
     */
    private int timeToAtk;

    /**
     * current hp of the instructor
     */
    private int currHP;


    /**
     * constructor that creates an instructor to participate in battle
     * @param name name of instructor
     * @param maxHP maximum health points of instructor
     * @param minAtk minimum attack damage of instructor
     * @param maxAtk maximum attack damage of instructor
     * @param timeToAtk time between each attack
     */
    public Instructor(String name, int maxHP, int minAtk,int maxAtk, int timeToAtk){
        this.name = name;
        this.maxHP = maxHP;
        this.minAtk = minAtk;
        this.maxAtk = maxAtk;
        this.timeToAtk = timeToAtk;
        this.currHP = maxHP;
    }

    /**
     * gets name of instructor
     * @return string of the instructor's name
     */
    public String getName() {
        return name;
    }

    /**
     * gets current hp of instructor
     * @return integer of current health points
     */
    public int getHP() {
        return currHP;
    }

    /**
     * gets a random attack amount between the minimum and maximum attack of instructor
     * @return random integer between min and max attack
     */
    public int getAtkAmount(){
        return (int) (Math.random() * (maxAtk - minAtk) + minAtk);

    }

    /**
     * gets time between each attack of instructor
     * @return integer of time
     */
    public int getTimeToAtk() {
        return timeToAtk;
    }

    /**
     * instructor takes damage from passed in param
     * @param dmg damage instructor will take
     */
    public void takeDamage(int dmg){
        this.currHP -= dmg;
    }

    /**
     * returns if instructor is still alive in fight
     * @return a boolean if instructor is alive or not.
     */
    public boolean isAlive(){
        if (currHP > 0){
            return true;
        }
        return false;
    }

    /**
     * resets the instructor's current hp to the max hp
     */
    public void resetHP(){
        this.currHP = this.maxHP;
    }

    /**
     * returns a boolean if two objects are identical
     * @param obj
     * @return a boolean if objects are equal
     */
    public boolean equals(Object obj) {
        if(!(obj instanceof Instructor))
        {
            return false;
        }
        Instructor i = (Instructor) obj;
        return this.maxAtk == i.maxAtk && this.minAtk == i.minAtk &&
                this.maxHP == i.maxHP && this.name.equals(i.name);
    }

    /**
     * will return a string of the instructor in a specific format
     * @return
     */
    public String toString(){
        return getName() + ": " + this.currHP + " hp, " + this.minAtk + " - " + this.maxAtk +
                " atk";
    }
}
