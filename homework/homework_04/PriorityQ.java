// priorityQ.java
// demonstrates priority queue
// to run this program: C>java PriorityQApp
////////////////////////////////////////////////////////////////
class PriorityQ extends Heap
{
// array in sorted order, from max at 0 to min at size-1
private int maxSize;
private Heap queArray;
private int nItems;
//-------------------------------------------------------------
public PriorityQ(int s) // constructor
{
super(100);

maxSize = s;
queArray = new Heap(s);
nItems = 0;

}
//-------------------------------------------------------------
public void insert(Node item) // insert item
{
	queArray.insert( item.getKey() );
}// end insert()
//-------------------------------------------------------------
public Node remove() // remove minimum item
{ 
	return queArray.remove();
 }
//-------------------------------------------------------------


public void peek() // peek at minimum item
{ 
	queArray.displayHeap();

}

//-------------------------------------------------------------
public boolean isEmpty() // true if queue is empty
{ return (nItems==0); }
//-------------------------------------------------------------
public boolean isFull() // true if queue is full
{ return (nItems == maxSize); }
//-------------------------------------------------------------

public static void main (String[] args){

}

} // end class PriorityQ
////////////////////////////////////////////////////////////////
class PriorityQApp
{
public static void main(String[] args) 
{

System.out.println("Hello, starting the PriorityQ");
PriorityQ thePQ = new PriorityQ(5);
System.out.println("Testing Inserting: 1, 50, 10, 15, 20");
Node tester = new Node (1);
Node tester2 = new Node (50);
Node tester3 = new Node (10);
Node tester4 = new Node (15);
Node tester5 = new Node (20);


thePQ.insert(tester);
thePQ.insert(tester2);
thePQ.insert(tester3);
thePQ.insert(tester4);
thePQ.insert(tester5);

System.out.println("Printing Heap");

thePQ.peek();

System.out.println("Testing the remove fucntion");

Node removed = new Node(0);
removed = thePQ.remove();
System.out.println("Removed node");
removed=thePQ.remove();
thePQ.peek();
} // end main()
//-------------------------------------------------------------
} // end class PriorityQApp