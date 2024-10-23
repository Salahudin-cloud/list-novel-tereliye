package com.example.myrecyclerview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ListBookAdapter.OnItemClickCallback {

    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var rvBook: RecyclerView
    private val list = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBook = findViewById(R.id.rv_books)
        rvBook.setHasFixedSize(true)

        // Mengisi data listBook
        list.addAll(getListBook())

        // Menampilkan list RecyclerView
        showRecyclerList()
    }

    // Mengambil data buku dari resources
    private fun getListBook(): ArrayList<Book> {
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPenerbit = resources.getStringArray(R.array.data_penerbit)
        val dataTerbit = resources.getStringArray(R.array.data_terbit)
        val dataGenre = resources.getStringArray(R.array.data_genre)
        val dataHalaman = resources.getStringArray(R.array.data_halaman)
        val dataDescription = resources.getStringArray(R.array.data_description)

        val listBook = ArrayList<Book>()

        for (i in dataName.indices) {
            val book = Book(
                dataPhoto.getResourceId(i, -1),
                dataName[i],
                dataPenerbit[i],
                dataTerbit[i],
                dataGenre[i],
                dataHalaman[i],
                dataDescription[i]
            )
            listBook.add(book)
        }

        return listBook
    }

    // Menampilkan RecyclerView dengan adapter
    private fun showRecyclerList() {
        rvBook.layoutManager = LinearLayoutManager(this)
        val listBookAdapter = ListBookAdapter(list, this) // Kirim callback ke adapter
        rvBook.adapter = listBookAdapter
    }

    // Implementasi interface dari adapter untuk menangani item yang di-klik
    override fun onItemClicked(data: Book) {
        val intent = Intent(this, DetailBookActivity::class.java)
        intent.putExtra("data", data)  // Mengirim data Book ke DetailBookActivity
        startActivity(intent)
    }

    // Menambahkan menu ke ActionBar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // Event handler untuk item di menu ActionBar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, About::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
