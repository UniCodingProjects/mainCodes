import java.text.NumberFormat;
import java.util.Iterator;
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
        Calculator calc = new Calculator();
    }
}



class test2{
    public static void main(String[] args){
        String word = "";
        int[] myArray = {1, 2, 3};
        for (int i = 0; i < myArray.length; i++){
            System.out.println(myArray[i]);
        }
        String[] mySArray = {"fag", "gay", "fag"};
        for (int i = 0; i < mySArray.length; i++){
            System.out.println(mySArray[i]);
            word = mySArray[i].equals("fag") ? "fag" : "f";
        }
        System.out.println(word);
        for (int value: myArray) {
            System.out.println(value);
        }
        for (String value: mySArray) {
            System.out.println(value);
        }
    }
}

class Worker{
    private String _name;
    private double _salary;
    private int _vacationDays;

    public Worker(){
        _name = "fag";
        _salary = 0;
        _vacationDays = 0;
    }

    public Worker(String name, double salary, int vacationDays){
        _name = name;
        _salary = salary;
        _vacationDays = vacationDays;
    }

    public double getSalary(){
        return _salary;
    }

    public void setSalary(double salary){
        _salary = salary;
    }

    public boolean checkSalary(){
        if (_salary>20){
            return true;
        }
        return false;
    }


    public static void main(String[] args){
        Worker randomWorker = new Worker();
        System.out.println(randomWorker._name.charAt(0));
//        Worker worker1 = new Worker("roman", 8000, 0);
//        Worker worker2 = new Worker("sasha", 10, 1000);
//
//        double mySalary = worker1.getSalary();
//        System.out.println(mySalary);
//        double mySalary2 = worker2.getSalary();
//        System.out.println(mySalary2);
//        worker2.setSalary(5);
//        System.out.println(worker2.getSalary());
    }
}