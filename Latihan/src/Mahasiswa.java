public class Mahasiswa {
    int sksMaksimal;
    int sisaSks;

    public void setSksMaksimal(int sks) {
        if (sks > 24 || sks < 2) {
            throw new IllegalArgumentException("Kesalahan sistem: Batas SKS tidak valid (harus antara 2 - 24 SKS)!");
        }
        this.sksMaksimal = sks;
        this.sisaSks = sks;
        System.out.println("SKS maksimal mahasiswa: " + sksMaksimal);
    }

    public void ambilMataKuliah(String namaMatkul, int bebanSks) {
        if (bebanSks > sisaSks) {
            throw new SksTidakCukupException("Sisa SKS tidak cukup untuk mengambil " + namaMatkul);
        }
        sisaSks = sisaSks - bebanSks;
        System.out.println("Berhasil mengambil " + namaMatkul + " (" + bebanSks + " SKS)");
        System.out.println("Sisa SKS: " + sisaSks);
    }
}