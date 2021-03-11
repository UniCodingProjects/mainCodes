import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a 4 digit number : ");
        int num = scan.nextInt();
        if (!(num > 999 && num <= 9999 || num < -999 && num >= -9999))//if(num>999 && num<9999 || num>9999 && num<-9999) //
        {
            System.out.println("Illegal number – you must enter a 4 digit number");
        } else {//add condition for negative number and positive number
            int thousands = num / 1000;
            int hundreds = (num / 100) % 10;
            int tens = (num / 10) % 10;
            int ones = num % 10;

            System.out.println("1. Reverse sign.\n" +
                               "2. Reverse number.\n" +
                               "3. Reverse sign and number.\n" +
                               "Please choose an option:");
            int userInput = scan.nextInt();
            if(userInput<1 || userInput> 3) {
                System.out.println("Illegal option – you must choose 1, 2 or 3");
            }
            switch (userInput) {
                case 1:
                    System.out.println("The result is: \n" + num * -1);
                    break;
                case 2:
                    System.out.println("The result is: \n" + ones + tens + hundreds + thousands);
                    break;
                case 3:
                    if(num<0) {
                        thousands = thousands*-1;
                        hundreds = hundreds*-1;
                        tens = tens*-1;
                        ones = ones*-1;
                        System.out.println("The result is: \n" + ones + tens + hundreds + thousands);
                    }else {
                        System.out.println("The result is: \n" + "-" + ones + tens + hundreds + thousands);
                    }
                    break;
            }
        }
    }
}