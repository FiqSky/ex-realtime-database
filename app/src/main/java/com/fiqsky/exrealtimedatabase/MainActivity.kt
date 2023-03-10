package com.fiqsky.exrealtimedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var ref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ref = FirebaseDatabase.getInstance().getReference("USERS")

        val btnShowData = findViewById<Button>(R.id.showData)
        val showDataRecyclerview = findViewById<Button>(R.id.showDataRecyclerview)

        btnShowData.setOnClickListener {
            val intent = Intent (this, CheckActivity::class.java)
            startActivity(intent)
        }

        btnShowData.setOnClickListener {
            val intent = Intent (this, ShowActivity::class.java)
            startActivity(intent)
        }

        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener {
            val intent = Intent (this, ShowActivity::class.java)
            startActivity(intent)
            savedata()
        }
    }

    private fun savedata() {
        val inputNama = findViewById<EditText>(R.id.inputNama)
        val inputStatus = findViewById<EditText>(R.id.inputStatus)

        val KodePenyakit = inputNama.text.toString()
        val NamaPenyakit = inputStatus.text.toString()

        val user = Users(KodePenyakit,NamaPenyakit)
        val userId = ref.push().key.toString()

        ref.child(userId).setValue(user).addOnCompleteListener {
            Toast.makeText(this, "Successs",Toast.LENGTH_SHORT).show()
            inputNama.setText("")
            inputStatus.setText("")
        }
    }
}