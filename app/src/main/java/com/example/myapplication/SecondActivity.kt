package com.example.myapplication2

//import androidx.viewBinding

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*


class SecondActivity : AppCompatActivity() {

    private lateinit var myRef: DatabaseReference
    private lateinit var listOfItems: ArrayList<DatabaseRow>
    private var recyclerView: RecyclerView? = null
    companion object {
        const val TAG = "SecondActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val HOME_Button_nd = findViewById(R.id.HOME_Button_nd) as Button
        HOME_Button_nd.setOnClickListener {
            Toast.makeText(this@SecondActivity, "You clicked HOME.", Toast.LENGTH_SHORT).show()
            var homepage: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(homepage)
        }
        val USER_Button_nd = findViewById(R.id.CLIENT_Button_nd) as Button
        USER_Button_nd.setOnClickListener {
            Toast.makeText(this@SecondActivity, "You clicked USER.", Toast.LENGTH_SHORT).show()

        }
        val PHOTO_Button_nd = findViewById(R.id.PHOTO_Button_nd) as Button
        PHOTO_Button_nd.setOnClickListener {
            Toast.makeText(this@SecondActivity, "You clicked PHOTO.", Toast.LENGTH_SHORT).show()
            var photpage: Intent = Intent(applicationContext, ThirdActivity::class.java)
            startActivity(photpage)

        }

        val firebase = FirebaseDatabase.getInstance()
        myRef = firebase.getReference("ArrayData")

        recyclerView?.layoutManager = GridLayoutManager(applicationContext, 1)

        //val submitData = findViewById(R.id.submitData) as Button

        submitData.setOnClickListener {
            val imie = imieInput.text.toString()
            val nazwisko = nazwiskoInput.text.toString()
            val nip = nipInput.text.toString()
            val firebaseInput = DatabaseRow(imie, nazwisko, nip)
            //myRef.setValue(firebaseInput)
            myRef.child("${Date().time}").setValue(firebaseInput)
            Toast.makeText(this@SecondActivity, "$firebaseInput ", Toast.LENGTH_SHORT).show()
        }
        // Read from the database

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //val value = dataSnapshot.getValue(String::class.java)!!
                //Log.d(TAG, "Value is: $value")
                //Toast.makeText(this@SecondActivity, "Good ", Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

       /*myRef.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(databaseError: DatabaseError) {

            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listOfItems = ArrayList()
                for(i in dataSnapshot.children){
                    val newRow = i.getValue(DatabaseRow::class.java)
                    listOfItems.add(newRow!!)
                }
                setupAdapter(listOfItems)
            }

        })*/
    }
    /*private fun setupAdapter(arrayDate: ArrayList<DatabaseRow>){
        recyclerView?.adapter = Adapter(arrayDate)
    }*/
    
}

