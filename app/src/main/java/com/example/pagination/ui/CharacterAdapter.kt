package com.example.pagination.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pagination.R
import kotlinx.android.synthetic.main.item_layout.view.*

class CharacterAdapter:PagingDataAdapter<Result,CharacterAdapter.CharacterViewHolder>(diffUtil) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Result>() {

            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val result=getItem(position)
        result.let {
            if (it != null) {
                holder.setData(it)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return CharacterViewHolder(view)
    }

    class CharacterViewHolder(private val view:View):RecyclerView.ViewHolder(view){
        fun setData(result: Result){
            view.apply {
                tv_name.text=result.name
                Glide.with(ivCharacter).load(result.image).into(ivCharacter)
            }
        }
    }
}