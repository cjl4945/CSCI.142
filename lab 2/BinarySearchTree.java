/**
 * Description: Java program to represent a binary search with multiple methods
 *
 * @author Chase Lewis
 *
 */

public class BinarySearchTree {
    /**
     * The value of the binary tree
     */
    private int value;

    /**
     * The left child of current binary tree
     */
    private BinarySearchTree LeftChild;

    /**
     * The right child of the current binary tree
     */
    private BinarySearchTree RightChild;

    /**
     * This is a constructors that takes in one parameter, the value of the tree.
     * The left and right child states are null
     *
     * @param val is an integer passed in to represent the value of the tree
     */
    public BinarySearchTree(int val){
        this.value = val;
        this.LeftChild = null;
        this.RightChild = null;
    }

    /**
     * A constructer that takes in three parameters, a integer value, a binary tree left child,
     * and a binary tree right child
     *
     * @param val is an integer passed in to represent the value of the value
     * @param LeftChild represents the leftchild of the current tree
     * @param RightChild represents the rightchild of the current
     */
    public BinarySearchTree(int val, BinarySearchTree LeftChild, BinarySearchTree RightChild){
        this.value = val;
        this.LeftChild = LeftChild;
        this.RightChild = RightChild;
    }

    /**
     * This is a helper function that returns an integer
     *
     * @param tree binary search that is inputted into the helper function
     * @return an integer that represents the size of the tree
     */
    private int HelperGetSize(BinarySearchTree tree){
       int counter = 0;
       if (tree == null){
       return counter;
       }
       else{
           counter = HelperGetSize(tree.RightChild) + 1 + HelperGetSize(tree.LeftChild);
       }
       return counter;
    }
    public Integer size(){
       return HelperGetSize(this);
    }

    /**
     * This function uses the binary search tree and returns a height
     *
     * @return an integer of the height of the binary search tree
     */
    public int height(){
        int counter = 0;
        if (this.value == 0){
            return counter;
        }
        else{
            counter = this.RightChild.height() + 1 + this.LeftChild.height();
        }
        return counter;
    }

    /**
     * This function returns an in-order traversal of the tree.
     *
     * @return a call of the inOrder function
     */
    @Override
    public String toString(){
        return inOrder();

    }

    /**
     * This function determines if two Binary Search Trees are considered equal if all of
     * their traversal are equivalent
     *
     * @param o
     * @return true or false if all of the traversals are equivalent
     *
     */
    @Override
    public boolean equals(Object o){
        if (!(o instanceof BinarySearchTree)){
            return false;
        }
        BinarySearchTree ov = (BinarySearchTree) (o);
        return inOrder().equals(ov.inOrder()) && postOrder().equals(ov.postOrder())
                && preOrder().equals(ov.preOrder());
    }

    /**
     * Finds the value to the Binary Search Tree; returns true
     * if there, false otherwise.
     *
     * @param value this is the provided value to search for in the tree
     * @return true or false if the integer provided was found
     */
    public boolean find(int value){
        if (this.value == value){
            return true;
        }
        else if (this.value > value){
            if (this.RightChild == null){
              return false;
            }
            else{
                return  RightChild.find(value);
            }
        }
        else if (this.value < value){
            if (this.LeftChild == null){
                return false;
            }
            else{
                return LeftChild.find(value);
            }
        }
        return false;
    }

    /**
     * This a helper function for the function add that returns a tree
     *
     * @param tree a binary search that is provided
     * @param value an integer that is to be added to the tree
     * @return Binary search tree with the new added value
     */
    private BinarySearchTree addHelper(BinarySearchTree tree, int value) {
        if(tree == null){
            return new BinarySearchTree(value);
        }
        else if(value < tree.value){
             tree.LeftChild  = addHelper(tree.LeftChild, value);
        }
        else if(value > tree.value){
            tree.RightChild = addHelper(tree.RightChild,value);
        }
        // ignore duplicate items
        return tree;
    } // end private TreeNode insert(TreeNode tree, int d)

    /**
     * Adds the value to the Binary Search Tree; returns nothing.
     *
     * @param value a integer value that is to be added to the binary search tree
     */
    public void add(int value){
        BinarySearchTree tree = new BinarySearchTree(0);
        tree = addHelper(this,value);
    }

    /**
     * Tree traversal method
     *
     * @return returns a string of the in-order traversal of the tree.
     */
    public String inOrder(){
        String result = "";
        if (this.LeftChild != null){
            result += this.LeftChild.inOrder();
        }
        result += this.value + "";
        if (this.RightChild != null){
            result += this.RightChild.inOrder();
        }
        return result;
    }

    /**
     * Tree traversal method
     *
     * @return returns a string of the pre-order traversal of the tree.
     */
    public String preOrder(){
        String result = "";
        result += this.value + "";
        if (this.LeftChild != null){
            result += this.LeftChild.preOrder();
        }

        if (this.RightChild != null){
            result += this.RightChild.preOrder();
        }
        return result;
    }

    /**
     * Tree traversal method
     *
     * @return returns a string of the post-order traversal of the tree.
     */
    public String postOrder(){
        String result = "";
        if (this.LeftChild != null){
            result += this.LeftChild.postOrder();
        }

        if (this.RightChild != null){
            result += this.RightChild.postOrder();
        }
        result += this.value + "";
        return result;
    }


}
