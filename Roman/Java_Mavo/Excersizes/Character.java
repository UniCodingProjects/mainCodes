import java.util.Scanner;

public abstract class Character {
    protected boolean male;
    protected boolean female;

    public void setMale(){
        if (!female) {
            System.out.println("character is male");
            male = true;
        }
    }
    public void setFemale(){
        if (!male) {
            System.out.println("character is female");
            female = true;
        }
    }
}

class Paladin extends Character{
    public Paladin(){
        System.out.println("is paladin");
    }
}

class Warrior extends Character{
    public Warrior(){
        System.out.println("is warrior");
    }
}

class Player{
    public static void main(String[] args){
        Character mychar;
        Scanner scanner = new Scanner(System.in);
        System.out.println("choose your char: \n" +
                "1.Paladin\n" +
                "2.Warrior");

        int choice = scanner.nextInt();
        while (choice > 2 || choice < 1){
            choice = scanner.nextInt();
        }
        if (choice == 1){
            mychar = new Paladin();
        }
        else{
            mychar = new Warrior();
        }

        System.out.println("choose your gender: \n" +
                "1.Male\n" +
                "2.Female");
        choice = scanner.nextInt();
        while (choice > 2 || choice < 1){
            choice = scanner.nextInt();
        }
        if (choice == 1){
            mychar.setMale();
        }
        else {
            mychar.setFemale();
        }
    }
}


abstract class X
{
    public X(){
        System.out.println("imm at x");
    }
    abstract void fag();
}
abstract class Z extends X
{
    public Z()
    {
        System.out.println ("B constructor");
    }

    public static void main(String[] args){
    }
}
