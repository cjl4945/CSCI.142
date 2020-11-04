/**
 * This class implenments the interface of IStack
 *
 * @author Chase Lewis
 *
 */
import java.util.ArrayList;

public class ArrayListStack<T> implements IStack<T> {

    /**
     * An empty array list is created as a state
     *
     */
    private ArrayList<T> list = new ArrayList<>();

    /**
     * Will return the number of items in the stack as an integer
     *
     * @return an integer value of the size of the list
     */
    public int size(){
        return list.size();
    }

    /**
     * return the value at the top of the stack
     *
     * @return any variable value of the stack
     */
    public T top(){
        return list.get(list.size()-1);
    }

    /**
     * Remove the item from the top of the stack and
     * return nothing
     *
     */
    public void pop(){
        list.remove(list.size()-1);

    }

    /**
     * push the item on the top of the stack and return nothing
     *
     * @param item any variable value provided
     */
    public void push(T item){
        list.add(item);
    }

    public static void main(String[] args) {
        ArrayListStack<Integer> lst = new ArrayListStack<>();
        lst.push(10);
        lst.push(22);
        lst.pop();
        lst.push(2);
        lst.push(13);
        lst.pop();
        lst.push(5);
        System.out.println(lst.size());
        System.out.println(lst.top());
        System.out.println(lst);
    }
}
