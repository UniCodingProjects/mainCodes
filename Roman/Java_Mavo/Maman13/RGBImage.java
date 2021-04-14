/**
 * Class that represents an RGB image of X by Y dimensions
 */
@SuppressWarnings("WeakerAccess")
public class RGBImage {
    private RGBColor[][] _image;

    /**
     * Instantiates a new black image, size = rowsXcols
     *
     * @param rows amount of rows in the image
     * @param cols amount of columns in the image
     */
    public RGBImage(int rows, int cols) {
        imageAssignLooper(rows, cols);
    }

    /**
     * Instantiates a new RGB image based on 1 given color and size
     *
     * @param pixels 2D array of RGBColor type
     */
    public RGBImage(RGBColor[][] pixels) {
        imageAssignLooper(pixels);
    }

    /**
     * Copy constructor,
     * copies another RGBImage object
     * @param other another RGBImage object
     */
    public RGBImage(RGBImage other) {
        imageAssignLooper(other);
    }

    private void imageAssignLooper(int rows, int cols) {
        this._image = new RGBColor[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.setPixel(i, j, new RGBColor());
            }
        }
    }

    private void imageAssignLooper(RGBColor[][] image) {
        _image = new RGBColor[image.length][image[0].length];
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                this.setPixel(i, j, image[i][j]);
            }
        }
    }

    private void imageAssignLooper(RGBImage image) {
        _image = new RGBColor[image._image.length][image._image[0].length];
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                this.setPixel(i, j, image.getPixel(i, j));
            }
        }
    }

    private void fillRowByOffset(int row, RGBColor color) {
        for (int j = 0; j < this.getWidth(); j++) {
            this.setPixel(row, j, new RGBColor(color));
        }
    }

    private void fillRowByOffset(int offset, int row) {
        int setIdx = this.getHeight() - row - 1;
        int getIdx = this.getHeight() - offset - 1 - row;
        if (!(this.getHeight() - Math.abs(offset) - 1 - row < 0) && getIdx != this.getHeight()) {
            for (int j = 0; j < this.getWidth(); j++) {
                this.setPixel(setIdx, j, new RGBColor(this.getPixel(getIdx, j)));
            }
        }
    }

    private void shiftDownDirection(int offset) {
        if (Math.abs(offset) == this.getHeight()) {
            imageAssignLooper(this.getHeight(), this.getWidth());
        } else if (offset != 0 && !(offset > this.getHeight())) {
            for (int i = 0; i <= this.getHeight(); i++) {
                fillRowByOffset(offset, i);
            }
            for (int row = 0; row < offset; row++) {
                fillRowByOffset(row, new RGBColor());
            }
//            fillRowWithSameColor(0, 0, 0, offset, 0);
        }
    }

    private boolean checkCoordinatesValidity(int row, int col) {
        return row < this.getHeight() && col < this.getWidth();
    }

    private RGBColor[] getRow(int row) {
        return this._image[row];
    }

    /**
     * Get image height
     *
     * @return returns the height value as int
     */
    public int getHeight() {
        return this._image.length;
    }

    /**
     * Get image width
     *
     * @return returns the width value as int
     */
    public int getWidth() {
        return this._image[0].length;
    }

    /**
     * Get the RGBColor object at a specified location that represents,
     * that pixel color value
     *
     * @param row the row of the pixel
     * @param col the col of the pixel
     * @return returns RGBColor object that represents the desired pixel
     */
    public RGBColor getPixel(int row, int col) {
        return checkCoordinatesValidity(row, col) ? this._image[row][col] : new RGBColor();
    }

    /**
     * Set the color value of a specific location, by assigning a
     * RGBColor obj to it
     *
     * @param row the row of the pixel
     * @param col the col of the pixel
     * @param pixel RGBColor object that represents the desired pixel to be set
     */
    public void setPixel(int row, int col, RGBColor pixel) {
        if (checkCoordinatesValidity(row, col)) {
            if (this.getPixel(row, col) == null) {
                this._image[row][col] = new RGBColor(pixel);
            } else {
                this.getPixel(row, col).setBlue(pixel.getBlue());
                this.getPixel(row, col).setGreen(pixel.getGreen());
                this.getPixel(row, col).setRed(pixel.getRed());
            }
        }
    }

    /**
     * Check if 2 images of RGBImage type are equal
     *
     * @param other RGBImage object that represents that image to compare to
     * @return true if equal, false otherwise
     */
    public boolean equals(RGBImage other) {
        if (this.getHeight() == other.getHeight() && this.getWidth() == other.getWidth()) {
            for (int i = 0; i < this.getHeight(); i++) {
                for (int j = 0; j < this.getWidth(); j++) {
                    if (!(this.getPixel(i, j).equals(other.getPixel(i, j)))) {
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
     * Flip the image horizontally
     */
    public void flipHorizontal() {
        int lastRowIndex = this.getHeight() - 1;
        for (RGBColor[] row : this._image) {
            if (!(lastRowIndex == this.getHeight() / 2) || this.getHeight() == 2) {
                RGBColor[] tempRow = this.getRow(lastRowIndex);
                this._image[lastRowIndex] = row;
                this._image[(this.getHeight() - 1) - lastRowIndex] = tempRow;
                if (this.getHeight() == 2) {
                    break;
                }
                lastRowIndex--;
            }
        }
    }

    /**
     * Flip the image vertically.
     */
    public void flipVertical() {
        int lastIndexInRow = this.getWidth() - 1;
        int firstRowIndex = 0;
        for (RGBColor[] row : _image) {
            for (RGBColor color : row) {
                if (!(lastIndexInRow == this.getWidth() / 2) || this.getWidth() == 2) {
                    this._image[firstRowIndex][this.getWidth() - 1 - lastIndexInRow] = new RGBColor(row[lastIndexInRow]);
                    this._image[firstRowIndex][lastIndexInRow] = new RGBColor(color);
                    if (this.getWidth() == 2) {
                        break;
                    }
                    lastIndexInRow--;
                } else {
                    break;
                }
            }
            lastIndexInRow = this.getWidth() - 1;
            firstRowIndex++;
        }
    }

    /**
     * Invert colors of the image
     */
    public void invertColors() {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                this.getPixel(i, j).invert();
            }
        }
    }

    /**
     * Rotate the image clockwise
     */
    public void rotateClockwise() {
        RGBColor[][] rotatedImage = new RGBColor[this.getWidth()][this.getHeight()];
        for (int i = 0; i < this.getWidth(); i++) {
            for (int j = 0; j < this.getHeight(); j++) {
                rotatedImage[i][j] = new RGBColor(this.getPixel(this.getHeight() - 1 - j, i));
            }
        }
        imageAssignLooper(rotatedImage);
    }

    /**
     * Rotate the image counter clockwise
     */
    public void rotateCounterClockwise() {
        for (int i = 0; i < 3; i++) {
            rotateClockwise();
        }
    }

    /**
     * Shift columns - positive offset will shift the image to the right, negative to the left
     *
     * @param offset the desired offset for shifting the image's columns
     */
    public void shiftCol(int offset) {
        if (offset > 0) {
            rotateClockwise();
            shiftDownDirection(offset);
            rotateCounterClockwise();
        } else if (offset < 0) {
            rotateCounterClockwise();
            shiftDownDirection(Math.abs(offset));
            rotateClockwise();
        }
    }

    /**
     * Shift row - positive offset will shift the image to the bottom, negative to the top
     *
     * @param offset the desired offset for shifting the image's rows
     */
    public void shiftRow(int offset) {
        if (offset > 0) {
            shiftDownDirection(offset);
        } else if (offset < 0) {
            rotateClockwise();
            rotateClockwise();
            shiftDownDirection(Math.abs(offset));
            rotateCounterClockwise();
            rotateCounterClockwise();
        }

    }

    /**
     * Convert the whole image to grayScale and return it as a 2D double type array
     *
     * @return the gray-scaled image as a 2D double type array
     */
    public double[][] toGrayscaleArray() {
        double[][] greyScale = new double[this.getHeight()][this.getWidth()];
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                greyScale[i][j] = this.getPixel(i, j).convertToGrayscale();
            }
        }
        return greyScale;
    }

    /**
     *
     * @return a string representation of the whole image.
     */
    public String toString() {
        StringBuilder imageString = new StringBuilder();
        for (int i = 0; i < _image.length; i++) {
            for (int j = 0; j < _image[i].length; j++) {
                imageString.append(this.getPixel(i, j) + " ");
            }
            imageString.append("\n");
        }
        return imageString.toString();
    }

    /**
     * Copy the image and return it
     *
     * @return the copied 2D RGBColor array
     */
    public RGBColor[][] toRGBColorArray() {
        RGBColor[][] copyImage = new RGBColor[this.getHeight()][this.getWidth()];
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                copyImage[i][j] = new RGBColor(this.getPixel(i, j));
            }
        }
        return copyImage;
    }
}
