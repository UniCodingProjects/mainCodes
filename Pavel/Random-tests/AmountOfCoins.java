import java.util.Scanner;
public class AmountOfCoins {
    public static void main(String[]args){
        final int tenCoin = 10;
        final int fiveCoin = 5;
        final int oneCoin = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter amount of money for conversion");
        int moneyAmount = scanner.nextInt();
        if(moneyAmount >= 0) {
            int coinsOfTen = moneyAmount / tenCoin;
            int coinsOfFive = (moneyAmount % tenCoin) / fiveCoin;
            int coinsOfOne = ((moneyAmount % tenCoin) % fiveCoin) / oneCoin;
            System.out.println("For the amount of " + moneyAmount + "\n" + "We need " + coinsOfTen + " coins of 10 NIS \n" +
                    "We need " + coinsOfFive + " coins of 5 NIS \n" + "We need " + coinsOfOne + " coins of 1 NIS");
        }else{
            System.out.println("The amount you entered is invalid");
        }
    }
}
