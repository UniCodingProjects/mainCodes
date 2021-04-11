import java.util.Scanner;
public class Payment {
    public static void main(String[]args){
        final int HEALTH_TAX = 100, GRANT = 200;
        final int SENIOR = 67, ADULT = 18;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter employee age and salary:");
        int employeeAge = scan.nextInt();
        int employeeSalary = scan.nextInt();
        if(employeeAge >= ADULT && employeeAge <= SENIOR) {
            employeeSalary = employeeSalary - HEALTH_TAX;
        }else{
            employeeSalary = employeeSalary + GRANT;
        }
        System.out.println("Employee salary is:" + employeeSalary);
    }
}
