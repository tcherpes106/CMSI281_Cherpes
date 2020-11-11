// Accept a piece of text, potentiall more than 1 line DONE
//count number of occurances, put into an array list
//prioity queue to help sure most frequent values used
//create huffman tree based off of the values in the arraylist
//create the code table for your text
//encode the message, display it on the screen
//using the hiffman tree, decode the message and redisplay it on the screen

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class HuffmanTree {

	// create indiviudal nodes to later use in the arraylist/ tree
	 public class Huffnode  implements Comparable<Huffnode> {

		public int value;
		public int count;
		public Huffnode leftNode;
		public Huffnode rightNode;

		//constructor to create Hnodes
		public  Huffnode (int val, int cnt, Huffnode left, Huffnode right){

			value=val;
			count=cnt;
			leftNode=left;
			rightNode=right;
		}

		public int compareTo(Huffnode hf){

			int retVal = count - hf.count;
			return retVal;
		}
	}

	// THIS should create an arrayList from the String given by user, 
	public ArrayList compress (String textString) {
		ArrayList <Huffnode> txtFile = new ArrayList<Huffnode>(56);
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ., \n";
		
		//populates the arraylist with the characters needed
		for (int j = 0; j < 56; j ++) {
			txtFile [j] = new Huffnode (alphabet.charAt(j),0,count,count);

			//counts the characters for the array list
			for (int i =1 ; i< textString.length(); i++) {
				if (textString.charAt(i).equals(txtFile[j].value)){
					txtFile[j].count ++;
				}
			}
		}
		//deletes any unused characters
		for (int a =0; a<56; a++){
			if (txtFile[a].count == 0){
				txtFile.remove(a);
			}
		}
		return txtFile;

		//make sure to sort in here
	}

	//build the tree
	
	public void huffTree (ArrayList charNodes) {
		PriorityQueue<Huffnode> tree = new PriorityQueue<Huffnode>(charNodes.length);
		for (int i = 0; i< charNodes.length-1; i++){
			for (int j = 1; j< charNodes.length-2; j++){
				if (charNodes[i].compareTo(charNodes[j])>0){
					tree.add(charNodes[i]);
				}
			}
		}
	}
	
	//scanner doesnt properly access all of the lines, skips line 3
	public static void main (String [] args) {
		System.out.println("Hello, welcome to the Huffman project.");
		System.out.println("This code will be effective in transfering your text in a more efficient manner.");
		System.out.println("Please insert your text:");
		Scanner sc = new Scanner (System.in);
		String inputText = "";
		int counter = 0;
		inputText += sc.nextLine();
		
		while (counter ==0){
		System.out.println("(Did you want another line? if not press enter.)");
			inputText += " ";
			inputText += sc.nextLine();
			System.out.println("First input in loop");
			
			if (sc.nextLine().equals("")){
				counter = 1;
				System.out.println("if statement for blank line");

			}
			System.out.println("End of loop");

		}


		System.out.println("Grabbed text: " + inputText);
		System.out.println("Simulation starting:");
		HuffmanTree simulator = new HuffmanTree ();
		ArrayList<Huffnode> tester = new ArrayList<Huffnode>();
		System.out.println("Compressing characters:");
		tester= simulator.compress(inputText);
		System.out.println(" Creating huffman tree:");




	}
	
	}

// Important notes to fix
// scanner does not properly ask and recieve text. the loop causes an extra ask line?