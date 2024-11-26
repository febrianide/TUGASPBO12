/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class MenuPerpustakaan {
    private static final String TEXT_FILE = "buku.txt";
    private static final String SERIAL_FILE = "buku.ser";
    private static List<Buku> bukuList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Perbaikan penempatan kurung kurawal untuk loop
            System.out.println("\nMenu Perpustakaan");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Simpan Buku ke File Teks");
            System.out.println("3. Simpan Buku ke File Serialisasi");
            System.out.println("4. Tampilkan Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (dalam angka): ");
            int menu = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (menu) {
                case 1 -> tambahBuku(scanner); // Perbaikan nama metode
                case 2 -> simpanFileTeks();
                case 3 -> simpanFileSerial(); // Perbaikan nama metode
                case 4 -> tampilkanBuku(); // Perbaikan nama metode
                case 5 -> {
                    System.out.println("Keluar dari sistem perpustakaan");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Pilihan tidak valid");
            }
        }
    }

    private static void tambahBuku(Scanner scanner) {
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan nama pengarang: ");
        String pengarang = scanner.nextLine();
        System.out.print("Masukkan tahun terbit: ");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        bukuList.add(new Buku(judul, pengarang, tahunTerbit));
        System.out.println("Buku telah berhasil ditambahkan ke sistem");
    }

    private static void simpanFileTeks() {
        try (FileWriter writer = new FileWriter(TEXT_FILE)) {
            for (Buku buku : bukuList) {
                writer.write(buku.toString() + "\n");
            }
            System.out.println("Data buku berhasil disimpan ke file teks.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan file teks");
            e.printStackTrace();
        }
    }

    private static void simpanFileSerial() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIAL_FILE))) {
            oos.writeObject(bukuList); // Pastikan Buku mengimplementasikan Serializable
            System.out.println("Data buku berhasil disimpan ke file serial.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan file serial.");
            e.printStackTrace();
        }
    }

    private static void tampilkanBuku() {
        System.out.println("\nDaftar Buku:");
        for (Buku buku : bukuList) {
            buku.informasi(); // Metode ini harus ada di kelas Buku
        }
    }
}
    

