// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
import java.util.*;
import java.util.stream.*;
import java.util.Arrays;
import java.util.LinkedHashSet;


public class HighArray
     {
     private long[] a; // ref to array a
     private int nElems; // number of data items
     //-----------------------------------------------------------
     public HighArray(int max) // constructor
          {
          a = new long[max]; // create the array
          nElems = 0; // no items yet
          }
     //-----------------------------------------------------------
     public boolean find(long searchKey)
          { // find specified value
          int j;
          for(j=0; j<nElems; j++) // for each element,
               if(a[j] == searchKey) // found item?
                    break; // exit loop before end
     if(j == nElems) // gone to end?
          return false; // yes, can’t find it
     else
          return true; // no, found it
     } // end find()
//-----------------------------------------------------------
     public void insert(long value) // put element into array
          {
          a[nElems] = value; // insert it
          nElems++; // increment size
          }
//-----------------------------------------------------------
     public boolean delete(long value)
          {
          int j;
          for(j=0; j<nElems; j++) // look for it
               if( value == a[j] )
                    break;
          if(j==nElems) // can’t find it
               return false;
          else // found it
               {
               for(int k=j; k<nElems; k++) // move higher ones down
                    a[k] = a[k+1];
               nElems--; // decrement size
               return true;
               }
          } // end delete()
//-----------------------------------------------------------
     public void display() // displays array contents
          {
          for(int j=0; j<nElems; j++) // for each element,
               System.out.print(a[j] + " "); // display it
          System.out.println("");
          }
//-----------------------------------------------------------
     public void getMax()
          {
          long max = 0;
          int j;

          if (a == null)
               max = 0;

          if (a.length == 0)
               max = 0;

          for(j=0; j<nElems; j++)
               if(a[j] >= max)
                    max = a[j];
          System.out.println(max);
          } // end getMax()

//-----------------------------------------------------------
     public void noDups()
     {
          Set<Long>set = new HashSet<Long>();
          for( int i = 0; i < a.length; i++ ) {
               set.add( Long.valueOf( a[i] ) );
          }

          int i = 0;
          for(Long l : set){
           a[i++] = l.longValue();
          }

          nElems = set.size();
     }
//Array.sort, will sort the array
//Hash Set, only takes objects, cant pass in an int.
//put a value of ex) -999
//keep track of the size of the thing in array, keep track of the zeros

     } // end class HighArray
////////////////////////////////////////////////////////////////
