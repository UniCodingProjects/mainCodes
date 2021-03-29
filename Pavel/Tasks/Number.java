import java.util.Scanner; // Import Scanner class
/** The following program asks the user to select a 4 digit number and prints out a different variation of the number
  * based on the user's input:
  * 1. Prints the number with the opposite sign.
  * 2. Prints the number in reversed order.
  * 3. Prints the number with the opposite sign and in reversed order.
  * Any illegal input will terminate the program */
public class Number { // Defines a new class called Number
    public static void main(String[] args) { // Creates a method called main
        Scanner scan = new Scanner(System.in); // Creates a new Scanner instance for standard input
        System.out.println("Please enter a 4 digit number : "); // Prints a message asking the user for a 4 digit number input
        int num = scan.nextInt(); // Adds the user selected number into a new integer "num"
        if(!(num > 999 && num <= 9999 || num < -999 && num >= -9999)) // Set a condition for user input, If the number selected is invalid - An error message will be printed, If the number is valid - The program will continue
        {
            System.out.println("Illegal number – you must enter a 4 digit number"); // Prints an error message when the user enters an invalid number
        }else{ //add condition for negative number and positive number
            int thousands = num / 1000; // Adds the thousands digit into a new integer "thousands"
            int hundreds = (num / 100) % 10; // Adds the hundreds digit into a new integer "hundreds"
            int tens = (num / 10) % 10; // Adds the tens digit into a new integer "tens"
            int ones = num % 10; // Adds the ones digit into a new integer "ones"
            int reversed = ones*1000 + tens*100 + hundreds*10 + thousands; // Adds all the numbers in reversed order into a new integer called "reversed"
            System.out.println("1. Reverse sign.\n" +
                               "2. Reverse number.\n" +
                               "3. Reverse sign and number.\n" +
                               "Please choose an option:"); // Prints a message for user choices
            int userInput = scan.nextInt(); // Add user input into a new integer called "userInput"
            if(userInput<1 || userInput> 3) { // Condition for a scenario when the user enters an unwanted number
                System.out.println("Illegal option – you must choose 1, 2 or 3"); // Prints an error message if the user chooses a different number than asked
                }
            switch (userInput) { // Add 3 cases for user selection
                case 1: // User input is 1
                    System.out.println("The result is: \n" + num * -1); // Print the user selected number with reversed sign
                    break; // End of case 1
                case 2: // User input is 2
                    System.out.println("The result is: \n" + reversed); // Print the user selected number in reversed order
                    break; // End of case 2
                case 3: // User input is 3
                        System.out.println("The result is: \n" + reversed*-1); // Print the digits of the selected number in reversed order and change the sign
                    break; // End of case 3
                } // End of switch statement
        } // End of else condition
    } // End of method main
} // End of class Number