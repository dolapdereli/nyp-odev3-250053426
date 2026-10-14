package toros;


public class Main {
    public static void main(String[] args) {
        lonca kartalLoncası = new lonca(
                "Kartal", 1071, "Cuma akşamı kale kuşatması!");
        lonca kurtLoncası = new lonca(
                "Kurt", 1200, "Yeni üyelerimizi bekliyoruz.");

        int kDegeri = 8;
        savaşcı savaşçı = new savaşcı(
                "Kaan", 8, kartalLoncası, kDegeri % 31);
        büyücü büyücü = new büyücü("Mira", 12, kurtLoncası);
        okçu okçu = new okçu("Eren", 10, kartalLoncası);
        suikastcı suikastçı = new suikastcı("Lara", 9, kurtLoncası);

        silah kılıç = new silah("Kılıç", 12);
        silah yay = new silah("Yay", 12);
        savaşçı.silahKuşan(kılıç);
        okçu.silahKuşan(yay);

        System.out.println("Karakter bilgileri:");
        System.out.println(savaşçı.bilgiGoster());
        System.out.println(büyücü.bilgiGoster());
        System.out.println(okçu.bilgiGoster());
        System.out.println(suikastçı.bilgiGoster());

        System.out.println("\nSavaşçının saldırıları:");
        for (int saldırı = 1; saldırı <= 3; saldırı++) {
            System.out.println("Saldırı " + saldırı + ": " + savaşçı.saldir());
        }
        System.out.println("Kılıcın dayanıklılığı: " + kılıç.getDayaniklilik());

        savaşçı.hasarAl(40);
        büyücü.hasarAl(40);
        System.out.println("\n40 hasar sonrası savaşçının canı: " + savaşçı.getCan());
        System.out.println("40 hasar sonrası büyücünün canı: " + büyücü.getCan());

        System.out.println("\nBüyü denemeleri:");
        for (int deneme = 1; deneme <= 3; deneme++) {
            try {
                int manaMaliyeti = deneme <= 2 ? 30 : 50;
                int büyüHasarı = büyücü.buyuYap("Ateş Topu", manaMaliyeti);
                System.out.println("Büyü " + deneme + " hasarı: " + büyüHasarı);
            } catch (IllegalStateException e) {
                System.out.println("Büyü " + deneme + " reddedildi: " + e.getMessage());
            }
        }

        System.out.println("\nOkçunun atışları:");
        System.out.println("İlk atış hasarı: " + okçu.atesEt());
        System.out.println("İkinci atış hasarı: " + okçu.atesEt());
        System.out.println("Kalan ok sayısı: " + okçu.getOkSayisi());

        System.out.println("\nSuikastçının saldırıları:");
        suikastçı.gizlen();
        System.out.println("Gizlenmiş saldırı hasarı: " + suikastçı.saldir());
        System.out.println("İkinci saldırı hasarı: " + suikastçı.saldir());

        büyücü.iyiles(25);
        büyücü.seviyeAtla();
        System.out.println("\nİyileşme ve seviye atlama sonrası:");
        System.out.println(büyücü.bilgiGoster());

        System.out.println("\nGeçersiz işlem denemeleri:");
        try {
            new karakter("Al", 1, kartalLoncası);
        } catch (IllegalArgumentException e) {
            System.out.println("Geçersiz karakter reddedildi: " + e.getMessage());
        }
        try {
            savaşçı.hasarAl(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Negatif hasar reddedildi: " + e.getMessage());
        }
        try {
            büyücü.iyiles(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Sıfır miktarlı iyileşme reddedildi: " + e.getMessage());
        }

        kartalLoncası.setDuyuru("Pazar günü lonca toplantısı yapılacaktır.");
        System.out.println("\nGüncel lonca duyurusu: " + kartalLoncası.getDuyuru());
        System.out.println("Kartal Loncası üyeleri:");
        System.out.println(savaşçı.bilgiGoster());
        System.out.println(okçu.bilgiGoster());

        System.out.println("\nOkçunun toString çıktısı:");
        System.out.println(okçu);
    }
}
