package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val HOME_Button_rd = findViewById(R.id.HOME_Button_rd) as Button
        HOME_Button_rd.setOnClickListener {
            Toast.makeText(this@ThirdActivity, "You clicked HOME.", Toast.LENGTH_SHORT).show()
            var homepage: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(homepage)
        }
        val USER_Button_rd = findViewById(R.id.CLIENT_Button_rd) as Button
        USER_Button_rd.setOnClickListener {
            Toast.makeText(this@ThirdActivity, "You clicked USER.", Toast.LENGTH_SHORT).show()
            var userpage: Intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(userpage)
        }
        val PHOTO_Button_rd = findViewById(R.id.PHOTO_Button_rd) as Button
        PHOTO_Button_rd.setOnClickListener {
            Toast.makeText(this@ThirdActivity, "You clicked PHOTO.", Toast.LENGTH_SHORT).show()

        }
    }
}


