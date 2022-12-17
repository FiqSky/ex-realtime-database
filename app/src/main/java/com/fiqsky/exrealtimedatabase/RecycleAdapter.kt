package com.fiqsky.exrealtimedatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter (
    private val listItems: ArrayList<Users>,
    private val listener: StudentListener
) : RecyclerView.Adapter<RecycleAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val item = listItems[position]
        holder.kodePenyakit.text = item.KodePenyakit
        holder.namaPenyakit.text = item.NamaPenyakit
        holder.itemView.setOnClickListener {
            listener.OnItemClicked(item)
        }
    }

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var kodePenyakit = itemView.findViewById<TextView>(R.id.textNama)
        var namaPenyakit = itemView.findViewById<TextView>(R.id.textStatus)
    }

    interface StudentListener{
        fun OnItemClicked(users: Users)
    }
}