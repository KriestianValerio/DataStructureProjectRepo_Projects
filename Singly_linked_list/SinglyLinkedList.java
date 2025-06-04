package elice;
/**
 * A basic singly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class SinglyLinkedList<E> {
    //---------------- nested Node class ----------------
    /**
     * Node of a singly linked list, which stores a reference to its
     * element and to the subsequent node in the list (or null if this
     * is the last node).
     */
    private int rc_count = 0; //Do not modify this line of code.Do not use rc_count in your implementation for HW2.
    protected static class Node<E> {

        /** The element stored at this node */
        private E element; // reference to the element stored at this node

        /** A reference to the subsequent node in the list */
        private Node<E> next; // reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e  the element to be stored
         * @param n  reference to a node that should follow the new node
         */
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        // Accessor methods
        /**
         * Returns the element stored at the node.
         * @return the element stored at the node
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         * @return the following node
         */
        public Node<E> getNext() {
            return next;
        }

        // Modifier methods
        /**
         * Sets the node's next reference to point to Node n.
         * @param n    the node that should follow this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    } //----------- end of nested Node class -----------

    // instance variables of the SinglyLinkedList
    /** The head node of the list */
    private Node<E> head = null; // head node of the list (or null if empty)

    /** The last node of the list */
    private Node<E> tail = null; // last node of the list (or null if empty)

    /** Number of nodes in the list */
    private int size = 0; // number of nodes in the list

    /** Constructs an initially empty list. */
    public SinglyLinkedList() {} // constructs an initially empty list

    // access methods
    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the first element of the list
     * @return element at the front of the list (or null if empty)
     */
    public E first() { // returns (but does not remove) the first element
        if (isEmpty()) return null;
        return head.getElement();
    }

    /**
     * Returns (but does not remove) the last element of the list.
     * @return element at the end of the list (or null if empty)
     */
    public E last() { // returns (but does not remove) the last element
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // update methods
    /**
     * Adds an element to the front of the list.
     * @param e  the new element to add
     */
    protected void addFirst(E e) { // adds element e to the front of the list
        head = new Node<> (e, head); // create and link a new node
        if (size == 0)
            tail = head; // special case: new node becomes tail also
        size++;
    }

    /**
     * Adds an element to the end of the list.
     * @param e  the new element to add
     */
    public void addLast(E e) { // adds element e to the end of the list
        Node<E> newest = new Node<> (e, null); // node will eventually be the tail
        if (isEmpty())
            head = newest; // special case: previously empty list
        else
            tail.setNext(newest); // new node after existing tail
        tail = newest; // new node becomes the tail
        size++;
    }

    /**
     * Removes and returns the first element of the list.
     * @return the removed element (or null if empty)
     */
    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) return null; // nothing to remove
        E answer = head.getElement();
        head = head.getNext(); // will become null if list had only one node
        size--;
        if (size == 0)
            tail = null; // special case as list is now empty
        return answer;
    }

    /* # 3 */
    // Implement the method that removes and returns the last element of the linked list
    // If thet list is empty, it returns null.
    public E removeLast() {
        // Implement here
        if(isEmpty()){
            return null;
        }
        Node<E> current = head;
        while(current.getNext() != tail) {
            current = current.getNext();
        }

        E lastelement = tail.getElement();
        current.setNext(null);
        tail=current;
        size--;
        return lastelement;
    // Placeholder return statement. Replace it with your own implementation.
    }

    
    /* # 4 */
    // Recursive search in a linked list
    /*
     * In the recursive helper method,
     * If there is no such an element we are looking for, return false.
     * If a node has the element, return true.
     * For recursion implementation, call the method contains_rc(next node, element).
     */
    public boolean contains_rc(E element) {
        // Implement here
        return contains_rc(head, element);

        
         // Placeholder return statement. Replace it with your own implementation.
    }

    
    
    // Recursive helper method with additional parameters
    //The access modifier 'protected' is used only for the automatic detection of whether you use recursion or not. 
    //If you do not use recursion correctly, you will get a zero automatically.
    protected boolean contains_rc(Node<E> walk, E element) {
        // Implement here
        // Your implementation should not modify the original linked list.
        if (walk == null) {
            return false;
        }
        if (walk.getElement().equals(element)) {
            return true;
        }
        return contains_rc(walk.getNext(), element);
        // Placeholder return statement. Replace it with your own implementation.
    }
    
    /* #5 */ 
    // Print elements from the last node to the first node, using recursion
    //Do not modify the reverseDisplay() method
    public void reverseDisplay(){
        reverseDisplay_rc(head);
    }
    
    // Recursive helper method with additional parameters
    //The access modifier 'protected' is used only for the automatic detection of whether you use recursion or not. 
    //If you do not use recursion correctly, you will get a zero automatically.
    protected void reverseDisplay_rc(Node<E> node){
        //implement here
        // Your implementation should not modify the original linked list.
       if(node==null){
           return;
       }

       reverseDisplay_rc(node.getNext());
        System.out.print(node.element+" "); //Use this print statement
    }

    /* # 6 */
    // Implement the method that counts the number of times a particular value appears in the list
    public int count(E element) {
        // Implement here
        if (isEmpty()) {
            return 0;
        }
        E checkedelement = removeFirst();
        int counted = count(element);
        
        addFirst(checkedelement);

        if (checkedelement.equals(element)){
            return counted+1;
        } else {
            return counted;
        }
         // Placeholder return statement. Replace it with your own implementation.
    }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     * Please do not change this method.
     */
    public String toString() {
       String s = "";
        for(Node<E> x = head; x!= null; x = x.next) 
		    s +=x.element+" ";
        return s;
    }
    
    /* Please do not change this method. */
    /* Do not use this method in your implementation for HW2 */
    public int recCount() {
        return rc_count;
    }
}
