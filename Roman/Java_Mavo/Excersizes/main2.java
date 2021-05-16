class main {
    public static void main(String[] args) throws Exception{
//        Gender Male = new Gender("male");
//        System.out.println(Male.getGender());
//        Male.switchGender();
////        System.out.println(Male.getGender());
//        Male.switchGender();
////        System.out.println(Male.getGender());
//        Male.transformNonBinary();
////        System.out.println(Male.getGender());
//        int trY = 0;
//        while (trY < 5){
//            Male.switchGender();
//            trY++;
//        }
//        fagChild fag = new fagChild("fag");
//        System.out.println(fag.getGender());
//        fag.switchGender();
//        fag.getGaylordness();
//        abomination grot = new abomination();
//        grot.switchGender();
//        grot.transformNonBinary();
//        System.out.println(grot.getGender());
//        System.out.println(fag.getGender());
//
//
//        fagChild faggy = new fagChild("fag");
//        sexualOrientetion S = (sexualOrientetion)faggy;
//        Gender M = faggy;
//        Gender fagl = (Gender) new fagChild("fagggggg");
//        try {
//            fagChild FF = (fagChild) Male;
//            System.out.println(FF.getGender());
//        }
//        catch (Exception ex){
//            System.out.println(ex.getMessage());
////            throw new Exception(ex);
//        }
//        System.out.println(M.getGender());
//        System.out.println(faggy.getGender());
//        System.out.println(fagl.getGender());
//        System.out.println(M.getClass());
//        System.out.println(faggy.getClass());
//        System.out.println(fagl.getClass());
//        System.out.println(S.getClass());
//        int a = 5;
//        System.out.println(a);
//        double b = (int)a;
//        System.out.println(b);
////        System.out.println(FF instanceof fagChild);

        sexualOrientetion male = new Gender("male");
        System.out.println(male.getClass());
        sexualOrientetion fag = new fagChild("Fage");
        System.out.println(fag.getClass());
        fagChild faggy = new fagChild("Fagge");
        System.out.println(faggy.getClass());
        System.out.println(male.equals(fag));
        System.out.println(fag.getGender());
        System.out.println(faggy.getGender());
    }
}