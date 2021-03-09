import java.util.Scanner;

public class Num {
    /* The Number class manipulates a 4-digit number in 3 ways:
    * 1.Reverse sign
    * 2.Reverse Number
    * 3.Both 1 and 2
    * On any illegal choice the program will exit */
    public static void main(String[] args) {
        char sign = ' ';
        String reversed;
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Please enter a 4 digit number: ");
        int userNumberInput = myScanner.nextInt(); // Receive a number from the user
        String userDefinedNumberAsString = String.valueOf(userNumberInput); // convert the received number(integer) to string
        if (userNumberInput > 0){
            if (userDefinedNumberAsString.length() != 4){
                System.out.println("Illegal number – you must enter a 4 digit number");
                System.exit(0);
            }
        }
        else if (userNumberInput < 0){
            if (userDefinedNumberAsString.length() != 5){
                System.out.println("Illegal number – you must enter a 4 digit number");
                System.exit(0);
            }
        }
        System.out.print("" +
                "1. Reverse sign.\n" +
                "2. Reverse number.\n" +
                "3. Reverse sign and number.\n" +
                "Please choose an option: "); // manipulation choices for the user
        int userChoice = myScanner.nextInt();
        if (userChoice > 3 || userChoice < 1){ // check if choice is legal between 1 and 3 (including)
            System.out.println("Illegal option – you must choose 1, 2 or 3");
            System.exit(0); //exit program if illegal value received
        }
        if (userNumberInput > 0){
            sign = '-';
            reversed = String.format("%c%c%c%c", userDefinedNumberAsString.charAt(3), userDefinedNumberAsString.charAt(2),
                    userDefinedNumberAsString.charAt(1), userDefinedNumberAsString.charAt(0));  //Reverse the number in case of 2 or 3, to avoid code duplication
        }
        else {
            reversed = String.format("%c%c%c%c%c", userDefinedNumberAsString.charAt(0), userDefinedNumberAsString.charAt(4),
                    userDefinedNumberAsString.charAt(3), userDefinedNumberAsString.charAt(2), userDefinedNumberAsString.charAt(1));  //Reverse the number in case of 2 or 3, to avoid code duplication
            userDefinedNumberAsString = userDefinedNumberAsString.replace('-', ' ');
        }
        if (userChoice == 1){
            System.out.printf("The result is: %c%s", sign, userDefinedNumberAsString); // print the number with reversed sign
        }
        else if (userChoice == 2){
            System.out.printf("The result is: %s", reversed); // print the reversed number
        }
        else {
            reversed = reversed.replace('-', ' ');
            System.out.printf("The result is: %c%s", sign, reversed); // print the reversed number with reversed sign
            System.out.print("5"+5+5+5);
        }
    } // end main method
} // end class
