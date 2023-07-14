import java.util.Arrays;
import java.util.Scanner;

public class Inventory {
    private Barang[] daftarBarang;

    public Inventory(Barang[] daftarBarang) {
        this.daftarBarang = daftarBarang;
    }

    public void tampilkanBarang() {
        for (Barang barang : daftarBarang) {
            System.out.println(barang.toString());
        }
    }

    public void urutkanBarang() {
        int n = daftarBarang.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (daftarBarang[j].getNama().compareTo(daftarBarang[minIndex].getNama()) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    private void swap(int i, int j) {
        Barang temp = daftarBarang[i];
        daftarBarang[i] = daftarBarang[j];
        daftarBarang[j] = temp;
    }

    public void cariBarang(String keyword) {
        boolean found = false;
        for (Barang barang : daftarBarang) {
            if (barang.getNama().equalsIgnoreCase(keyword)) {
                System.out.println(barang.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        Barang barang1 = new Barang("B001", "Pensil");
        Barang barang2 = new Barang("B003", "Buku");
        Barang barang3 = new Barang("B002", "Penghapus");
        Barang barang4 = new Barang("B004", "Bolpoin");

        Barang[] daftarBarang = {barang1, barang2, barang3, barang4};

        Inventory inventory = new Inventory(daftarBarang);

        System.out.println("Selamat datang di Inventory TOKOPEDIA!");

        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        while (pilihan != 4) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan daftar barang");
            System.out.println("2. Urutkan daftar barang");
            System.out.println("3. Cari barang berdasarkan nama");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("\nDaftar barang:");
                    inventory.tampilkanBarang();
                    break;
                case 2:
                    System.out.println("\nUrutkan daftar barang:");
                    inventory.urutkanBarang();
                    inventory.tampilkanBarang();
                    break;
                case 3:
                    System.out.print("\nMasukkan nama barang yang ingin dicari: ");
                    scanner.nextLine(); // Membersihkan new line
                    String keyword = scanner.nextLine();
                    System.out.println("\nHasil pencarian:");
                    inventory.cariBarang(keyword);
                    break;
                case 4:
                    System.out.println("\nTerima kasih!");
                    break;
                default:
                    System.out.println("\nPilihan tidak valid. Silakan pilih menu yang tersedia.");
                    break;
            }
        }
    }
}

class Barang {
    private String kode;
    private String nama;

    public Barang(String kode, String nama) {
        this.kode = kode;
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    @Override
    public String toString() {
        return "Barang{" +
                "kode='" + kode + '\'' +
                ", nama='" + nama + '\'' +
                '}';
    }
}