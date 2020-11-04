/**
 * This class implenments the interface of IQueue
 *
 * @author Chase Lewis
 *
 */

import java.util.ArrayList;

public class ArrayListQueue<T> implements IQueue<T> {

    /**
     * An empty array list is created as a state
     *
     */
    private ArrayList<T> list = new ArrayList<>();

    /**
     * Will return the number of items in the queue as an integer
     *
     * @return an integer value of the size of the list
     */
    public int size(){
        return list.size();
    }

    /**
     * returns the value at the front of the queue
     *
     * @return what ever the variable is, it will
     * return that variable value of the front of the queue
     */
    public T front(){
        return list.get(list.size()-1);
    }

    /**
     * returns the value at the back of the queue of the queue
     *
     * @return what ever the variable is, it will
     * return that variable value of the back of the queue
     */
    public T back(){
        return list.get(0);
    }

    /**
     * returns the item from the front of the queue of the queue and returns nothing
     *
     */
    public void dequeue(){
        list.remove(list.size()-1);
    }

    /**
     * Puts the item on the back of the queue of the queue and returns nothing
     *
     * @param item any item that is provided to be put into the queue
     */
    public void enqueue(T item){
        list.add(0,item);
    }

}
