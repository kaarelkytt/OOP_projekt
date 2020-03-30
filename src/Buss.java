public class Buss {
    private int[][] kohad;

    public Buss(int ridade_arv) {
        // Antud bussi ridade arv
        // Loob bussi vastava ridade arvuga, ehk istme paaride hulga
        this.kohad = new int[ridade_arv*2][2];
        for (int i = 0; i < ridade_arv*2; i++) {
            kohad[i][0] = 2*i+1;
            kohad[i][1] = 2*i+2;
        }
    }

    public void bussiplaan(){
        // Väljastab bussi kohtade plaani, kus nulliga on märgistatud ostetud kohad
        // Paarituarvulised kohad on alati akna all
        System.out.println("Bussi kohtade plaan:");
        for (int i = 0; i < kohad.length/2; i++) {
            System.out.printf("  %2d %2d   %2d %2d \n", kohad[i*2][0], kohad[i*2][1], kohad[i*2+1][1], kohad[i*2+1][0]);
        }
        System.out.println();
    }

    public int vabad_kohad(){
        // Tagastab bussis leiduvate vabade kohtade arvu
        int vabad_kohad = 0;
        for (int[] paar: this.kohad)
            for (int koht: paar)
                if (koht != 0)
                    vabad_kohad++;
        return vabad_kohad;
    }

    public boolean piisavalt_kohti(int kohtade_arv){
        // Antud soovitud kohtade arv
        // Tagastab tõeväärtuse, kas bussis on nii palju vabu kohti
        return vabad_kohad() >= kohtade_arv;
    }

    public void koht_kinni(int koha_nr){
        // Antud koha number
        // Muudab bussis koha numbri nulliks
        this.kohad[(koha_nr-1) / 2][1-(koha_nr % 2)] = 0;
    }

    public int esimene_vaba_koht(){
        // Tagastab esimese vaba koha eest poolt taha vaadates
        for (int[] paar: this.kohad) {
            if (paar[1] != 0){
                if (paar[0] != 0)
                    return paar[0];
                return paar[1];
            }
        }
        return 0;
    }

    public int esimene_vaba_paar(){
        // Tagastab esimese vaba istme paari eest poolt taha vaadates
        for (int[] paar: this.kohad) {
            if (paar[0] != 0){
                return paar[0];
            }
        }
        return 0;
    }

    public String ost(int kohad){
        // Paneb bussis kinni vastava arvu kohti
        // Kohti valitakse nii, et paarisarvuline seltskond saab alati koos istuda
        if (piisavalt_kohti(kohad)){
            if (kohad % 2 == 1){
                koht_kinni(esimene_vaba_koht());
                int ev = esimene_vaba_koht();
                for (int i = ev; i < ev + kohad - 1; i++) {
                    koht_kinni(i);
                }
            } else{
                int ev = esimene_vaba_paar();
                for (int i = ev; i < ev + kohad; i++) {
                    koht_kinni(i);
                }
            }
            return "Teie kohad on kinnitatud";
        }

        else
            return "Pole piisavalt vabu kohti";
    }

}
