public class inc {
    private int num;
    private static int counter;

    public inc(){
        counter++;
        num = counter;
    }

    public void printy(){
        System.out.println(num + "" + counter);
    }

}