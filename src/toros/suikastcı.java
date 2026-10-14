package toros;

public class suikastcı extends karakter {
    private boolean gizli;

    public suikastcı(String ad, int seviye, lonca lonca) {
        super(ad, seviye, lonca);
        gizli = false;
    }

    public boolean isGizli() {
        return gizli;
    }

    public void gizlen() {
        hayattaOldugunuDogrula();
        gizli = true;
        kayitYaz("gölgelere karıştı.");
    }

    @Override
    public int saldir() {
        if (!gizli) {
            return super.saldir();
        }

        int hasar = super.saldir();
        gizli = false;
        return hasar * 2;
    }

    @Override
    public String bilgiGoster() {
        return super.bilgiGoster() + " | Gizli: " + gizli;
    }

    @Override
    public String toString() {
        return "Suikastçı[" + getAd() + ", seviye " + getSeviye() + "]";
    }
}
