import java.util.Comparator;

/**
 *Student class uses the Compararble interface
 *
 * @author Chase Lewis
 */
public class Student implements Comparable<Student> {

    /**
     * string to represent the first name of a student
     */
    private String FirstName;

    /**
     * string to represent the last name of a student
     */
    private String LastName;

    /**
     * string to represent the username of a student
     */
    private String userID;

    /**
     *
     * integer to represent a student number
     */
    private int SNum;

    /**
     * double to represent the gpa of a student
     */
    private double gpa;

    /**
     * construct to take information of a student
     *
     * @param FirstName  a stringfirst name of student
     * @param LastName a stringlast name of student
     * @param userID a string username of student
     * @param SNum  an integer student number of student
     * @param gpa   a double gpa of student
     */
    public Student(String FirstName, String LastName, String userID, int SNum, double gpa){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.userID = userID;
        this.SNum = SNum;
        this.gpa = gpa;
    }

    /**
     * getter function to get first name of student
     * @return first name of student
     */
    public String getFirstName(){
        return this.FirstName;
    }

    /**
     * getter function to get last name of student
     * @return last name of student
     */
    public String getLastName(){
        return this.LastName;
    }

    /**
     * getter function to get user name of student
     * @return user name of student
     */
    public String getUserID(){
        return this.userID;
    }

    /**
     * getter function to get student number
     * @return first name of student
     */
    public int getSNum(){
        return this.SNum;
    }

    /**
     * getter function to get gpa of student
     * @return gpa of student
     */
    public double getGpa(){
        return this.gpa;
    }


    /**
     * turn take in a student and represent their information in string format
     * @return a string of the student and his/her information
     */
    public String toString() {
        return "Student " + this.SNum + ":" + " " + this.FirstName + " " + this.LastName + ", " +
                this.userID + ", " + this.gpa;
    }

    /**
     * will determine that two students are equal if their numbers
     * are equal.
     *
     * @param o student object
     * @return boolean if they're equal
     */
    public boolean equals(Object o){
        if (!(o instanceof Student))
            return false;
        else if (this.SNum == ((Student) o).SNum){
            return true;
        }
        return false;
    }

    /**
     * will order students by last then first name alphabetically
     *
     * @param o object of student
     * @return integer presenting which is greater or less
     */
    public int compareTo(Student o) {
        if (this.LastName.compareTo(o.LastName) == 0){
            int result = this.FirstName.compareTo(o.FirstName);
            return result;
        }
        else{
            return this.LastName.compareTo(o.LastName);
        }
    }

    /**
     *will hash the student based on hashing their user name.
     *
     * @return integer for hash of the user name
     */
    public int hashCode() {
        return userID.hashCode();
    }
}

/**
 * comparator for the ordering of the gpa
 *
 */
class GPA_Comparator implements Comparator<Student>{

    /**
     * compares two students based on gpa
     *
     * @param o1 first student object
     * @param o2 second student object
     * @return
     */
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getGpa() < o2.getGpa()){
            return -1;
        }
        else if (o1.getGpa() > o2.getGpa()){
            return 1;
        }
        else{
            return 0;
        }
    }
}

/**
 * Compparator for the ordering of students based on their student number
 *
 */
class Number_Comparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getSNum() - o2.getSNum();
    }


}