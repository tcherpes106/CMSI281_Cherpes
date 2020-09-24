class HighArrayApp
     {
     public static void main(String[] args)
          {
          int maxSize = 100; // array size
          HighArray arr; // reference to array
          arr = new HighArray(maxSize); // create the array

          System.out.println("\n" + "Welcome to HighArrayApp!");
          System.out.println("Adding numbers to the array..." + "\n");
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
          arr.insert(33);
          arr.insert(33);

          System.out.println("Current array is: ");
          arr.display(); // display items

          System.out.println("\n" + "Current max value should report as 99.");
          System.out.println("Current max value is: ");
          arr.getMax();

          System.out.println("\n" + "Removing duplicates...");
          arr.noDups();
          System.out.println("\n" + "Current array is: ");
          arr.display(); // display items

          System.out.println("\n" + "Deleting certain items from array...");
          arr.delete(00); // delete 3 items
          arr.delete(55);
          arr.delete(99);

          System.out.println("\n" + "Current array is: ");
          arr.display(); // display items

          System.out.println("\n" + "Current max value should report as 88.");
          System.out.println("Current max value is: ");
          arr.getMax();

          System.out.println("\n" + "Adding numbers to the array...");
          arr.insert(500);
          arr.insert(821);
          arr.insert(500);
          arr.insert(821);
          arr.insert(500);
          arr.insert(97);

          System.out.println("\n" + "Current array is: ");
          arr.display(); // display items

          System.out.println("\n" + "Searching array for '35' - Should return false");
          int searchKey = 35; // search for item
          if( arr.find(searchKey) )
               System.out.println("Found " + searchKey);
          else
               System.out.println("Can not find " + searchKey);

          System.out.println("\n" + "Adding numbers to the array...");
          arr.insert(35);

          System.out.println("\n" + "Searching array for '35' - Should return true");
          searchKey = 35; // search for item
          if( arr.find(searchKey) )
               System.out.println("Found " + searchKey);
          else
               System.out.println("Can not find " + searchKey);


          System.out.println("\n" + "Current max value should report as 821.");
          System.out.println("Current max value is: ");
          arr.getMax();

          System.out.println("\n" + "Removing duplicates...");
          arr.noDups();
          System.out.println("\n" + "Current array is: ");
          arr.display(); // display items

          System.out.println("\n" + "Current max value should report as 821.");
          System.out.println("Current max value is: ");
          arr.getMax();

          System.out.println("\n" + "Removing all numbers from array...");
          arr.delete(0);
          arr.delete(33);
          arr.delete(97);
          arr.delete(66);
          arr.delete(500);
          arr.delete(821);
          arr.delete(22);
          arr.delete(88);
          arr.delete(11);
          arr.delete(44);
          arr.delete(77);
          arr.delete(35);

          System.out.println("\n" + "Current max value should report as 0. (Array is empty)");
          System.out.println("Current max value is: ");
          arr.getMax();

          System.out.println("\n" + "Adding numbers to the array...");
          arr.insert(1);

          System.out.println("\n" + "Current array is: ");
          arr.display(); // display items

          System.out.println("\n" + "Current max value should report as 1.");
          System.out.println("Current max value is: ");
          arr.getMax();

          System.out.println("\n" + "Adding numbers to the array...");
          arr.insert(1);
          arr.insert(2);

          System.out.println("\n" + "Current array is: ");
          arr.display(); // display items

          System.out.println("\n" + "Current max value should report as 2.");
          System.out.println("Current max value is: ");
          arr.getMax();

          System.out.println("\n" + "END OF PROGRAM");





          } // end main()
     } // end class HighArrayApp
////////////////////////////////////////////////////////////////
