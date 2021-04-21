/** Triangle - a class that represents a triangle object in a 2 dimensional space based on 3 points
 * Provides various methods to discover the characteristics of a triangle and compare to other triangles
 *
 * @Author - Pavel Butov
 * @version - Maman 12
 */
public class Triangle {
    public static final double EPSILON = 0.001;
    private Point _point1;
    private Point _point2;
    private Point _point3;
    private double side1; // distance of p1 to p2
    private double side2; // distance of p2 to p3
    private double side3; // distance of p3 to p1

    /**
     * Constructor
     * Instantiates a new triangle based on 3 provided default points
     */
    public Triangle() { // add default points into default constructor
        _point1 = new Point(1, 0);
        _point2 = new Point(-1, 0);
        _point3 = new Point(0, 1);
        calculateSides();
    }

    /**
     * Constructor
     * Instantiates a new triangle based on 3 points each point consists of x and y coordinates
     *
     * @param p1 first point of the triangle
     * @param p2 second point of the triangle
     * @param p3 third point of the triangle
     */
    public Triangle(Point p1, Point p2, Point p3) {
        if (!isValid(p1, p2, p3)) {
            _point1 = new Point(1, 0);
            _point2 = new Point(-1, 0);
            _point3 = new Point(0, 1);
            calculateSides();
        } else {
            _point1 = p1;
            _point2 = p2;
            _point3 = p3;
            calculateSides();
        }
    }

    /**
     * Constructor
     * Instantiates a new triangle 3 points each point consists of x and y coordinates
     *
     * @param point1 represents the x value of the first point of the triangle
     * @param point2 represents the y value of the first point of the triangle
     * @param point3 represents the x value of the second point of the triangle
     * @param point4 represents the y value of the second point of the triangle
     * @param point5 represents the x value of the third point of the triangle
     * @param point6 represents the y value of the third point of the triangle
     */
    public Triangle(double point1, double point2, double point3, double point4, double point5, double point6) {
        if (!isValid(new Point(point1, point2), new Point(point3, point4), new Point(point5, point6))) {
            _point1 = new Point(1, 0);
            _point2 = new Point(-1, 0);
            _point3 = new Point(0, 1);
            calculateSides();
        } else {
            _point1 = new Point(point1, point2);
            _point2 = new Point(point3, point4);
            _point3 = new Point(point5, point6);
            calculateSides();
        }
    }

    /**
     * Copy Constructor
     * Instantiates a new triangle object
     *
     * @param other another triangle object
     */
    public Triangle(Triangle other) {
        _point1 = other._point1;
        _point2 = other._point2;
        _point3 = other._point3;
        calculateSides();
    }

    private boolean isSidesEqual(double sideA, double sideB, double sideC) { // Check if length of each 2 sides equals the 3rd side
        if (Math.abs(sideA + sideB - sideC) < EPSILON) {
            return true;
        } else if (Math.abs(sideA + sideC - sideB) < EPSILON) {
            return true;
        } else {
            return (Math.abs(sideB + sideC - sideA) < EPSILON);
        }
    }

    private void calculateSides() { // Calculates the distance of the sides
        side1 = _point1.distance(_point2);
        side2 = _point2.distance(_point3);
        side3 = _point3.distance(_point1);
    }

    //Getters

    /**
     * Get point 1
     *
     * @return returns the coordinate values of point1
     */
    public Point getPoint1() {
        return _point1;
    }

    /**
     * Get point 2
     *
     * @return returns the coordinate values of point2
     */
    public Point getPoint2() {
        return _point2;
    }

    /**
     * Get point 3
     *
     * @return returns the coordiante values of point3
     */
    public Point getPoint3() {
        return _point3;
    }

    //Setters

    /**
     * Set point 1
     *
     * @param p Sets point1
     */
    public void setPoint1(Point p) {
        if (isValid(p, _point2, _point3)) {
            _point1 = p;
        }
    }

    /**
     * Set point 2
     *
     * @param p Sets point2
     */
    public void setPoint2(Point p) {
        if (isValid(_point1, p, _point3)) {
            _point2 = p;
        }
    }

    /**
     * Set point 3
     *
     * @param p Sets point3
     */
    public void setPoint3(Point p) {
        if (isValid(_point1, _point2, p)) {
            _point3 = p;
        }
    }

    /**
     * isValid boolean
     *
     * @param p1 point1
     * @param p2 point2
     * @param p3 point3
     * @return returns true if the triangle is valid or false if not
     */
    public boolean isValid(Point p1, Point p2, Point p3) {
        double sideA = p1.distance(p2);
        double sideB = p2.distance(p3);
        double sideC = p3.distance(p1);

        if (isSidesEqual(sideA, sideB, sideC)) {
            return false;
        }
        return true;
    }

    /**
     * toString
     *
     * @return returns a coordinate representation of the points in a string format
     */
    public String toString() {
        return ("{" + _point1 + "," + _point2 + "," + _point3 + "}");
    }

    /**
     * getPerimeter double
     *
     * @return returns the perimeter of the triangle
     */
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    /**
     * getArea double
     *
     * @return returns the area of the triangle
     */
    public double getArea() {
        return (Math.sqrt((side1 + side2 + side3) * (side1 + side2 - side3) * (side2 + side3 - side1) * (side3 + side1 - side2)) / 4);
    }

    /**
     * isIsosceles boolean
     *
     * @return returns true if the triangle is isosceles or false if not
     */
    public boolean isIsosceles() {
        return (((Math.abs(side1 - side2)) < EPSILON) || ((Math.abs(side2 - side3)) < EPSILON) || ((Math.abs(side1 - side3)) < EPSILON));
    }

    /**
     * isPythagorean boolean
     *
     * @return returns true if the triangle is pythagorean or false if not
     */
    public boolean isPythagorean() {
        return ((Math.pow(side1, 2) + Math.pow(side2, 2)) - (Math.pow(side3, 2)) < EPSILON) || ((Math.pow(side2, 2) + Math.pow(side3, 2)) - (Math.pow(side1, 2)) < EPSILON) || ((Math.pow(side1, 2) + Math.pow(side3, 2)) - (Math.pow(side2, 2)) < EPSILON);
    }

    /**
     * isContainedInCircle boolean
     *
     * @param x coordinate x of a new point
     * @param y coordinate y of a new point
     * @param r length of a radius
     * @return returns true if the triangle is contained inside a circle or false if not
     */
    public boolean isContainedInCircle(double x, double y, double r) {
        if (_point1.distance(new Point(x, y)) <= r && _point2.distance(new Point(x, y)) <= r && _point3.distance(new Point(x, y)) <= r)
            return true;
        return false;
    }

    /**
     * lowestPoint point
     *
     * @return returns the lowest point of the triangle
     */
    public Point lowestPoint() {
        if (_point1.isUnder(_point2) && _point1.isUnder(_point3)) return _point1;
        if (_point2.isUnder(_point1) && _point2.isUnder(_point3)) return _point2;
        if (_point3.isUnder(_point2) && _point3.isUnder(_point1)) return _point3;

        if ((Math.abs(_point1.getY() - _point2.getY())) < EPSILON) {
            if (_point1.isLeft(_point2)) return _point1;
            return _point2;
        }
        if ((Math.abs(_point2.getY() - _point3.getY())) < EPSILON) {
            if (_point3.isLeft(_point2)) return _point2;
            return _point3;
        }
        if ((Math.abs(_point1.getY() - _point3.getY())) < EPSILON)
            if (_point1.isLeft(_point3)) return _point1;
        return _point3;
    }

    /**
     * highestPoint point
     *
     * @return returns the highest point of the triangle
     */
    public Point highestPoint() {
        if (_point1.isAbove(_point2) && _point1.isAbove(_point3)) return _point1;
        if (_point2.isAbove(_point1) && _point2.isAbove(_point3)) return _point2;
        if (_point3.isAbove(_point2) && _point3.isAbove(_point1)) return _point3;

        if ((Math.abs(_point1.getY() - _point2.getY())) < EPSILON) {
            if (_point1.isLeft(_point2)) return _point1;
            return _point2;
        }
        if ((Math.abs(_point2.getY() - _point3.getY())) < EPSILON) {
            if (_point3.isLeft(_point2)) return _point2;
            return _point3;
        }
        if ((Math.abs(_point1.getY() - _point3.getY())) < EPSILON)
            if (_point1.isLeft(_point3)) return _point1;
        return _point3;
    }

    /**
     * isLocated boolean
     *
     * @return returns true if all the points in the triangle are in the same quadrant
     */
    public boolean isLocated() {
        return (Math.abs(_point1.quadrant() - _point2.quadrant()) < EPSILON) && (Math.abs(_point2.quadrant() - _point3.quadrant()) < EPSILON);
    }

    /**
     * isAbove
     *
     * @param other another triangle for comparison
     * @return returns true if the triangle is above the other triangle or false if not
     */
    public boolean isAbove(Triangle other) {
        if (Triangle.this.lowestPoint().isAbove(other.highestPoint())) return true;
        return false;
    }

    /**
     * isUnder
     *
     * @param other another triangle for comparison
     * @return returns true if the triangle is under the other triangle or false if not
     */
    public boolean isUnder(Triangle other) {
        if (Triangle.this.highestPoint().isUnder(other.lowestPoint())) return true;
        return false;
    }

    /**
     * equals boolean
     *
     * @param other another triangle for comparison
     * @return returns true if the triangle equals to the other triangle or false if not
     */
    public boolean equals(Triangle other) {
        if ((Triangle.this._point1.equals(other._point1)) && (Triangle.this._point2.equals(other._point2)) && (Triangle.this._point3.equals(other._point3)))
            return true;
        return false;
    }

    /**
     * isCongruent boolean
     *
     * @param other another triangle for comparison
     * @return returns true if the triangle is congruent or false if not
     */
    public boolean isCongruent(Triangle other) {
        if ((Math.abs(Triangle.this._point1.distance(_point2) - other._point1.distance(other._point2)) < EPSILON) || (Math.abs(Triangle.this._point1.distance(_point2) - other._point2.distance(other._point3)) < EPSILON) || (Math.abs(Triangle.this._point1.distance(_point2) - other._point3.distance(other._point1)) < EPSILON))
            if ((Math.abs(Triangle.this._point2.distance(_point3) - other._point1.distance(other._point2)) < EPSILON) || (Math.abs(Triangle.this._point2.distance(_point3) - other._point2.distance(other._point3)) < EPSILON) || (Math.abs(Triangle.this._point2.distance(_point3) - other._point3.distance(other._point1)) < EPSILON))
                if ((Math.abs(Triangle.this._point3.distance(_point1) - other._point1.distance(other._point2)) < EPSILON) || (Math.abs(Triangle.this._point3.distance(_point1) - other._point2.distance(other._point3)) < EPSILON) || (Math.abs(Triangle.this._point3.distance(_point1) - other._point3.distance(other._point1)) < EPSILON))
                    return true;
        return false;
    }
}