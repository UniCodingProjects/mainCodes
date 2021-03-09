import java.util.Scanner;

public class HeartRate {
    /* Calculates the average heart rate based on the user's age*/
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in); //define scanner object
        final int HIGH_THRESHOLD = 85;
        final int LOW_THRESHOLD = 65;
        final int CONST_VALUE = 220;
        System.out.println("This program calculates your target heart rate while exercising");
        System.out.print("Enter your age: ");
        int age = myScanner.nextInt(); // receive age input from user
        int LOW_OUTPUT = (CONST_VALUE - age) * LOW_THRESHOLD / 100;
        int HIGH_OUTPUT = (CONST_VALUE - age) * HIGH_THRESHOLD / 100;
        System.out.printf("Your estimated target heart rate zone is %d – %d beats per minute.", LOW_OUTPUT, HIGH_OUTPUT); // print heart rate after calculation
    } // end of main method
} // end of class
