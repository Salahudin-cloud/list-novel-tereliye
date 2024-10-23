package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListBookAdapter(
    private val listBook: ArrayList<Book>,
    private val onItemClickCallback: OnItemClickCallback
) : RecyclerView.Adapter<ListBookAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_book, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val book = listBook[position]

        holder.imgPhoto.setImageResource(book.photo)
        holder.tvName.text = book.name
        holder.tvDescription.text = book.desc

        holder.itemView.setOnClickListener {
            // Menggunakan callback untuk mengirim data buku ke MainActivity
            onItemClickCallback.onItemClicked(listBook[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listBook.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    // Interface untuk menghubungkan event klik item ke MainActivity
    interface OnItemClickCallback {
        fun onItemClicked(data: Book)
    }
}
