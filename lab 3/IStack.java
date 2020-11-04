/**
 * The interface to implement the ArrayList versions
 * of a stack, ArrayListStack
 *
 * @author Chase Lewis
 */
public interface IStack<T>{
    /**
     * push the item on the top of the stack and return nothing
     *
     * @param item any variable value provided
     */

    public void push(T item);
    /**
     * Remove the item from the top of the stack and
     * returns nothing
     *
     */
    public void pop();

    /**
     * return the value at the top of the stack
     *
     * @return any variable value of the stack
     */
    public T top();

    /**
     * Will return the number of items in the stack as an integer
     *
     * @return an integer value of the size
     */
    public int size();
}
