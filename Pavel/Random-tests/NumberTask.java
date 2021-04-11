import java.util.Scanner;
public class NumberTask {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number between 1-6");
        int num = scan.nextInt();
        if(num == 1 || num == 2){
            num = num++;
        }else if(num >=3 && num <= 5){
            num = num--;
        }else if(num == 6){
            num = num*2;
        }else if(num > 6 || num < 1){
            num = num*3;
        }
        System.out.println(num);
    }
}
