import java.util.Scanner; // Import Scanner class
/** The following program prints the wanted heart rate of a user during exercise based on entered age */
public class HeartRate { // Defines a new class called HeartRate
    public static void main(String[] args){ // Creates a method called main
        final int CONST = 220; // Defining constant value for maximal heart rate
        final int HIGH = 85; // Defining constant value for upper limit
        final int LOW = 65; // Defining constant value of lower limit
        Scanner scan = new Scanner(System.in); // Define scanner object
        System.out.println("This program calculates your " + "target heart rate while exercising "); // Printing brief explanation about the program
        System.out.print("Enter your age : "); // Prompts user input
        int age = scan.nextInt(); // Receives user's age input
        System.out.println("Your estimated target heart rate zone is " + ((CONST-age)*LOW)/100 + " – " + ((CONST-age)*HIGH)/100 + " beats per minute."); // Print result of calculated heart rate during exercise
    } // End of method main
} // End of class HeartRate
