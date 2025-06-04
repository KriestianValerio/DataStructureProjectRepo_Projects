package elice;

import java.util.*;

public class StackNode<E> implements Stack<E>, Iterable<E> {
    private Node<E> first;     // top of stack
    private int n;                // size of the stack

    // helper linked list class
    private static class Node<E> {
        
		private E item;
        private Node<E> next;
        }
    
    /**
     * Initializes an empty stack.
     */
    public StackNode() {
        first = null;
        n = 0;
    }
    
    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    @Override //Annotation tells Java that we implement the method specified in API.
    public boolean isEmpty() {
        return (first == null);
    }

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
     @Override //Annotation tells Java that we implement the method specified in API.
    public int size() {
        return n;
    }

    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
     @Override //Annotation tells Java that we implement the method specified in API.
    public void push(E item) {
    //insert a new node at the beginning of the list.
        Node<E> oldfirst = first;
        first = new Node<E>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * return null if this stack is empty
     */
     @Override //Annotation tells Java that we implement the method specified in API.
    public E pop() {
        if (isEmpty()) return null;
        //Remove the first node from the list and return item.
        E item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * Return null, if this stack is empty
     */
     @Override //Annotation tells Java that we implement the method specified in API.
    public E top() {
        if (isEmpty()) return null;
        return first.item;
    }
    
    public void traverse() {
    	for (Node x = first; x != null; x = x.next) 
    	    System.out.println(x.item);
    }
    
    /**
   * Returns an iterator to this stack that iterates through the items in LIFO order.
   *
   * @return an iterator to this stack that iterates through the items in LIFO order
   */
  public Iterator<E> iterator() {
      return new ListIterator(first);
  }
  //HW3 #4
  private class ListIterator implements Iterator<E> {
      private Node<E> current;

      public ListIterator(Node<E> first) {
      //implement here
        this.current = first;
          
      }

      public boolean hasNext() {
      //implement here
        return current != null;
          
      }

      public void remove() {
          throw new UnsupportedOperationException();
          
      }

      public E next() {
      //implement here
            E element = current.item;
          current = current.next;
          return element;
      }
    }
   
   //DO NOT MODIFY the following code
   public static void main(String[] args){
   StackNode<Integer> list1 = new StackNode<Integer>();
   Scanner input = new Scanner(System.in);
   int num = input.nextInt();
   int data;
   
   for(int i=0; i<num;i++){
        data = (int)(Math.random()*10)+2;
        System.out.println("Push "+data);
        list1.push(data);
   }
   for(Integer n:list1)
        System.out.println(n);
  }
    
}
    
    