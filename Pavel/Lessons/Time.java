public class Time {
    private final int DEF_VAL = 0;
    private int _hour;
    private int _minute;

    public Time(int hour, int minute) {
        if (hour < 0 || 23 < hour) {
            hour = DEF_VAL;
        }
        _hour = hour;
        if (minute < 0 || 59 < minute) {
            minute = DEF_VAL;
        }
        _minute = minute;
    }

    // getters
    public int getHour() {
        return _hour;
    }

    public int getMinute() {
        return _minute;
    }
    //copy constructor
    public Time(Time t){
        _hour = t._hour;
        _minute = t._minute;
    }
    // setters
    public void setHour(int h) {
        if (0 <= h && h <= 23) {
            _hour = h;
        }
    }
    public void setMinute(int m){
        if (0 <= m && m <= 59) {
            _minute = m;
        }
    }
    public boolean equals (Time t){
        return _hour == t._hour && _minute == t._minute;
    }
    public boolean before (Time t){
        return (_hour < t._hour || _hour == t._hour && _minute < t._minute);
    }
    public boolean after (Time t){
        return t.before(this);
    }
    public int minFromMidnight() {
        return _hour * 60 + _minute;
    }
    public int difference(Time t){
        return Math.abs(t.minFromMidnight() - minFromMidnight());
    }
    public String toString () {
        return (_hour<10? "0":"") +_hour + ":" +(_minute<10? "0":"") + _minute; // Return additional "0" if the number is single digit
    }
}