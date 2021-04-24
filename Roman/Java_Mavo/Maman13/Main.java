import javax.swing.JFrame;

class Main {
//    public Main() {
//    }
    public void printy(int i, int j, int[][] arr){
        System.out.println(arr[i][j]);
    }
    public static void main(String[] args) {
        Main m = new Main();
        int j = 0;
        int[][] a = new int[3][5];
        for (int i = 0; i < a.length; i++){
            if (j < a[0].length) {
                m.printy(i, j, a);
                j++;
            }
            System.out.println(" ");
        }
    }
}