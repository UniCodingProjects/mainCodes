import java.util.Scanner;


class TimeDisplay {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int hours = myScanner.nextInt();
        int mins = myScanner.nextInt();
        String outP = (hours < 10 ? "0" : "") + hours + ":" +  (mins < 10 ? "0" : "") + mins;
        System.out.print(outP);
    }
}