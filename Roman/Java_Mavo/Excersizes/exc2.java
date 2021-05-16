import java.util.Arrays;

public class exc2 {
    private int _b = 5;

    public exc2(int num, String name){
        _b = num;
        System.out.println(name);
    }

    public int getB(){
        return this._b;
    }
}

class exc3 extends exc2 {
    private int _a = 4;
    private boolean stop = false;
    private int[] arr;
    private boolean sizeSet = false;

    public exc3(int num){
        super(num, "fag");
    }

    public int getA(){
        return this._a;
    }

    public void recurse(int num, int size){
        if (!sizeSet) {
            this.arr = new int[size];
            this.sizeSet = true;
        }
        if ((size == num)) {
            this.stop = true;
        }
        else {
            this.arr[num] = num;
            num++;
        }
        if (!this.stop) {
            recurse(num, size);
            return;
        }
        System.out.println(Arrays.toString(arr));
    }




    public static void main(String[] args){
        exc3 checkInh = new exc3(7);
        System.out.println(checkInh.getB());
        System.out.println(checkInh.getA());
        exc2 checkI = new exc2(7, "gay");
        System.out.println("====");
        checkInh.recurse(0, 5);
    }
}







abstract class sexualOrientetion{
    protected String[] normal = {"male", "female"};
    private String _gender;
    protected String nonBinaryIdentifier = "0";

    public sexualOrientetion(String gender){
        _gender = gender;
        System.out.printf("welcome: %S\n".toLowerCase(), _gender);
    }
    public String getGender(){
        return _gender;
    }
    abstract void switchGender();
    abstract void transformNonBinary();
    public void setGender(String gender){
        _gender = gender;
    }
}


class abomination extends sexualOrientetion{
    public abomination(){
        super("FUCK YOU");
    }

    public void switchGender(){
        System.out.println("CANTTTTT");
    }

    public void transformNonBinary(){
        System.out.println("AAAAAAAAAAAAA");
    }
}


class Gender extends sexualOrientetion{
    private String fag = "fag";

    public Gender(String gender){
        super(gender);
    }
    public void switchGender(){
        if (super.getGender().equals(super.nonBinaryIdentifier)){
            System.out.println("person is fucked up beyond repair, aborting operation (too late)");
            return;
        }
        for (String orien : super.normal){
            if (!orien.equals(super.getGender())){
                String prevGender = super.getGender();
                super.setGender(orien);
                System.out.printf("ergpirjhgoiherg =>>> %S is now %S :(((( \n",prevGender, super.getGender());
                return;
            }
        }
    }
    public void transformNonBinary(){
        System.out.println("transformed to some shit, no way back");
        super.setGender("0");
    }
}

class fagChild extends Gender{
    public fagChild(String gender){
        super(gender);
    }

    public void getGaylordness(){
        System.out.println("over 9000");
    }
    public String getGender(){
        return super.getGender() + "_Fag";
    }
    public static void main(String[] args){
        fagChild fag = new fagChild("fagg");
    }
}