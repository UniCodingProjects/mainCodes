import com.sun.jdi.Method;

/**
 *Triangle class
 @author Roman Rapoport)
 @version (V1)
 */
public class Triangle {
    private Point _point1;
    private Point _point2;
    private Point _point3;
    private double _edge1;
    private double _edge2;
    private double _edge3;
    public static final double EPSILON = 0.001;

    // define class constructors //
    public Triangle (){
        this._point1 = new Point(1.0, 0.0);
        this._point2 = new Point(-1.0, 0.0);
        this._point3 = new Point(0.0, 1.0);
        setEdges();
    }

    public Triangle (Point point1, Point point2, Point point3){
        this._point1 = new Point(point1);
        this._point2 = new Point(point2);
        this._point3 = new Point(point3);
        setEdges();
    }

    public Triangle (double point1, double point2, double point3, double point4, double point5, double point6){
        this._point1 = new Point(point1, point2);
        this._point2 = new Point(point3, point4);
        this._point3 = new Point(point5, point6);
        setEdges();
    }

    public Triangle (Triangle other){
        this._point1 = other._point1; //TODO: check if not aliasing here
        this._point2 = other._point2;
        this._point3 = other._point3;
        setEdges();
    }

    private boolean compareEqual(double num1, double num2){
        return (Math.abs(num1 - num2) < this.EPSILON);
    }

    private void setEdges(){
        this._edge1 = this._point1.distance(this._point2); //TODO: check if not aliasing here
        this._edge2 = this._point2.distance(this._point3);
        this._edge3 = this._point3.distance(this._point1);
    }

    private Point assertForEqualY(){
        if (compareEqual(this._point1.getY(), this._point2.getY())){
            if (this._point1.isLeft(this._point2)){
                return this._point1;
            }
            else {
                return this._point2;
            }
        }
        else {
            if (this._point2.isLeft(this._point3)){
                return this._point2;
            }
            else {
                return this._point3;
            }
        }
    }

    private Point assertIsPlacement(String placement){
        switch (placement) {
            case ("isAbove"):
                if (this._point1.isAbove(this._point2) && this._point1.isAbove(this._point3)) {
                    return this._point1;
                }
                if (this._point2.isAbove(this._point1) && this._point2.isAbove(this._point3)) {
                    return this._point2;
                }
                if (this._point3.isAbove(this._point2) && this._point3.isAbove(this._point1)) {
                    return this._point3;
                }
                if (this._point1.isAbove(this._point2)) {
                    if (this._point1.isLeft(this._point3)) {
                        return this._point1;
                    } else {
                        return this._point3;
                    }
                }
            case("isUnder"):
                if (this._point1.isUnder(this._point2) && this._point1.isUnder(this._point3)) {
                    return this._point1;
                }
                if (this._point2.isUnder(this._point1) && this._point2.isUnder(this._point3)) {
                    return this._point2;
                }
                if (this._point3.isUnder(this._point2) && this._point3.isUnder(this._point1)) {
                    return this._point3;
                }
                if (this._point1.isUnder(this._point2)){
                    if (this._point1.isLeft(this._point3)){
                        return this._point1;
                    }
                    else {
                        return this._point3;
                    }
                }
        }
        return assertForEqualY();
    }

    private boolean assertPointIsAboveOthers(Point point) {
        return this._point1.isAbove(point) && this._point2.isAbove(point) && this._point3.isAbove(point);
    }

    // define getters
    /**
     *
     * @return value of first defined Point
     */
    public Point getPoint1(){
        return this._point1;
    }

    public Point getPoint2(){
        return this._point2;
    }

    public Point getPoint3(){
        return this._point3;
    }

    // define setters
    public void setPoint1(Point point1){
       this._point1 = point1;
    }

    public void setPoint2(Point point2){
        this._point2 = point2;
    }

    public void setPoint3(Point point3){
        this._point3 = point3;
    }

    // def class methods
    public boolean isValid(Point p1, Point p2, Point p3){
        double edge1 = p1.distance(p2);
        double edge2 = p2.distance(p3);
        double edge3 = p3.distance(p1);
        return !(compareEqual((edge1 + edge2), edge3) ||
                compareEqual((edge2 + edge3), edge1) ||
                compareEqual((edge1 + edge3), edge2));
    }

    public String toString(){
        return ""+'{'+this._point1+','+this._point2+','+this._point3+'}';
    }

    public double getPerimeter(){
        return this._edge1 + this._edge2 + this._edge3;
    }

    public double getArea(){
        double s = getPerimeter()/2;
        return Math.sqrt(s*(s-this._edge1)*(s-this._edge2)*(s-this._edge3));
    }

    public boolean isIsosceles(){
        return (compareEqual(this._edge1, this._edge3) ||
                compareEqual(this._edge2, this._edge3) ||
                compareEqual(this._edge1, this._edge2));
    }

    public boolean isPythagorean(){
        return (compareEqual(Math.sqrt(Math.pow(this._edge1, 2) + Math.pow(this._edge2, 2)), this._edge3) ||
                compareEqual(Math.sqrt(Math.pow(this._edge2, 2) + Math.pow(this._edge3, 2)), this._edge1) ||
                compareEqual(Math.sqrt(Math.pow(this._edge3, 2) + Math.pow(this._edge1, 2)), this._edge2));
    }

    public boolean isContainedInCircle(double x , double y, double r){
        Point circlePoint = new Point(x, y);
        if (r - this._point1.distance(circlePoint) < EPSILON){
            return false;
        }
        else if (r - this._point2.distance(circlePoint) < EPSILON){
            return false;
        }
        else if (r - this._point3.distance(circlePoint) < EPSILON){
            return false;
        }
        else {
            return true;
        }
    }

    public Point lowestPoint(){
        return assertIsPlacement("isUnder");
    }

    public Point highestPoint(){
        return assertIsPlacement("isAbove");
    }

    public boolean isLocated(){
        if (compareEqual(this._point1.quadrant(), this._point2.quadrant())){
            return compareEqual(this._point1.quadrant(), this._point3.quadrant());
        }
        return false;
    }

    public boolean isAbove(Triangle other){
        if (!assertPointIsAboveOthers(other.getPoint1())){
            return false;
        }
        if (!assertPointIsAboveOthers(other.getPoint2())){
            return false;
        }
        return assertPointIsAboveOthers(other.getPoint3());
    }

    public boolean isUnder(Triangle other) {
        return other.isAbove(this);
    }

    public boolean equals(){
        return false;
    }

    public boolean isCongruent(){
        return false;
    }

    public static void main(String[ ] args) {
        Point myPoint = new Point(-2, 5);
        Point myPoint2 = new Point(-3, 2);
        Point myPoint3 = new Point(-3 ,1);
        Point p1 = new Point(-10, 20);
        Point p2 = new Point(-12, 30);
        Point p3 = new Point(-20 ,10);
//        Point myPoint4 = new Point(-3 ,-20);
        Triangle newT = new Triangle(myPoint, myPoint2, myPoint3);
        Triangle newTT = new Triangle(p1, p2, p3);
//        newT.setPoint1(myPoint4);
//        System.out.println(newT.isValid(myPoint, myPoint2, myPoint3));
//        System.out.println(newT.isIsosceles());
//        System.out.println(newT.isPythagorean());
//        System.out.println(newT.toString());
        System.out.println(newT.isContainedInCircle(2.5, 4, 3));
        System.out.println(newT.lowestPoint());
        System.out.println(newT.highestPoint());
        System.out.println(newT.isLocated());
        System.out.println(newT.isAbove(newTT));
        System.out.println(newT.isUnder(newTT));
    }
}
