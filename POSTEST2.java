/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package project.POSTTEST2;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import project.VAPE.VAPE;


public  final class POSTEST2 {
    

    public final static void main(String[] args) {
        ArrayList<VAPE> daftarvape = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

    
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Vape");
            System.out.println("2. Lihat Daftar Vape");
            System.out.println("3. Cari Vape");
            System.out.println("4. Update Vape");
            System.out.println("5. Hapus Vape");
            System.out.println("6. Keluar");
            System.out.print("Pilihan Anda: ");

            String pilihan = scanner.nextLine();


            switch (pilihan) {
                case "1":
                    System.out.print("Masukkan Nama Vape: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Merk Vape: ");
                    String merk = scanner.nextLine();
                    System.out.print("Masukkan Harga Vape: ");
                    double harga = Double.parseDouble(scanner.nextLine());

                    VAPE vape = new VAPE(nama, merk, harga);
                    daftarvape.add(vape);
                    System.out.println("Vape berhasil ditambahkan!");
                    break;

                case "2":
                    if (daftarvape.isEmpty()) {
                        System.out.println("Daftar Vape Tidak Ada");
                    } else {
                        System.out.println("Daftar Vape:");
                        for (VAPE p : daftarvape) {
                            System.out.println(p);
                        }
                    }
                    break;

                case "3":
                    System.out.print("Masukkan Nama Vape yang dicari: ");
                    String namaCari = scanner.nextLine();
                    boolean ditemukan = false;

                    for (VAPE p : daftarvape) {
                        if (p.getNama().equalsIgnoreCase(namaCari)) {
                            System.out.println("Vape ditemukan:");
                            System.out.println(p);
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Vape tidak ditemukan.");
                    }
                    break;

                    
                case "4":
                    System.out.print("Masukkan Nama Vape yang akan diupdate: ");
                    String namaUpdate = scanner.nextLine();
                    boolean ditemukanUpdate = false;

                    for (int i = 0; i < daftarvape.size(); i++) {
                        VAPE s = daftarvape.get(i);
                        if (s.getNama().equalsIgnoreCase(namaUpdate)) {
                            System.out.print("Masukkan Nama Baru: ");
                            String namaBaru = scanner.nextLine();

                            System.out.print("Masukkan Merk Baru: ");
                            String merkBaru = scanner.nextLine();

                            System.out.print("Masukkan Harga Baru: ");
                            double hargaBaru = scanner.nextDouble();

                            
                            VAPE vapeBaru = new VAPE(namaBaru, merkBaru, hargaBaru);

                            
                            daftarvape.set(i, vapeBaru);

                            System.out.println("Vape berhasil diupdate!");
                            ditemukanUpdate = true;
                            break;
                        }
                    }

                    if (!ditemukanUpdate) {
                        System.out.println("Vape tidak ditemukan.");
                    }
                    break;


                    
                case "5":
                    System.out.print("Masukan nama vape yg ingin dihapus:");
                    String namavapeHapus = scanner.nextLine();

                    
                    Iterator<VAPE> iterator = daftarvape.iterator();
                    while (iterator.hasNext()) {
                        VAPE objekvape = iterator.next();
                        if (objekvape.getNama().equalsIgnoreCase(namavapeHapus)) {
                            iterator.remove(); 
                        }
                    }
                    break;

//                

                    
                case "6":
                    System.out.println("Terima kasih!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }
}