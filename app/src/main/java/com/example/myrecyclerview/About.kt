package com.example.myrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)

        // Menampilkan tombol kembali di ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Menambahkan padding untuk menghindari system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Menangani event saat tombol kembali ditekan
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Kembali ke halaman sebelumnya
        return true
    }
}
