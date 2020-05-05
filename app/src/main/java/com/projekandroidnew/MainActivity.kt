package com.projekandroidnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView1 = findViewById<TextView>(R.id.TextView1)

        textView1.setOnClickListener {
            Toast.makeText(this, "hai", Toast.LENGTH_SHORT).show()
        }
    }
}

