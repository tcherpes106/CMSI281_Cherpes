import java.util.Scanner;
public class classwork_01 {
  public static void main (String[] args){

    System.out.println("Hello World");

    Scanner myInput = new Scanner(System.in);
    System.out.println("Enter your name: ");
    String inputName = myInput.nextLine();

    System.out.println("Hello " + inputName);
  }
}
