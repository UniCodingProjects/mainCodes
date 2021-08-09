//import java.util.*;
//
//public class mmh3 {
//    Stack<Integer> stk = new Stack<>();
//    Queue<Integer> q = new LinkedList<>();
//
//    public static int secret(int num)
//    {
//        int temp, dig;
//        if (num<10)
//            return num;
//        else
//        {
//            temp = secret (num/10);
//            dig = num%10;
//            if (dig<temp)
//                return dig;
//            else return temp;
//        }
//    }
//    public static boolean check(Stack s, int m)
//    {
//        boolean fine;
//        int x = (int) s.pop();
//        if (secret(x) != m)
//        {
//            s.push(x);
//            return false;
//        }
//        else if (s.isEmpty())
//        {
//            s.push(x);
//            return true;
//        }
//        else
//        {
//            fine = check(s, m);
//            s.push(x);
//            return fine;
//        }
//    }
//
//    public static int checkQ (Queue q, int x){
//        if (q.isEmpty() || x != (int) q.element()){
//            return 1;
//        }
//        x = (int) q.remove();
//        return 1+ checkQ(q, x);
//    }
//
//    public static int checkQ1 (Queue q){
//        int y;
//        if (q.isEmpty()){
//            y = 0;
//        }
//        else {
//            int x = (int) q.remove();
//            int z = x * checkQ(q, x);
//            y = 1+ checkQ1(q);
//            q.add(z);
//        }
//        return y;
//    }
//
//
//
//
//
//    public static void main(String [] args){
////        int a = secret(45);
////        int b = secret(298);
////        System.out.println(a);
////        System.out.println(b);
////        Queue<Integer> q = new LinkedList<>();
////        q.add(2);
////        q.add(3);
////        q.add(1);
////        q.add(1);
////        q.add(2);
////        q.add(2);
////        q.add(2);
////        q.add(4);
////        q.add(4);
////        q.add(4);
////        q.add(5);
////        int a = checkQ1(q);
////        System.out.println(a);
////        System.out.println(q.toString());
//
//        // q5 = vav
//        // q6 = gimel
//        // q7 = gimel
//        // q8 = daled
//        // q9 = alef
//        // q10 = gimel or hey
//        // q11 = hey
//
//
//
//
//    }
//}
//// Java program to construct a tree using inorder and preorder traversal
//
///* A binary tree node has data, pointer to left child
//and a pointer to right child */
//class Node {
//    int data;
//    Node left, right;
//
//    Node(int item)
//    {
//        data = item;
//        left = right = null;
//    }
//}
//
//class BinaryTree {
//    Node root;
//    static int preIndex = 0;
//
//    /* Recursive function to construct binary of size len from
//    Inorder traversal in[] and Preorder traversal pre[].
//    Initial values of inStrt and inEnd should be 0 and len -1.
//    The function doesn't do any error checking for cases where
//    inorder and preorder do not form a tree */
//    Node buildTree(int in[], int pre[], int inStrt, int inEnd)
//    {
//        if (inStrt > inEnd)
//            return null;
//
//		/* Pick current node from Preorder traversal using preIndex
//		and increment preIndex */
//        Node tNode = new Node(pre[preIndex++]);
//
//        /* If this node has no children then return */
//        if (inStrt == inEnd)
//            return tNode;
//
//        /* Else find the index of this node in Inorder traversal */
//        int inIndex = search(in, inStrt, inEnd, tNode.data);
//
//		/* Using index in Inorder traversal, construct left and
//		right subtress */
//        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
//        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
//
//        return tNode;
//    }
//
//    /* UTILITY FUNCTIONS */
//
//    /* Function to find index of value in arr[start...end]
//    The function assumes that value is present in in[] */
//    int search(int arr[], int strt, int end, int value)
//    {
//        int i;
//        for (i = strt; i <= end; i++) {
//            if (arr[i] == value)
//                return i;
//        }
//        return i;
//    }
//
//    /* This funtcion is here just to test buildTree() */
//    void printInorder(Node node)
//    {
//        if (node == null)
//            return;
//        /* first recur on left child */
//        printInorder(node.left);
//
//        /* now recur on right child */
//        printInorder(node.right);
//
//        /* then print the data of node */
//        System.out.print(node.data + " ");
//
//
//    }
//    public static boolean ret(){
//        return false && false;
//    }
//
//    // driver program to test above functions
//    public static void main(String args[])
//    {
//
//        BinaryTree tree = new BinaryTree();
//        int in[] = new int[] {4,3,5,2,1,7,6,8};
//        int pre[] = new int[] {1,2,3,4,5,6,7,8};
//        int len = in.length;
//        Node root = tree.buildTree(in, pre, 0, len - 1);
//
//        // building the tree by printing inorder traversal
//        System.out.println("Post order traversal of constructed tree is : ");
//        tree.printInorder(root);
//    }
//}
//
//// This code has been contributed by Mayank Jaiswal
