package YilanOyunu;

import java.util.Random;
import java.util.Scanner;

public class Islem {

    Node head;
    Node matris[][];
    int boyut, size;
    int iBomba, jBomba;
    int iH, jH;
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    boolean bitme;

    Islem(int boyut) {
        this.boyut = boyut + 2;
        head = null;
        matris = new Node[boyut + 2][boyut + 2];
        size = 0;
        bitme = true;
    }

    public void baslangic() {
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                if (i == 0 || i == boyut - 1) {
                    matris[i][j] = new Node('-');
                } else if (j == 0 || j == boyut - 1) {
                    matris[i][j] = new Node('|');
                } else {
                    matris[i][j] = new Node(' ');
                }
            }
        }
    }

    public boolean oyunBittimi() {
        if (bitme == false || size == 3) {
            if (size == 3) {
                System.out.println("Yılanının dügümü 3 e düstü...Öldünüz");
            }
            return false;
        } else {
            return true;
        }
    }

    public void oynama() {
        int bombaSayacı = 0;
        int giris = 0;
        while (oyunBittimi()) {
            System.out.println("2: Assagı iner\t"
                    + "4: Sola gider\t"
                    + "6: Saga gider\t"
                    + "8: Yukarı gider");
            int hamle = scan.nextInt();
            if (hamle == 2) {
                if (matris[iH + 1][jH].dugum == ' ' || matris[iH + 1][jH].dugum == 'B') {
                    if (matris[iH + 1][jH].dugum == 'B') {
                        giris++;
                    }
                    matris[iH + 1][jH] = new Node('H');
                    matris[iH + 1][jH].next = matris[iH][jH];
                    head = matris[iH + 1][jH];
                    matris[iH][jH].dugum = '*';
                    iH++;
                    Node node = head;
                    Node isaret = null;
                    while (node.next != null) {
                        isaret = node;
                        node = node.next;
                    }
                    isaret.next = null;
                    node.dugum = ' ';

                } else if (matris[iH + 1][jH].dugum == 'Y') {
                    matris[iH + 1][jH] = new Node('H');
                    matris[iH + 1][jH].next = matris[iH][jH];
                    head = matris[iH + 1][jH];
                    matris[iH][jH].dugum = '*';
                    iH++;
                    yemekOlusturma();
                    size++;
                } else if (matris[iH + 1][jH].dugum == '*' || matris[iH + 1][jH].dugum == '-' || matris[iH + 1][jH].dugum == '|') {
                    System.err.println("OYUN BİTMİŞTİR!!! Kendi düğümünüze yada Köseye çarptınız");
                    bitme = false;
                }
            } else if (hamle == 4) {
                if (matris[iH][jH - 1].dugum == ' ' || matris[iH][jH - 1].dugum == 'B') {
                    if (matris[iH][jH - 1].dugum == 'B') {
                        giris++;
                    }
                    matris[iH][jH - 1] = new Node('H');
                    matris[iH][jH - 1].next = matris[iH][jH];
                    head = matris[iH][jH - 1];
                    matris[iH][jH].dugum = '*';
                    jH--;
                    Node node = head;
                    Node isaret = null;
                    while (node.next != null) {
                        isaret = node;
                        node = node.next;
                    }
                    isaret.next = null;
                    node.dugum = ' ';

                } else if (matris[iH][jH - 1].dugum == 'Y') {
                    matris[iH][jH - 1] = new Node('H');
                    matris[iH][jH - 1].next = matris[iH][jH];
                    head = matris[iH][jH - 1];
                    matris[iH][jH].dugum = '*';
                    jH--;
                    yemekOlusturma();
                    size++;
                    System.out.println(size);
                } else if (matris[iH][jH - 1].dugum == '*' || matris[iH][jH - 1].dugum == '|' || matris[iH][jH - 1].dugum == '-') {
                    System.err.println("OYUN BİTMİŞTİR!!! Kendi düğümünüze yada Köseye çarptınız");
                    bitme = false;
                }
            } else if (hamle == 6) {
                if (matris[iH][jH + 1].dugum == ' ' || matris[iH][jH + 1].dugum == 'B') {
                    if (matris[iH][jH + 1].dugum == 'B') {
                        giris++;
                    }
                    matris[iH][jH + 1] = new Node('H');
                    matris[iH][jH + 1].next = matris[iH][jH];
                    head = matris[iH][jH + 1];
                    matris[iH][jH].dugum = '*';
                    jH++;
                    Node node = head;
                    Node isaret = null;
                    while (node.next != null) {
                        isaret = node;
                        node = node.next;
                    }
                    isaret.next = null;
                    node.dugum = ' ';

                } else if (matris[iH][jH + 1].dugum == 'Y') {
                    matris[iH][jH + 1] = new Node('H');
                    matris[iH][jH + 1].next = matris[iH][jH];
                    head = matris[iH][jH + 1];
                    matris[iH][jH].dugum = '*';
                    jH++;
                    yemekOlusturma();
                    size++;
                } else if (matris[iH][jH + 1].dugum == '*' || matris[iH][jH + 1].dugum == '-' || matris[iH][jH + 1].dugum == '|') {
                    System.err.println("OYUN BİTMİŞTİR!!! Kendi düğümünüze yada Köseye çarptınız");
                    bitme = false;
                }
            } else if (hamle == 8) {
                if (matris[iH - 1][jH].dugum == ' ' || matris[iH - 1][jH].dugum == 'B') {
                    if (matris[iH - 1][jH].dugum == 'B') {
                        giris++;
                    }
                    matris[iH - 1][jH] = new Node('H');
                    matris[iH - 1][jH].next = matris[iH][jH];
                    head = matris[iH - 1][jH];
                    matris[iH][jH].dugum = '*';
                    iH--;
                    Node node = head;
                    Node isaret = null;
                    while (node.next != null) {
                        isaret = node;
                        node = node.next;
                    }
                    isaret.next = null;
                    node.dugum = ' ';

                } else if (matris[iH - 1][jH].dugum == 'Y') {
                    matris[iH - 1][jH] = new Node('H');
                    matris[iH - 1][jH].next = matris[iH][jH];
                    head = matris[iH - 1][jH];
                    matris[iH][jH].dugum = '*';
                    iH--;
                    yemekOlusturma();
                    size++;
                } else if (matris[iH - 1][jH].dugum == '*' || matris[iH - 1][jH].dugum == '-' || matris[iH - 1][jH].dugum == '|') {
                    System.err.println("OYUN BİTMİŞTİR!!! Kendi düğümünüze yada Köseye çarptınız");
                    bitme = false;
                }
            } else {
                System.out.println("Gecersiz giriş baştan giriniz");
            }
            if (giris != 0) {
                bombaSayacı++;
            }
            if (bombaSayacı == 3) {
                matris[iBomba][jBomba].dugum = ' ';
                Node node = head;
                while (node.next.dugum != ' ') {
                    node = node.next;
                }
                yazdirma();
                Node isaret = null;
                isaret = node.next;
                isaret = isaret.next;
                node.next = isaret;
                giris = 0;
                bombaSayacı = 0;
                bombaOlusturma();
                size--;
            }
            yazdirma();
        }
    }

    public void yazdirma() {

        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                System.out.print(matris[i][j].dugum + " ");
            }
            System.out.println();
        }
    }

    public void yemekOlusturma() {
        int i = 1 + rand.nextInt(boyut - 2);
        int j = 1 + rand.nextInt(boyut - 2);
        while (matris[i][j].dugum != ' ') {
            i = 1 + rand.nextInt(boyut - 2);
            j = 1 + rand.nextInt(boyut - 2);
        }
        matris[i][j] = new Node('Y');
    }

    public void bombaOlusturma() {
        iBomba = 1 + rand.nextInt(boyut - 2);
        jBomba = 1 + rand.nextInt(boyut - 2);
        while (matris[iBomba][jBomba].dugum != ' ') {
            iBomba = 1 + rand.nextInt(boyut - 2);
            jBomba = 1 + rand.nextInt(boyut - 2);
        }
        matris[iBomba][jBomba] = new Node('B');
    }

    public void yilanOlusturma() {
        iH = 1 + rand.nextInt(boyut - 2);
        jH = 1 + rand.nextInt(boyut - 2);
        matris[iH][jH] = new Node('H');
        head = matris[iH][jH];
        int i = iH;
        int j = jH;
        int dugumSayisi = 0;
        int option;
        int cik = 0;
        while (dugumSayisi < 4) {
            while (cik == 0) {
                option = rand.nextInt(4);
                if (option == 0 && matris[i + 1][j].dugum == ' ') {
                    matris[i + 1][j] = new Node('*');
                    matris[i][j].next = matris[i + 1][j];
                    i++;
                    cik++;
                } else if (option == 1 && matris[i][j + 1].dugum == ' ') {
                    matris[i][j + 1] = new Node('*');
                    matris[i][j].next = matris[i][j + 1];
                    j++;
                    cik++;
                } else if (option == 1 && matris[i][j - 1].dugum == ' ') {
                    matris[i][j - 1] = new Node('*');
                    matris[i][j].next = matris[i][j - 1];
                    j--;
                    cik++;
                } else if (option == 0 && matris[i - 1][j].dugum == ' ') {
                    matris[i - 1][j] = new Node('*');
                    matris[i][j].next = matris[i - 1][j];
                    i--;
                    cik++;
                }
            }
            dugumSayisi++;
            cik = 0;
        }
        size = 5;
    }

}
