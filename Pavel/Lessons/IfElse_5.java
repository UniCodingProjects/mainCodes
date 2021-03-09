import java.util.Scanner;

public class IfElse_5
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter grade (1-10)");
        int grade = scan.nextInt();

        if(1 <= grade && grade<=4){
            System.out.println("Fail");
        }else if(grade == 5) {
            System.out.println("Poor");
        } else if(grade == 6) {
            System.out.println("Pass");
        }else if(grade == 7 || grade == 8) {
                System.out.println("Good");
        }else if(grade == 9 || grade == 10) {
                    System.out.println("Very good");
        }else {
            System.out.println(grade + "Invalid grade");
        }
    }
}
