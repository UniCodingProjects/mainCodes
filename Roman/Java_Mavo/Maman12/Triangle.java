/**
 * Class that represents a triangle object in 2D space.
 * Used to check various triangle characteristics and compare to another triangle class.
 *
 * @author Roman Rapoport
 * @version Maman12
 */
public class Triangle {
    private Point _point1;
    private Point _point2;
    private Point _point3;
    private double _edge1;
    private double _edge2;
    private double _edge3;
    public static final double EPSILON = 0.001;

    /**
     * Constructor
     * Instantiates a new default triangle object
     */
    public Triangle (){
        defaultTriangle();
    }

    /**
     * Constructor
     * Instantiates a new triangle based on 3 points where each point is a point class object that represents X,Y
     * values of the point
     *
     * @param point1 the point 1 of the triangle
     * @param point2 the point 2 of the triangle
     * @param point3 the point 3 of the triangle
     */
    public Triangle (Point point1, Point point2, Point point3){
        if (!isValid(point1, point2, point3)){
            defaultTriangle();
        }
        else {
            setPointsByCoords(point1,  point2,  point3);
        }
    }

    /**
     * Constructor
     * Instantiates a new triangle based on 3 points where each point consists of 2 doubles (X,Y)
     *
     * @param point1 the point 1 X value
     * @param point2 the point 1 Y value
     * @param point3 the point 2 X value
     * @param point4 the point 2 Y value
     * @param point5 the point 3 X value
     * @param point6 the point 3 Y value
     */
    public Triangle (double point1, double point2, double point3, double point4, double point5, double point6){
        if (!isValid(new Point(point1, point2), new Point(point3, point4), new Point(point5, point6))){
            defaultTriangle();
        }
        else {
            setPointsByCoords(point1,  point2,  point3,  point4,  point5,  point6);
        }
    }

    /**
     * Copy constructor
     * Instantiates a new triangle object.
     *
     * @param other triangle object
     */
    public Triangle (Triangle other){
        setPointsByCoords(other._point1, other._point2, other._point3);
    }

    private void defaultTriangle(){
        setPointsByCoords(1.0,  0.0,  -1.0,  0.0,  0.0,  1.0);
    }

    // private methods
    private void setPointsByCoords(Point point1, Point point2, Point point3) {
        this._point1 = point1;
        this._point2 = point2;
        this._point3 = point3;
        setEdges();
    }

    private void setPointsByCoords(double point1, double point2, double point3, double point4, double point5, double point6){
        this._point1 = new Point(point1, point2);
        this._point2 = new Point(point3, point4);
        this._point3 = new Point(point5, point6);
        setEdges();
    }

    private void setEdges(){
        this._edge1 = this._point1.distance(this._point2);
        this._edge2 = this._point2.distance(this._point3);
        this._edge3 = this._point3.distance(this._point1);
    }

    private boolean compareEqual(double num1, double num2){
        return (Math.abs(num1 - num2) < this.EPSILON);
    }

    private boolean compareEdge(Double edge){
        return compareEqual(edge, this._edge1) ||
                compareEqual(edge, this._edge2) ||
                compareEqual(edge, this._edge3);
    }


    private boolean assertPointIsAboveOthers(Point point) {
        return this._point1.isAbove(point) && this._point2.isAbove(point) && this._point3.isAbove(point);
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

    // public methods
    /**
     * Get point 1 point.
     *
     * @return value of first point
     */
    public Point getPoint1(){
        return this._point1;
    }

    /**
     * Get point 2 point.
     *
     * @return value of second point
     */
    public Point getPoint2(){
        return this._point2;
    }

    /**
     * Get point 3 point.
     *
     * @return value of third point
     */
    public Point getPoint3(){
        return this._point3;
    }

    /**
     * Set point 1.
     *
     * @param point1 Set point 1
     */
    public void setPoint1(Point point1){
        if (isValid(point1, this._point2, this._point3)){
            this._point1 = point1;
            setEdges();
        }
    }

    /**
     * Set point 2.
     *
     * @param point2 Set point 2
     */
    public void setPoint2(Point point2){
        if (isValid(this._point1, point2, this._point3)){
            this._point2 = point2;
            setEdges();
        }
    }

    /**
     * Set point 3.
     *
     * @param point3 Set point 3
     */
    public void setPoint3(Point point3){
        if (isValid(this._point1, this._point2, point3)){
            this._point3 = point3;
            setEdges();
        }
    }

    /**
     * Is valid boolean.
     *
     * @param p1 point 1
     * @param p2 point 2
     * @param p3 point 3
     * @return true if triangle is valid or false if not
     */
    public boolean isValid(Point p1, Point p2, Point p3){
        double edge1 = p1.distance(p2);
        double edge2 = p2.distance(p3);
        double edge3 = p3.distance(p1);
        return !(compareEqual((edge1 + edge2), edge3) ||
                compareEqual((edge2 + edge3), edge1) ||
                compareEqual((edge1 + edge3), edge2));
    }

    /**
     *
     * @return a string representation of the 3 points that form the triangle
     */
    public String toString(){
        return ""+'{'+this._point1+','+this._point2+','+this._point3+'}';
    }

    /**
     * Get perimeter double.
     *
     * @return the triangle's perimeter
     */
    public double getPerimeter(){
        return this._edge1 + this._edge2 + this._edge3;
    }

    /**
     * Get area double.
     *
     * @return the triangle's area
     */
    public double getArea(){
        double s = getPerimeter()/2;
        return Math.sqrt(s*(s-this._edge1)*(s-this._edge2)*(s-this._edge3));
    }

    /**
     * Is isosceles boolean.
     *
     * @return true if the triangle is an isosceles triangle otherwise returns false
     */
    public boolean isIsosceles(){
        return (compareEqual(this._edge1, this._edge3) ||
                compareEqual(this._edge2, this._edge3) ||
                compareEqual(this._edge1, this._edge2));
    }

    /**
     * Is pythagorean boolean.
     *
     * @return true if the triangle is a pythagorean triangle otherwise returns false
     */
    public boolean isPythagorean(){
        return (compareEqual(Math.sqrt(Math.pow(this._edge1, 2) + Math.pow(this._edge2, 2)), this._edge3) ||
                compareEqual(Math.sqrt(Math.pow(this._edge2, 2) + Math.pow(this._edge3, 2)), this._edge1) ||
                compareEqual(Math.sqrt(Math.pow(this._edge3, 2) + Math.pow(this._edge1, 2)), this._edge2));
    }

    /**
     * Is contained in circle boolean.
     *
     * @param x x coordinate of the circle center
     * @param y y coordinate of the circle center
     * @param r the circle's radius
     * @return true if the triangle is contained in circle otherwise returns false
     */
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

    /**
     * Lowest point point.
     *
     * @return Lowest point in the triangle
     */
    public Point lowestPoint(){
        return assertIsPlacement("isUnder");
    }

    /**
     * Highest point point.
     *
     * @return Highest point in the triangle
     */
    public Point highestPoint(){
        return assertIsPlacement("isAbove");
    }

    /**
     * Is located boolean.
     *
     * @return true if the whole triangle is in one quadrant otherwise returns false
     */
    public boolean isLocated(){
        if (compareEqual(this._point1.quadrant(), this._point2.quadrant())){
            return compareEqual(this._point1.quadrant(), this._point3.quadrant());
        }
        return false;
    }

    /**
     * Is above boolean.
     *
     * @param other the triangle object to compare to
     * @return true if the triangle is fully above the compared to triangle otherwise return false
     */
    public boolean isAbove(Triangle other){
        if (!assertPointIsAboveOthers(other.getPoint1())){
            return false;
        }
        if (!assertPointIsAboveOthers(other.getPoint2())){
            return false;
        }
        return assertPointIsAboveOthers(other.getPoint3());
    }

    /**
     * Is under boolean.
     *
     * @param other the triangle object to compare to
     * @return true if the triangle is fully below the compared to triangle
     */
    public boolean isUnder(Triangle other) {
        return other.isAbove(this);
    }

    /**
     * Equals boolean.
     *
     * @param other the triangle object to compare to
     * @return true if the triangles are equal otherwise return false
     */
    public boolean equals(Triangle other){
        return this._point1.distance(other._point1) < EPSILON && this._point2.distance(other._point2) < EPSILON && this._point3.distance(other._point3) < EPSILON;
    }

    /**
     * Is congruent boolean.
     *
     * @param other the triangle object to compare to
     * @return true if the triangles are congruent otherwise return false
     */
    public boolean isCongruent(Triangle other) {
        if (compareEdge(other._edge1) && compareEdge(other._edge2) && compareEdge(other._edge3)) {
            if (compareEdge(other._edge1) && compareEdge(other._edge2) && compareEdge(other._edge3)) {
                if (compareEdge(other._edge1) && compareEdge(other._edge2) && compareEdge(other._edge3)) {
                    return true;
                }
            }
        }
        return false;
    }
}
