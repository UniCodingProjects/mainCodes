import java.util.Scanner;

public class IfElse {
    public static void main(String[] args){
        Scanner Scan = new Scanner(System.in);
        System.out.println("Enter 2 digit number");
        int num = Scan.nextInt();
        //check if num is NOT 2 digit number
        if (num < 10 || 99 < num ){
            System.out.println(num + "is not a 2 digit number");
        }
        else{
            //number is 2 digit number
            if (num %11 == 0){
                System.out.println(num + "is a 2 digit number");
            }
         else{

             System.out.println("Error");

            }
        }
    }
}
