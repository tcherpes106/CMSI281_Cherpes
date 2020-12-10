public class Tree {
	//problem #1 -> inOrderTraversal review

	public void inOrderTraversal (Node root){
		if(root ==null){
			return;
		}
		inOrderTraversal(root.getChild("L"));
		System.out.println("Node: "+ root.info );
		inOrderTraversal(root.getChild("R"));
	}
	public static void main (String [] args){
	
	}
}