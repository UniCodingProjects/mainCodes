/*
class exam {
    public static int howManyPaths(int[][] mat){
        int paths = 0;
        boolean[][] isVisted = new boolean[mat.length][mat[0].length];
        return howManyPaths(mat, 0, 0, paths, isVisted);
    }

    private static int howManyPaths(int[][] mat,
                                    int i, int j,
                                    int paths, boolean[][] isVisted){
        if ((i >= mat.length || i < 0 || j >= mat[0].length || j < 0)){
            return paths;
        }
        else if (isVisted[i][j]){
            return paths;
        }
        int jmlValue = mat[i][j];
        if (i == mat.length-1 && j == mat[i].length-1){
            return paths+1;
        }
        isVisted[i][j] = true;
        int rightPath = howManyPaths(mat, i, j+jmlValue, paths, isVisted);
        int downPath = howManyPaths(mat, i+jmlValue, j, paths, isVisted);
        int uptPath = howManyPaths(mat, i-jmlValue, j, paths, isVisted);
        int leftPath = howManyPaths(mat, i, j-jmlValue, paths, isVisted);
        return rightPath+leftPath+uptPath+downPath;
    }

    public static int meetingPoint(int[] a, int[] b){
        int min = 0;
        int max = Math.min(a.length-1, b.length-1);
        int mid;
        while (min <= max){
            mid = (max+min)/2;
            if (a[mid] == b[mid]){
                return mid;
            }
            if (a[mid] > b[mid]){
                min = mid +1;
            }
            else{
                max = mid-1;
            }
        }
        return -1;
    }






    public static void main(String[] args) {
//        int[][] arr =
//                        {{3,3,1,6},
//                        {2,8,1,2},
//                        {6,2,1,1},
//                        {2,4,1,3}};
//        System.out.println(howManyPaths(arr));
        int[] a = {8,7,6,5,4};
        int[] b = {1,2,3,3,4, 5, 6, 7};
        System.out.println(meetingPoint(a, b));
    }
}
*/

class one extends two {

}

class two  {

}

class drivers {
    public static void main(String[] args){
        one a2 = new one();
        two z1 = new two();
        z1 = (two )a2;

    }
}