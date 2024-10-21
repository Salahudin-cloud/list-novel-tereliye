package com.example.myrecyclerview

import android.os.Bundle
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
        val book = intent.getParcelableExtra<Book>(MainActivity.INTENT_PARCELABLE)

        // Menghubungkan view dengan data
        val photo = findViewById<ImageView>(R.id.img_item_photo)
        val name = findViewById<TextView>(R.id.tv_item_name)
        val description = findViewById<TextView>(R.id.tv_item_description)

        // Menampilkan data ke view
        book?.let {
            photo.setImageResource(it.photo)
            name.text = it.name
            description.text = it.description
        }
    }

    // Fungsi untuk menangani navigasi kembali saat tombol Up ditekan
    override fun onSupportNavigateUp(): Boolean {
        // Menutup activity dan kembali ke halaman sebelumnya
        finish()
        return true
    }
}
