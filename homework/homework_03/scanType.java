import java.util.Scanner;

public class scanType {
	

	public static void main (String [] args) {
		System.out.println("Insert text:");
		Scanner sc = new Scanner (System.in);
		String text = sc.nextLine();
		System.out.println("Do you want to add another line? (Press enter to accept the text as is.)");
		text += sc.nextLine();
		System.out.println("Grabbed text: " + text);
	}
}