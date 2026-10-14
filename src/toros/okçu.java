package toros;

public class okçu extends karakter {
    private int okSayisi;

    public okçu(String ad, int seviye, lonca lonca) {
        super(ad, seviye, lonca);
        okSayisi = 30;
    }

    public int getOkSayisi() {
        return okSayisi;
    }

    public int atesEt() {
        hayattaOldugunuDogrula();
        if (okSayisi <= 0) {
            throw new IllegalStateException("Ok kalmadı.");
        }

        okSayisi--;
        kayitYaz("Ok attı.");
        return saldir() + 3;
    }

    public void okTopla(int adet) {
        if (adet <= 0) {
            throw new IllegalArgumentException("Ok adedi pozitif olmalıdır.");
        }
        okSayisi = (int) Math.min(60, (long) okSayisi + adet);
    }

    @Override
    public String bilgiGoster() {
        return super.bilgiGoster() + " | Ok: " + okSayisi + "/60";
    }

    @Override
    public String toString() {
        return "Okçu[" + getAd() + ", seviye " + getSeviye() + "]";
    }
}
