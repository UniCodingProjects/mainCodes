import java.util.Arrays;

class moedB1 {

    private static void printArr(int[] a, int i){
        System.out.print(a[i]);
        if (i < a.length-1) {
            printArr(a, i + 1);
        }
        else{
            System.out.println();
        }
    }

    private static int[] makeArr(int[] a, int i, int[] b){
        if (i == a.length){
            return b;
        }
        b[i] = a[i];
        return makeArr(a, i+1, b);
    }

    private static void mirror(int[] a, int i, int j, int[] b, int initS, int initE){
        if (initS+1 == initE || i+1>=a.length){
            return;
        }
        if (i >= j){
            b = makeArr(a, 0, b);
            mirror(a, initS+1, initE-1, b, initS+1, initE-1);
        }
        int temp = b[i];
        b[i] = b[j];
        b[j] = temp;
        printArr(b, 0);
        mirror(a, i+1, j-1, b, initS, initE);
    }

    public static void mirror(int[] a){
        int[] b = new int[a.length];
        b = makeArr(a, 0, b);
        mirror(a, 0, a.length-1, b, 0, a.length-1);
    }

    public static void main(String[] args){
        int[] a = {5, 3, 1, 4};
        mirror(a);
    }
}


class moedB2 {

    public static int findBC (String s){
        int i = 0;
        int j = 0;
        while (s.charAt(i) == 'a'){
            j++;
            if (i == 0){
                i += 1;
            }
            i *= 2;
        }
        System.out.printf("amount of actions: %d\n", j);
        return i;
    }

    public static int firstB (String s) {
        int i = findBC(s);
        int j = 0;
        while (true) {
            j++;
            if (i == 0 && s.charAt(i) == 'c'){
                i = -1;
                break;
            }
            if (s.charAt(i) == 'a' && s.charAt(i+1) == 'c'){
                i = -1;
                break;
            }
            if (s.charAt(i) == 'b' && i == 0){
                break;
            }
            if (s.charAt(i) == 'b' && s.charAt(i-1) == 'a'){
                break;
            }
            i = i/2;
            if (s.charAt(i) == 'c'){
                i = i - i/2;
            }
            else if (s.charAt(i) == 'a'){
                i = i + i/2+1;
            }
        }
        System.out.printf("amount of actions: %d\n", j);
        return i;
    }

    public static void main(String[] args){
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc";
        System.out.printf("s length: %s\n", s.length());
        System.out.printf("index that is not a: %d\n", findBC(s));
        System.out.printf("index that is first b: %d\n", firstB(s));
    }
}


class interview{
    public static void permutation(String s, int i, int j,  char[] s1){
        if (i+1 == 0){
//            s1 = s.toCharArray();
            permutation(s, s.length()-j, j-1, s1);
            return;
        }
        if (j+1 == 0){
            return;
        }
        char temp = s1[i];
        s1[i] = s1[j];
        s1[j] = temp;
        System.out.println(s1);
        permutation(s, i - 1, j, s1);
    }

    public static void permutation(String s){
        char[] s1 = s.toCharArray();
        permutation(s, s.length()-1, s.length()-1, s1);
    }

    public static void main(String[] args){
        permutation("abb");

    }
}


class moedB3{
    private static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void crossSort(int [] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void main (String[] args){
        int[] arr1 = {1, 9, 2, 8, 4, 7, 7, 4, 12};
        int[] arr = {1, 7, 2, 4, 5, 3};
        crossSort(arr);
    }
}

class MergeSort{
    public static void mergeSort(int[] arr,int start,int end) {
        // start - first idx of the current array
        // end - last idx of the current array
        if (start < end){ // while (recursively) the array len > 1 continue to split until len is 1
            int mid = (start+end) / 2; // find middle of the current array

            mergeSort(arr, start, mid); // split left half from start to mid including
            mergeSort(arr, mid +1, end); // split right half from mid + 1 to the end of the array

            merge(arr, start, mid, end); // merge each 2 single elemented arrays into new double elemented array and continue recursively
            // to merge until same arr len as original and sorted is achieved
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] tempArr1 = new int[mid - start + 1]; // create 2 temp arrays in the size of the 2 arrays to be sorted and merged
        int[] tempArr2 = new int[end - mid]; // 1st size is start to mid +1 / 2nd size is mid till end same as in the split above

        fillTempArr(arr, tempArr1, start, 0); // fill both temp arrays with the corresponding nums at indexes they assigned to
        fillTempArr(arr, tempArr2, mid +1, 0); // from start to mid is left and from mid+1 to end is right

        sort(arr, tempArr1, tempArr2, start, end, 0, 0); // call the sorting func to compare temparr1 to 1 indx by indx

    }

    public static void sort(int[] arr, int[] tempArr1, int[] tempArr2,
                            int start, int end, int i, int j){

        if (start < end && i < tempArr1.length && j < tempArr2.length){ // iterate recursively over the whole array len
            if (tempArr1[i] <= tempArr2[j]){ // if element is left array is smaller
                arr[start] = tempArr1[i];
                arr[start+1] = tempArr2[j]; // put at first idx in the main array
                sort(arr, tempArr1, tempArr2, start + 1, end, i+1, j); // inc left array pointer i and main array pointer start
            }
            else{
                arr[start] = tempArr2[j]; // else put from right temp array into main array and inc right array pointer j and main array
                arr[start+1] = tempArr1[i];
                sort(arr, tempArr1, tempArr2, start + 1, end, i, j+1); // pointer start

                // each time call sort until array len end - start = 0
            }
        }
        else{
            fill(arr, tempArr1, start + 1, i+1); // if any elements are left unsorted in comparison sequence fill main array
            fill(arr, tempArr2, start + 1, j+1); // with them as they are already sorted in their respective sub arrays
        }
    }
    public static void fill (int[] arr, int[] tempArr, int idx, int i){
        if (i < tempArr.length && idx < arr.length){ // fill main array until sub array is at its end
            arr[idx] = tempArr[i];
            fill(arr, tempArr, idx+1, i+1);
        }
    }

    public static void fillTempArr(int[] arr, int[] tempArr , int idx, int i){ // fill temp array until is full from idx in main array
        if (i < tempArr.length){ // until tempArr is full
            tempArr[i] = arr[idx];
            fillTempArr(arr, tempArr, idx +1, i +1);
        }
    }
}

class InsertionSort extends  MergeSort{
    public static void insertionSort(int[] arr){
        int j;
        for (int i = 0; i< arr.length; i++){
            int temp = arr[i];
            j = i -1;
            while (j >= 0 && temp < arr[j]){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = temp;
        }
    }
}

class sorting extends InsertionSort{





    public static void main(String[] args){
        int[] arr = {1, 12, 4, 7, 4, 5, 3, 6, 9, 56, 12, 4, 3};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}





class Cube {
    private int _num;
    private Cube _next;

    public Cube(int num){
        this._num = num;
        this._next = null;
    }

    public Cube(int num, Cube next){
        this._num = num;
        this._next = next;
    }

    public int getNum(){
        return this._num;
    }

    public Cube getNext(){
        return this._next;
    }

    public void setNext(Cube next){
        this._next = next;
    }

    @Override
    public String toString(){
        return "Num: " + this._num;
    }
}

class CubeList{
    private Cube _head;

    public CubeList(Cube head){
        this._head = head;
    }

    public void insertCubeAtStart(int num){
        Cube newHead = new Cube(num, this._head);
        this._head = newHead;
    }

    public void insertAtEnd(int num){
        Cube temp = this._head;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }

        temp.setNext(new Cube(num));
    }

    public void deleteHead(){
        this._head = this._head.getNext();
    }

    @Override
    public String toString(){
        String outPut = "";
        Cube temp = this._head;
        while (temp != null){
            outPut += temp + (temp.getNext() != null ? ", " : "");
            temp = temp.getNext();
        }
        return outPut;
    }

    public void insertAndKeepSorted(int num){
        Cube temp = this._head;
        if (temp.getNum() >= num){
            insertCubeAtStart(num);
            return;
        }
        while (temp.getNext() != null){
            if (temp.getNext().getNum() >= num){
                temp.setNext(new Cube(num, temp.getNext()));
                return;
            }
            temp = temp.getNext();
        }
        temp.setNext(new Cube(num));
    }

    public static void main(String[] args){
        Cube cube = new Cube(1);
        CubeList cl = new CubeList(cube);

        cl.insertAtEnd(2);
//        cl.insertAtEnd(3);


        System.out.println(cl);

//        cl.deleteHead();

        cl.insertAndKeepSorted(3);
        cl.insertAndKeepSorted(4);

        System.out.println(cl);
        cl.insertAndKeepSorted(0);
        cl.insertAndKeepSorted(-1);
        cl.insertAndKeepSorted(50);
        cl.insertAndKeepSorted(30);
        cl.insertAndKeepSorted(70);
        cl.insertAndKeepSorted(4);
        System.out.println(cl);

    }
}

class Stack{
    private int[] _stack;
    private int[] _minValueStack;
    private int _currIdx;
    private int _minIdx;

    public Stack(int length){
        _stack = new int[length];
        _minValueStack = new int[length];
        _currIdx = length-1;
        _minIdx = _currIdx;
        _minValueStack[_minIdx] = Integer.MAX_VALUE;
    }

    public void push(int num){
        if (_currIdx >= 0) {
            _stack[_currIdx] = num;
            if (_minValueStack[_minIdx] >= num){
                _minValueStack[_minIdx] = num;
                _minIdx--;
            }
            _currIdx--;
        }
    }

    public int pop(){
        if (_currIdx < _stack.length-1){
            int popped = _stack[_currIdx+1];
            if (_stack[_currIdx+1] == _minValueStack[_currIdx+1]){
                _stack[_currIdx+1] = Integer.MAX_VALUE;
                _minValueStack[_currIdx+1] = Integer.MAX_VALUE;
                _currIdx++;
                _minIdx++;
            }
            else{
                _stack[_currIdx+1] = Integer.MAX_VALUE;
                _currIdx++;
            }
            return popped;
        }
        return -1;
    }

    public int peek(){
        int peeked = pop();
        push(peeked);
        return peeked;
    }

    public int getMinimum(){
        if (_minIdx < _minValueStack.length-1){
            int popped = _minValueStack[_minIdx+1];
            _minIdx++;
            _minIdx--;
            _minValueStack[_minIdx+1] = popped;
            return popped;
        }
        return -1;
    }







    public static void main(String[] args){


    }
}

class Queue{
    private int[] _q;
    private int head;
    private int tail;
    protected int canDq = 0;

    public Queue(int l){
        _q = new int[l];
        head = -1;
        tail = -1;
    }

    public void enqueue(int n){
        this.canDq++;
        if (tail == _q.length && head != 0){
            tail = 0;
        }
        if (head < 0 && tail < 0) {
            head++;
            tail++;
            _q[head] = n;
        }
        else {
            tail++;
            if (tail == _q.length && head != 0){
                tail = 0;
            }
            _q[tail] = n;
        }
    }

    public int dequeue(){
        if (head == _q.length){
            head = 0;
        }
        if (this.canDq > 0) {
            int dQ = _q[head];
            head++;
            this.canDq--;
            return dQ;
        }
        return -111;
    }

    public void dequeueAll(){
        while (this.canDq > 0){
            System.out.println(this.dequeue());
        }
    }


    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.dequeueAll();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.dequeueAll();

        q.enqueue(5);
        q.dequeueAll();

        q.enqueue(4);
        q.dequeueAll();



    }

}


class rotateArr{
    public static void rotate1(int[] arr, int k){
        if (k == 0 || arr.length == 1){
            return;
        }
        int i = arr.length-1;
        int[] tempArr = new int[arr.length];
        if (k < 0){
            k = arr.length+k;
        }
        while (i >= 0) {
            if (k > arr.length){
                while (k > arr.length) {
                    k = Math.abs(arr.length - k);
                }
            }
            int idx = k + i > arr.length - 1 ? k + i - arr.length : k + i;
            tempArr[idx] = arr[i];
            i--;
        }
        for (int j = 0;j < arr.length;j++){
            arr[j] = tempArr[j];
        }
    }

    public static void rotate1(char[] arr, int k){
        if (k == 0 || arr.length == 1){
            return;
        }
        int i = arr.length-1;
        char[] tempArr = new char[arr.length];
        if (k < 0){
            k = arr.length+k;
        }
        while (i >= 0) {
            if (k > arr.length){
                while (k > arr.length) {
                    k = Math.abs(arr.length - k);
                }
            }
            int idx = k + i > arr.length - 1 ? k + i - arr.length : k + i;
            tempArr[idx] = arr[i];
            i--;
        }
        for (int j = 0;j < arr.length;j++){
            arr[j] = tempArr[j];
        }
    }



    public static void rotate(int[] arr, int k){
        if (k == 0 || k == arr.length){
            return;
        }
        else if (k > 0){
            for (int i= 0;i<Math.abs(k);i++) {
                rightRotate(arr, arr.length);
            }
        }
        else if (k < 0){
            for (int i= 0;i<Math.abs(k);i++) {
                leftRotate(arr,  arr.length);
            }
        }
    }

    private static void leftRotate(int arr[], int l){
        int temp = arr[0];
        int i;
        for (i = 0;i<l-1;i++){
            arr[i] = arr[i+1];
        }
        arr[i] = temp;
    }

    private static void rightRotate(int arr[], int l){
        int temp = arr[l-1];
        int i;
        for (i = l-1;i > 0;i--){
            arr[i] = arr[i-1];
        }
        arr[i] = temp;
    }


/*             for chyar array              */


    public static void rotate(char[] arr, int k){
        if (k == 0 || k == arr.length){
            return;
        }
        else if (k > 0){
            for (int i= 0;i<Math.abs(k);i++) {
                rightRotate(arr, arr.length);
            }
        }
        else if (k < 0){
            for (int i= 0;i<Math.abs(k);i++) {
                leftRotate(arr,  arr.length);
            }
        }
    }
    private static void leftRotate(char arr[], int l){
        char temp = arr[0];
        int i;
        for (i = 0;i<l-1;i++){
            arr[i] = arr[i+1];
        }
        arr[i] = temp;
    }

    private static void rightRotate(char arr[], int l){
        char temp = arr[l-1];
        int i;
        for (i = l-1;i > 0;i--){
            arr[i] = arr[i-1];
        }
        arr[i] = temp;
    }




    public static void main(String[] args){
//        int[] arr = {1,2,3,4,5,6,7};
        int k  = -1;

        char[] arr = {'f', 'a', 'g'};

        rotate1(arr, k);
        System.out.println(Arrays.toString(arr));
    }

}