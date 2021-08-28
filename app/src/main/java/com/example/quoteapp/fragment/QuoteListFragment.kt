package com.example.quoteapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quoteapp.adapter.QuoteAdapter
import com.example.quoteapp.database.QuoteDatabase
import com.example.quoteapp.databinding.FragmentQuoteListBinding
import com.example.quoteapp.models.QuoteDBModel


class QuoteListFragment : Fragment() {

    private lateinit var binding: FragmentQuoteListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuoteListBinding.inflate(inflater, container, false)

        val quoteDb: QuoteDatabase? = QuoteDatabase.getQuoteDb(binding.root.context)
        val list = quoteDb?.quoteDao()?.getAllQuote()

        binding.recyclerView.layoutManager =
            LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = QuoteAdapter(list as MutableList<QuoteDBModel>)

        return binding.root
    }

}