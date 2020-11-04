/**
 * The interface to implement the LinkedList versions
 * of a linked list, LinkedList
 *
 * @author Chase Lewis
 */
public interface ILinkedList<T> {


    /**
     *
     * @param index of the Node of the value to be returned
     * @return the value of Node at the provided index in the linked list
     */
    public T valueAt(int index);

    /**
     * will return the Node at the provided index in the linked list. If index is
     greater than the length of the linked list it will return null|.
     *
     * @param index the index where the node is at
     * @return the node at the index provided
     */
    public Node<T> nodeAt(int index);

    /**
     * returns the size of the linked list
     *
     * @return the number of nodes in the linked list
     */
    public int size();

    /**
     * inserts a value in a Node in the linked list at the provided index
     *
     * @param value The value to be inserted
     * @param index The index at which the provided value will be inserted
     */
    public void insertAt(T value, int index);

    /**
     * gets the node at the end of a linked list
     *
     * @return the node at the end of a linked list
     */
    public Node<T> getTail();

    /**
     * removes a Node value in a linked list at an idex
     *
     * @param index the index at which the Node in the linked list will be removed at
     */
    public void removeAt(int index);

    /**
     * Will make a copy of the nodes of lst and
     * add them to the end of it’s linked list
     *
     * @param lst linked list that is passed into the function
     */
    public void concat(LinkedList<T> lst);

    /**
     * Will construct a new LinkedList in the reserve
     * order
     *
     * @return a linked list of the reverse form of a linked list passed into it
     */
    public LinkedList<T> reverse();
}
