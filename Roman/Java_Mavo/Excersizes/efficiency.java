import java.util.Arrays;

public class efficiency {

    public int binarySearch(int[] arr , int num){
        int mid, start=0, end= arr.length -1;
        mid = (start+end)/2;
        System.out.println("arr len: "+(arr.length-1));
        while (true){
            if (end - mid == 1 && arr[mid] == num){
                return mid;
            }
            if (arr[mid] == num){
                return mid;
            }
            else if (num > arr[mid]){
                end = mid;
                mid = (start+end)/2 + mid;
            }
            else {
                end = mid;
                mid = (start+end)/2;

            }
        }
    }

    public int[] insertionSort(int [] arr){
        for (int i = 0, counter = 0; i < arr.length; i++){
            int smallest = arr[i];
            boolean swap = false;
            for (int j = i+1; j < arr.length; j++){
                if (smallest > arr[j]){
                    smallest = arr[j];
                    swap = true;
                    counter = j;
                }
            }
            if (swap) {
                int temp = arr[i];
                arr[i] = arr[counter];
                arr[counter] = temp;
            }
        }
        return arr;
    }

    public int[] sort2TypesInArr(int[] arr){
        int low = 0, high = arr.length-1;
        boolean swapLow = false, swapHigh = false;
        while (low+1 != arr.length && high >= 0){
            if (arr[high] == arr[low]){
                int temp = arr[low+1];
                arr[low+1] = arr[high];
                arr[high] = temp;
                low++;
                continue;
            }
            if (arr[low] == arr[low+1]){
                low++;
            }
            else {
                swapLow = true;
            }
            if (high-1 >=0 && arr[high] == arr[high-1]){
                high--;
            }
            else {
                swapHigh = true;
            }
            if (swapHigh && swapLow){
                if (!(low+1 == high && arr[low] != arr[high] && low+1 == arr.length && high != 0 )) {
                    System.out.println(high);
                    int temp = arr[low+1];
                    arr[low+1] = arr[high-1];
                    arr[high-1] = temp;
                    swapHigh = false;
                    swapLow = false;
                }
                low++;
                high--;
            }
        }
        return arr;
    }

    public static void main(String[] args){
        efficiency eff = new efficiency();
        int[] arr = {0, 1, 1, 1};
        eff.sort2TypesInArr(arr);
        System.out.println(Arrays.toString(arr));

    }
}























class recursion {
    private int counter = 0;

    public int rec(int i){
        i ++;
        counter++;
        if (i > 20){
            System.out.printf("got here after %d increments\n", counter);
            return i;
        }
        else {
            return rec(i);
        }
    }

    public static void main(String[] args){
        recursion a = new recursion();
        System.out.println(a.rec(-10));
    }
}
