package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.adapters.Adapters
import com.example.myapplication2.model.Item
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var item:ArrayList<Item>? = null
    private var adapters: Adapters? = null
    //private lateinit var myRef: DatabaseReference
    //private lateinit var listOfItem: ArrayList<DatabaseRow>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val HOME_Button = findViewById(R.id.HOME_Button) as Button
        HOME_Button.setOnClickListener {
            Toast.makeText(this@MainActivity, "You clicked HOME.", Toast.LENGTH_SHORT).show()
        }
        val USER_Button = findViewById(R.id.CLIENT_Button) as Button
        USER_Button.setOnClickListener {
            Toast.makeText(this@MainActivity, "You clicked USER.", Toast.LENGTH_SHORT).show()
            var userpage: Intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(userpage)
        }
        val PHOTO_Button = findViewById(R.id.PHOTO_Button) as Button
        PHOTO_Button.setOnClickListener {
            Toast.makeText(this@MainActivity, "You clicked PHOTO.", Toast.LENGTH_SHORT).show()
            var photpage: Intent = Intent(applicationContext, ThirdActivity::class.java)
            startActivity(photpage)
        }
        recyclerView = findViewById(R.id.recycler_view)
        gridLayoutManager = GridLayoutManager(applicationContext, 1, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        item = ArrayList()
        item = setDataInList()
        adapters = Adapters(applicationContext, item!!)
        recyclerView?.adapter = adapters

        /*recyclerView = findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = GridLayoutManager(applicationContext,1)

        val firebase = FirebaseDatabase.getInstance()
        myRef = firebase.getReference("ArrayData")

        submitData.setOnClickListener{
            val imie = imieInput.text.toString()
            val nazwisko = nazwiskoInput.text.toString()
            val firebaseInput = DatabaseRow(imie,nazwisko)
            myRef.child("${Date().time}").setValue(firebaseInput)
        }*/
        /*myRef.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(databaseError: DatabaseError) {

            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listOfItem = ArrayList()
                for (i in dataSnapshot.children){
                    val newRow = i.getValue(DatabaseRow::class.java)
                    listOfItem.add(newRow!!)
                }
                setupAdapter(listOfItem)
            }

        })*/
    }
    private fun setDataInList() : ArrayList<Item> {

        var items:ArrayList<Item> = ArrayList()

        items.add(Item(R.drawable.item, "Komplet pierwszy"))
        items.add(Item(R.drawable.item_b, "Komplet drugi"))
        items.add(Item(R.drawable.item_c, "Komplet trzeci"))
        items.add(Item(R.drawable.item_d, "Komplet czwarty"))
        items.add(Item(R.drawable.item_e, "Komplet piąty"))

        return items
    }

    /*private fun setupAdapter(arrayData: ArrayList<DatabaseRow>){
        recyclerView?.adapter = Adapter(arrayData)
    }*/
}

