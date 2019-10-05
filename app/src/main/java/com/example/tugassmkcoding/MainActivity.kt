package com.example.tugassmkcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var isFragmentLoaded = true
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonkiri = findViewById<Button>(R.id.previous)
        val buttonkanan  = findViewById<Button>(R.id.next)
        showFragmentUtama()

        buttonkanan.setOnClickListener {
            if (isFragmentLoaded) {
                showFragmentNext()
                buttonkanan.setEnabled(false)
            }else{
                showFragmentUtama()
                buttonkiri.setEnabled(true)
            }
        }
        buttonkiri.setOnClickListener {
            if (isFragmentLoaded){
                showFragmentPrevious()
                buttonkiri.setEnabled(false)
            }else{
                showFragmentUtama()
                buttonkanan.setEnabled(true)
            }
        }

    }

    fun showFragmentUtama(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentUtama()
        transaction.replace(R.id.fl_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentLoaded = true
    }

    fun showFragmentPrevious(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentPrevious()
        transaction.replace(R.id.fl_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentLoaded = false
    }

    fun showFragmentNext(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentNext()
        transaction.replace(R.id.fl_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentLoaded = false
    }

}