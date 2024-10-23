package com.example.myrecyclerview

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetailBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_book)

        // Mengaktifkan tombol kembali di ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Mengambil data Book yang dikirim dari MainActivity
        val book = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("data", Book::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Book>("data")
        }

        // Menghubungkan view dengan data
        val photo = findViewById<ImageView>(R.id.img_item_photo)
        val judulBuku = findViewById<TextView>(R.id.value_judul_buku)
        val penerbit = findViewById<TextView>(R.id.value_penerbit)
        val terbit = findViewById<TextView>(R.id.value_terbit)
        val genre = findViewById<TextView>(R.id.value_genre_buku)
        val tebalBuku = findViewById<TextView>(R.id.value_halaman_buku)
        val desc = findViewById<TextView>(R.id.valueDesc)


        // Menampilkan data ke view
        book?.let {
            photo.setImageResource(it.photo)
            judulBuku.text = it.name
            penerbit.text = it.penerbit
            terbit.text = it.terbit
            genre.text = it.genre
            tebalBuku.text = it.halaman
            desc.text = it.desc
        }
    }

    // Fungsi untuk menangani navigasi kembali saat tombol Up ditekan
    override fun onSupportNavigateUp(): Boolean {
        // Menutup activity dan kembali ke halaman sebelumnya
        finish()
        return true
    }
}
