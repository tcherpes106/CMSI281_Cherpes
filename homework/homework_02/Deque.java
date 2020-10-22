public class Deque {
    private int maxSize;
    private long[] dequeArray;
    private int front;
    private int rear;
    private int nItems;

    /**
     * Constructor
     * @param int x maximum size of queue
     */
    public Deque( int x ) {
        maxSize = x;
        dequeArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * Inserts item at front of deque
     * @param long value to insert
     */
    public void insertLeft( long j ) {
        if ( front == 0 ) {
            front = maxSize;
        }
        dequeArray[--front] = j;
        nItems++;
    }

    /**
     * Inserts item at rear of deque
     * @param long value to insert
     */
    public void insertRight( long j ) {
        if ( rear == maxSize-1 ) {
            rear = -1;
        }
        dequeArray[++rear] = j;
        nItems++;
    }

    /**
     * Removes item at front of deque
     * @return long value removed
     */
    public long removeLeft() {
        long temp = dequeArray[front++];
        if ( front == maxSize ) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    /**
     * Removes item at rear of deque
     * @return long value removed
     */
    public long removeRight() {
        long temp = dequeArray[rear--];
        if ( rear == -1 ) {
            rear = maxSize-1;
        }
        nItems--;
        return temp;
    }

    /**
     * Retruns true if deque is empty and false otherwise
     * @return boolean true if deque is empty and false otherwise
     */
    public boolean isEmpty() {
        return ( nItems == 0 );
    }

    /**
     * Retruns true if deque is full and false otherwise
     * @return boolean true if deque is full and false otherwise
     */
    public boolean isFull() {
        return ( nItems == maxSize );
    }

    /**
     * Displays elements in the deque from front to rear
     */
    public void display() {
        int index = front;
        for ( int count = 0; count < nItems; count++ ) {
            System.out.print( dequeArray[index] + " " );
            if ( index == maxSize - 1 ) {  
                index = 0;
            }
            else {
                index++;
            }
        }
        System.out.println();
    }

    /**
     * Main to test methods
     */
    public static void main( String args[] ) {
        Deque theDeque = new Deque( 8 );

        System.out.println( ">>>>> Test for insertRight <<<<<");
        theDeque.insertRight( 1 );
        System.out.println( "   Inserting 1" );
        theDeque.insertRight( 2 );
        System.out.println( "   Inserting 2" );
        theDeque.insertRight( 3 );
        System.out.println( "   Inserting 3" );
        theDeque.insertRight( 4 );
        System.out.println( "   Inserting 4" );
        System.out.print( "   Deque: ");
        theDeque.display();
        System.out.println();

        System.out.println( ">>>>> Test for insertLeft <<<<<");
        theDeque.insertLeft( 10 );
        System.out.println( "   Inserting 10" );
        theDeque.insertLeft( 20 );
        System.out.println( "   Inserting 20" );
        theDeque.insertLeft( 30 );
        System.out.println( "   Inserting 30" );
        theDeque.insertLeft( 40 );
        System.out.println( "   Inserting 40" );
        System.out.print( "   Deque: ");
        theDeque.display();
        System.out.println();

        System.out.println( ">>>>> Test for removeLeft and removeRight <<<<<");
        theDeque.removeLeft();
        System.out.println( "   Removing left" );
        System.out.print( "   Deque: ");
        theDeque.display();
        theDeque.removeLeft();
        System.out.println( "   Removing left" );
        System.out.print( "   Deque: ");
        theDeque.display();
        theDeque.removeRight();
        System.out.println( "   Removing right" );
        System.out.print( "   Deque: ");
        theDeque.display();
        theDeque.removeRight();
        System.out.println( "   Removing right" );
        System.out.print( "   Deque: ");
        theDeque.display();
        System.out.println();

        System.out.println( ">>>>> Test for isEmpty and isFull <<<<<");
        System.out.print( "   Deque: ");
        theDeque.display();
        System.out.println( "   Is deque empty: " + theDeque.isEmpty() );  //false
        System.out.println( "   Is deque full: " + theDeque.isFull() );   //false
        System.out.println( "   Inserting 4 values" );
        theDeque.insertLeft( 123 );
        theDeque.insertRight( 321 );
        theDeque.insertLeft( 11111 );
        theDeque.insertRight( 5 );
        System.out.print( "   Deque: ");
        theDeque.display();
        System.out.println( "   Is deque full: " + theDeque.isFull() );   //true
        System.out.println( "   Removing all values." );
        theDeque.removeRight();
        theDeque.removeRight();
        theDeque.removeRight();
        theDeque.removeRight();
        theDeque.removeRight();
        theDeque.removeRight();
        theDeque.removeRight();
        theDeque.removeRight();
        System.out.print( "   Deque: ");
        theDeque.display();
        System.out.println( "   Is deque empty: " + theDeque.isEmpty() );  //true
    }
}
