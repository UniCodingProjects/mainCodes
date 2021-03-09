import java.util.Scanner;

public class TimeDisplay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter hour and minutes");
        int h = scan.nextInt();
        int m = scan.nextInt();
        System.out.println(h + ":" + m);

        String res = (h < 10 ? "0" : "") + h + ":" + (m < 10 ? "0" : "") + m;
        System.out.println(res);
    }
}