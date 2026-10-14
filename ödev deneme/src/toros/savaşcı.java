package toros;

public class savaşcı extends karakter {
    private final int zirh;

    public savaşcı(String ad, int seviye, lonca lonca, int zirh) {
        super(ad, seviye, lonca);
        if (zirh < 0 || zirh > 30) {
            throw new IllegalArgumentException("Zırh 0–30 arasında olmalıdır.");
        }
        this.zirh = zirh;
    }

    public int getZirh() {
        return zirh;
    }

    @Override
    public void hasarAl(int miktar) {
        if (miktar <= 0) {
            super.hasarAl(miktar);
            return;
        }
        super.hasarAl(Math.max(1, miktar - zirh));
    }

    @Override
    public String bilgiGoster() {
        return super.bilgiGoster() + " | Zırh: " + zirh;
    }

    @Override
    public String toString() {
        return "Savaşçı[" + getAd() + ", seviye " + getSeviye() + ", zırh " + zirh + "]";
    }
}
