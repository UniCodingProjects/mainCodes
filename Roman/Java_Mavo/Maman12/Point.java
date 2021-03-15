public class Point {
    private double _x;
    private double _y;
    public Point(double x, double y){
        _x = x;
        _y = y;
    }
    public Point (Point other){
       _x = other._x;
       _y = other._y;
    }
    double getX(){
        return _x;
    }
    double getY(){
        return _y;
    }
    void setX(double num){
        _x = num;
    }
    void setY(double num){
        _y = num;
    }
    public String toString(){
        return ""+'('+_x+','+_y+')';
    }
    private boolean equals(Point other){
        if (other.getX() == this._x && other.getY() == this._y){
            return true;
        }
        return false;
    }
    private boolean isAbove(Point other){
        if (other.getY() > this._y){
            return true;
        }
        return false;
    }
    private boolean isUnder(Point other){
        return !isAbove(other);
    }

    private boolean isLeft(Point other){
        if (other.getX() < this._x){
            return true;
        }
        return false;
    }
    private boolean isRight(Point other){
        return !isLeft(other);
    }

    double distance (Point p){
        return Math.sqrt(Math.pow((p.getY() - this._y), 2) + Math.pow((p.getX() - this._x), 2));
    }
    public static void main(String[] args){
        Point myPoint = new Point(2.0, 3.0);
        System.out.println(myPoint.toString());
        myPoint.setX(1.5);
        System.out.println(myPoint.toString());
        Point myPoint2 = new Point(4.0 ,3.5);
        System.out.println(myPoint.equals(myPoint2));
        System.out.println(myPoint.isAbove(myPoint2));
        System.out.println(myPoint.isUnder(myPoint2));
        System.out.println(myPoint.isLeft(myPoint2));
        System.out.println(myPoint.isRight(myPoint2));
        System.out.println(myPoint.distance(myPoint2));
    }
}
