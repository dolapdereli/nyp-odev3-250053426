package toros;

public class lonca {
    private final String ad;
    private final int kurulusYili;
    private String duyuru;

    public lonca(String ad, int kurulusYili, String duyuru) {
        if (ad == null || ad.length() < 3 || ad.length() > 25) {
            throw new IllegalArgumentException("Lonca adı 3–25 karakter olmalıdır.");
        }
        if (kurulusYili <= 0) {
            throw new IllegalArgumentException("Kuruluş yılı pozitif olmalıdır.");
        }

        this.ad = ad;
        this.kurulusYili = kurulusYili;
        this.duyuru = duyuruyuDogrula(duyuru);
    }

    private String duyuruyuDogrula(String duyuru) {
        if (duyuru == null || duyuru.trim().isEmpty() || duyuru.length() > 100) {
            throw new IllegalArgumentException("Duyuru boş olamaz ve en fazla 100 karakter olabilir.");
        }
        return duyuru;
    }

    public String getAd() {
        return ad;
    }

    public int getKurulusYili() {
        return kurulusYili;
    }

    public String getDuyuru() {
        return duyuru;
    }

    public void setDuyuru(String duyuru) {
        this.duyuru = duyuruyuDogrula(duyuru);
    }

    public String bilgiMetni() {
        return ad + " Loncası (kuruluş " + kurulusYili + ") - Duyuru: " + duyuru;
    }
}
