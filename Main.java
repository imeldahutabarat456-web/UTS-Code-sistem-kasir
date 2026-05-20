import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            Kasir kasir = new Kasir();
            int pilihan;

            do {
                System.out.println("\n===== MENU KASIR =====");
                System.out.println("1. Tambah Barang");
                System.out.println("2. Tampilkan Barang");
                System.out.println("3. Set Member");
                System.out.println("4. Cetak Struk");
                System.out.println("5. Bayar");
                System.out.println("6. Keluar");
                System.out.print("Pilih menu: ");

                pilihan = input.nextInt();

                switch (pilihan) {

                    case 1 -> {
                        System.out.print("Nama barang : ");
                        String nama = input.next();

                        System.out.print("Harga       : ");
                        double harga = input.nextDouble();

                        System.out.print("Jumlah      : ");
                        int jumlah = input.nextInt();

                        kasir.tambahBarang(new Barang(nama, harga, jumlah));
                    }

                    case 2 -> kasir.tampilBarang();

                    case 3 -> {
                        System.out.print("Nama member : ");
                        String namaMember = input.next();

                        System.out.print("Diskon (contoh 0.1 = 10%) : ");
                        double diskon = input.nextDouble();

                        kasir.setMember(new Member(namaMember, diskon));
                    }

                    case 4 -> kasir.cetakStruk();

                    case 5 -> {
                        System.out.print("Uang bayar : ");
                        double uang = input.nextDouble();
                        kasir.bayar(uang);
                    }

                    case 6 -> System.out.println("Keluar...");

                    default -> System.out.println("Menu salah");
                }

            } while (pilihan != 6);
        }
    }
}