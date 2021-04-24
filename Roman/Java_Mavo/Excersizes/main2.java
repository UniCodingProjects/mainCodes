class main {
    public static void main(String[] args){
        Gender Male = new Gender("male");
        System.out.println(Male.getGender());
        Male.switchGender();
//        System.out.println(Male.getGender());
        Male.switchGender();
//        System.out.println(Male.getGender());
        Male.transformNonBinary();
//        System.out.println(Male.getGender());
        int trY = 0;
        while (trY < 5){
            Male.switchGender();
            trY++;
        }
    }
}