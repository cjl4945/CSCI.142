/**
 * This class is the creation of a node
 *
 * @author Chase Lewis
 *
 */
public class Node<T> {
    /**
     * the current value of the node
     */
    private T value;
    /**
     * the next nodes
     */
    private Node<T> next;

    /**
     * construct node and the node will get a value as
     * an integer
     *
     * @param value the value of the node
     */
    public Node(T value){
        this.value = value;
        this.next = null;
    }

    /**
     * construct a node object and the node will take in
     * a integer value and a next node
     *
     * @param value the current value of the node
     * @param next the next node
     */
    public Node(T value, Node<T> next){
        this.value = value;
        this.next = next;
    }

    /**
     * Get the value of the node
     *
     * @return the current value of the Node
     */
    public T getValue(){
        return this.value;
    }

    /**
     * get the next node in the linked list
     *
     * @return the next node
     */
    public Node<T> getNext(){
        return this.next;
    }

    /**
     *
     * @param next the next node
     */
    public void setNext(Node<T> next){
        this.next = next;
    }

}


