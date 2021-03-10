import java.text.NumberFormat;
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
            System.out.println("GREAT UNGOODD");
        }
    }
}
class TimeDisplay {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int hours = myScanner.nextInt();
        int mins = myScanner.nextInt();
        String outP = (hours < 10 ? "0" : "") + hours + ":" +  (mins < 10 ? "0" : "") + mins;
        System.out.print(outP);
    }
}

class Calculator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("enter 2 digits and an operator - digit operator digit, in that order");
        double num1 = myScanner.nextDouble();
        String operator = myScanner.next();
        double num2 = myScanner.nextDouble();
        switch (operator){
            case "+":
                System.out.printf("%f", (num1 + num2));
                break;
            case "*":
                System.out.printf("%f", (num1 * num2));
                break;
            case ":":
            case "/":
                if (num2 == 0) {
                    System.out.println("WRONG CANT DIVIDE BY 0");
                    break;
                }
                System.out.printf("%f", (num1 / num2));
                break;
            case "-":
                System.out.printf("%f", (num1 - num2));
                break;
            default:
                System.out.println("WRONG OPERATOR");
        }
    }
}


class test1{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        int num = myScanner.nextInt();
        if (num > 999 && num < 9999 || num < -999 && num > -9999){
            System.out.println(num);
        }
    }
}
