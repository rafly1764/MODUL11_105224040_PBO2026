import java.io.FileNotFoundException;

public class SistemAkademik {
    public void gabungKelas(String kodeKelas, int kuotaTersedia) throws KelasPenuhException {
        if (kuotaTersedia <= 0) {
            throw new KelasPenuhException("Kelas " + kodeKelas + " sudah penuh");
        }
        System.out.println("Berhasil gabung kelas " + kodeKelas);
    }
    public void cetakDokumenKrs(String namaFile) throws FileNotFoundException {
        if (!namaFile.equals("krs_valid.txt")) {
            throw new FileNotFoundException("File " + namaFile + " tidak ditemukan");
        }
        System.out.println("Dokumen KRS berhasil dicetak dari file " + namaFile);
    }
}