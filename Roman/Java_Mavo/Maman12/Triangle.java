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
    final double EPSILON = 0.001;

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

    private boolean compareBelowEpsilon(double num1, double num2){
        return (Math.abs(num1 - num2) < this.EPSILON);
    }

    private void setEdges(){
        this._edge1 = this._point1.distance(this._point2); //TODO: check if not aliasing here
        this._edge2 = this._point2.distance(this._point3);
        this._edge3 = this._point3.distance(this._point1);
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
        this._point1 = point2;
    }

    public void setPoint3(Point point3){
        this._point1 = point3;
    }

    // def class methods
    public boolean isValid(Point p1, Point p2, Point p3){
        double edge1 = p1.distance(p2);
        double edge2 = p2.distance(p3);
        double edge3 = p3.distance(p1);
        return !(compareBelowEpsilon((edge1 + edge2), edge3) ||
                compareBelowEpsilon((edge2 + edge3), edge1) ||
                compareBelowEpsilon((edge1 + edge3), edge2));
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
        return (compareBelowEpsilon(this._edge1, this._edge3) ||
                compareBelowEpsilon(this._edge2, this._edge3) ||
                compareBelowEpsilon(this._edge1, this._edge2));
    }

    public boolean isPythagorean(){
        return (compareBelowEpsilon(Math.sqrt(Math.pow(this._edge1, 2) + Math.pow(this._edge2, 2)), this._edge3) ||
                compareBelowEpsilon(Math.sqrt(Math.pow(this._edge2, 2) + Math.pow(this._edge3, 2)), this._edge1) ||
                compareBelowEpsilon(Math.sqrt(Math.pow(this._edge3, 2) + Math.pow(this._edge1, 2)), this._edge2));
    }


    public static void main(String[] args) {
        Point myPoint = new Point(5, -4.0);
        Point myPoint2 = new Point(2, 0);
        Point myPoint3 = new Point(0 ,-4.0);
        Triangle newT = new Triangle(myPoint, myPoint2, myPoint3);
        System.out.println(newT.isValid(myPoint, myPoint2, myPoint3));
        System.out.println(newT.isIsosceles());
        System.out.println(newT.isPythagorean());
    }
}
