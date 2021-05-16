public class mamah02 {
    public double overload(double x, double y){
        return x;
    }
    public int overload(int a){
        return a;
    }
    public double overload(double x){
        return x;
    }

    public void overload(){
        return;
    }

    public double get(int a){
        return 5.0;
    }
    public static void main(String[] args){

    }
}

class B extends mamah02{
    public double get(){
        return 7.0;
    }

    public static void main(String[] args){
        mamah02 a1 = new B();
        B b1 = (B)a1;
        b1.get();
        Object obj = new Object();
    }
}



class AA {
    private int _val=0;
    public AA(){
        _val=5;
    }
    public AA(int val){
        _val=val;
    }
    public int getVal(){
        return _val;
    }
    public void setVal(int val){
        _val=val;
    }
    public String toString(){
        return "val=" + _val ;
    }
}
//------------------------------------------------------
class BB extends AA {
    private String _st;
    public BB (){
        _st="bb";
    }
    public BB(String st, int val){
        super(val);
        _st=st;
    }
    public String getSt(){
        return _st;
    }
    public boolean equals (Object ob) // 1 שיטה
    {
        System.out.printf("Object ob");
        if ((ob != null) && (ob instanceof BB))
        {
            if (_st.equals(((BB)ob)._st) &&
                    (getVal() == ((BB)ob).getVal()))
                return true;
        }
        return false;
    }
    public boolean equals (AA ob) // 2 שיטה
    {
        System.out.printf("AA ob");

        if ((ob != null) && (ob instanceof BB))
        {
            if (_st.equals(((BB)ob)._st) &&
                    (getVal() == ((BB)ob).getVal()))
                return true;
        }
        return false;
    }
    public boolean equals(BB ob) // 3 שיטה
    {
        System.out.printf("BB ob");

        if (ob != null)
        {
            if (_st.equals(((BB)ob)._st) &&
                    (getVal() == ((BB)ob).getVal()))
                return true;
        }
        return false;
    }
}


class Driver
{
    public static void main (String [] args)
    {
        AA a1 = new AA();
        AA a2 = new BB();
        AA a3 = new AA();
        AA a4 = new BB();
        BB b1 = new BB();
        BB b2 = new BB();
//        System.out.println(a3.equals(a1));
//        System.out.println(a4.equals(a2));
//        System.out.println(a1.equals(a2));
//        System.out.println(a2.equals(b1));
        System.out.println(b1.equals(a1));
//        System.out.println(b2.equals(b1));
//        System.out.println(b1.equals(a4));


    }
}


class A extends Object
{
    public A(){
        System.out.println ("A constructor");
    }
}
class C extends A
{
    public C()
    {
        System.out.println ("C constructor");
    }

    public static void main(String[] args){
        C c = new C();
    }
}


abstract class F {
    abstract boolean f(int x);
}

class FF extends G{

}
abstract class G extends F {
    public G(){
        int a = 9;
    }
    public boolean f(int x) {
        System.out.println("fag");
        return x == 2;
    }


    public static void main(String[] args){
        FF ff = new FF();
        System.out.println(ff.f(5));
    }
}

class W extends F {
    public boolean f(int x) {
        return x == 2.0;
    }
}


interface fag {
    void setfag();
}


class myfag implements fag{
    public void setfag(){
        System.out.println("fag");
    }
}

