/* Updated after lesson 4 with changes for "Flight" */
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

        Flight f1 =  new Flight("TLV", "PARIS", t3, 180, 153, 400);
        System.out.println("f1 = " + f1);
        Flight f2 =  new Flight("TLV", "MADRID", t3, 180, 300, -400);
        System.out.println("f2 = " + f2);
        t3.setHour(19);
        Flight f3 =  new Flight("TLV", "SWISS", t3, 200, 190, 450);
        Flight f4 =  new Flight("TLV", "SWISS", t3, 170, 190, 450);
        System.out.println("f3 = " + f3);
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);

        Time t12 = f2.getDeparture();
        System.out.println("t12 = " + t12);
        t12.setHour(20);
        System.out.println("f2 = " + f2);
        f2.setDeparture(t12);
        System.out.println("f2 = " + f2);
        t12.setHour(15);
        System.out.println("f2 = " + f2);
        System.out.println("f2.equals(f3) = " + f2.equals(f3));
        System.out.println("f4.equals(f3) = " + f4.equals(f3));
        System.out.println("f3.getArrivalTime() = " + f3.getArrivalTime());
        System.out.println("f4 : Passengers = " + f4.getPassengers()); // Not added in class
        f4.addPassengers(60);
        System.out.println("f4.pass = " + f4);
        System.out.println("f4.landsEarlier(f3) = " + f4.landsEarlier(f3));
        System.out.println("f4.landsEarlier(f2) = " + f4.landsEarlier(f2));
    }
}