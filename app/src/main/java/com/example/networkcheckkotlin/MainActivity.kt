package com.example.networkcheckkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutInflater = findViewById<View>(R.id.networkError)

        val networkConnection= NetworkConnection(applicationContext)

        networkConnection.observe(this) { isConnected ->

            if (isConnected) {
                Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show()
                layoutInflater.visibility= View.GONE
            } else {
                Toast.makeText(this, "Not Connected", Toast.LENGTH_SHORT).show()
                layoutInflater.visibility= View.VISIBLE
            }
        }
    }
}