import java.util.Arrays;

class exam2013 {
    public int get(){
        return 5;
    }

//    private static boolean assertDiff(int a, int b, int diff){
//        return a-b == diff;
//    }
//
//    private static int longerSlope(int[][] mat, int num,
//                            int maxSlope, int currentMaxSlope, int x,int y, boolean duplicate){
//        if (y + 1 < mat[0].length) {
//            if (assertDiff(mat[x][y], mat[x][y + 1], num)) {
//                if (!duplicate) {
//                    currentMaxSlope++;
//                }
//                duplicate = true;
//                maxSlope = longerSlope(mat, num, maxSlope, currentMaxSlope, x, y + 1, duplicate);
//            }
//            else {
//                duplicate = false;
//            }
//        }
//        if ( x+1 < mat.length){
//            if (assertDiff(mat[x][y], mat[x + 1][y], num)) {
//                if (!duplicate) {
//                    currentMaxSlope++;
//                }
//                duplicate = true;
//                maxSlope = longerSlope(mat, num, maxSlope, currentMaxSlope, x+1, y, duplicate);
//            }
//            else {
//                duplicate = false;
//            }
//        }
//        if (y+1 < mat[0].length ) {
//            maxSlope = longerSlope(mat, num, maxSlope, currentMaxSlope, x, y + 1, duplicate);
//        }
//        else if (x+1 < mat.length) {
//            maxSlope = longerSlope(mat, num, maxSlope, currentMaxSlope, x+1, y, duplicate);
//        }
//
//        if (currentMaxSlope > maxSlope){
//            maxSlope = currentMaxSlope;
//        }
//        return maxSlope;
//    }
//
//
//    public static int longerSlope(int[][] mat, int num){
//        return longerSlope(mat, num, 0, 0, 0,0, false);
//    }
//
//    public static int what(int[] a){
//        int temp = 0;
//        int leftC = 0;
//        int rightC = 0;
//        int sum = 0;
//        while (leftC < a.length){
//            sum += a[rightC];
//            if (sum % 2 == 1){
//                if (rightC-leftC+1 > temp){
//                    temp = rightC-leftC+1;
//                }
//            }
//            if (rightC+1 == a.length){
//                leftC++;
//                rightC = leftC;
//                sum = 0;
//            }
//            else{
//                rightC++;
//            }
//        }
//        return temp;
//    }
    private static boolean indecesFlat(int[] arr,
                                       int a,
                                       int b,
                                       int startIdx){
        a = Math.abs(a);
        b = Math.abs(b);
        int startNum = Math.abs(arr[startIdx]);
        if (((Math.abs(a-b) == 1 &&
                (Math.abs(startNum-b) <= 1) &&
                Math.abs(startNum-b)  >= 0) || (Math.abs(a-b) == 0 &&
                Math.abs(startNum-b) == 0))){
            return true;
        }
        return false;
    }

    private static int longestFlat(int[] arr, int maxFlatSequence,
                            int sequenceCounter, int startCounter,
                                   int startIdx){
        if (indecesFlat(arr,
                arr[startCounter],
                arr[startCounter+1],
                startIdx)){
            if (sequenceCounter == 0){
                sequenceCounter += 2;
            }
            else {
                sequenceCounter++;
            }
        }
        else {
            if (sequenceCounter > maxFlatSequence) {
                maxFlatSequence = sequenceCounter;
            }
            sequenceCounter = 0;
            startIdx++;
            startCounter = startIdx;
            if (startCounter+1 != arr.length -1){
            return longestFlat(arr, maxFlatSequence,
                    sequenceCounter, startCounter,
                    startIdx);}
        }
        if (startCounter + 2 != arr.length){
            if (sequenceCounter > maxFlatSequence) {
                maxFlatSequence = sequenceCounter;
            }
            startCounter++;
            return longestFlat(arr, maxFlatSequence,
                    sequenceCounter, startCounter,
                    startIdx);
        }
        if (sequenceCounter > maxFlatSequence) {
            maxFlatSequence = sequenceCounter;
        }
        return maxFlatSequence;
    }


    public static int longestFlat(int[] arr){
        int maxFlatSequence = 0;
        int sequenceCounter = 0;
        int startCounter = 0;
        return longestFlat(arr, maxFlatSequence,
                sequenceCounter, startCounter, 0);
    }

    public static void main(String[] args){
        int[] a = new int[6];
        a[0] = 4;
        a[1] = 5;
        a[2] = 6;
        a[3] = 5;
        a[4] = 4;
        a[5] = 3;
        System.out.println(longestFlat(a));
//        System.out.println(what(a));
//        int[][] a = new int[3][3];
//        a[0][0] = 4;
//        a[0][1] = 0;
//        a[1][0] = 3;
//        a[1][1] = 2;
//        a[1][2] = 1;
//        int num = 1;
//        System.out.println(Arrays.toString(a[0]) + "\n" + Arrays.toString(a[1]) + "\n" + Arrays.toString(a[2]));
//        System.out.println(longerSlope(a, num));

    }
}

class test {
//    public static int findSingle(int[] a){
//        int low = 0;
//        int high = a.length;
//        while (high != low+1 || high != low -1){
//            int mid = (high+low)/2;
//            if (a[mid] == a[mid+1]){
//                low = mid;
//            }
//            else if (a[mid] == a[mid-1]){
//                high = mid;
//            }
//            else {
//                return a[mid];
//            }
//        }
//        return a[low];
//    }
//
//    public static int findSingle1(int[] a){
//        int min = 0;
//        int max = a.length;
//        int mid = (max+min)/2;
//        boolean choice = (a.length / 2) % 2 == 0;
//        if (max == 3){
//            return a[mid] == a[mid+1] ? a[mid-1] : a[mid+1];
//        }
//        while (max != min+1){
//            mid = (max+min)/2;
//            if (a[mid] == a[mid+1]){
//                if (choice) {
//                    min = (max + min) / 2;
//                }
//                else{
//                    max = (max+min) / 2;
//                }
//            }
//            else if (a[mid] == a[mid-1]){
//                if (choice) {
//                    max = (max+min) / 2;
//                }
//                else{
//                    min = (max + min) / 2;
//                }
//            }
//            else {
//                return a[mid];
//            }
//        }
//        return a[mid] == a[mid+1] ? a[mid-1] : a[mid+1];
//    }
//
//public static int findSingle(int[] a) {
//    int low = 0, high = a.length, mid = (high+low)/2;
//    while(low <= high){
//        mid = (low+high)/2;
//        if(mid == 0)
//            break;
//        if(a[mid] != a[mid+1] && a[mid] != a[mid-1])
//            return a[mid];
//        if(a[mid] == a[mid+1])
//            if((mid+1)%2 == 0)
//                low = mid+1;
//            else
//                high = mid-1;
//        else
//        if((mid-1)%2 == 0)
//            low = mid+1;
//        else
//            high = mid-1;
//    }
//    return a[mid];
//}
    public static int findSingle(int[] a) {
        int low = 0, high = a.length, mid = low+(high-low)/2;
        while(low != high){
            mid = low+(high-low)/2;
            if((mid == high || mid == low) || mid+1 == a.length || mid-1 < 0)
                break;
            if(a[mid] == a[mid+1])
                if((mid)%2 == 0)
                    low = mid+1;
                else
                    high = mid;
            else if(a[mid] == a[mid-1])
                if((mid)%2 == 0)
                    high = mid;
                else
                    low = mid+1;
        }
        return a[mid];
    }

    private static boolean isValidMove(int[][] drm,
                                int i, int j,
                                boolean[][] wasThere, int previous){
        if ((i < drm.length && j < drm[0].length) && (i >= 0 && j >= 0)) {
            if (drm[i][j] == -1){
                return true;
            }
            if (!(previous - drm[i][j] > 2 || previous - drm[i][j] < -1)) {
                return true;
            }
        }
        return false;
    }

    private static int prince(int[][] drm, int i,
                              int j,
                              boolean[][] wasThere, int counter,int previous){
        int right,left,down,up;
        int max = drm.length * drm[0].length;
        if (!isValidMove(drm, i, j, wasThere, previous)){
            return max;
        }
        if (wasThere[i][j]){
            return max;
        }
        wasThere[i][j] = true;
        if (drm[i][j] == -1){
            return counter;
        }
        right = prince(drm, i,
                j+1,
                wasThere, counter+1, drm[i][j]);
        left = prince(drm, i,
                j-1,
                wasThere, counter+1, drm[i][j]);
        down = prince(drm, i+1,
                j,
                wasThere, counter+1, drm[i][j]);
        up = prince(drm, i-1,
                j,
                wasThere, counter+1, drm[i][j]);

        return Math.min(Math.min(right, left), Math.min(up, down));
    }

    public static int prince(int[][] drm, int i, int j){
        int counter = 0;
        boolean[][] wasThere = new boolean[drm.length][drm[0].length];
        int val =  prince(drm,  i,
                j,
                wasThere,  counter, drm[i][j]);
        if (val == drm.length*drm[0].length){
            return -1;
        }
        return val;
    }



    public static void main(String [] args){
//        int[][] a =
//                {{2,7,1,2,1},
//                {1,7,1,5,4},
//                {1,-1,6,8,7},
//                {3,4,7,2,4},
//                {2,4,3,1,1}};
//        System.out.println(prince(a, 2, 3));
        int[] b = {5, 5, 9, 1, 1, 3, 3, 4, 4, 6, 6, 7,7};
        int[] c = {1, 1, 3};
        System.out.println(findSingle(c));

    }
}

