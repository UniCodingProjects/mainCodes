package Workspace;

import java.util.Arrays;
import java.util.HashMap;



class Stack{
    private int[] _stack;
    private int _idx = -1;
    private int len;

    public Stack(int l){
        _stack = new int[l];
        len = l;
    }

    public void push(int n){
        if (_idx < _stack.length){
            _idx++;
            _stack[_idx] = n;
        }
    }

    public int pop(){
        if (_idx >= 0){
            int popped = _stack[_idx];
            _idx--;
            return popped;
        }
        return 0;
    }

    public int peek(){
        int peeked = pop();
        push(peeked);
        return peeked;
    }

    public int getIndex(){
        return _idx;
    }

    public int getLength(){
        return len;
    }

}

public class learn {

    public static boolean findDuplicateHashMap(int[] nums){
        HashMap<String, Integer> M = new HashMap<>(nums.length);
        for (int i : nums){
            if (M.getOrDefault(String.valueOf(i) , null) == null){
                M.putIfAbsent(String.valueOf(i), i);
            }
            else {
                return true;
            }
        }
        return false;
    }

    public static int findSingle(int[] nums){
        if (nums.length % 2 == 0) return -1;
        int start = 0;
        int end = nums.length -1;
        int mid = (start+end) / 2;
        while (start  < end) {
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    start = mid + 2;
                    mid = (start + end) / 2;
                } else {
                    end = mid;
                    mid = (start + end) / 2;
                }
            } else if (mid % 2 == 1) {
                if (nums[mid] == nums[mid - 1]) {
                    start = mid + 1;
                    mid = (start + end) / 2;
                } else {
                    end = mid-1;
                    mid = (start + end) / 2;
                }
            }
        }
        return nums[mid];
    }

    public static void hanoi(){
        Stack A = new Stack(6);
        Stack B = new Stack(6);
        Stack C = new Stack(6);

        A.push(6);
        A.push(5);
        A.push(4);
        A.push(3);
        A.push(2);
        A.push(1);

        move(6, A, C, B);

        for (int i = 0; i< 6;i++){
            System.out.println(C.pop());
        }
    }

    public static void move(int n, Stack from, Stack to, Stack by){
        if (n == 1){
            by.push(from.pop());
            to.push(by.pop());
        }
        else {
            move(n - 1, from, by, to);
            by.push(from.pop());
            to.push(by.pop());
            move(n - 1, by, to, from);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private static int partition(int[] arr, int start, int end){
        int lastIdxValue = arr[end];
        int i = start;
        for (int j = start; j<end;j++){
            if (arr[j] <= lastIdxValue){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, end, i);
        return i;
    }

    public static void quickSort(int[] arr, int start, int end){
        if (start < end){
            quickSort(arr, start, partition(arr, start, end)-1);
            quickSort(arr, partition(arr, start, end)+1, end);
        }
    }

    public static void countingSort(int[] arr){
        int j = 0;
        int[] tempArr = new int[10];
        for (int i=0;i < arr.length;i++){
            tempArr[arr[i]]++;
        }
        for (int i=0;i<tempArr.length;i++){
            if (tempArr[i] > 0){
                int v = tempArr[i];
                while (v > 0){
                    arr[j] = i;
                    v--;
                    j++;
                }
            }
        }
    }

    public static boolean countingSortFindDups(int[] arr){
        int[] tempArr = new int[10];
        for (int i=0;i < arr.length;i++){
            tempArr[arr[i]]++;
        }
        for (int i=0;i<tempArr.length;i++){
            if (tempArr[i] > 1){
                return true;
            }
        }
        return false;
    }

    public static int countingSortReturnSingle(int[] arr){
        int[] tempArr = new int[10];
        for (int i=0;i < arr.length;i++){
            tempArr[arr[i]]++;
        }
        for (int i=0;i<tempArr.length;i++){
            if (tempArr[i] == 1){
                return i;
            }
        }
        return -1;
    }




    public static void main(String[] args){
        int[] arr = {1, 6, 9, 2, 3, 4, 8};
        System.out.println(Arrays.toString(arr));
        countingSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(countingSortFindDups(arr));

        int[] dupsArr = {1, 1, 2, 2, 4, 4, 5, 7, 7};
        System.out.println(countingSortReturnSingle(dupsArr));
    }
}
