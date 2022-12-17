package com.fiqsky.exrealtimedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CheckActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)
        val listItems = arrayListOf<Users>()
        setupRecyclerView(listItems)
    }

    private fun setupRecyclerView(listItems: ArrayList<Users>){
        val rv_main = findViewById<RecyclerView>(R.id.rv_main)
        rv_main.apply {
            adapter = RecycleAdapter(listItems, object : RecycleAdapter.StudentListener{
                override fun OnItemClicked(users: Users) {
//                    val intent = Intent(this@MainActivity, EditActivity::class.java)
//                    intent.putExtra(EditActivity().STUDENT_EXTRA, student)
                    startActivity(intent)
                }
            })
            layoutManager = LinearLayoutManager(this@CheckActivity)
        }
    }
}