import java.util.Scanner;

public class Exc1 {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        int grade = myScanner.nextInt();
        if (1 <= grade && grade <= 4){
            System.out.println("SHIT");
        }
        else if (grade == 5){
            System.out.println("meh");
        }
        else if (grade == 6){
            System.out.println("meh2");
        }
        else if (grade == 7){
            System.out.println("meh3");
        }
        else if (grade == 8){
            System.out.println("meh4");
        }
        else if (grade == 9){
            System.out.println("meh5");
        }
        else if (grade == 10){
            System.out.println("GREAT SUCCESS");
        }
        else {
            System.out.println("GREAT UNGOOOOOOODDDDD");
        }
    }
}
