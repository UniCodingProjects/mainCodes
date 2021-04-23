/** RGBImage - A class that represents a color image object via a 2-dimensional array where each block in the array
 *  represents a pixel made of an object that holds 3 values for each color of red,green and blue.
 *  Provides various methods allowing the user to manipulate the image.
 *
 * @author Pavel Butov
 * @version Maman 13
 */
public class RGBImage {
    private RGBColor[][] _image;

    /**
     * Constructor
     * Instantiates a new RGBImage with of default color(black) using the dimensions provided by the user
     *
     * @param rows amount rows in the image
     * @param cols amount of columns in the image
     */
    public RGBImage(int rows, int cols) {
        _image = new RGBColor[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                _image[i][j] = new RGBColor();
            }
        }
    }

    /**
     * Constructor
     * Instantiates a new RGBImage using an array as a parameter for dimensions
     *
     * @param pixels
     */
    public RGBImage(RGBColor[][] pixels) {
        _image = pixels;
    }

    /**
     * Copy Constructor
     * Instantiates a new RGBImage object
     *
     * @param other another RGBImage object
     */
    public RGBImage(RGBImage other) {
        _image = other._image;
    }

    /**
     * Get number of rows
     *
     * @return returns the amount of rows in the _image array
     */
    public int getHeight() {
        return _image.length;
    }

    /**
     * Get number of columns
     *
     * @return returns the amount of columns in the _image array
     */
    public int getWidth() {
        return _image[0].length;
    }

    /**
     * Get the pixel in specified index of the array
     *
     * @param row row number
     * @param col column number
     * @return returns the RGB value of the specified location
     */
    public RGBColor getPixel(int row, int col) {
        if ((row >= getHeight() || col >= getWidth())) return new RGBColor();
        return new RGBColor(_image[row][col]);
    }

    /**
     * Set the pixel in a specified index of the array
     *
     * @param row row number
     * @param col column number
     * @param pixel parameter containing the RGB values
     */
    public void setPixel(int row, int col, RGBColor pixel) {
        _image[row][col] = new RGBColor(pixel);
    }

    /**
     * Equals boolean
     *
     * @param other other image object to compare to
     * @return returns true if the image is similar to the other, otherwise returns false
     */
    public boolean equals(RGBImage other) {
        if (this._image.length == other._image.length && this._image[0].length == other._image[0].length) {
            for (int i = 0; i < _image.length; ++i) {
                for (int j = 0; j < _image[0].length; ++j) {
                    if (!_image[i][j].equals(other._image[i][j])) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * Horizontal flip
     *
     * flips the image horizontally
     */
    public void flipHorizontal() {
        RGBColor temp;
        for (int i = 0; i < getHeight(); ++i) {
            for (int j = 0; j < getWidth() / 2; ++j) {
                temp = _image[i][j];
                _image[i][j] = _image[i][getWidth() - 1 - j];
                _image[i][getWidth() - 1 - j] = temp;
            }
        }
    }

    /**
     * Vertical flip
     *
     * flips the image vertically
     */
    public void flipVertical() {
        RGBColor temp;
        for (int i = 0; i < getHeight() / 2; ++i) {
            for (int j = 0; j < getWidth(); ++j) {
                temp = _image[i][j];
                _image[i][j] = _image[getHeight() - 1 - i][j];
                _image[getHeight() - 1 - i][j] = temp;
            }
        }
    }

    /**
     * Invert colors
     *
     * inverts the colors of the image
     */
    public void invertColors() {
        for (int i = 0; i < getHeight(); ++i) {
            for (int j = 0; j < getWidth(); ++j) {
                _image[i][j].invert();
            }
        }
    }

    /**
     * Rotate clockwise
     *
     * rotates the image 90 degrees clockwise
     */
    public void rotateClockwise() {
        RGBColor[][] temp = new RGBColor[getWidth()][getHeight()];
        for (int i = 0; i < getHeight(); ++i) {
            for (int j = 0; j < getWidth(); ++j) {
                temp[j][i] = this._image[getHeight() - i - 1][j];
            }
        }
        _image = temp;
    }

    /**
     * Rotate counter clockwise
     *
     * rotates the image 90 degrees counter clockwise
     */
    public void rotateCounterClockwise() {
        RGBColor[][] temp = new RGBColor[getWidth()][getHeight()];
        for (int i = 0; i < getHeight(); ++i) {
            for (int j = 0; j < getWidth(); ++j) {
                temp[j][i] = this._image[i][getWidth() - j - 1];
            }
        }
        _image = temp;
    }

    /**
     * shiftColumn
     *
     * shifts the columns of the image by a chosen offset
     * @param offset amount of pixels to shift the image by
     */
    public void shiftCol(int offset) {
        RGBColor[][] temp = new RGBColor[getHeight()][getWidth()];
        for (int i = 0; i < getHeight(); ++i) {
            for (int j = 0; j < getWidth(); ++j) {
                temp[i][j] = new RGBColor();
            }
        }
        if (offset >= 0 && offset < getWidth()) {
            for (int i = 0; i < getHeight(); ++i) {
                for (int j = 0; j < getWidth() - offset; ++j) {
                    temp[i][j + offset] = this._image[i][j];
                }
            }
        } else if (offset < 0 && offset > -getWidth()) {
            for (int i = 0; i < getHeight(); ++i) {
                for (int j = getWidth() - 1; j >= -offset; --j) {
                    temp[i][j + offset] = this._image[i][j];
                }
            }
        } else temp = _image;
        _image = temp;
    }

    /**
     * shiftRow
     *
     * shifts the columns of the image by a chosen offset
     * @param offset amount of rows to shift the image by
     */
    public void shiftRow(int offset) {
        RGBColor[][] temp = new RGBColor[getHeight()][getWidth()];
        for (int i = 0; i < getHeight(); ++i) {
            for (int j = 0; j < getWidth(); ++j) {
                temp[i][j] = new RGBColor();
            }
        }
        if (offset >= 0 && offset < getHeight()) {
            for (int i = 0; i < getHeight() - offset; ++i) {
                for (int j = 0; j < getWidth(); ++j) {
                    temp[i + offset][j] = this._image[i][j];
                }
            }
        } else if (offset < 0 && offset > -getHeight()) {
            for (int i = getHeight() - 1; i >= -offset; --i) {
                for (int j = getWidth() - 1; j >= -offset; --j) {
                    temp[i + offset][j] = this._image[i][j];
                }
            }
        } else temp = _image;
        _image = temp;
    }

    /**
     * toGrayscale
     *
     * @return returns grayscale array with a single value
     */
    public double[][] toGrayscaleArray() {
        double[][] gray = new double[getHeight()][getWidth()];
        for (int i = 0; i < getHeight(); ++i) {
            for (int j = 0; j < getWidth(); ++j) {
                gray[i][j] = _image[i][j].convertToGrayscale();
            }
        }
        return gray;
    }

    /**
     * toString
     *
     * @return returns the array in a string format
     */
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < getHeight(); ++i) {
            for (int j = 0; j < getWidth(); ++j) {
                string.append(_image[i][j] + " ");
            }
            string.append("\n");
        }
        return string.toString();
    }

    /**
     * toRGBColorArray
     *
     * @return returns a copy of the pixel array
     */
    public RGBColor[][] toRGBColorArray() {
        RGBImage arrayCopy = new RGBImage(_image);
        return arrayCopy._image;
    }
}
