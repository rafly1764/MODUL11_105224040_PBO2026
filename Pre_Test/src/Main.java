import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Masukkan pembilang : ");
            int pembilang = input.nextInt();
            System.out.print("Masukkan penyebut : ");
            int penyebut = input.nextInt();
            Kalkulator kalkulator = new Kalkulator(pembilang, penyebut);
            int hasil = kalkulator.hitungPembagian();
            System.out.println("Hasil pembagian : " + hasil);

        } catch (ArithmeticException e) {
            System.out.println("Error: penyebut tidak boleh 0.");

        } catch (InputMismatchException e) {
            System.out.println("Error: input harus berupa angka, bukan huruf atau karakter lain.");

        } finally {
            input.close();
            System.out.println("Proses kalkulasi selesai dan resource memori telah dibersihkan.");
        }
    }
}