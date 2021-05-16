public class Ex14 {
    public static int maximalDrop (int [] a){
        int minC= 0;
        int maxC = a.length - 1;
        int maxDrop = 0;
        while (minC != (a.length - 1)) {
            if (a[minC] > a[maxC] && (a[minC] - a[maxC]) > maxDrop){
                maxDrop = a[minC] - a[maxC];
            }
            maxC--;
            if (minC >= maxC){
                maxC = a.length - 1;
                minC++;
            }
        }
        return maxDrop;
    }

    public static int isSink (int [][] mat){
        int rowCounter;
        int crossCounter;
        for (rowCounter = 0; rowCounter <= mat.length-1; rowCounter++){
            if ((mat[rowCounter][0] == 0 && mat[rowCounter][mat.length-1] == 0 && mat[rowCounter][rowCounter] == 0 &&
                 mat[0][rowCounter] == 1 && mat[mat.length-1][rowCounter] == 1) ||

                (rowCounter == 0 && mat[rowCounter][mat.length-1] == 0 && mat[0][0] == 0 && mat[mat.length-1][rowCounter] == 1 &&
                mat[rowCounter+1][rowCounter] == 1) ||

                (rowCounter == mat.length-1 && mat[rowCounter][mat.length-1] == 0 && mat[rowCounter][0] == 0 && mat[0][rowCounter] == 1 &&
                mat[rowCounter-1][rowCounter] == 1)) {

                for (crossCounter = 0; crossCounter <= mat.length-1; crossCounter++){
                    if (!(mat[crossCounter][rowCounter] == 1 || crossCounter == rowCounter)){
                        break;
                    }
                    if (!(mat[rowCounter][crossCounter] == 0)){
                        break;
                    }
                }
                if (crossCounter > mat.length-1) {
                    return rowCounter;
                }
            }
        }
        return -1;
    }


    private static int trueAmount = -1;
    private static int falseAmount = 0;


    public static int size (boolean[][] mat, int x, int y) {
        if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length) {
            return 0;
        }
        if ((trueAmount + 1 + falseAmount < mat.length * mat[0].length)) {
            System.out.println("ewfwef");
            if (mat[x][y]) {
                System.out.println("found true");
                trueAmount++;
            }
        }
        if (trueAmount != -1){
            return trueAmount+1;
        }
        return -1;
    }
    public static void main(String[] args){
        boolean[][] mat = {{true, false},
                           {true, false}};

        System.out.println(size(mat, 1, 0));

    }
}
