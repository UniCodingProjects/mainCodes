public class Ex14 {
    /**
     *
     * runtime complexity is O(n) due to the amount of CMDS being x times n while x<n
     * @param a 1D array of random numbers
     * @return the maximum diff between highest and lowest nums in the given array while the highest num must be
     * to the right of the small num
     */
    public static int maximalDrop (int [] a){
        if (a.length == 0){
            return 0;
        }
        int minC= 0;
        int maxC = a.length - 1;
        int maxDrop = 0;
        while (minC != (a.length - 1)) {
            if (a[minC] > a[maxC] && (a[minC] - a[maxC]) > maxDrop && a[minC] >= 0 && a[maxC] >= 0){
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

    /**
     * the method runs in O(n) runtime complexity, this is due to the loop goes over the rows which is O(n),
     * and due to the condition we go into the columns (inside the row) only when this row is a perfect candidate
     * which will be + another O(n) and n+n = O(n).
     * @param mat 2D array that consists of randomized 0's and 1's
     * @return the idx of the row that is fully zero and the col at the same idx is fully 1 except mat[idx][idx]
     *
     */
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

    /**
     * the method checks the amount of adjacent true values from the given x,y coordinate recursively.
     * @param mat 2D boolean array
     * @param x rows idx in the 2D array
     * @param y cols idx in the 2D array
     * @return amount of adjacent true values in the 2D array
     */
    public static int size (boolean[][] mat, int x, int y) {
        int trueCounter = 0;
        if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length) {
            return trueCounter;
        }
        boolean[][] isVisited = new boolean[mat.length][mat[0].length];
        if (mat[x][y]){
            isVisited[x][y] = true;
            trueCounter++;
            return size (mat, x, y, isVisited, trueCounter);
        }
        return trueCounter;
    }

    private static int size (boolean[][] mat, int x, int y,
                             boolean[][] isVisited, int trueCounter) {
        if (x - 1 >=0){
            if (mat[x-1][y] && !isVisited[x-1][y]){
                trueCounter++;
                isVisited[x-1][y] = true;
                trueCounter = size(mat, x-1, y, isVisited, trueCounter);
            }
            if (y - 1 >= 0){
                if (mat[x-1][y-1] && !isVisited[x-1][y-1]){
                    isVisited[x-1][y-1] = true;
                    trueCounter++;
                    trueCounter = size(mat, x-1, y-1, isVisited, trueCounter);
                }
            }
        }
        if (y - 1 >= 0) {
            if (mat[x][y-1] && !isVisited[x][y-1]){
                isVisited[x][y-1] = true;
                trueCounter++;
                trueCounter = size(mat, x, y-1, isVisited, trueCounter);
            }
            if (x+1 < mat.length){
                if (mat[x+1][y-1] && !isVisited[x+1][y-1]){
                    isVisited[x+1][y-1]=true;
                    trueCounter++;
                    trueCounter = size(mat, x+1, y-1, isVisited, trueCounter);
                }
            }
        }
        if (x + 1 < mat.length){
            if (mat[x+1][y]&& !isVisited[x+1][y]){
                isVisited[x+1][y] = true;
                trueCounter++;
                trueCounter = size(mat, x+1, y, isVisited, trueCounter);
            }
            if (y+1 < mat[0].length){
                if (mat[x+1][y+1] && !isVisited[x+1][y+1]){
                    trueCounter++;
                    isVisited[x+1][y+1]=true;
                    trueCounter = size(mat, x+1, y+1, isVisited, trueCounter);
                }
            }
        }
        if (y + 1 < mat[0].length){
            if (mat[x][y+1] && !isVisited[x][y+1]){
                isVisited[x][y+1] = true;
                trueCounter++;
                trueCounter = size(mat, x, y+1, isVisited, trueCounter);
            }
            if (x-1 >= 0){
                if (mat[x-1][y+1] && !isVisited[x-1][y+1]){
                    isVisited[x-1][y+1]=true;
                    trueCounter++;
                    trueCounter = size(mat, x-1, y+1, isVisited, trueCounter);
                }
            }
        }
        return trueCounter;
    }

    /**
     * the method checks if 2 given arrays are equal in length and content.
     * @param a unsorted array of integers
     * @param b unsorted array of integers
     * @return true if condition is met, false otherwise
     */
    public static boolean isPermutation (int [] a, int [] b){
        if (a.length != b.length){
            return false;
        }
        int pointer = 0;
        char stop = 'n';
        a = bubbleSort(a, pointer, stop);
        b = bubbleSort(b, pointer, stop);
        return isPermutation(a, b, 0);
    }

    private static int[] bubbleSort(int[] arr, int pointer, char stop){
        int temp;
        if (pointer == arr.length-1 && stop == 'n'){
            return bubbleSort(arr, 0, stop);
        }
        if (pointer+1 < arr.length) {
            if (arr[pointer] > arr[pointer + 1]){
                temp = arr[pointer];
                arr[pointer] = arr[pointer+1];
                arr[pointer+1] = temp;
                stop = 'n';
                return bubbleSort(arr, pointer+1, stop);
            }
            else {
                stop = 'y';
                return bubbleSort(arr, pointer + 1, stop);
            }
        }
        return arr;
    }

    private static boolean isPermutation(int[] a, int[] b, int pointer){
        if (a[pointer] == b[pointer]){
            if (pointer+1 < a.length && pointer+1 < b.length){
                return isPermutation(a, b, pointer+1);
            }
            else {
                return true;
            }
        }
        return false;
    }
}
