package com.example.bookstoreui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter (val book : List<Books>) :RecyclerView.Adapter<BookAdapter.MyViewHolder>() {

    class MyViewHolder(val row : View) : RecyclerView.ViewHolder(row){
        val image = row.findViewById<ImageView>(R.id.book_image)
        val author = row.findViewById<TextView>(R.id.author)
        val title = row.findViewById<TextView>(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent,false)
        return MyViewHolder(row)
    }

    override fun getItemCount(): Int {
        return book.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val book = book[position]
        holder.image.setImageResource(book.image)
        holder.author.text = book.author
        holder.title.text = book.title
    }

}