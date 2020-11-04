/**
 *
 *
 * @author Chase Lewis
 *
 */
public class LinkedList {
    /**
     * Will hold the Node at the head, or front, of the linked list
     */
    private Node head;

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
    public Node getHead(){
        return this.head;
    }

    /**
     *
     * @param index of the Node of the value to be returned
     * @return the value of Node at the provided index in the linked list
     */
    public Integer valueAt(int index){
        Node current = this.head;
        for (int i = 0; i < index; i++){
            current = current.getNext();
        }
        return current.getValue();
    }

    /**
     * returns the size of the linked list
     *
     * @return the number of nodes in the linked list
     */
    public int size(){
        Node current = this.head;
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
    public void insertAt(int value, int index){
        Node current = this.head;
        if (index == 0){
            this.head = new Node(value, current);
        }
        else if(this.head != null){
            for (int i =0; i < index-1; i++){
                current = current.getNext();


            }
            Node NewNode = new Node(value, current.getNext());
            current.setNext(NewNode);
        }
    }

    /**
     * gets the node at the end of a linked list
     *
     * @return the node at the end of a linked list
     */
    public Node getTail(){
        Node curr = this.head;
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
        Node current = this.head;
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
    public void concat(LinkedList lst) {
        if (lst == null) {
            return;
        } else {
            Node curr = lst.getHead();
            LinkedList LL = new LinkedList();
            while (curr != null){
                Node n = new Node(curr.getValue());
                if (LL.getHead() == null){
                    LL.head = n;
                }
                else{
                    Node tail = LL.getTail();
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
    public LinkedList reverse() {
        LinkedList lst = this;
        if (lst == null) {
            return null;
        } else {
//            Node curr = lst.getTail();
            LinkedList LL = new LinkedList();

                for (int i = lst.size()-1; i >= 0; i--) {
                    Node n = new Node(lst.valueAt(i));
                    if (LL.getHead() == null) {
                        LL.head = n;
                    } else {
                        Node tail = LL.getTail();
                        tail.setNext(n);
                    }



            }
         return LL;
        }


    }

    public static void main(String[] args){
        LinkedList L = new LinkedList();
        L.insertAt(1,0);
        L.insertAt(10,1);
        L.insertAt(6,2);
        L.insertAt(3,3);
        L.insertAt(4,4);
        L.removeAt(0);
        LinkedList P = new LinkedList();
        P.insertAt(2,0);
        P.insertAt(1,1);
        P.insertAt(5,2);
        LinkedList k = P.reverse();
        System.out.println(P);
    }

}
