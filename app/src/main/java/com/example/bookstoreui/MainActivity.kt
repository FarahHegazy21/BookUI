package com.example.bookstoreui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookstoreui.databinding.ActivityMainBinding
import com.example.bookstoreui.ui.theme.BookStoreUITheme

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    var book : MutableList<Books> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view : View = binding.root
        setContentView(view)

        book = mutableListOf(
            Books(R.drawable.solitude,"by Gabriel Garcia Marquez","One Hundred Years of Solitude"),
            Books(R.drawable.nostra,"by Carlos Fuentes","Terra Nostra"),
            Books(R.drawable.angels,"by Dan Brown","Angels & Demons"),
            Books(R.drawable.sword,"by Peter Lerangis","The Sword Thief"),
            Books(R.drawable.blood,"by James Rollins","Bloodline"),
            Books(R.drawable.spirits,"by Isabel Allende","The House of the Spirits"),
            Books(R.drawable.humming,"by Luis Alberto Urrea","The Hummingbird's Daughter")
        )


        val bookAdapter = BookAdapter(book)
        binding.books.adapter = bookAdapter


        binding.toolbar.materialToolbar.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.notification -> {
                    Toast.makeText(this,R.string.notification_clicked, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        binding.toolbar.materialToolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.review -> {
                    Toast.makeText(this, R.string.review_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.Fav -> {
                    Toast.makeText(this, R.string.favorite_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.setting -> {
                    Toast.makeText(this, R.string.setting_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.profile -> {
                    Toast.makeText(this, R.string.profile_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.search -> {
                    Toast.makeText(this, R.string.search_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                else -> false
            }
        }

    }
}

