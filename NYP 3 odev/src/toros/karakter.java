package toros;

public class karakter {
    private final String ad;
    private int seviye;
    private int can;
    private final lonca lonca;
    private silah silah;

    public karakter(String ad, int seviye, lonca lonca) {
        if (ad == null || ad.trim().isEmpty() || ad.length() < 3 || ad.length() > 15) {
            throw new IllegalArgumentException("Karakter adı 3–15 karakter olmalıdır.");
        }
        if (seviye < 1 || seviye > 50) {
            throw new IllegalArgumentException("Seviye 1–50 arasında olmalıdır.");
        }
        if (lonca == null) {
            throw new IllegalArgumentException("Lonca null olamaz.");
        }

        this.ad = ad;
        this.seviye = seviye;
        this.can = azamiCan();
        this.lonca = lonca;
    }

    public String getAd() {
        return ad;
    }

    public int getSeviye() {
        return seviye;
    }

    public int getCan() {
        return can;
    }

    public lonca getLonca() {
        return lonca;
    }

    public silah getSilah() {
        return silah;
    }

    public final int azamiCan() {
        return 100 + seviye * 10;
    }

    public final boolean hayattaMi() {
        return can > 0;
    }

    protected void hayattaOldugunuDogrula() {
        if (!hayattaMi()) {
            throw new IllegalStateException("Karakter hayatta değil.");
        }
    }

    protected void kayitYaz(String olay) {
        System.out.println("[" + ad + "] " + olay);
    }

    public void hasarAl(int miktar) {
        if (miktar <= 0) {
            throw new IllegalArgumentException("Hasar miktarı pozitif olmalıdır.");
        }
        can = Math.max(0, can - miktar);
    }

    public void iyiles(int miktar) {
        if (miktar <= 0) {
            throw new IllegalArgumentException("İyileşme miktarı pozitif olmalıdır.");
        }
        hayattaOldugunuDogrula();
        can = (int) Math.min(azamiCan(), (long) can + miktar);
    }

    public void seviyeAtla() {
        hayattaOldugunuDogrula();
        if (seviye == 50) {
            throw new IllegalStateException("Seviye en fazla 50 olabilir.");
        }
        seviye++;
        can = azamiCan();
    }

    public void silahKuşan(silah yeniSilah) {
        if (yeniSilah == null) {
            throw new IllegalArgumentException("Silah null olamaz.");
        }
        silah = yeniSilah;
    }

    public int saldir() {
        hayattaOldugunuDogrula();
        return silah == null ? 5 + seviye : silah.kullan() + seviye;
    }

    public String bilgiGoster() {
        return ad + " | Seviye " + seviye + " | Can " + can + "/" + azamiCan()
                + " | Lonca: " + lonca.getAd() + " Loncası | Silah: "
                + (silah == null ? "yok" : silah.bilgiMetni());
    }

    @Override
    public String toString() {
        return "Karakter[" + ad + ", seviye " + seviye + "]";
    }
}
