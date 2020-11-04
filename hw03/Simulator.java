import java.util.*;

/**
 * The simulator class only has a main method
 *
 * @author Chase Lewis
 */
public class Simulator {

    public static void main(String[] args) {
        TreeSet<Student> a = new TreeSet<>(new GPA_Comparator());
        TreeSet<Student> Nat = new TreeSet<>(Comparator.naturalOrder());
        TreeSet<Student> Num = new TreeSet<>(new Number_Comparator());
        HashSet<Student> user = new HashSet<>();
        Student Chris = new Student("Chris", "Jackson", "clj", 425, 3.620000  );
        Student Chase = new Student("Charles", "Lewis", "cjl", 609, 3.950000  );
        Student Zoe = new Student("Zoe", "Lett", "zrl", 205, 2.300000  );
        Student Scott = new Student("Scott", "Johnson", "scj", 123, 3.250000  );
        Student Jansen = new Student("Jansen", "Orfan", "jro", 345, 3.050000  );
        a.add(Chris);
        a.add(Chase);
        a.add(Zoe);
        a.add(Scott);
        a.add(Jansen);
        Nat.add(Chris);
        Nat.add(Chase);
        Nat.add(Zoe);
        Nat.add(Scott);
        Nat.add(Jansen);
        Num.add(Chris);
        Num.add(Chase);
        Num.add(Zoe);
        Num.add(Scott);
        Num.add(Jansen);
        user.add(Chris);
        user.add(Chase);
        user.add(Zoe);
        user.add(Scott);
        user.add(Jansen);
//        System.out.println(a);
//        System.out.println(Nat);
//        System.out.println(Num);
//        System.out.println(user);
        Collection<Student> coll = Nat;
        Iterator<Student> iter = coll.iterator();
        Collection<Student> aa = a;
        Iterator<Student> aIter = aa.iterator();
        Collection<Student> NumNum = Num;
        Iterator<Student> NumIter = NumNum.iterator();
        Collection<Student> Useruser = user;
        Iterator<Student> UserIter = Useruser.iterator();
        while(iter.hasNext()){
            Student nxt = iter.next();
            System.out.println("Adding: " + nxt.toString() + "\n");
            //System.out.println("Adding: " + "Student " + nxt.getSNum() + ": " + nxt.getFirstName() + " " + nxt.getLastName()
            //+ ", " + nxt.getUserID() + ", " + nxt.getGpa());
        }
        Collection<Student> collect = Nat;
        Iterator<Student> colliter = collect.iterator();
        int i = 0;
        while(aIter.hasNext()){
            Student natural = colliter.next();
            Student gpa = aIter.next();
            Student number = NumIter.next();
            Student userid = UserIter.next();
            System.out.println("Students at slot " + i + ":" );
            i++;
            System.out.println("Natural: " + natural.toString());
            System.out.println("GPA: " + gpa.toString());
            System.out.println("Number: " + number.toString());
            System.out.println("Hash: " + userid.toString() + "\n");

        }

        }
    }


