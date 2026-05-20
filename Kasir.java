import java.util.ArrayList;

public class Kasir extends Transaksi {

    private final ArrayList<Barang> daftarBarang = new ArrayList<>();
    private Member member;

    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void tampilBarang() {

        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada barang.");
            return;
        }

        System.out.println("\n===== DAFTAR BARANG =====");

        for (Barang b : daftarBarang) {
            System.out.println(
                b.getNama() + " | " +
                b.getHarga() + " | " +
                b.getJumlah() + " | " +
                b.getSubtotal()
            );
        }
    }

    @Override
    public double hitungTotal() {

        double subtotal = 0;

        for (Barang b : daftarBarang) {
            subtotal += b.getSubtotal();
        }

        double diskon = 0;

        if (member != null) {
            diskon = subtotal * member.getDiskon();
        }

        double setelahDiskon = subtotal - diskon;
        double pajak = setelahDiskon * 0.11;

        return setelahDiskon + pajak;
    }

    public void cetakStruk() {

        Struk s = new Struk();
        s.cetakHeader();

        double subtotal = 0;

        for (Barang b : daftarBarang) {
            System.out.println(b.getNama() + " x " + b.getJumlah() + " = " + b.getSubtotal());
            subtotal += b.getSubtotal();
        }

        double diskon = 0;

        if (member != null) {
            diskon = subtotal * member.getDiskon();
        }

        double setelahDiskon = subtotal - diskon;
        double pajak = setelahDiskon * 0.11;
        double total = setelahDiskon + pajak;

        System.out.println("--------------------------");
        System.out.println("Subtotal   : " + subtotal);
        System.out.println("Diskon     : " + diskon);
        System.out.println("Pajak 11%  : " + pajak);
        System.out.println("Total      : " + total);

        s.cetakFooter();
    }

    public void bayar(double uang) {

        double total = hitungTotal();

        System.out.println("\n===== PEMBAYARAN =====");
        System.out.println("Total Belanja : " + total);
        System.out.println("Uang Dibayar  : " + uang);

        if (uang >= total) {
            System.out.println("Kembalian     : " + (uang - total));
        } else {
            System.out.println("Kurang Bayar  : " + (total - uang));
        }
    }
}