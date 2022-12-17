package com.fiqsky.exrealtimedatabase

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class Adapter(val mCtx: Context, val layoutResId: Int, val list: List<Users>)
    :ArrayAdapter<Users>(mCtx,layoutResId,list){

    @SuppressLint("ViewHolder", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutResId,null)

        val textNama = view.findViewById<TextView>(R.id.textNama)
        val textStatus = view.findViewById<TextView>(R.id.textStatus)

        val user = list[position]

        textNama.text = "Kode Penyakit : " + user.KodePenyakit
        textStatus.text = "Nama Penyakit : " + user.NamaPenyakit

        return view
    }
}