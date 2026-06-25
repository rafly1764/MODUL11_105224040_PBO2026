public class KeretaApi {
    String kodeKereta;
    String namaKereta;
    String rute;
    int sisaKursi;

    public KeretaApi(String kodeKereta, String namaKereta, String rute, int sisaKursi) {
        this.kodeKereta = kodeKereta;
        this.namaKereta = namaKereta;
        this.rute = rute;
        this.sisaKursi = sisaKursi;
    }
    public void tampilkanInfo() {
        System.out.println(kodeKereta + " - " + namaKereta + " - " + rute + " Sisa kursi: " + sisaKursi);
    }
    public void kurangiKursi(int jumlah) {
        sisaKursi -= jumlah;
    }
}