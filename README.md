# Kasir Buku App

## Deskripsi
**Kasir Buku App** adalah aplikasi Java berbasis Swing yang dirancang untuk membantu proses transaksi kasir di toko buku. Aplikasi ini menyediakan fitur login, navigasi antar halaman, pengelolaan buku, serta perekaman transaksi ke dalam file teks.

---

## Fitur Utama

1. **Login**
   - Halaman login dengan autentikasi sederhana.
   - Username dan password default: `admin`.

2. **Home Page**
   - Navigasi ke halaman transaksi.
   - Tombol logout untuk kembali ke halaman login.

3. **Halaman Transaksi**
   - **Pilih Buku**: Menampilkan daftar buku yang tersedia, harga, dan gambar.
   - **Hitung Total**: Menghitung total biaya berdasarkan jumlah buku yang dibeli.
   - **Tambah Buku**: Menambahkan buku baru ke dalam daftar.
   - **Edit Buku**: Mengedit data buku yang ada.
   - **Hapus Buku**: Menghapus buku dari daftar.
   - **Simpan Transaksi**: Menyimpan detail transaksi ke dalam file teks di lokasi yang telah ditentukan.

---

## Struktur Program

1. **KasirBukuApp**
   - Kelas utama yang memuat logika aplikasi.
   - Berisi metode untuk:
     - Inisialisasi data buku.
     - Menampilkan halaman login.
     - Menampilkan home page.
     - Menampilkan halaman transaksi.

2. **Data Buku**
   - Data buku disimpan dalam array list dengan format `[nama, harga, path gambar]`.

3. **File Penyimpanan**
   - Transaksi disimpan ke file `Transaksi.txt` dengan format:
     ```
     Buku: [Nama Buku]
     Harga: [Harga Buku]
     Jumlah: [Jumlah Buku]
     Total: [Total Harga]
     =================================
     ```

---

## Langkah Instalasi dan Menjalankan Program

1. **Persiapan**
   - Pastikan JDK telah terinstal pada sistem.
   - Pastikan path gambar buku sesuai dengan lokasi file pada komputer Anda.

2. **Kompilasi dan Eksekusi**
   - Kompilasi kode menggunakan perintah:
     ```bash
     javac KasirBukuApp.java
     ```
   - Jalankan program dengan perintah:
     ```bash
     java KasirBukuApp
     ```

---

## Catatan Penting

- Semua path gambar buku harus disesuaikan dengan lokasi file aktual.
- Pastikan format input jumlah buku adalah angka.
- File `Transaksi.txt` akan dibuat secara otomatis jika belum ada di lokasi penyimpanan.

---

## Kontributor
- **Nama**: [Nama Anda]
- **Email**: [Email Anda]

Terima kasih telah menggunakan **Kasir Buku App**! Jika Anda memiliki masukan atau saran, silakan hubungi kami.

