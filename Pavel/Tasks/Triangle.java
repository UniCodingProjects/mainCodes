import java.security.spec.ECPoint;

public class Triangle {
    public static final double EPSILON = 0.001;
    private Point _point1;
    private Point _point2;
    private Point _point3;
    private double side1; // distance of p1 to p2
    private double side2; // distance of p2 to p3
    private double side3; // distance of p3 to p1

    public Triangle() { // add default points into default constructor
        _point1 = new Point(1, 0);
        _point2 = new Point(-1, 0);
        _point3 = new Point(0, 1);
        calculateSides();
    }

    public Triangle(Point p1, Point p2, Point p3) {
        if (!isValid(p1, p2, p3)) {
            _point1 = new Point(1, 0);
            _point2 = new Point(-1, 0);
            _point3 = new Point(0, 1);
            calculateSides();
//            defaultTriangle();
        } else {
            _point1 = p1;
            _point2 = p2;
            _point3 = p3;
            calculateSides();
//            setPoints(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
        }
    }

    public Triangle(double point1, double point2, double point3, double point4, double point5, double point6) {
        if (!isValid(new Point(point1, point2), new Point(point3, point4), new Point(point5, point6))) {
            _point1 = new Point(1, 0);
            _point2 = new Point(-1, 0);
            _point3 = new Point(0, 1);
            calculateSides();
//            defaultTriangle();
        } else {
            _point1 = new Point(point1, point2);
            _point2 = new Point(point3, point4);
            _point3 = new Point(point5, point6);
            calculateSides();
//            setPoints(point1, point2, point3, point4, point5, point6);
        }
    }

    public Triangle(Triangle other) {
        _point1 = other._point1;
        _point2 = other._point2;
        _point3 = other._point3;
        calculateSides();
    }

    //    private void defaultTriangle(){
//        setPoints(1.0, 0.0, -1.0, 0.0, 0.0, 1.0);
//    }
//    private void setPoints(Point point1, Point point2, Point point3){
//        this._point1 = point1;
//        this._point2 = point2;
//        this._point3 = point3;
//    }
//    private void setPoints(double point1, double point2, double point3, double point4, double point5, double point6){
//        this._point1 = new Point(point1, point2);
//        this._point2 = new Point(point3, point4);
//        this._point3 = new Point(point5, point6);
//    }
    //Getters
    public Point getPoint1() {
        return _point1;
    }
    public Point getPoint2() {
        return _point2;
    }
    public Point getPoint3() {
        return _point3;
    }

    //Setters
    public void setPoint1(Point p) {
        if (isValid(p, _point2, _point3)) {
            _point1 = p;
        }
    }
    public void setPoint2(Point p) {
        if (isValid(_point1, p, _point3)) {
            _point2 = p;
        }
    }
    public void setPoint3(Point p) {
        if (isValid(_point1, _point2, p)) {
            _point3 = p;
        }
    }
    public boolean isValid(Point p1, Point p2, Point p3) {
        double sideA = p1.distance(p2);
        double sideB = p2.distance(p3);
        double sideC = p3.distance(p1);

        if (isEqual(sideA, sideB, sideC)) {
            return false;
        }
        return true;
    }

    private boolean isEqual(double sideA, double sideB, double sideC) {//Check if length of each 2 sides equals the 3rd side
        if (Math.abs(sideA + sideB - sideC) < EPSILON) {
            return true;
        } else if (Math.abs(sideA + sideC - sideB) < EPSILON) {
            return true;
        } else {
            return (Math.abs(sideB + sideC - sideA) < EPSILON);
        }
    }

    public String toString() {
        return ("{" + _point1 + " , " + _point2 + " , " + _point3 + "}");
    }
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
    public double getArea(){
        return Math.sqrt((side1+side2+side3)*(side1+side2-side3)*(side2+side3-side1)*(side3+side1-side2));
    }
    private void calculateSides() {
        side1 = _point1.distance(_point2);
        side2 = _point2.distance(_point3);
        side3 = _point3.distance(_point1);
//       System.out.println(side1 + "," + side2 + "," + side3);
    }
    public boolean isIsosceles() {
//        if(((Math.abs(side1 - side2)) < EPSILON) || ((Math.abs(side2 - side3)) < EPSILON) || ((Math.abs(side1 - side3)) < EPSILON)){
            return (((Math.abs(side1 - side2)) < EPSILON) || ((Math.abs(side2 - side3)) < EPSILON) || ((Math.abs(side1 - side3)) < EPSILON));
    }
    public boolean isPythagorean(){
        return ((Math.pow(side1,2)+Math.pow(side2,2))-(Math.pow(side3,2)) < EPSILON) || ((Math.pow(side2,2)+Math.pow(side3,2))-(Math.pow(side1,2)) < EPSILON) || ((Math.pow(side1,2)+Math.pow(side3,2))-(Math.pow(side2,2)) < EPSILON);
    }
    public boolean isContainedInCircle(double x, double y, double r){
        if(_point1.distance(new Point(x,y)) <= r && _point2.distance(new Point(x,y)) <= r && _point3.distance(new Point(x,y)) <= r) {
            return true;
        }
        return false;
    }

//    private boolean compareEqualHeight(){
//        if((Math.abs((_point1.getY() - _point2.getY())) < EPSILON){
//
//        }
//
//    }
//    public Point lowestPoint() { //**********last version**************//
//          if (((_point1.isUnder(_point2)) || ((Math.abs((_point1.getY() - _point2.getY())) < EPSILON) && _point1.isLeft(_point2))) && ((_point1.isUnder(_point3)) || ((Math.abs(_point1.getY() - _point3.getY())) < EPSILON) && _point1.isLeft(_point3))) {
//              if((!(_point1.isUnder(_point2))) && (Math.abs(_point1.getY() - _point2.getY())) < EPSILON) {
//                  return _point1;
//              }
//          }else if(((_point2.isUnder(_point1)) || ((Math.abs((_point2.getY() - _point1.getY())) < EPSILON) && _point2.isLeft(_point1))) && ((_point2.isUnder(_point3)) || ((Math.abs(_point2.getY() - _point1.getY())) < EPSILON) && _point2.isLeft(_point3))){
//                  if((!(_point2.isUnder(_point1))) && (Math.abs(_point2.getY() - _point1.getY())) < EPSILON) {
//                      return _point2;
//                  }
//          }else if(((_point3.isUnder(_point1)) || ((Math.abs((_point3.getY() - _point1.getY())) < EPSILON) && _point3.isLeft(_point1))) && ((_point3.isUnder(_point2)) || ((Math.abs(_point3.getY() - _point2.getY())) < EPSILON) && _point3.isLeft(_point2))){
//                  if((!(_point3.isUnder(_point1))) && (Math.abs(_point3.getY() - _point1.getY())) < EPSILON) {
//                      return _point3;
//                  }///////////*************************************///////////////////
//        if (((_point1.isUnder(_point2)) && (_point1.isUnder(_point3))) || ((Math.abs((_point1.getY() - _point2.getY())) < EPSILON) && _point1.isLeft(_point2)) || ((Math.abs(_point1.getY() - _point3.getY())) < EPSILON) && _point1.isLeft(_point3)){
//            return _point1;
//        }else if(((_point2.isUnder(_point1)) && (_point2.isUnder(_point3))) || ((Math.abs((_point2.getY() - _point1.getY())) < EPSILON) && _point2.isLeft(_point1)) || ((Math.abs(_point2.getY() - _point3.getY())) < EPSILON) && _point2.isLeft(_point3)) {
//            return _point2;
//        }else if(((_point3.isUnder(_point1)) && (_point3.isUnder(_point2))) || ((Math.abs((_point3.getY() - _point1.getY())) < EPSILON) && _point3.isLeft(_point1)) || ((Math.abs(_point3.getY() - _point2.getY())) < EPSILON) && _point3.isLeft(_point2)){
//            return _point3;
//        }
//        return null;
//    }
//    public Point highestPoint() { //********* last version***********//
//        if (((_point1.isAbove(_point2)) && (_point1.isAbove(_point3))) || ((Math.abs((_point1.getY() - _point2.getY())) < EPSILON) && _point1.isLeft(_point2)) || ((Math.abs(_point1.getY() - _point3.getY())) < EPSILON) && _point1.isLeft(_point3)) {
//            return _point1;
//        } else if (((_point2.isAbove(_point1)) && (_point2.isAbove(_point3))) || ((Math.abs((_point2.getY() - _point1.getY())) < EPSILON) && _point2.isLeft(_point1)) || ((Math.abs(_point2.getY() - _point3.getY())) < EPSILON) && _point2.isLeft(_point3)) {
//            return _point2;
//        } else if (((_point3.isAbove(_point1)) && (_point3.isAbove(_point2))) || ((Math.abs((_point3.getY() - _point1.getY())) < EPSILON) && _point3.isLeft(_point1)) || ((Math.abs(_point3.getY() - _point2.getY())) < EPSILON) && _point3.isLeft(_point2)){
//                return _point3;
//            }
//        return null;
//    }///////////////////////***********************///////////////////////
//    public boolean isLocated(){
//        if((_point1.quadrant( && _point2.quadrant() = 1 && _point3.quadrant() = 1){
//
//        }
//    }


    public static void main(String []args){
//        Triangle myT2 = new Triangle(myT);
        Point p1 = new Point(0,3);
        Point p2 = new Point(1,3);
        Point p3 = new Point(-2,0);
        Triangle myT = new Triangle(p1,p2,p3);
//        Triangle myT = new Triangle();
//        myT.calculateSides();
//        myT.getArea();
//        myT.setPoint1(new Point(-2,3));
//        myT.setPoint2(new Point(-1,4));
//        myT.setPoint3(new Point(6,1));
        Triangle myT3 = new Triangle(1.0,2,3,4,8,6);
        System.out.println(myT.getPoint1());
//        System.out.println(myT.side1); // need to add calculate side function
//        System.out.println(myT.side2);
//        System.out.println(myT.side3);
        System.out.println("" + myT.getPoint1() + myT.getPoint2() + myT.getPoint3());
        System.out.println(myT.toString());
        System.out.println(myT.getPerimeter());
        System.out.println(myT.getArea());
//        System.out.println(myT.isIsosceles());
//        System.out.println(myT.isPythagorean());
        System.out.println(myT.isContainedInCircle(1,2,3.02));
//        System.out.println(myT.lowestPoint());
//        System.out.println(myT.highestPoint());
    }
}