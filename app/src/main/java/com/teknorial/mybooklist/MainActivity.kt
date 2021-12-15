package com.teknorial.mybooklist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvBooks = findViewById<RecyclerView>(R.id.recyclerview)
        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etAuthor = findViewById<EditText>(R.id.etAuthor)
        val btnAdd = findViewById<Button>(R.id.btnAdd)

        //data buku awal dengan menggunakan MutableList
        val bookList = mutableListOf(
            Book("Senja,Hujan, dan Cerita Yang Telah Usai", "Boy candra"),
            Book("Sebuah Usaha Melupakan", "Boy candra"),
            Book("Negeri Para Badebah", "Tere Liye"),
            Book("Rembulan Tenggelam di Wajah-mu", "Tere Liye"),
            Book("Konspirasi Alam Semesta", "Fiersa Besari"),
            Book("Tapak Jejak", "Fiersa Besari"),
            Book("Dilan 1990", "Pidi Baiq"),
            Book("Dilan 1991", "Pidi Baiq"),
            Book("Beyond The Inspiration", "Felix Y.Siauw"),
        )

        //memasukkan data ke dalam adapter dan menampilkah ke dalam RecyclerView
        val adapter = BookAdapter(bookList)
        rvBooks.adapter = adapter
        rvBooks.layoutManager = LinearLayoutManager(this)

        //event click pada button add
        btnAdd.setOnClickListener {
            //mengambil value dari kedua EditText
            val title = etTitle.text.toString()
            val author = etAuthor.text.toString()

            val book = Book(title, author)

            //menambahkan data baru ke dalam list
            bookList.add(book)
            //memberi tahu adapter bahwa item baru telah ditambahkan
            adapter.notifyItemInserted(bookList.size - 1)
        }

    }
}