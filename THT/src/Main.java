import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ReservasiKereta sistem = new ReservasiKereta();
        boolean jalan = true;
        try {
            while (jalan) {
                try {
                    System.out.println("=== JAVA EXPRESS ===");
                    System.out.println("1.Lihat Jadwal Kereta");
                    System.out.println("2.Pesan Tiket");
                    System.out.println("3.Keluar");
                    System.out.print("Pilih menu : ");
                    int menu = input.nextInt();
                    input.nextLine();

                    switch (menu) {
                        case 1:
                            sistem.lihatJadwal();
                            break;
                        case 2:
                            System.out.print("Masukkan kode kereta : ");
                            String kodeKereta = input.nextLine();
                            System.out.print("Masukkan NIK : ");
                            String nik = input.nextLine();
                            System.out.print("Masukkan nama penumpang : ");
                            String nama = input.nextLine();
                            System.out.print("Masukkan jumlah tiket : ");
                            int jumlah = input.nextInt();
                            input.nextLine();
                            sistem.pesanTiket(kodeKereta, nik, nama, jumlah);
                            break;

                        case 3:
                            jalan = false;
                            System.out.println("Keluar dari sistem...");
                            break;
                        default:
                            System.out.println("Menu tidak tersedia");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Input harus berupa angka");
                    input.nextLine();

                } catch (DataPenumpangTidakValidException e) {
                    System.out.println("Data penumpang tidak valid:" + e.getMessage());

                } catch (RuteTidakDitemukanException e) {
                    System.out.println("Gagal pesan tiket:" + e.getMessage());

                } catch (TiketHabisException e) {
                    System.out.println("Gagal pesan tiket:" + e.getMessage());
                    System.out.println("Kereta : " + e.getNamaKereta());
                    System.out.println("Sisa kursi : " + e.getSisaKursi());
                }
            }
        } finally {
            input.close();
            System.out.println("Terima kasih telah menggunakan JAVA EXPRESS");
        }
    }
}