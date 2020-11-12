
//prioity queue to help sure most frequent values used
//create huffman tree based off of the values in the arraylist
//create the code table for your text
//encode the message, display it on the screen
//using the hiffman tree, decode the message and redisplay it on the screen

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Collections;


public class HuffmanTree {

	// create indiviudal nodes to later use in the arraylist/ tree
	 public class Huffnode  implements Comparable<Huffnode> {

		public char value;
		public int count;
		public Huffnode leftNode;
		public Huffnode rightNode;
		public String code="";
		//public Huffnode parent = null;

		//constructor to create Hnodes
		public  Huffnode (char val, int cnt, Huffnode left, Huffnode right){

			value=val;
			count=cnt;
			leftNode=left;
			rightNode=right;
		}

		public int compareTo(Huffnode hf){
			int retVal =0;

			if (count == hf.count) {
				retVal = value - hf.value;
			}
			else { 
				 retVal = count - hf.count;
			}
			return retVal;
		}
	}

	// THIS should create an arrayList from the String given by user, 
	public ArrayList compress (String textString) {
		ArrayList <Huffnode> txtFile = new ArrayList<Huffnode>(56);
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ., \n";
		int counter =0;

		//populates the arraylist with the characters needed
		for (int j = 0; j < 56; j ++) {
			Huffnode inserter = new Huffnode (alphabet.charAt(j),0,null,null);
			txtFile.add(inserter);
			//counts the characters for the array list
			for (int i =0 ; i < textString.length(); i++) {
				if (textString.charAt(i)==(txtFile.get(j).value)){
					txtFile.get(j).count ++;

					
				}
			}
		}
		for (int a =0; a<56; a++){
			if (txtFile.get(a).count != 0){
				counter ++;
			}
		}

		ArrayList <Huffnode> retFile = new ArrayList<Huffnode>(counter);
		int tinycount =0;
		for (int k = 0; k < txtFile.size(); k++){
			if (txtFile.get(k).count!=0 ){
				Huffnode finalInsert = txtFile.get(k);
				retFile.add(finalInsert);
			}
				
			

		}

		Collections.sort(retFile);


		return retFile;

		//make sure to sort in here
	}

	//build the tree
	
	public PriorityQueue huffTree (ArrayList<Huffnode> charNodes) {
		PriorityQueue<Huffnode> tree = new PriorityQueue<Huffnode>(charNodes.size());
		
		//PriorityQueue <Huffnode> doneQ = new PriorityQueue<Huffnode>(1);

		
		for (int i = 0; i< charNodes.size()-1; i++){
			tree.add(charNodes.get(i));
		}

		while (tree.size()>1){
			Huffnode leftNode = tree.peek();
			tree.remove();
			Huffnode rightNode= tree.peek();
			tree.remove(); 
		
			// parent node that will be added.
			Huffnode parent = new Huffnode(' ', leftNode.count +rightNode.count, leftNode, rightNode);
			tree.add(parent);
		}

		return tree;
		//created the queue, now creating tree
		// select certain index, adjust their nodes for right and left
		// Create holder nodes to be the parent node


	}
	// will create the new table based off of the tree created
	public void encode (PriorityQueue<Huffnode> treelist){
		HuffmanTree runner = new HuffmanTree();
		Huffnode root = treelist.peek();
		String value = "";

		runner.inOrderTraversal(root);
	}
	// not sure if to put codechar inserts before or after calling recursive method or how to add code to each node
	public void inOrderTraversal (Huffnode step){
		String codeChar = "";
		if (step == null){
			return;
		}
		codeChar += "0";
		inOrderTraversal(step.leftNode);
		codeChar = codeChar.substring(0,codeChar.length()-1);
		System.out.println(step.value+"");
		step.code = codeChar;

		codeChar += "1";
		inOrderTraversal(step.rightNode);
		codeChar = codeChar.substring(0,codeChar.length()-1);	
	}

	// returns the message that was encoded as a string
	public void decode (String binary, PriorityQueue<Huffnode> treelist){
		HuffmanTree runner = new HuffmanTree();
		Huffnode root = treelist.peek();
		Huffnode pointer =root;
		String chooper ="";

		//looping through the string

		for (int i =0; i<binary.length();i++){
			while (pointer.leftNode != null && pointer.rightNode != null){
				
				//might need to have quotes?
				if (binary.charAt(i)=='0'){
					pointer = pointer.leftNode;

				}
				else {
					pointer= pointer.rightNode;
				}
			}
			chooper +=pointer.value;
			pointer = root;

		}
		//use a pointer to call throughout the process
		//loop through the binary string
		//If left +right = null, return the value at NODE
		//if first letter is 0 -> Go Left
		//If 1 -> go right

		

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
		/*
		while (counter ==0){
		System.out.println("(Did you want another line? if not press enter.)");
			inputText += " ";
			inputText += sc.nextLine();
			//System.out.println("First input in loop");
			
			if (sc.nextLine().equals("")){
				counter = 1;
				System.out.println("if statement for blank line");

			}
			System.out.println("End of loop");

		}*/


		System.out.println("Grabbed text: " + inputText);
		System.out.println("Simulation starting:");
		HuffmanTree simulator = new HuffmanTree ();
		ArrayList<Huffnode> tester = new ArrayList<Huffnode>();
		System.out.println("Compressing characters:");
		tester= simulator.compress(inputText);
		System.out.println(" Creating huffman tree:");
		PriorityQueue<Huffnode> treeMade = new PriorityQueue<Huffnode>();
		treeMade= simulator.huffTree(tester);
		System.out.println("Success! Tree created");
		System.out.println("Now encoding the text.");
		simulator.encode(treeMade);
		System.out.println("Success!properly ran encoded.");
		System.out.println("Now checking Decode.");
		//simulator.decode




	}
	
	}

// Important notes to fix
// scanner does not properly ask and recieve text. the loop causes an extra ask line?