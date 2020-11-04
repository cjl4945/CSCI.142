import java.util.ArrayList;

/**
 *
 *
 * @author Chase Lewis
 *
 */
public class LinkedList<T> implements ILinkedList<T>{
    /**
     * Will hold the Node at the head, or front, of the linked list
     */
    private Node<T> head;

    //private ArrayList<T> list = new ArrayList<>();

    /**
     * Sets the head of the linked list to null
     */
    public LinkedList(){
        this.head = null;
    }

    /**
     *
     * @return the head of the linked list
     */
    public Node<T> getHead(){
        return this.head;
    }

    /**
     *
     * @param index of the Node of the value to be returned
     * @return the value of Node at the provided index in the linked list
     */
    public T valueAt(int index){
        if(index > size()-1){
            return null;
        }
        Node<T> current = this.head;
        for (int i = 0; i < index; i++){
            current = current.getNext();
        }
        return current.getValue();
    }

    /**
     * will return the Node at the provided index in the linked list. If index is
     greater than the length of the linked list it will return null|.
     *
     * @param index the index where the node is at
     * @return the node at the index provided
     */
    public Node<T> nodeAt(int index){ //Instructor added.
        if(index > size()-1){
            return null;
        }
        Node<T> current = this.head;
        for (int i = 0; i < index; i++){
            current = current.getNext();
        }
        return current;
    }

    /**
     * returns the size of the linked list
     *
     * @return the number of nodes in the linked list
     */
    public int size(){
        Node<T> current = this.head;
        int counter = 0;
        while (current != null){
            current = current.getNext();
            counter++;
        }
        return counter;
    }

    /**
     * inserts a value in a Node in the linked list at the provided index
     *
     * @param value The value to be inserted
     * @param index The index at which the provided value will be inserted
     */
    public void insertAt(T value, int index){
        Node<T> current = this.head;
        if (index == 0){
            this.head = new Node<>(value, current);
        }
        else if(this.head != null){
            for (int i =0; i < index-1; i++){
                current = current.getNext();


            }
            Node<T> NewNode = new Node<>(value, current.getNext());
            current.setNext(NewNode);
        }
    }

    /**
     * gets the node at the end of a linked list
     *
     * @return the node at the end of a linked list
     */
    public Node<T> getTail(){
        Node<T> curr = this.head;
        while (curr.getNext() != null){
            curr = curr.getNext();
        }
        return curr;
    }

    /**
     * removes a Node value in a linked list at an idex
     *
     * @param index the index at which the Node in the linked list will be removed at
     */
    public void removeAt(int index){
        Node<T> current = this.head;
        if (current == null){
            return;
        }
        else if(index ==0){
            this.head = current.getNext();
        }
        else{
            for (int i=0; i < index-1; i++ ) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
    }

    /**
     * Will make a copy of the nodes of lst and
     * add them to the end of it’s linked list
     *
     * @param lst linked list that is passed into the function
     */
    public void concat(LinkedList<T> lst) {
        if (lst == null) {
            return;
        } else {
            Node<T> curr = lst.getHead();
            LinkedList<T> LL = new LinkedList<>();
            while (curr != null){
                Node<T> n = new Node<>(curr.getValue());
                if (LL.getHead() == null){
                    LL.head = n;
                }
                else{
                    Node<T> tail = LL.getTail();
                    tail.setNext(n);
                }
                curr = curr.getNext();
            }
            this.getTail().setNext(LL.getHead());
        }

    }

    /**
     * Will construct a new LinkedList in the reserve
     * order
     *
     * @return a linked list of the reverse form of a linked list passed into it
     */
    public LinkedList<T> reverse() {
        LinkedList<T> lst = this;
        if (lst == null) {
            return null;
        } else {
//            Node curr = lst.getTail();
            LinkedList<T> LL = new LinkedList<>();

            for (int i = lst.size()-1; i >= 0; i--) {
                Node<T> n = new Node<>(lst.valueAt(i));
                if (LL.getHead() == null) {
                    LL.head = n;
                } else {
                    Node<T> tail = LL.getTail();
                    tail.setNext(n);
                }



            }
            return LL;
        }


    }

    public static void main(String[] args){
        LinkedList<String> L = new LinkedList<>();
        L.insertAt("hi",0);
        L.insertAt("bye",1);
        L.insertAt("don't",2);
        L.insertAt("b",3);
        L.insertAt("n",4);
        L.removeAt(0);
        LinkedList<String> P = new LinkedList<>();
        P.insertAt("h",0);
        P.insertAt("j",1);
        P.insertAt("k",2);
        LinkedList<String> k = P.reverse();
        System.out.println(P);
    }

}
