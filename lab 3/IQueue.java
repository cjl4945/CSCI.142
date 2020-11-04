/**
 * The interface to implement the ArrayList versions
 * of a queue, ArrayListQueue
 *
 * @author Chase Lewis
 */
public interface IQueue<T> {

    /**
     * Will return the number of items in the queue as an integer
     *
     * @return an integer value of the size of the list
     */
    public int size();

    /**
     * returns the value at the front of the queue
     *
     * @return what ever the variable is, it will
     * return that variable value of the front of the queue
     */
    public T front();

    /**
     * returns the value at the back of the queue
     *
     * @return what ever the variable is, it will
     * return that variable value of the back of the queue
     */
    public T back();

    /**
     * returns the item from the front of the queue and returns nothing
     *
     */
    public void dequeue();
    /**
     * Puts the item on the back of the queue and returns nothing
     *
     * @param item any item that is provided to be put into the queue
     */
    public void enqueue(T item);
}
