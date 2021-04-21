/** Point - a class that presents a point in a 2 dimensional plane using (x,y) coordinates
 *
 *  @Author Pavel Butov
 * @version Maman 12
 */
public class Point {
    private double _x;
    private double _y;

    /**
     * Constructor
     * obtains new x, y coordinates
     *
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        _x = x;
        _y = y;
    }

    /**
     * Constructor
     *
     * instantiates a new object of the Point type
     * @param other reference object for coordinate copy
     */
    public Point(Point other) {
        _x = other._x;
        _y = other._y;
    }

    /**
     * Get x double
     *
     * @return obtaining x coordinate of the Point object
     */
    //Getters
    public double getX() {
        return _x;
    }

    /**
     * Get y double
     *
     * @return obtaining y coordinate of the Point object
     */
    public double getY() {
        return _y;
    }

    /**
     * Set x double
     *
     * @param num sets x coordinate of the Point object
     */
    //Setters
    public void setX(double num) {
        _x = num;
    }
    /**
     * Set x double
     *
     * @param num sets y coordinate of the Point object
     */
    public void setY(double num) {
        _y = num;
    }

    /** toString
     *
     * @return returns a string representation of the point's coordinates
     */
    public String toString() {
        return ("(" + _x + "," + _y + ")");
    }

    /**
     * equals boolean
     *
     * @param other point object used for comparison
     * @return returns true if coordinates of both points are equal or false if not
     */
    public boolean equals(Point other) {
        return ((_x == other._x) && (_y == other._y));
    }

    /**
     * isAbove boolean
     *
     * @param other point object used for comparison
     * @return returns true if the point is above the compared point or false if not
     */
    public boolean isAbove(Point other) {
        return ((_y > other._y));
    }

    /**
     * isUnder boolean
     *
     * @param other point object used for comparison
     * @return returns true if the point is under the compared point or false if not
     */
    public boolean isUnder(Point other) {
        return other.isAbove(this);
    }

    /**
     * isLeft boolean
     *
     * @param other point object used for comparison
     * @return returns true if the point is located left of the compared point or false if not
     */
    public boolean isLeft(Point other) {
        return ((_x < other._x));
    }

    /**
     * isRight boolean
     *
     * @param other point object used for comparison
     * @return returns true if the point is located right of the compared point or false if not
     */
    public boolean isRight(Point other) {
        return other.isLeft(this);
    }

    /**
     * distance
     *
     * @param p point object used for comparison
     * @return returns the distance between the two points compared
     */
    public double distance(Point p) {
        return Math.sqrt(Math.pow(_x - p.getX(), 2) + Math.pow(_y - p.getY(), 2));
    }

    /**
     * quadrant
     *
     * @return returns the number of quadrant the point is located at
     */
    public int quadrant() {
        if (_x > 0 && _y > 0) return 1;
        if (_x < 0 && _y > 0) return 2;
        if (_x < 0 && _y < 0) return 3;
        if (_x > 0 && _y < 0) return 4;
        return 0;
    }
}