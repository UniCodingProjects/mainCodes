public class RGBImage{
    private RGBColor[][] _image;

    //constructors
    public RGBImage(int rows, int cols){
        _image = new RGBColor[rows][cols];
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                _image[i][j] = new RGBColor();
            }
        }
    }

    public RGBImage(RGBColor[][] pixels){
        _image = pixels;
    }

    public RGBImage(RGBImage other){
        _image = other._image;
    }

    private boolean checkCoordinatesValidity(int row, int col){
        return row < _image.length && col < _image[0].length;
    }


    private boolean assertPixelEquality(int i, int j, RGBColor[][] image){
        return  _image[i][j].getGreen() == image[i][j].getGreen() &&
                _image[i][j].getBlue() == image[i][j].getBlue() &&
                _image[i][j].getRed() == image[i][j].getRed();
    }

    //getters
    public int getHeight(){
        return _image.length;
    }

    public int getWidth(){
        return _image[0].length;
    }

    public RGBColor getPixel (int row, int col){
        return checkCoordinatesValidity(row, col) ? _image[row][col] : new RGBColor();
    }

    public void setPixel(int row, int col, RGBColor pixel){
        if (checkCoordinatesValidity(row, col)){
            _image[row][col].setBlue(pixel.getBlue());
            _image[row][col].setGreen(pixel.getGreen());
            _image[row][col].setRed(pixel.getRed());
        }
    }

    public boolean equals(RGBImage other){
        if (_image.length == other._image.length && _image[0].length == other._image[0].length){
            for (int i=0; i<_image.length; i++){
                for (int j=0; j<_image[0].length; j++){
                    if (!assertPixelEquality(i, j, other._image)){
                        return false;
                    }
                }
            }
        }
        return true;
    }





    public static void main(String[] args){
        RGBImage RGB = new RGBImage(5, 8);

        RGBColor[][] RGBC2 = new RGBColor[2][4];
        for (int i=0; i<2; i++){
            for (int j=0; j<4; j++){
                RGBC2[i][j] = new RGBColor(10, 10, 10);
            }
        }

        RGBColor[][] RGBC4 = new RGBColor[2][4];
        for (int i=0; i<2; i++){
            for (int j=0; j<4; j++){
                RGBC4[i][j] = new RGBColor(10, 10, 10);
            }
        }

        RGBImage RGB2 = new RGBImage(RGBC2);
        RGBImage RGB4 = new RGBImage(RGBC4);

//        System.out.println(RGBC2[1][1]);

        RGBImage RGB3 = new RGBImage(RGB);

//        System.out.println(RGB._image[1][2].getRed());
//        System.out.println(RGB3._image[1][2].getRed());
        System.out.println(RGB2.getHeight());
        System.out.println(RGB2.getWidth());
        System.out.println(RGB2.getPixel(1,3));
        RGBColor pixel = new RGBColor(200, 150, 100);
        RGB2.setPixel(1, 3, pixel);
        System.out.println(RGB2.getPixel(1,3));
        System.out.println(RGB2.equals(RGB4));





//        RGBColor RGB = new RGBColor();
//        RGBColor[] ar1 = {RGB, RGB};
//        RGBColor[][] a =
//                {ar1,
//                ar1};
//        System.out.println(RGB.toString());
    }

}