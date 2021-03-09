
import java.util.Scanner;

public class HeartRate {
    public static void main(String[] args){
        final int CONST = 220;
        final int High = 85;
        final int Low = 65;
        Scanner scan = new Scanner(System.in);
        System.out.println("This program calculates your " + "target heart rate while exercising ");
        System.out.print("Enter your age : ");
        int age = scan.nextInt();
        System.out.println("Your estimated target heart rate zone is " + ((CONST-age)*Low)/100 + " – " + ((CONST-age)*High)/100 + " beats per minute.");

    }
}
