import java.util.Scanner;

public class Proov {
    public static void main(String[] args) {

        Buss b1 = new Buss(5);

        b1.bussiplaan();
        while (true) {
            int arv = piletiteArv(b1); // saab ostjalt kohtade arvu
            String kohad = b1.ost(arv); // paneb nii palju kohti kinni kui ostija soovis(kui võimalik) ja tagastab, kas kohad, mis said kinni pandud või "Pole piisavalt vabu kohti"
            System.out.println(kohad);

            // Kui kohtade arv, mis ostija sisestas oli liiga palju siis programmi töö lõppeb
            if (kohad.equals("Pole piisavalt vabu kohti.")) {
                break;
            }

            // Kontrollib, kas vabu kohti on veel, kui ei siis lõpetab
            if (b1.vabad_kohad() == 0) {
                System.out.println("Vabu kohti rohkem ei ole.");
                break;
            }
            System.out.println("\n" + "\u001B[36m" + "Järgmine ostija" + "\u001B[0m");
            //b1.bussiplaan();
        }
    }

    public static int piletiteArv(Buss buss) {
        Scanner piletid = new Scanner(System.in);
        System.out.println("Mitu piletit soovite?");

        int arv = Integer.parseInt(piletid.nextLine());
        return arv;
    }
}
