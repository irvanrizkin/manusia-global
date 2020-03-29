public class ManusiaGlobal {
    public static void main(String[] args) {
        Manusia makaji = new Manusia("Makaji", "177013", true);
        makaji.getData();
        System.out.println();

        Mahasiswa ais = new Mahasiswa("Ais", "306496", false, "288865", 3.6);
        ais.getData();
        System.out.println();

        Pekerja bayu = new Pekerja("Bayu Rahayudi", "238406", true, 50, 2);
        bayu.getData();
        System.out.println();

        Manajer wayan = new Manajer("Wayan Firdaus", "235801", true, 70, 3, 10, "Research and Development");
        wayan.getData();
        System.out.println();
    }
}

class Manusia {
    String nama;
    String nik;
    boolean menikah;
    double tunjangan;
    double pendapatan;

    Manusia(String nama, String nik, boolean menikah) {
        this.nama = nama;
        this.nik = nik;
        this.menikah = menikah;
        setMenikah(menikah);
    }

    void setTunjangan(double tunjangan) {
        this.tunjangan += tunjangan;
        setPendapatan(tunjangan);
    }

    // Menambah pendapatan setiap tunjangan dipanggil
    void setPendapatan(double pendapatan) {
        this.pendapatan += tunjangan;
    }

    // Mengatur tunjangan berdasar status perkawinan
    void setMenikah(boolean menikah) {
        if (menikah) {
            setTunjangan(25);
        } else {
            setTunjangan(15);
        }
    }

    void getData() {
        System.out.println("Nama        : " + nama);
        System.out.println("NIK         : " + nik);
        System.out.println("Menikah     : " + menikah);
        System.out.println("Tunjangan   : " + tunjangan);
        System.out.println("Pendapatan  : " + pendapatan);
    }
}

class Mahasiswa extends Manusia {
    String nim;
    double ipk;

    Mahasiswa(String nama, String nik, boolean menikah, String nim, double ipk) {
        // Super = Memanggil Constructor kelas induk (Manusia)
        super(nama, nik, menikah);
        this.nim = nim;
        this.ipk = ipk;

    }

    // Mengatur tunjangan berdasar IPK
    void setIPK(double ipk) {
        if (ipk >= 3.5) {
            setTunjangan(75);
        } else if (ipk >= 3) {
            setTunjangan(50);
        }
    }

    // Mengalihkan getData() ke kelas Mahasiswa dengan tambahan nim dan IPK
    @Override
    void getData() {
        super.getData();
        System.out.println("NIM         : " + nim);
        System.out.println("IPK         : " + ipk);
    }
}

class Pekerja extends Manusia {
    double gaji;
    int jumlahAnak;

    Pekerja(String nama, String nik, boolean menikah, double gaji, int jumlahAnak) {
        // Super = memanggil constructor kelas induk (Manusia)
        super(nama, nik, menikah);
        setGaji(gaji);
        setJumlahAnak(jumlahAnak);
    }

    void setGaji(double gaji) {
        this.gaji = gaji;
        // Memanggil fungsi setTunjangan di kelas induk
        setTunjangan(gaji);
    }

    void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
        // Memanggil fungsi setTunjangan di kelas induk
        setTunjangan(20 * jumlahAnak);
    }

    // Mengalihkan getData() ke kelas Pekerja dengan tambahan gaji dan jumlahAnak
    @Override
    void getData() {
        super.getData();
        System.out.println("Gaji        : " + gaji);
        System.out.println("Jumlah Anak : " + jumlahAnak);
    }
}

class Manajer extends Pekerja {
    double tunjangan;
    String departemen;

    Manajer(String nama, String nik, boolean menikah, double gaji, int jumlahAnak, double tunjangan,
            String departemen) {
        // Memanggil constructor dari kelas induk (Pekerja) dan kakek (Manusia)
        super(nama, nik, menikah, gaji, jumlahAnak);
        setTunjangan(tunjangan);
        this.departemen = departemen;
    }

    void setTunjangan(double tunjangan) {
        this.tunjangan = tunjangan;
        // Menambah tunjangan di fungsi kakek (Manusia)
        super.setTunjangan(tunjangan);
    }

    // Mengalihkan getData() ke kelas induk dengan tambahan tunjangan (MANAJER) dan departemen
    @Override
    void getData() {
        super.getData();
        System.out.println("NIK         : " + nik);
        // Print tunjangan milik MANAJER
        System.out.println("Tunjangan M : " + tunjangan);
        System.out.println("Departemen  : " + departemen);
    }
}
