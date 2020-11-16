/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  oddEvenSort.java
 *  Purpose       :  To practice using sorting systems and sorting by using the odd-even sort method
 *  @author       :  Timothy and Alex
 *  Date written  :  11/10/2020
 *  Description   :  To use this program, the user must type "java oddEvenSortApp"
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
class ArrayOddEven {
   private long[] a;                        // ref to array a
   private int nElems;                      // number of data items

   public ArrayOddEven(int max) {
      a = new long[max];
      nElems = 0;
   }

   public void insert(long value) {
      a[nElems] = value;
      nElems++;
   }

   public void display() {
      for(int j=0; j<nElems; j++)
         System.out.print(a[j] + " ");
      System.out.println("");
   }

   public void oddEvenSort() {
     int odd, even;
     for(int i = 0; i < nElems; i++){
     //boolean sorted = false;
     //while(!sorted){
       //sorted = true;
       for(odd = 1; odd < nElems; odd += 2){
         if(nElems > 3)
         if(a[odd] > a[odd + 1]){
         swap(odd, odd + 1);
         //sorted = false;
       }
     }
     for(even = 0; even < nElems; even += 2){
       if(a[even] > a[even + 1]){
         swap(even, even + 1);
         //sorted = false;
       }
     }
    }
   }

   private void swap(int one, int two) {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;
   }
}

class OddEvenSortApp {
   public static void main(String[] args) {
     System.out.println("\n-------Test 1-------\n");
      int maxSize = 100;
      ArrayOddEven arr;

      arr = new ArrayOddEven(maxSize);
      arr.insert(77);
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();

      arr.oddEvenSort();
      arr.display();

      System.out.println("\n-------Test 2-------\n");
      ArrayOddEven arr2 = new ArrayOddEven(maxSize);

      arr2.insert(124);
      arr2.insert(21);
      arr2.insert(02);
      arr2.insert(524);
      arr2.insert(213);
      arr2.insert(69);
      arr2.insert(25);
      arr2.insert(00);
      arr2.insert(01);

      arr2.display();

      arr2.oddEvenSort();
      arr2.display();

      System.out.println("\n-------Test 3-------");
      //test to make sure oddEvenSort works when less than 3 nElems
      ArrayOddEven arr3 = new ArrayOddEven(maxSize);

      arr3.insert(35);
      arr3.insert(07);

      arr3.display();

      arr3.oddEvenSort();
      arr3.display();

      System.out.println("\n-------Test 4-------");
      //already sorted
      ArrayOddEven arr4 = new ArrayOddEven(maxSize);
      arr4.insert(0);
      arr4.insert(01);
      arr4.insert(02);
      arr4.insert(03);
      arr4.insert(04);
      arr4.insert(05);
      arr4.insert(06);
      arr4.insert(07);
      arr4.insert(8);
      arr4.insert(9);

      arr4.display();

      arr4.oddEvenSort();
      arr4.display();
   }
}
