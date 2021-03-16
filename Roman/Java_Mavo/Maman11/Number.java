import java.util.Scanner;

public class Number {
    /* The Number class manipulates a 4-digit number in 3 ways:
     * 1.Reverse sign
     * 2.Reverse Number
     * 3.Both 1 and 2
     * On any illegal choice the program will exit */
    public static void main(String[] args){
        System.out.print("Please enter a 4 digit number: ");
        Scanner myScanner = new Scanner(System.in); // define scanner object
        int userInput = myScanner.nextInt(); // Receive a number from the user
        if (userInput / 1000 >=-9 && userInput / 1000 <= 9 && userInput / 1000 != 0){
            System.out.print("" +
                    "1. Reverse sign.\n" +
                    "2. Reverse number.\n" +
                    "3. Reverse sign and number.\n" +
                    "Please choose an option: "); // manipulation choices for the user
            int userChoice = myScanner.nextInt();
            if (userChoice < 4 && userChoice > 0){ // check if choice is legal between 1 and 3 (including)
                int thousands = userInput / 1000; // get the thousandth digit
                int hundreds = userInput / 100 % 10; // get the hundredth digit
                int tens = userInput / 10 % 10; // get the tenth digit
                int ones = userInput % 10; // get the first digit
                int flipResult = ones*1000 + tens*100 + hundreds*10 + thousands;
                if (userInput < 0){
                    thousands = thousands*(-1);
                    hundreds = hundreds*(-1);
                    tens = tens*(-1);
                    ones = ones*(-1);
                    flipResult = (-1)*(ones*1000 + tens*100 + hundreds*10 + thousands);
                }
                switch (userChoice){
                    case 1:
                        System.out.println("The result is: "+ userInput*(-1)); // print the number with reversed sign
                        break;
                    case 2:
                        System.out.print("The result is: "+ flipResult); // print the reversed number
                        break;
                    case 3:
                        System.out.print("The result is: "+ (-1)*flipResult); // print the reversed number with reversed sign
                        break;
                }
            }
            else {
                System.out.println("Illegal option – you must choose 1, 2 or 3"); // exit program due to wrong choice
            }
        }
        else {
            System.out.println("Illegal number – you must enter a 4 digit number"); // exit program due to wrong number input
        }
    } // end of main method
} //end of class
