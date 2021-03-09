import java.util.Scanner;

public class Switch_5
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter grade (1-10)");
        int g = scan.nextInt();
        switch (g){
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println("Fail");
                break;
            case 5:
                System.out.println("Poor");
                break;
            case 6:
                System.out.println("Pass");
                break;
            case 7:
            case 8:
                System.out.println("Good");
                break;
            case 9:
            case 10:
                System.out.println("Very good");
                break;
            default:
                System.out.println("Invalid grade");
        }
    }
}
