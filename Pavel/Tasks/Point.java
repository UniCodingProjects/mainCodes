public class Point {
    private double _x;
    private double _y;

    public Point(double x, double y){
        _x = x;
        _y = y;
    }
    public Point(Point other){
        _x = other._x;
        _y = other._y;
    }
    //Getters
    public double getX(){
        return _x;
    }
    public double getY(){
        return _y;
    }
    //Setters
    public void setX(double num){
        _x = num;
    }
    public void setY(double num){
        _y = num;
    }
    public String toString(){
        return ("(" + _x + "," + _y + ")");
    }
    public boolean equals(Point other){
        return ((_x == other._x) && (_y == other._y));
    }
    public boolean isAbove (Point other){
        return ((_y > other._y));
    }
    public boolean isUnder (Point other){
        return other.isAbove(this);
    }
    public boolean isLeft(Point other){
        return ((_x < other._x));
    }
    public boolean isRight(Point other){
        return other.isLeft(this);
    }
    public double distance (Point p){
        return Math.sqrt(Math.pow(_x - p.getX(), 2) + Math.pow(_y - p.getY(), 2));
    }
    public int quadrant(){
        if(_x > 0 && _y > 0){
            return 1;
        }
        if(_x < 0 && _y > 0){
            return 2;
        }
        if(_x < 0 && _y < 0){
            return 3;
        }
        if(_x > 0 && _y < 0){
            return 4;
        }else{
            if(_x == 0 || _y == 0);
            return 0;
        }
    }

    public static void main(String[] args){
        Point myPoint = new Point(2, 2);
        System.out.println("x value of myPoint " + myPoint.getX());
        Point myPoint2 = new Point(myPoint);
        System.out.println("x value of myPoint2 " + myPoint2.getX());
        Point myPoint3 = new Point(myPoint);
        myPoint3.setX(3);
        myPoint3.setY(5);
        myPoint.setX(0);
//        System.out.println("myPoint x value after change  " + myPoint.getX());
        System.out.println("get values as string " + myPoint.toString());
        System.out.println("is equal " + myPoint.equals(myPoint2));
        System.out.println("is above " + myPoint.isAbove(myPoint2));
        System.out.println("is under " + myPoint.isUnder(myPoint2));
        System.out.println("is left " + myPoint.isLeft(myPoint2));
        System.out.println("is right " + myPoint.isRight(myPoint2));
        System.out.println("The distance is " + myPoint.distance(myPoint2));
        System.out.println("Quadrant is " + myPoint2.quadrant());
    }
}