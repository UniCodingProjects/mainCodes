import java.util.Arrays;

public class exc2 {
    private int _b = 5;

    public int getB(){
        return this._b;
    }
}

class exc3 extends exc2 {
    private int _a = 4;
    private boolean stop = false;
    private int[] arr;
    private boolean sizeSet = false;

    public int getA(){
        return this._a;
    }

    public void recurse(int num, int size){
        if (!sizeSet) {
            this.arr = new int[size];
            this.sizeSet = true;
        }
        if ((size == num)) {
            this.stop = true;
        }
        else {
            this.arr[num] = num;
            num++;
        }
        if (!this.stop) {
            recurse(num, size);
            return;
        }
        System.out.println(Arrays.toString(arr));
    }




    public static void main(String[] args){
        exc3 checkInh = new exc3();
        System.out.println(checkInh.getB());
        System.out.println(checkInh.getA());
        exc2 checkI = new exc2();
        System.out.println("====");
        checkInh.recurse(0, 5);
    }
}
