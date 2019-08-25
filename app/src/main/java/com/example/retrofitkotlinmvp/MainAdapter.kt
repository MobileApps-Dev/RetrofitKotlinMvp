package com.example.retrofitkotlinmvp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.help_item.view.*

class MainAdapter(context: Context, arrayList: ArrayList<ResponModel>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private var context = context
    private var arrayList = arrayList


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        //Declare View of .xml
        var view = LayoutInflater.from(context).inflate(R.layout.help_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        var model: ResponModel? = arrayList.get(position)
        holder.tvhelpline.text = model?.name

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvhelpline = view.tvhelpline

    }

}