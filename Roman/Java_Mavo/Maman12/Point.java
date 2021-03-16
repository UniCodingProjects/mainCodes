public class Point {
    /** Point class represents a point in a 2D plane based on the cartesian system, e.g. (x, y)
     * @author Roman Rapoport
     * */
    // declarations //
    private double _x;
    private double _y;

    // constructor definitions //
    public Point(double x, double y){
        this._x = x;
        this._y = y;
    }
    public Point (Point other){
       this._x = other._x;
       this._y = other._y;
    }

    // define getters //
    public double getX(){
        return this._x;
    }
    public double getY(){
        return this._y;
    }

    //d define setters //
    public void setX(double num){
        this._x = num;
    }
    public void setY(double num){
        this._y = num;
    }

    // define class methods //
    public String toString(){
        return ""+'('+_x+','+_y+')';
    }
    public boolean equals(Point other){
        if (other._x == this._x && other._y == this._y){
            return true;
        }
        return false;
    }
    public boolean isAbove(Point other){
        if (other._y > this._y){
            return true;
        }
        return false;
    }
    public boolean isUnder(Point other){
        return !isAbove(other);
    }

    public boolean isLeft(Point other){
        if (other._x < this._x){
            return true;
        }
        return false;
    }
    public boolean isRight(Point other){
        return !isLeft(other);
    }

    public double distance (Point p){
        return Math.sqrt(Math.pow((p._y - this._y), 2) + Math.pow((p._x - this._x), 2));
    }

    public int quadrant(){
        if (this._x >0 && this._y> 0){
            return 1;
        }
        if (this._x >0 && this._y < 0){
            return 4;
        }
        if (this._x <0 && this._y> 0){
            return 2;
        }
        if (this._x <0 && this._y< 0){
            return 3;
        }
        return 0;
    }
    public static void main(String[] args){
        Point myPoint = new Point(2.0, -3.0);
        System.out.println(myPoint.toString());
        myPoint.setX(1.5);
//        myPoint.setY(1.5);
        System.out.println(myPoint.toString());
        Point myPoint2 = new Point(4.0 ,3.5);
        System.out.println(myPoint.equals(myPoint2));
        System.out.println(myPoint.isAbove(myPoint2));
        System.out.println(myPoint.isUnder(myPoint2));
        System.out.println(myPoint.isLeft(myPoint2));
        System.out.println(myPoint.isRight(myPoint2));
        System.out.println(myPoint.distance(myPoint2));
        System.out.println(myPoint.quadrant());
        Point myPoint3 = new Point(myPoint);
        System.out.println(myPoint3.equals(myPoint));
    }
}
