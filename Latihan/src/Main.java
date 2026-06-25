import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== SISTEM KRS AKADEMIK ===");

        //Soal 1
        int[] kuota = new int[3];
        for (int i = 0; i < 4; i++) {
            try {
                System.out.print("Masukkan kuota mata kuliah ke-" + (i + 1) + ": ");
                kuota[i] = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka");
                input.nextLine();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: batas array terlewati, hanya tersedia 3 data kuota");
            }
        }

        //Soal 2
        Mahasiswa mahasiswa = new Mahasiswa();

        try {
            mahasiswa.setSksMaksimal(30);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        mahasiswa.setSksMaksimal(10);

        //Soal 3
        try {
            mahasiswa.ambilMataKuliah("Pemrograman Berorientasi Objek", 4);
            mahasiswa.ambilMataKuliah("Basis Data", 4);
            mahasiswa.ambilMataKuliah("Kecerdasan Buatan", 5);
        } catch (SksTidakCukupException e) {
            System.out.println("Gagal ambil mata kuliah: " + e.getMessage());
        }

        //Soal 4
        SistemAkademik sistem = new SistemAkademik();
        try {
            sistem.gabungKelas("PBO-A", 0);
        } catch (KelasPenuhException e) {
            System.out.println("Gagal gabung kelas: " + e.getMessage());
        }

        //Soal 5
        try {
            sistem.cetakDokumenKrs("krs_salah.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Gagal cetak KRS: " + e.getMessage());
        } finally {
            input.close();
            System.out.println("Sesi Sistem Rencana Studi telah ditutup. Koneksi database diputuskan");
        }
    }
}