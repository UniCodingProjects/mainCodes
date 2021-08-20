package Workspace;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;


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


    private static int findMax(int[] arr){
        int max = 0;
        for (int i: arr){
            if (i > max){
                max = i;
            }
        }
        return max;
    }

    public static void countingSort(int[] arr){
        int j = 0;
        int[] tempArr = new int[findMax(arr)+1];
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
        int[] tempArr = new int[findMax(arr)+1];
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
        int[] tempArr = new int[findMax(arr)+1];
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


    public static void crossSort(int[] arr){
        int[] newArr = new int[arr.length];

        int d, c, g, e = 5;

        int evenIdxStart = 0;
        int oddIdxEnd = arr.length % 2 == 0 ? arr.length-1 : arr.length-2;
        int newArrRunningIdx = 0;

        while (evenIdxStart < arr.length || oddIdxEnd >= 0){

            if (evenIdxStart < arr.length && oddIdxEnd >= 0){
                if (arr[evenIdxStart] < arr[oddIdxEnd]){
                    newArr[newArrRunningIdx] = arr[evenIdxStart];
                    newArrRunningIdx++;
                    evenIdxStart += 2;
                }
                else {
                    newArr[newArrRunningIdx] = arr[oddIdxEnd];
                    oddIdxEnd -= 2;
                    newArrRunningIdx++;
                }
            }

            else if (evenIdxStart >= arr.length){
                newArr[newArrRunningIdx] = arr[oddIdxEnd];
                newArrRunningIdx++;
                oddIdxEnd -= 2;
            }
            else{
                newArr[newArrRunningIdx] = arr[evenIdxStart];
                newArrRunningIdx++;
                evenIdxStart += 2;
            }
        }

        for (int i=0;i < arr.length; i++){
            arr[i] = newArr[i];
        }



    }


    public static int crossSearch(int[] arr, int x) {
        int i = 0;
        int j = arr.length-1;
        int mid = ((i + j) / 2) + (((i + j) / 2) % 2 == 0 ? 0 : 1);

        while (i < j){
            if (x > arr[mid]){
                i = mid+1;
                mid = ((i + j) / 2) + (((i + j) / 2) % 2 == 0 ? 0 : 1);
            }
            else if (x < arr[mid]){
                j = mid-1;
                mid = ((i + j) / 2) + (((i + j) / 2) % 2 == 0 ? 0 : 1);
            }
            else{
                return mid;
            }
        }
        i = 0;
        j = arr.length-1;
        mid = ((i + j) / 2) + (((i + j) / 2) % 2 == 0 ? +1: +0);

        while (i < j){
            if (x < arr[mid]){
                i = mid+1;
                mid = ((i + j) / 2) + (((i + j) / 2) % 2 == 0 ? +1: +0);
            }
            else if (x > arr[mid]){
                j = mid-1;
                mid = ((i + j) / 2) + (((i + j) / 2) % 2 == 0 ? +1: +0);
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    private static void updateHasBeen(boolean[][] hasBeen, int i, int j){
        hasBeen[i][j] = false;
        if (i+1 < hasBeen.length) {
            updateHasBeen(hasBeen, i + 1, j);
        }
        if (j+1 < hasBeen[0].length) {
            updateHasBeen(hasBeen, i, j + 1);
        }
    }

    private static void printPathWeights(int[][] m, int counter, int moveRow, int moveCol, boolean[][] hasBeen){
        if (moveRow>= m.length || moveCol >= m[0].length || moveCol< 0 || moveRow < 0){
            return;
        }
        if (hasBeen[moveRow][moveCol]){
            return;
        }
        counter += m[moveRow][moveCol];
        if (moveCol == m[0].length-1 && moveRow == m.length-1){
//            System.out.println(counter);
            if (counter == 60) System.out.println("fag " + counter);
            if (counter == 52) System.out.println("fag " + counter);
            return;
        }
        hasBeen[moveRow][moveCol] = true;

        printPathWeights(m, counter,moveRow+1, moveCol, hasBeen);

        printPathWeights(m, counter, moveRow, moveCol+1, hasBeen);

        printPathWeights(m, counter, moveRow-1, moveCol, hasBeen);

        printPathWeights(m, counter, moveRow, moveCol-1, hasBeen);

        hasBeen[moveRow][moveCol] = false;
    }

    public static void printPathWeights(int [][] m) {
        boolean[][] hasBeen = new boolean[m.length][m[0].length];
        printPathWeights(m, 0, 0, 0, hasBeen);

    }


    public static void main(String[] args){
        int[] arr = {4, 9, 6, 7, 8, 4, 12, 2, 14, 1, 300};
//        crossSort(arr);
//        System.out.println(Arrays.toString(arr));
        int [] arr2 = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
//        countingSort(arr);
//        System.out.println(crossSearch(arr2, 10));
//        System.out.println(arr2[crossSearch(arr2, 10)]);
//        System.out.println(Arrays.toString(arr2));

        int[][] m = {{8, 4, 2, 4, 3},
                    {6, 3, 8, 4, 5},
                    {1, 4, 9, 9, 7},
                    {2, 1, 7, 6, 5}};

        printPathWeights(m);
    }
}


class IntNode {    private int _value;    private IntNode _next;    public IntNode(int val, IntNode n)
{       _value = val;       _next = n;    }    public int getValue()     { return _value; }    public IntNode getNext()  { return _next;  }
    public void setValue(int v)  { _value = v; }    public void setNext(IntNode node)  { _next = node; } }


class IntList {
    private IntNode _head;

    public IntList() {
        _head = null;
    }

    public IntList(IntNode node) {
        _head = node;
    }


    public void fill(int[] arr) {
        _head = new IntNode(arr[0], null);
        IntNode temp = _head;
        for (int i = 1; i < arr.length; i++) {
            temp.setNext(new IntNode(arr[i], null));
            temp = temp.getNext();
        }
    }


    public int longestAscend() {
        IntNode temp = _head;
        return longestAscend(temp, temp, temp.getNext(), 1, 1);
    }

    public int longestAscend(IntNode start, IntNode temp, IntNode next, int counter, int maxCounter) {
        if (start == null) return maxCounter;
        if (next == null) {
            if (counter > maxCounter) maxCounter = counter;
            counter = 1;
            maxCounter = longestAscend(start.getNext(), start, start, counter, maxCounter);
        } else if (temp.getValue() < next.getValue()) {
            counter++;
            maxCounter = longestAscend(start, next, next.getNext(), counter, maxCounter);
        } else {
            maxCounter = longestAscend(start, temp, next.getNext(), counter, maxCounter);
        }
        if (start.getNext() == null) return maxCounter;
        else return longestAscend(start.getNext(), start, start, 1, maxCounter);
    }
}


class test{
    public static void main(String[] args){
        IntList ll = new IntList();
        int[] arr = {9,10,0,3,4, 7, 2, 9, 1, 10};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {9,1,0,5,6,2,3,4};
        ll.fill(arr3);
//        System.out.println(ll.longestAscend());


//        System.out.println("hello");
        System.out.printf("%c, %d, %s: all this was formatted\n", 'i', 20, "hello");

        char[] arr4 = {'a', 'b'};
        char[] rr = {'c'};
        int[] bb = new int[]{1, 2, 3, 4};
        System.out.println(bb.length);
        System.out.println(bb[3]);
    }




}