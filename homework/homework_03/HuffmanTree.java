
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

	// DONE 
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
	}
	
	//DONE- placeholder is @, not space
	public PriorityQueue huffTree (ArrayList<Huffnode> charNodes) {
		PriorityQueue<Huffnode> tree = new PriorityQueue<Huffnode>(charNodes.size());
		Huffnode leftNode = null;
		Huffnode rightNode = null;
		char pHolder = '@';
		//PriorityQueue <Huffnode> doneQ = new PriorityQueue<Huffnode>(1);

		
		for (int i = 0; i< charNodes.size(); i++){
			//System.out.println("ArrayList Value: " +charNodes.get(i).value);
			tree.add(charNodes.get(i));
			//System.out.println("Printing Queue Value " + tree.peek().count);
		}
		while (tree.size()>1){
			 leftNode = tree.peek();
			tree.remove();
			 rightNode= tree.peek();
			tree.remove(); 
		
			// parent node that will be added.
			Huffnode parent = new Huffnode(pHolder, leftNode.count +rightNode.count, leftNode, rightNode);
			tree.add(parent);
		}
		return tree;
	}
	// DONE
	public String encode (PriorityQueue<Huffnode> treelist, String textLine){
		HuffmanTree runner = new HuffmanTree();
		//ArrayList<Huffcode> = new ArrayList<Huffcode> ();
		Huffnode root = treelist.peek();
		String text = textLine;
		char chop = ' ';
		String retVal = "";

		for (int i =0; i < text.length(); i++){

			chop = text.charAt(i); 
			retVal += runner.inOrderTraversal(root, chop);
			//System.out.println("String returned: " +retVal);
		}
		//System.out.println("Printing the code piece for T:" + root.leftNode.rightNode.code);


		return retVal;
	}

	// DONE
	public String inOrderTraversal (Huffnode step, char target ){
		
		if (step.leftNode != null || step.rightNode != null) {
			if (step.leftNode.value == target){
				return "0";
			}
			if (step.rightNode.value == target){
				return "1";
			}

			String leftTraverse = inOrderTraversal(step.leftNode,target);
			if (leftTraverse != null){
				return "0" + leftTraverse;
			}

			String rightTraverse = inOrderTraversal(step.rightNode,target);
			if (rightTraverse != null){
				return "1" + rightTraverse;
			}
		}	

		return null;
	}

	// DONE
	public String decode (String binary, PriorityQueue<Huffnode> treelist){
		Huffnode root = treelist.peek();
		Huffnode pointer = root;
		String message ="";

		//looping through the string

		for (int i =0; i<binary.length(); i++) {
			if (pointer.leftNode == null && pointer.rightNode ==null){
				message += pointer.value;
				pointer = root;

			}
			//else {
				if (binary.charAt(i)=='0'){
					pointer = pointer.leftNode;

				}
				else {
					pointer= pointer.rightNode;
				}
			//}
			System.out.println("Value:"+ pointer.value + "frequency:" + pointer.count);

		}
		message += pointer.value;
		return message;
		

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
			inputText += " \n";
			inputText += sc.nextLine();
			//System.out.println("First input in loop");
			
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
		PriorityQueue<Huffnode> treeMade = new PriorityQueue<Huffnode>();
		treeMade= simulator.huffTree(tester);
		//System.out.println("Left piece of the root in Queue: " +treeMade.peek().rightNode.leftNode.count);
		System.out.println("Success! Tree created");

		System.out.println("Now Creating Code from tree:");
		String hamurabi = "";
		hamurabi = simulator.encode(treeMade, inputText);
		System.out.println("Binary Code:"+ hamurabi);

		System.out.println("Now Decoding Message using the tree:");
		String decodedMsg ="";
		decodedMsg = simulator.decode(hamurabi, treeMade);
		System.out.println("Decoded Message: "+ decodedMsg);

		System.out.println("Success, message has been decoded.");


	}
	
	}

// Important notes to fix
// scanner does not properly ask and recieve text. the loop causes an extra ask line?