package toros;

public class büyücü extends karakter {
    private int mana;

    public büyücü(String ad, int seviye, lonca lonca) {
        super(ad, seviye, lonca);
        mana = 100;
    }

    public int getMana() {
        return mana;
    }

    public int buyuYap(String buyuAdi, int manaMaliyeti) {
        if (buyuAdi == null || buyuAdi.trim().isEmpty()) {
            throw new IllegalArgumentException("Büyü adı boş olamaz.");
        }
        if (manaMaliyeti < 1 || manaMaliyeti > 50) {
            throw new IllegalArgumentException("Mana maliyeti 1–50 arasında olmalıdır.");
        }
        hayattaOldugunuDogrula();
        if (mana < manaMaliyeti) {
            throw new IllegalStateException("Yeterli mana yok.");
        }

        mana -= manaMaliyeti;
        kayitYaz(buyuAdi + " büyüsü yaptı.");
        return manaMaliyeti * 2 + getSeviye();
    }

    public void manaTopla(int miktar) {
        if (miktar <= 0) {
            throw new IllegalArgumentException("Mana miktarı pozitif olmalıdır.");
        }
        mana = (int) Math.min(100, (long) mana + miktar);
    }

    @Override
    public String bilgiGoster() {
        return super.bilgiGoster() + " | Mana: " + mana + "/100";
    }

    @Override
    public String toString() {
        return "Büyücü[" + getAd() + ", seviye " + getSeviye() + "]";
    }
}
