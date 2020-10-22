public class CircularList {
    private Node current;
    private int  size;

    /**
     * Constructor
     */
    public CircularList() {
        current = null;
        size = 0;
    }

    /**
     * Internal class that creates node object
     */
    private class Node {

       int data;
       Node next;

       /**
        * Constructor
        * @param int value node will contain
        */
       Node( int d ) {
          data = d;
          next = null;
       }
    }

    /**
     * Moves current to next node
     */
     public void step() {
        current = current.next;
     }

    /**
     * Insert value at given index
     * @param int value to insert
     */
    public void insert( int value ) {
        Node newNode = new Node( value );

        if ( size == 0 ) {
            current = newNode;
            newNode.next = newNode;
        }
        else {
            newNode.next = current.next;
            current.next = newNode;
            current = newNode;
        }

        size++;
    }


    /**
     * Search for value in the list
     * @param int value to search for
     * @return boolean true if value was found, false otherwise
     */
    public boolean find( int value ) {
        Node currentPointer = current;
        for ( int i = 0; i < size; i++ ) {
            if ( current.data == value ) {
                current = currentPointer;
                return true;
            }
            step();
        }
        current = currentPointer;
        return false;
    }

    /**
     * Remove value from list
     * @param int value to deletion
     */
    public void deletion( int value ) {
        Node currentPointer = current;
        for ( int i = 0; i < size; i++ ) {
            if ( current.next.data == value ) {
                if ( current.next.data == currentPointer.data ) {
                    currentPointer = current;
                }
                current.next = current.next.next;
                size--;
            }
            step();
        }
        current = currentPointer;
    }

    /**
     * Returns string representation of list where first inserted is first in string
     * @return String representing the list
     */
    public String toString() {
        String stringRepresenation = "";
        for ( int i = 0; i < size; i++ ) {
            step();
            stringRepresenation += current.data + " ";
        }
        return stringRepresenation;
    }

    /**
     * Return value at current node
     * @return int value at current node
     */
    public int getCurrentValue() {
        return current.data;
    }

    /**
     * Main used for testing
     */
    public static void main ( String args[] ) {

        CircularList theList = new CircularList();

        System.out.println( ">>>>> Test for insert <<<<<");
        System.out.println( "   Inserting 5" );
        theList.insert( 5 );
        System.out.println( "   Inserting 10" );
        theList.insert(  10 );
        System.out.println( "   Inserting 15" );
        theList.insert( 15 );
        System.out.println( "   Inserting 20" );
        theList.insert( 20 );
        System.out.println( "   The list: " + theList.toString() );

        System.out.println( ">>>>> Test for find <<<<<");
        System.out.println( ( theList.find( 5 ) ) ? "   Found 5" :  "   Could not find 5" );
        System.out.println( ( theList.find( -5 ) ) ? "   Found -5" :  "   Could not find -5" );
        System.out.println( ( theList.find( 20 ) ) ? "   Found 20" :  "   Could not find 20" );

        System.out.println( ">>>>> Test for deletion <<<<<");
        System.out.println( "   The list: " + theList.toString() );
        theList.deletion( 5 );
        System.out.println( "   The list without 5: " + theList.toString() );
        theList.deletion( 20 );
        System.out.println( "   The list without 20: " + theList.toString() );
        theList.deletion( 25 );
        System.out.println( "   The list without 25: " + theList.toString() );
    }
}
