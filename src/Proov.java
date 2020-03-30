public class Proov {
    public static void main(String[] args) {
        Buss b1 = new Buss(13);

        b1.koht_kinni(1);
        b1.koht_kinni(3);
        b1.koht_kinni(4);
        b1.koht_kinni(5);
        b1.koht_kinni(6);

        System.out.println(b1.ost(6));
        b1.bussiplaan();

        System.out.println(b1.ost(3));
        b1.bussiplaan();
    }
}
