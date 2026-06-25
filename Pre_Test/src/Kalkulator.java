public class Kalkulator {
    private int pembilang;
    private int penyebut;
    public Kalkulator(int pembilang, int penyebut) {
        this.pembilang = pembilang;
        this.penyebut = penyebut;
    }
    public int hitungPembagian() {
        return pembilang / penyebut;
    }
}