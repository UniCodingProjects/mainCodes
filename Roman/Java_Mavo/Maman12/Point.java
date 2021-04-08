/**
 * Point class that represents a point in a 2D plane based on the cartesian system, e.g. (x, y)
 *
 * @author Roman Rapoport
 * @version V1
 */
public class Point {
    private double _x;
    private double _y;

    /**
     * Constructor
     * Instantiates a new Point object
     *
     * @param x coordinate
     * @param y coordinate
     */
    public Point(double x, double y){
        this._x = x;
        this._y = y;
    }

    /**
     * Copy constructor
     * Instantiates a new Point object
     *
     * @param other the point object to use as a reference for coordinates copy
     */
    public Point (Point other){
       this._x = other._x;
       this._y = other._y;
    }

    /**
     * Get x double.
     *
     * @return get X coordinate of the point
     */
    public double getX(){
        return this._x;
    }

    /**
     * Get y double.
     *
     * @return get Y coordinate of the point
     */
    public double getY(){
        return this._y;
    }

    /**
     * Set x.
     *
     * @param num set X coordinate of the point
     */
    public void setX(double num){
        this._x = num;
    }

    /**
     * Set y.
     *
     * @param num set Y coordinate of the point
     */
    public void setY(double num){
        this._y = num;
    }

    /**
     * @return string representation of the point as X,Y coordinate
     */
    public String toString(){
        return ""+'('+_x+','+_y+')';
    }

    /**
     * Equals boolean.
     *
     * @param other another point object to compare with
     * @return true if points are of equal value, otherwise false
     */
    public boolean equals(Point other){
        if (other._x == this._x && other._y == this._y){
            return true;
        }
        return false;
    }

    /**
     * Is above boolean.
     *
     * @param other another point object to compare with
     * @return true if the point is above the compared to point, otherwise false
     */
    public boolean isAbove(Point other){
        if (other._y < this._y){
            return true;
        }
        return false;
    }

    /**
     * Is under boolean.
     *
     * @param other another point object to compare with
     * @return true if the point is under the compared to point
     */
    public boolean isUnder(Point other){
        return other.isAbove(this);
    }

    /**
     * Is left boolean.
     *
     * @param other another point object to compare with
     * @return true if the point is to the left of the compared to point
     */
    public boolean isLeft(Point other){
        if (other._x > this._x){
            return true;
        }
        return false;
    }

    /**
     * Is right boolean.
     *
     * @param other another point object to compare with
     * @return true if the point is to the right of the compared to point
     */
    public boolean isRight(Point other){
        return other.isLeft(this);
    }

    /**
     * Distance double.
     *
     * @param p another point object to compare with
     * @return distance between the compare points
     */
    public double distance (Point p){
        return Math.sqrt(Math.pow((p._y - this._y), 2) + Math.pow((p._x - this._x), 2));
    }

    /**
     * Quadrant int.
     *
     * @return the quadrant number in which the point is located
     */
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
}
