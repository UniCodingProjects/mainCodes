public class User {
    public static void main(String[] args){
        Time t1 = new Time(18, 50);
        System.out.println("T1 = " + t1.toString());
        System.out.println("T1 = " + t1);
        Time t2 = new Time(180, -20);
        System.out.println("T2 = " + t2);
        t2.setMinute(-50);
        System.out.println("T2 = " + t2);
        t2.setMinute(37);
        System.out.println("T2 = " + t2);
        Time t3 = new Time(18, 50);
        Time t4 = new Time(18, 50);
        Time t5 = new Time(18, 57);
        System.out.println("T3=" + t3 + ", t4=" + t4 + ", t5=" +t5); // Print t3, t4, t5
        System.out.println("t3.equals(t4)" + t3.equals(t4)); // Check if t3 is equal to t4 and print true or false
        System.out.println("t3.equals(t5)" + t3.equals(t5)); // Check if t3 is equal to t5 and print true or false
        System.out.println("t3.before(t5)" + t3.before(t5)); // Check if t3 is before t5
        System.out.println("t3.after(t5)" + t3.after(t5)); //
        System.out.println("t2.difference(t5)" + t2.difference(t5)); //
    }
}
