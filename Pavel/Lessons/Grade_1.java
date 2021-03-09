import java.util.Scanner;

public class Grade_1
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter grade and points");
        int grade = scan.nextInt();
        int points = scan.nextInt();

        if(points==5){
            grade += 25;
        }
        if(points==4){
            grade +=15;
        }
        System.out.println("The final grade is =" + grade);
    }
}
