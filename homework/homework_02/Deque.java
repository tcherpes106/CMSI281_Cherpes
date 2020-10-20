public class Deque {
    private int maxSize;
    private long[] dequeArray;
    private int front;
    private int rear;
    private int nItems;

    /**
     * Constructor
     * @param int s maximum size of queue
     */
    public Deque( int s ) {
        maxSize = s;
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
        if ( rear == maxSize-1 ) { // deal with wraparound
            rear = -1;
        }
        dequeArray[++rear] = j;    // increment rear and insert
        nItems++;                // one more item
    }

    /**
     * Removes item at front of deque
     * @return long value removed
     */
    public long removeLeft() {
        long temp = dequeArray[front++]; // get value and increment front
        if ( front == maxSize ) {           // deal with wraparound
            front = 0;
        }
        nItems--;                         // one less item
        return temp;
    }

    /**
     * Removes item at rear of deque
     * @return long value removed
     */
    public long removeRight() {
        long temp = dequeArray[rear--]; // get value and increment front
        if ( rear == -1 ) {                 // deal with wraparound
            rear = maxSize-1;
        }
        nItems--;                         // one less item
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
            if ( index == maxSize - 1 ) {   // accounting for wraparound
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

        System.out.println( "---------------TESTING insertRight---------------");
        theDeque.insertRight( 10 );
        System.out.println( "   Inserting 10" );
        theDeque.insertRight( 20 );
        System.out.println( "   Inserting 20" );
        theDeque.insertRight( 30 );
        System.out.println( "   Inserting 30" );
        theDeque.insertRight( 40 );
        System.out.println( "   Inserting 40" );
        System.out.print( "   Deque: ");
        theDeque.display();
        System.out.println();

        System.out.println( "---------------TESTING insertLeft---------------");
        theDeque.insertLeft( 11 );
        System.out.println( "   Inserting 11" );
        theDeque.insertLeft( 22 );
        System.out.println( "   Inserting 22" );
        theDeque.insertLeft( 33 );
        System.out.println( "   Inserting 33" );
        theDeque.insertLeft( 44 );
        System.out.println( "   Inserting 44" );
        System.out.print( "   Deque: ");
        theDeque.display();
        System.out.println();

        System.out.println( "---------------TESTING removeLeft and removeRight---------------");
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

        System.out.println( "---------------TESTING isEmpty and isFull---------------");
        System.out.print( "   Deque: ");
        theDeque.display();
        System.out.println( "   Deque empty? " + theDeque.isEmpty() );  //false
        System.out.println( "   Deque full? " + theDeque.isFull() );   //false
        System.out.println( "   Inserting 4 values" );
        theDeque.insertLeft( 89 );
        theDeque.insertRight( 103 );
        theDeque.insertLeft( 7289 );
        theDeque.insertRight( 8 );
        System.out.print( "   Deque: ");
        theDeque.display();
        System.out.println( "   Deque full? " + theDeque.isFull() );   //true
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
        System.out.println( "   Deque empty? " + theDeque.isEmpty() );  //true
    }
}
