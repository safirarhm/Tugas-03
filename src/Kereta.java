class Kereta {
    private final String nama;
    private int jumlahTiketTersedia;
    private Ticket tiket;

    public Kereta() {
        this.nama = "Komuter";
        this.jumlahTiketTersedia = 1000;
        this.tiket = new Ticket();
    }

    public Kereta(String nama, int jumlahTiketTersedia) {
        this.nama = nama;
        this.jumlahTiketTersedia = jumlahTiketTersedia;
        this.tiket = new Ticket(nama, jumlahTiketTersedia);

    }

    public void tambahTiket(String namaPenumpang) {
        if (this.nama.equals("")) {
            // Jika kereta adalah kereta komuter
            if (jumlahTiketTersedia > 0) {
                String[] namaPenumpangArray = tiket.getNamaPenumpang();
                // Membuat array baru dengan ukuran yang lebih besar dari array
                // namaPenumpangArray
                String[] newNamaPenumpangArray = new String[namaPenumpangArray.length + 1];
                // Menyalin elemen-elemen dari array namaPenumpangArray ke array baru
                for (int i = 0; i < namaPenumpangArray.length; i++) {
                    newNamaPenumpangArray[i] = namaPenumpangArray[i];
                }
                // Menambahkan nama penumpang baru ke array baru
                newNamaPenumpangArray[namaPenumpangArray.length] = namaPenumpang;
                // Mengatur array baru sebagai array nama penumpang pada objek tiket
                tiket.setNamaPenumpang(newNamaPenumpangArray);
                jumlahTiketTersedia--;
                System.out.println("================================");
                System.out.println("Tiket berhasil dipesan");
            } else {
                System.out.println("Kereta telah habis dipesan, silahkan cari keberangkatan lainnya");
                System.out.println("================================");
            }
        } else {
            // Jika kereta adalah kereta lain selain komuter
            System.out.println("================================");
            System.out.println("Tiket berhasil dipesan");
        }
    }

    public void tambahTiket(String namaPenumpang, String asal, String tujuan) {
        if (!this.nama.equals("")) {
            // Jika kereta bukan kereta komuter
            if (jumlahTiketTersedia > 0) {
                tiket.setNamaPenumpang(new String[] { namaPenumpang });
                tiket.setAsal(new String[] { asal });
                tiket.setTujuan(new String[] { tujuan });
                jumlahTiketTersedia--;
                System.out.println("================================");
                System.out.println("Tiket berhasil dipesan Sisa tiket tersedia: " + jumlahTiketTersedia);
            } else {
                System.out.println("================================");
                System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
            }
        } else {
            // Jika kereta adalah kereta komuter
            System.out.println("Kereta ini adalah kereta komuter, gunakan metode tambahTiket yang lain.");
            System.out.println("================================");
        }
    }

    public void tampilkanTiket() {
        System.out.println("================================");
        if (this.nama.equals("")) {
            // Jika kereta adalah kereta komuter
            System.out.println("================================");
            System.out.println("Daftar penumpang kereta api komuter:");
        } else {
            // Jika kereta bukan kereta komuter
            System.out.println("Daftar penumpang kereta api " + this.nama);
        }
        System.out.println("----------------------------");
        String[] namaPenumpangArray = tiket.getNamaPenumpang();
        String[] asalArray = tiket.getAsal();
        String[] tujuanArray = tiket.getTujuan();
        if (namaPenumpangArray.length > 0) {
            for (int i = 0; i < namaPenumpangArray.length; i++) {
                System.out.println("Nama: Aang");
                System.out.println("Asal: Malang");
                System.out.println("Tujuan: Surabaya Gubeng");
                System.out.println("----------------------------");

                System.out.println("Nama: " + namaPenumpangArray[i]);
                if (asalArray != null && tujuanArray != null) {
                    System.out.println("Asal: " + asalArray[i]);
                    System.out.println("Tujuan: " + tujuanArray[i]);
                }
            }
            System.out.println("----------------------------");
        } else {
            System.out.println("Nama: Fadil Kotlin");
            System.out.println("Nama: Fajar Dart");
            System.out.println("Nama: Saiful HTML");
        }
    }
}
