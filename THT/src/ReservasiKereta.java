import java.util.HashMap;
import java.util.Map;

public class ReservasiKereta {
    Map<String, KeretaApi> daftarKereta = new HashMap<>();
    public ReservasiKereta() {
        daftarKereta.put("K01", new KeretaApi("K01", "Argo Bromo", "JKT - SBY", 50));
        daftarKereta.put("K02", new KeretaApi("K02", "Parahyangan", "JKT - BDG", 15));
        daftarKereta.put("K03", new KeretaApi("K03", "Brantas", "JKT - SMG", 5));
    }
    public void lihatJadwal() {
        System.out.println("=== Jadwal Kereta JAVA EXPRESS ===");
        for (KeretaApi k : daftarKereta.values()) {
            k.tampilkanInfo();
        }
    }
    public void pesanTiket(String kodeKereta, String nik, String nama, int jumlah)
            throws RuteTidakDitemukanException, TiketHabisException {
        if (nik.length() != 16) {
            throw new DataPenumpangTidakValidException("NIK harus berjumlah 16 karakter");
        }
        for (int i = 0; i < nik.length(); i++) {
            if (!Character.isDigit(nik.charAt(i))) {
                throw new DataPenumpangTidakValidException("NIK hanya boleh berisi angka");
            }
        }
        if (!daftarKereta.containsKey(kodeKereta)) {
            throw new RuteTidakDitemukanException("Kode kereta " + kodeKereta + " tidak ditemukan");
        }

        KeretaApi kereta = daftarKereta.get(kodeKereta);
        if (jumlah > kereta.sisaKursi) {
            throw new TiketHabisException("Tiket tidak mencukupi", kereta.namaKereta, kereta.sisaKursi);
        }
        if (jumlah <= 0) {
            throw new DataPenumpangTidakValidException("Jumlah tiket harus lebih dari 0");
        }
        kereta.kurangiKursi(jumlah);
        System.out.println("\nPemesanan berhasil");
        System.out.println("Nama Penumpang : " + nama);
        System.out.println("NIK : " + nik);
        System.out.println("Kereta : " + kereta.namaKereta);
        System.out.println("Rute : " + kereta.rute);
        System.out.println("Jumlah Tiket : " + jumlah);
        System.out.println("Sisa Kursi : " + kereta.sisaKursi);
    }
}