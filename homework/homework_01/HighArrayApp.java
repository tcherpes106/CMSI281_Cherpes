public class HighArrayApp 
     {

     public static void main(String[] args)
          {
          int maxSize = 15; // array size
          HighArray arr; // reference to array
          arr = new HighArray(maxSize); // create the array

          arr.insert(77); // insert 10 items
          arr.insert(99);
          arr.insert(44);
          arr.insert(55);
          arr.insert(22);
          arr.insert(88);
          arr.insert(11);
          arr.insert(00);
          arr.insert(66);
          arr.insert(33);
          arr.insert(33);

          arr.display(); // display items
          arr.getMax();

          int searchKey = 35; // search for item
          if( arr.find(searchKey) )
               System.out.println("Found " + searchKey);
          else
               System.out.println("Can’t find " + searchKey);

          arr.delete(00); // delete 3 items
          arr.delete(55);
          arr.delete(99);

          arr.getMax();

          arr.display(); // display items again

          HighArray arr2 = new HighArray(6);

          arr2.insert(3);
          arr2.insert(1);
          arr2.insert(4);
          arr2.insert(3);
          arr2.insert(5);
          arr2.insert(3);
          


          System.out.println ("Begining Test Case: NODUPS:");
          System.out.println("");
          System.out.println("");
          System.out.println("");
          System.out.println("");

          arr2.noDups();





          } // end main()
     } // end class HighArrayApp
////////////////////////////////////////////////////////////////
