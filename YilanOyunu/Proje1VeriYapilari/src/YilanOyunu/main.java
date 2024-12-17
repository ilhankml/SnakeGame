package YilanOyunu;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        int boyut = boyutIsteme();
        Islem islem = new Islem(boyut);
        islem.baslangic();
        islem.yilanOlusturma();
        islem.bombaOlusturma();
        islem.yemekOlusturma();
        islem.yazdirma();
        islem.oynama();
    }

    public static int boyutIsteme() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Matrisiniz kac boyutlu olsun ");
        int boyut = scan.nextInt();
        return boyut;
    }
}
