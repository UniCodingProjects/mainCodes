class Split{
    /*
    This is the recursion code, it is based on my answer which worked only for consecutive numbers, and i've fixed it
    to work also with non consecutive sub arrays.
    The fix is using 3 different sum variables and for each sum var i use a separate counter which i increment on each
    finding of sum that equals to 1/3 of array sum.
     */
    private static int count(int[] arr, int i, int sum){
        if(i == arr.length){return sum;}
        sum +=arr[i];
        return count(arr, i+1, sum);
    }

    private static boolean split3(int[] arr, int i,
                                  int maxSum, int sum1,int sum2, int sum3,
                                  int counter1, int counter2, int counter3) { // add usage of 3 sums instead of 1, also 3 counters, 1 counter per sum
        if (sum1 == maxSum){ counter1++;} // if first sum equals the required array sum/3 increment counter
        if (sum2 == maxSum){ counter2++;} // if second sum equals the required array sum/3 increment counter
        if (sum3 == maxSum){ counter3++;} // if third sum equals the required array sum/3 increment counter
        if (counter1 == 3 || counter2 == 3 || counter3 == 3) { // if one of the counters equals 3, return true
            return true;
        }
        if (i == arr.length) {
            return false; // if reached the end of the array and didnt find 3 equal sums, return false
        }
        return  split3(arr, i + 1, maxSum, sum1 + arr[i],
                sum2, sum3, counter1, counter2, counter3) ||
                split3(arr, i + 1, maxSum, sum1,
                        sum2 + arr[i], sum3, counter1, counter2 , counter3) ||
                split3(arr, i + 1, maxSum, sum2,
                        sum2, sum3 + arr[i], counter1, counter2, counter3);  // recursively check each sum until found 3 equal sums
    }

    public static boolean split3(int[] arr){
        int maxSum = count(arr, 0, 0);
        if (maxSum % 3 != 0) {return false;}
        return split3(arr, 0,
        maxSum/3, 0,0, 0,
        0, 0, 0); // fix maxSum var - divide by 3, i counter starts from 0 and not from 1.
    }
}
