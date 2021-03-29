/* Lesson 4 */
public class Flight {
    public static final int MAX_CAPACITY=250;
    private String _origin;
    private String _destination;
    private Time _departure;
    private int _duration;
    private int _passenger;
    private boolean _isFull;
    private int _price;

    public Flight(String origin, String destination, Time departure, int duration, int pass, int price){
        _origin = origin;
        _destination = destination;
        _departure = new Time(departure);
        if (pass > MAX_CAPACITY){
            pass = MAX_CAPACITY;
        }else if (pass < 0){
            pass = 0;
        }
        _passenger = pass;
        _isFull = _passenger == MAX_CAPACITY ? true : false;
        _duration = duration < 0 ? 0 : duration;
        _price = price < 0 ? 0 : price;
    }
    public String toString(){
        return "Flight from " + _origin + " to " + _destination + " departs at "+ _departure.toString() + ". Flight is" + (_isFull ? " " : " not ") + "full. ";
    }
    public String getOrigin(){
        return _origin;
    }
    public String getDestination(){
        return _destination;
    }
    public int getPassengers(){
        return _passenger;
    }
    public boolean isFull(){
        return _isFull;
    }
    public int getPrice(){
        return _price;
    }
    public int getDuration(){
        return _duration;
    }
    public Time getDeparture() {
        return new Time(_departure);
    }

    public void setDeparture(Time departure){
        _departure = new Time (departure);
    }

    public boolean equals(Flight f){
        return _origin.equals(f._origin) && _destination.equals(f._destination) && _departure.equals(f._departure);
    }

    public Time getArrivalTime(){
        // 1st way
//        int totalMinute = _departure.getMinute() + _duration;
//        //mod 24 in case we go over 24 hours
//        int hour = (_departure.getHour() + totalMinute/60) % 24;
//        int minute = totalMinute % 60;
        // 2nd way
        int totalMin = _departure.minFromMidnight() + _duration;
        int hour = (totalMin / 60) %24;
        int minute = totalMin % 60;
        return new Time(hour, minute);
    }

    public boolean addPassengers(int num){
        if(_passenger + num > MAX_CAPACITY){
            return false;
        }
        _passenger += num;
        if(_passenger == MAX_CAPACITY){
            _isFull = true;
        }
        return true;
    }

    public boolean isCheaper(Flight f){
            return _price < f._price; // add print to see result
    }

    public int totalPrice(){
        return _passenger * _price; // add print to see result
    }

    public boolean landsEarlier(Flight f){
        //return getArrivalTime().before(f.getArrivalTime()); // 1st way
        // 2nd way
        Time arriveTime = getArrivalTime();
        System.out.println(arriveTime);
        Time fArriveTime = f.getArrivalTime();
        System.out.println(fArriveTime);
        return arriveTime.before(fArriveTime);
    }
}
