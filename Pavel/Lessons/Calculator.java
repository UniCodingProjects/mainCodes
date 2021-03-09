import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter num1 op num2 | op = {+, -, *, /, :}");
        double num1 = scan.nextDouble();
        String op = scan.next();
        double num2 = scan.nextDouble();
        String res = num1 + " " + op + " " + num2 + " = ";
        switch (op){
            case "+":
                res += num1 + num2;
                break;
            case "-":
                res += num1 - num2;
            case "*":
                res += num1 * num2;
                break;
            case ":":
            case "/":
                if (num2 !=0){
                    res += num1 / num2;

                }else{
                    res += "Cannot divide by 0";
                }
                break;
            default:
                res = op + "Invalid operator";

        }
        System.out.println(res);
    }
}