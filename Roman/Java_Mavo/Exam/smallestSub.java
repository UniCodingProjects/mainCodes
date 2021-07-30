class smallestSubArray{
    /* This is the method that i wrote during the exam (with fixes),
     given the fact that i understood the question incorrectly regarding the fact that
     the numbers need to be adjacent.
    */
    private static int sumNum(int[]a, int num, int j, int i, int counter){
        if (i+j == a.length){return Integer.MAX_VALUE;} // Integer.MAX -> changed to Integer.MAX_VALUE
        if (a[i+j] == num){return counter;}
        return sumNum(a, num-a[i+j],j,i+1,counter+1);       // fix -> remove unnecessary recursive call
                                                                        // fix-> recursive call to the overloaded sumNum instead of the main sumNum to avoid recursion fix
                                                                       // fix-> Counter incrementation at each index to count amount of numbers in sub Array
    }                                                                 // fix-> Change return type form boolean to int based on which integer is smaller
    private static int sumNum(int[]a, int num, int j, int counter){
        return sumNum(a, num, j, 0, counter);
    }
    public static int smallestSub(int[] a, int k){
        int len = a.length+1;
        for (int j=0;j<a.length;j++){
            int check = sumNum(a,k,j,1);
            if (check < len){
                len = check;
            }
        }
        return len;
    }
}