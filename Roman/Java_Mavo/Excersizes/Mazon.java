public class Mazon {
    private int _cal;
    private String _lastDate;
    static int integerMe;

    public Mazon(){
        _cal = 100;
        _lastDate = String.format("%d/%d/%d", 1, 1, 1900);
    }

    public Mazon(int cal, String lastDate){
        _cal = cal;
        _lastDate = lastDate;
    }

    public int getCal(){
        return _cal;
    }

    public String getLastDate(){
        return _lastDate;
    }

    public void setCal(int cal){
        _cal = cal;
    }

    public void setLastDate(String date){
        _lastDate = date;
    }

    public void eat(){
        System.out.println("i'm eating food");
    }

    public String toString(){
        return String.format("Cal: %d, Last Date: %S", _cal, _lastDate);
    }
}


class Pizza extends Mazon{
    private int _numOfTops;
    private int _numOfSlices;

    public Pizza(){
        super();
        _numOfTops = 1;
        _numOfSlices = 8;
    }

    public Pizza(int numOfTops, int numOfSlices, int cal, String lastDate){
        super(cal, lastDate);
        _numOfTops = numOfTops;
        _numOfSlices = numOfSlices;
    }

    public int getNumOfTops(){
        return _numOfTops;
    }

    public int getNumOfSlices(){
        return _numOfSlices;
    }

    public void setNumOfTops(int numOfTops){
        _numOfTops = numOfTops;
    }

    public void setNumOfSlices(int numOfSlices){
        _numOfSlices = numOfSlices;
    }

    public void eat(){
        System.out.println("I'm eating pizza!!!");
    }

    public String toString(){
        return String.format("Tops: %d, Slices: %d, Cal: %d, Last Date: %S", _numOfTops, _numOfSlices, getCal(), getLastDate());
    }
}