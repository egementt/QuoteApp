package com.example.quoteapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quoteapp.R
import com.example.quoteapp.models.QuoteDBModel

class QuoteAdapter(val quoteList: MutableList<QuoteDBModel>) :
    RecyclerView.Adapter<QuoteAdapter.ModelViewHolder>() {

    class ModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val content: TextView = view.findViewById(R.id.li_content)
        private val author: TextView = view.findViewById(R.id.li_author)

        fun bindItems(item: QuoteDBModel) {
            content.text = item.content
            author.text = item.author
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bindItems(quoteList[position])
    }

    override fun getItemCount(): Int {
        return quoteList.size
    }

}
