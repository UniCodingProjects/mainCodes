import java.util.Scanner;

public class HeartRate {
    public static void main(String[] args){
        final int CONST = 220; // Defining constant value for maximal heart rate
        final int High = 85; // Defining constant value for upper limit
        final int Low = 65; // Defining constant value of lower limit
        Scanner scan = new Scanner(System.in); // Define scanner object
        System.out.println("This program calculates your " + "target heart rate while exercising "); // Printing brief explanation about the program
        System.out.print("Enter your age : "); // Prompts user input
        int age = scan.nextInt(); // Receives user's age input
        System.out.println("Your estimated target heart rate zone is " + ((CONST-age)*Low)/100 + " – " + ((CONST-age)*High)/100 + " beats per minute."); // Print result of calculated heart rate during exercise
    }// End of method main
}// End of class HeartRate
