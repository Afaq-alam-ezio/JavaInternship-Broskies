import java.util.Scanner;

public class EvenOdd1{

    public static void main(String[] Args){

        try{

            System.out.print("Enter a number to check even or odd = ");
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();

            if(number % 2 == 0){

                System.out.println("Number is even.");
            }
            else{

                System.out.println("Number is odd.");
            }
        }
        catch(Exception e){

            System.out.println("Error = Invalid User Input.\nDetailed Error = " + e);
        }
    }
}