package com.example.currencyapi.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.currencyapi.models.Quote

class QuoteAdapter(val context: Context, val quotes: ArrayList<Quote>) : BaseAdapter {

    override fun getCount(): Int {
        return quotes.size
    }

    override fun getItem(position: Int): Any {
        return quotes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = view
        if (view == null) {
            //inflate layout resource if its null
            view = LayoutInflater.from(c).inflate(R.layout.row_model, viewGroup, false)
        }
    }
}