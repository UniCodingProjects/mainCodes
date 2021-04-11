//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class RGBColor {
    private int _red;
    private int _green;
    private int _blue;
    private static final int MAX_COLOR_VAL = 255;

    public RGBColor() {
        this._red = this._green = this._blue = 0;
    }

    public RGBColor(int red, int green, int blue) {
        if (this.validColor(red)) {
            this._red = red;
        }

        if (this.validColor(green)) {
            this._green = green;
        }

        if (this.validColor(blue)) {
            this._blue = blue;
        }

    }

    public RGBColor(RGBColor other) {
        if (other != null) {
            this._red = other._red;
            this._green = other._green;
            this._blue = other._blue;
        }

    }

    public int getRed() {
        return this._red;
    }

    public int getGreen() {
        return this._green;
    }

    public int getBlue() {
        return this._blue;
    }

    public void setRed(int num) {
        if (this.validColor(num)) {
            this._red = num;
        }

    }

    public void setGreen(int num) {
        if (this.validColor(num)) {
            this._green = num;
        }

    }

    public void setBlue(int num) {
        if (this.validColor(num)) {
            this._blue = num;
        }

    }

    public String toString() {
        return "(" + this._red + "," + this._green + "," + this._blue + ")";
    }

    public boolean equals(RGBColor other) {
        if (other == null) {
            return false;
        } else {
            return other.getRed() == this._red && other.getGreen() == this._green & other.getBlue() == this._blue;
        }
    }

    public double convertToGrayscale() {
        return 0.3D * (double)this._red + 0.59D * (double)this._green + 0.11D * (double)this._blue;
    }

    public void invert() {
        this._red = 255 - this._red;
        this._green = 255 - this._green;
        this._blue = 255 - this._blue;
    }

    private boolean validColor(int num) {
        return num >= 0 && num <= 255;
    }
}
