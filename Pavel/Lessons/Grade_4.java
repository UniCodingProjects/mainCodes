import java.util.Scanner;

public class Grade_4
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter 5 grades and exam grade");
        int count = 0;
        int total = 0;
        int grade = scan.nextInt();
        if (grade > -1){
            count++;
            total += grade;
        }
         grade = scan.nextInt();
        if (grade > -1) {
            count++;
            total += grade;
        }
         grade = scan.nextInt();
        if (grade > -1) {
            count++;
            total += grade;
        }
         grade = scan.nextInt();
        if (grade > -1) {
            count++;
            total += grade;
        }
         grade = scan.nextInt();
        if (grade > -1) {
            count++;
            total += grade;
        }
        int exam = scan.nextInt();
        if(count>=3){
            double finalGrade = (1-0.05*count)*exam + 0.05*total;
            System.out.println("Final grade" + finalGrade);
        }
        else{
            System.out.println("Not enough grades submitted");
        }

    }
}
