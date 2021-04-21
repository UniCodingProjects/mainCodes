import java.rmi.activation.ActivationGroup_Stub;

public class RGBImage {
    private RGBColor[][] _image;

    public RGBImage(int rows, int cols) {
        _image = new RGBColor[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
//                _image  = new RGBColor[i][j];
                _image[i][j] = new RGBColor();
            }
        }
//        System.out.println(_image[0][0]);
    }

    public RGBImage(RGBColor[][] pixels) {
        _image = pixels;
    }

    public RGBImage(RGBImage other) {
        _image = other._image;
    }

    public int getHeight() {
        return _image.length;
    }

    public int getWidth() {
        return _image[0].length;
    }

    public RGBColor getPixel(int row, int col){ // row and col number starts from 0, if rows selected is 2 {0,1}
        if((row >= getHeight() || col >= getWidth())) return new RGBColor();
//        RGBColor temp2 = new RGBColor(temp);
        return new RGBColor(_image[row][col]);
    }

    public void setPixel(int row,int col, RGBColor pixel){
        _image[row][col] = new RGBColor(pixel);
    }
    public boolean equals(RGBImage other) {
        if (this._image.length == other._image.length && this._image[0].length == other._image[0].length){
                for (int i = 0; i < _image.length; ++i) {
                    for (int j = 0; j < _image[0].length; ++j) {
                            if (!_image[i][j].equals(other._image[i][j])) {
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

    public void flipHorizontal(){
        RGBColor temp;
        for(int i=0 ; i < getHeight() ; ++i){
            for(int j=0 ; j < getWidth() /2 ; ++j){
                temp = _image[i][j];
                _image[i][j] = _image[i][getWidth()-1-j];
                _image[i][getWidth()-1-j] = temp;
            }
        }
    }
    public void invertColors(){
        for (int i = 0 ; i < getHeight() ; ++i) {
            for (int j = 0; j < getWidth(); ++j) {
                _image[i][j].invert();
            }
        }
    }

    public void rotateClockwise() { // needs fixing
        RGBColor temp;
        for (int i = 0; i < getHeight()/2 ; ++i) {
            for (int j = 0; j < getWidth() -i -1; ++j) {
                temp = _image[i][j];
                _image[i][j] = _image[getWidth()-1-j][i];
//                _image[getWidth()-1-j][i] = _image[getHeight() -1 -i][getWidth() -1 -j];
//                _image[getHeight()-1 -j][getWidth() -1 -j] = _image[j][getHeight()-1 -j];
//                _image[j][getHeight() -1 -i] = temp;

            }
        }
    }

    public void printing(){
        for (int i = 0 ; i < getHeight() ; ++i){
            System.out.println("");
            for(int j=0 ; j< getWidth() ; ++j){
                System.out.print(_image[i][j] + " ");
            }
        }
    }



public static void main(String[]args){
    RGBImage img = new RGBImage(6,4);
    RGBImage img4 = new RGBImage(3,3);
    RGBColor pix = new RGBColor(255,255,0);
    img.setPixel(0,0,pix);
    img.setPixel(0,1,pix);
    img.setPixel(0,2,pix);
//    img.setPixel(4,3,pix);
//    img.setPixel(4,2,pix);
    img.printing();
//    img.flipHorizontal();
    System.out.println(" ");
//    img.printing();
//    img.invertColors();
//    System.out.println(" ");
//    img.printing();
    img.rotateClockwise();
    img.printing();
//    System.out.println(" ");

//    System.out.print(img._image[0][0]);
//    System.out.print(img._image[0][1]);
//    System.out.println(img._image[0][2]);
//    System.out.print(img._image[1][0]);
//    System.out.print(img._image[1][1]);
//    System.out.println(img._image[1][2]);
//    System.out.print(img._image[2][0]);
//    System.out.print(img._image[2][1]);
//    System.out.println(img._image[2][2]);
//    img.flipHorizontal();
//    System.out.print(img._image[0][0]);
//    System.out.print(img._image[0][1]);
//    System.out.println(img._image[0][2]);
//    System.out.print(img._image[1][0]);
//    System.out.print(img._image[1][1]);
//    System.out.println(img._image[1][2]);
//    System.out.print(img._image[2][0]);
//    System.out.print(img._image[2][1]);
//    System.out.println(img._image[2][2]);
//    int x = img._image[0].length; // cols
//    int y = img._image.length; // rows
//    System.out.println(x +" "+ y);
//    System.out.println(img.getHeight() + " " + img.getWidth());
//    System.out.println(img.getPixel(1,1));
//        RGBColor color = new RGBColor();
//    RGBColor pixel = new RGBColor(255,0,0);
//    RGBColor[][] pixels = new RGBColor[2][3];
//    RGBImage img3 = new RGBImage(5,4);
//    img4.setPixel(2,0,pixel);
//    System.out.println(img3.getPixel(2,0));
//    System.out.println(img.equals(img4));
//    System.out.println(img.getPixel(2,2)); // array actually starts at 0 therefore 2 is 3rd place in array
//    img3.setPixel(5,3, test);
//    System.out.println(img2.getHeight() + " " + img2.getWidth());
//    System.out.println(img4.getPixel(2,0));
//    System.out.println(img3.getPixel(2,2));
//        System.out.print(img2[1][1]);
//        System.out.print(img2[1][1]);
//        System.out.print(color);
//       System.out.println(img);
}
}