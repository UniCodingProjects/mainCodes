class AAA {
    public boolean equals(BBB b){
        System.out.println("im at AAA got b");
    return true;
    }
    public boolean equals(AAA a){
        System.out.println("im at AAA got a");
        return true;
    }
    public void fag(){
        System.out.println("fagA");
    }
    public void gay(){
        System.out.println("gayA");
    }
}
class BBB extends AAA {
    public boolean equals(BBB b){
        System.out.println("im at BBB got b");
        return true;
    }
    public boolean equals(AAA a){
        System.out.println("im at BBB got a");
        return true;
    }
    public void fag(){
        System.out.println("fagB");
    }
    public void lord(){
        System.out.println("lordB");
    }

}

class tester {
    public static void main(String[] args){
        AAA a1 = new AAA();
        BBB b1 = new BBB();
        AAA b2 = new BBB();
        AAA c3 = (BBB)b2;
        System.out.println(c3.equals(b2));
        a1.fag();
        b1.fag();
        b2.fag();
        c3.fag();
    }
}