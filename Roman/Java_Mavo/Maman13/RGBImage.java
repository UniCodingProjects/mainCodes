/**
 * The type Rgb image.
 */
public class RGBImage{
    private RGBColor[][] _image;

    /**
     * Instantiates a new Rgb image.
     *
     * @param rows the rows
     * @param cols the cols
     */
//constructors
    public RGBImage(int rows, int cols){
        imageAssignLooper(rows, cols);
    }

    /**
     * Instantiates a new Rgb image.
     *
     * @param pixels the pixels
     */
    public RGBImage(RGBColor[][] pixels){
        imageAssignLooper(pixels);
    }

    /**
     * Instantiates a new Rgb image.
     *
     * @param other the other
     */
    public RGBImage(RGBImage other){
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
        for (int i=0; i< getHeight(); i++){
            for (int j=0; j < getWidth(); j++){
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

    private boolean checkCoordinatesValidity(int row, int col){
        return row < this.getHeight() && col < this.getWidth();
    }


    private void fillRowWithSameColor(int red, int green, int blue, int offset, int col) {
        if (!(col == this.getWidth())) {
            if (offset > 0){
                this.setPixel(offset-1, col, new RGBColor(red, green, blue));
                col++;
                fillRowWithSameColor(red, green, blue, offset, col);
            }
            else if (offset < 0){
                this.setPixel(this.getHeight() - Math.abs(offset), col, new RGBColor(red, green, blue));
                col++;
                fillRowWithSameColor(red, green, blue, offset, col);
            }
        }
        else if (offset > 0){
            offset--;
            col = 0;
            fillRowWithSameColor(red, green, blue, offset, col);
        }
        else if (offset < 0){
            offset ++;
            col = 0;
            fillRowWithSameColor(red, green, blue, offset, col);
        }
    }

    private void fillRowByOffset(int offset, int row){
        int setIdx = this.getHeight() - row - 1;
        int getIdx = this.getHeight() - offset - 1-row;
        if (offset < 0){
            setIdx = row;
            getIdx = row + Math.abs(offset);
        }
        if (!(this.getHeight() - Math.abs(offset) - 1-row < 0) && getIdx != this.getHeight()){
            for (int j = 0; j < this.getWidth(); j++) {
                this.setPixel(setIdx, j, new RGBColor(this.getPixel(getIdx, j)));
            }
        }
    }

    /**
     * Get height int.
     *
     * @return the int
     */
//getters
    public int getHeight(){
        return this._image.length;
    }

    /**
     * Get width int.
     *
     * @return the int
     */
    public int getWidth(){
        return this._image[0].length;
    }

    /**
     * Get pixel rgb color.
     *
     * @param row the row
     * @param col the col
     * @return the rgb color
     */
    public RGBColor getPixel (int row, int col){
        return checkCoordinatesValidity(row, col) ? this._image[row][col] : new RGBColor();
    }

    /**
     * Set pixel.
     *
     * @param row   the row
     * @param col   the col
     * @param pixel the pixel
     */
    public void setPixel(int row, int col, RGBColor pixel){
        if (checkCoordinatesValidity(row, col)){
            if (this.getPixel(row, col) == null){
                this._image[row][col] =  new RGBColor(pixel);
            }
            else {
                this.getPixel(row, col).setBlue(pixel.getBlue());
                this.getPixel(row, col).setGreen(pixel.getGreen());
                this.getPixel(row, col).setRed(pixel.getRed());
            }
        }
    }

    /**
     * Equals boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean equals(RGBImage other){
        if (this.getHeight() == other.getHeight() && this.getWidth()== other.getWidth()){
            for (int i=0; i< this.getHeight(); i++){
                for (int j=0; j < this.getWidth(); j++){
                    if (!(this.getPixel(i, j).equals(other.getPixel(i, j)))){
                        return false;
                    }
                }
            }
        }
        else {
            return false;
        }
        return true;
    }

    private RGBColor[] getRow(int row){
        return this._image[row];
    }

    /**
     * Flip horizontal.
     */
    public void flipHorizontal(){
        int lastRowIndex = this.getHeight()-1;
        for (RGBColor[] row: this._image){
            if (!(lastRowIndex == this.getHeight() /2 )|| this.getHeight() == 2) {
                RGBColor[] tempRow = this.getRow(lastRowIndex);
                this._image[lastRowIndex] = row;
                this._image[(this.getHeight() - 1) - lastRowIndex] = tempRow;
                if (this.getHeight() == 2){
                    break;
                }
                lastRowIndex--;
            }
        }
    }

    /**
     * Flip vertical.
     */
    public void flipVertical(){
        int lastIndexInRow = this.getWidth()-1;
        int firstRowIndex = 0;
        for (RGBColor[] row: _image) {
            for (RGBColor color : row) {
                if (!(lastIndexInRow == this.getWidth() / 2) || this.getWidth() == 2) {
                    RGBColor tempColor = row[lastIndexInRow];
                    this._image[firstRowIndex][lastIndexInRow] = color;
                    this._image[firstRowIndex][this.getWidth() - 1 - lastIndexInRow] = tempColor;
                    if (this.getWidth() == 2){
                        break;
                    }
                    lastIndexInRow--;
                }
                else {
                    break;
                }
            }
            lastIndexInRow = this.getWidth()-1;
            firstRowIndex++;
        }
    }

    /**
     * Invert colors.
     */
    public void invertColors(){
        for (int i=0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                this.getPixel(i, j).invert();
            }
        }
    }

    /**
     * Rotate clockwise.
     */
    public void rotateClockwise() {
        RGBColor[][] rotatedImage = new RGBColor[this.getWidth()][this.getHeight()];
        for (int i = 0; i < this.getWidth(); i++) {
            for (int j = 0; j < this.getHeight(); j++) {
                rotatedImage[i][j] = new RGBColor(this.getPixel(this.getHeight()-1-j, i));
            }
        }
        imageAssignLooper(rotatedImage);
    }

    /**
     * Rotate counter clockwise.
     */
    public void rotateCounterClockwise(){
        for (int i=0;i<3;i++){
            rotateClockwise();
        }
    }

    /**
     * Shift col.
     *
     * @param offset the offset
     */
    public void shiftCol(int offset){
        if (Math.abs(offset) == this.getWidth()){
            imageAssignLooper(this.getHeight(), this.getWidth());
        }
        else if (Math.abs(offset) < this.getWidth()){
            for (int i = 0; i < getHeight(); i++) {
                for (int j = 0; j < Math.abs(offset); j++) {
                    if (offset > 0){
                        _image[i][j + 1] = _image[i][j];
                        _image[i][j] = new RGBColor();
                    }
                    else {
                        _image[i][j] = _image[i][j+1];
                        _image[i][getWidth() -1 - j] = new RGBColor();
                    }
                }
            }
        }
    }

    /**
     * Shift row.
     *
     * @param offset the offset
     */
    public void shiftRow(int offset){
        if (Math.abs(offset) == this.getHeight()){
            imageAssignLooper(this.getHeight(), this.getWidth());
        }
        else if (offset != 0 && !(offset > this.getHeight())){
            for (int i = 0; i <= this.getHeight(); i++) {
                if (offset > 0){
                    fillRowByOffset(offset, i);
                }
                else {
                    fillRowByOffset(offset, i);
                    }
            }
            fillRowWithSameColor(0, 0, 0, offset, 0);
        }
    }

    /**
     * To grayscale array double [ ] [ ].
     *
     * @return the double [ ] [ ]
     */
    public double[][] toGrayscaleArray(){
        double[][] greyScale = new double[this.getHeight()][this.getWidth()];
        for (int i=0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                greyScale[i][j] = this.getPixel(i, j).convertToGrayscale();
            }
        }
        return greyScale;
    }

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
     * To rgb color array rgb color [ ] [ ].
     *
     * @return the rgb color [ ] [ ]
     */
    public RGBColor[][] toRGBColorArray(){
        RGBColor[][] copyImage = new RGBColor[this.getHeight()][this.getWidth()];
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                copyImage[i][j] = new RGBColor(this.getPixel(i, j));
            }
        }
        return copyImage;
    }


    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        RGBImage RGB = new RGBImage(3, 3);

        int rows = 4;
        int cols = 4;

        RGBColor[][] RGBC2 = new RGBColor[rows][cols];
        for (int i=0; i < rows; i++){
            for (int j=0; j < cols; j++){
                RGBC2[i][j] = new RGBColor(10, 10, 10);
            }
        }

        RGBImage RGB2 = new RGBImage(RGBC2);
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < cols; j++) {
                RGB2.setPixel(i, j, new RGBColor(50, 50, 20));
            }
        }
        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < cols; j++) {
                RGB2.setPixel(i, j, new RGBColor(40, 30, 80));
            }
        }



        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 1; j++) {
                RGB2.setPixel(i, j, new RGBColor(80, 80, 80));
            }
        }
//
//        System.out.println(RGB2.toString());
//        System.out.println();
//        RGB2.flipHorizontal();
//        System.out.println(RGB2.toString());
//        System.out.println("======================================\n");
//        System.out.println(RGB2.toString());
////
//        System.out.println();
//        RGB2.flipVertical();
//        System.out.println(RGB2.toString());

//        System.out.println();
//        RGB2.invertColors();
//        System.out.println(RGB2.toString());

//        System.out.println(RGB2.toString());
//        System.out.println();
//        RGB2.rotateClockwise();
//        System.out.println(RGB2.toString());
//
//        System.out.println();
//        RGB2.rotateCounterClockwise();
//        System.out.println(RGB2.toString());
//
//        System.out.println();
//        RGB2.shiftCol(-3);
//        System.out.println(RGB2.toString());
////
//        System.out.println();
//        RGB2.shiftRow(3);
        System.out.println(RGB2.toString());
        System.out.println(RGB2.toGrayscaleArray()[3][2]);
//        System.out.println(RGB2.equals(RGB2));





//
//            RGB2.flipHorizontal();
//
//            for (int i = 0; i < rows; i++) {
//                for (int j = 0; j < cols; j++) {
//                    System.out.print(RGB2.getPixel(rows, cols));
//                }
//                System.out.println("");
//            }
//
//



//        RGBColor[][] RGBC4 = new RGBColor[2][4];
//        for (int i=0; i<2; i++){
//            for (int j=0; j<4; j++){
//                RGBC4[i][j] = new RGBColor(10, 10, 10);
//            }
//        }
//        RGBImage RGB4 = new RGBImage(RGBC4);
////        System.out.println(RGBC2[1][1]);
//        RGBImage RGB3 = new RGBImage(RGB);
////        System.out.println(RGB._image[1][2].getRed());
////        System.out.println(RGB3._image[1][2].getRed());
//        System.out.println(RGB2.getHeight());
//        System.out.println(RGB2.getWidth());
//        System.out.println(RGB2.getPixel(1,3));
//        RGBColor pixel = new RGBColor(200, 150, 100);
//        RGB2.setPixel(1, 3, pixel);
//        System.out.println(RGB2.getPixel(1,3));
//        System.out.println(RGB2.equals(RGB4));
//        RGBColor RGB = new RGBColor();
//        RGBColor[] ar1 = {RGB, RGB};
//        RGBColor[][] a =
//                {ar1,
//                ar1};
//        System.out.println(RGB.toString());
    }
}
