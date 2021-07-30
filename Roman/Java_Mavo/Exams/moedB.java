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

    private static void swap(int[] arr, int oddI){
        int temp;
        if (arr[oddI] > arr[oddI+1]){
            temp = arr[oddI];
            arr[oddI] = arr[oddI+1];
            arr[oddI+1] = temp;
        }
    }

    public static void crossSort(int [] arr){
        int len = arr.length-1;
        System.out.println(len);
        int oddI = 1;
        int oddINegative = len%2 == 0 ? 1 : 0;
        while (oddI < len/2){
            int temp = arr[oddI];
            arr[oddI] = arr[len-oddINegative];
            arr[len-oddINegative] = temp;
            swap(arr, oddI);
            oddINegative += 2;
            oddI += 2;
        }
        oddI = 0;
        while (oddI < len){
           swap(arr, oddI);
           oddI++;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main (String[] args){
        int[] arr1 = {1, 9, 2, 8, 4, 7, 7, 4, 12};
        int[] arr = {1, 2, 3, 1, 7, 0, 10};
        crossSort(arr);
    }
}
