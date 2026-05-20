public class Member {

    private final String namaMember;
     private final double diskon;

    public Member(String namaMember, double diskon) {
        this.namaMember = namaMember;
        this.diskon = diskon;
    }

    public String getNamaMember() {
        return namaMember;
    }

    public double getDiskon() {
        return diskon;
    }
}