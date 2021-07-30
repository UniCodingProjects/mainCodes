class TestER{
    public static int average(int[] arr){
        int minL = arr[0];
        int maxL = arr[0];
        int len = arr.length;
        int minR = arr[len-1];
        int maxR = arr[len-1];
        int sum = arr[0];
        int diffIdx1 = 0;
        int diffIdx2 = 0;
        int diffIdx3 = 0;
        int diffIdx4 = 0;

        for (int i = 1; i< len; i++){
            sum += arr[i];
            if (sum/(i+1) > maxL){
                maxL = sum/(i+1);
                diffIdx1 = i;
            }
            else if (sum/(i+1) < minL){
                minL = sum/(i+1);
                diffIdx2 = i;
            }
        }
        sum = arr[len-1];
        for (int i = len-2; i > 0; i--){
            sum += arr[i];
            if (sum/(len-i) > maxR){
                maxR = sum/(len-i);
                diffIdx3 = i;
            }
            else if (sum/(len-i) < minR){
                minR = sum/(len-i);
                diffIdx4 = i;
            }
        }
        int maxDiff1 = Math.abs(maxR-minL);
        int idxDiff1= Math.abs(diffIdx3-diffIdx2);
        int maxDiff2 = Math.abs(maxL-minR);
        int idxDiff2 = Math.abs(diffIdx1-diffIdx4);
        if (maxDiff1 <= maxDiff2){
            return idxDiff2;
        }
        return idxDiff1;
    }

    public static boolean sumPower(int num){
        if (num==3 || num == 1) { return true;}
        return sumPower(num, 0, 2);
    }
    public static boolean sumPower(int num, int sum, int i){
        sum +=Math.pow(3, i);
        if (sum > num){ return false;}
        if (sum+1 == num || sum +3 == num){ return true;}
        if (sum == num) {return true;}
        return sumPower(num, sum, i+1);
    }

    public static boolean sumPower1(int num){
        if (num == 1) { return true;}
        return sumPower1(num, 0);
    }
    public static boolean sumPower1(int num, int i){
        if (num == 0){ return true;}
        if (num-1 == 0){ return true;}
        if (num < 0 ){ return false;}
        return sumPower1((num-3));
    }
    public static void main(String[] args){
        int[] arr = {5,7,-2,10};
        System.out.println(average(arr));
        System.out.println(sumPower(27));
        System.out.println(sumPower(3));
        System.out.println(sumPower(9));
        System.out.println(sumPower(37));
        System.out.println(sumPower(10));

    }
}
