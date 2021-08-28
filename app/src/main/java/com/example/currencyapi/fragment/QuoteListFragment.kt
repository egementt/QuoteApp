package com.example.currencyapi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapi.database.QuoteDatabase
import com.example.currencyapi.databinding.FragmentQuoteListBinding
import com.example.currencyapi.databinding.FragmentViewQuteBinding
import com.example.currencyapi.models.Quote


class QuoteListFragment : Fragment() {

    private lateinit var binding: FragmentQuoteListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuoteListBinding.inflate(inflater, container, false)

        val quoteDb: QuoteDatabase? = QuoteDatabase.getQuoteDb(binding.root.context)

        val list: ArrayList<Quote> =
            quoteDb?.quoteDao()?.getAllQuote() as ArrayList<Quote>

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        binding.listView.adapter = adapter

        return binding.root
    }

}