package com.example.currencyapi.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.currencyapi.R
import com.example.currencyapi.database.QuoteDatabase
import com.example.currencyapi.databinding.FragmentViewQuteBinding
import com.example.currencyapi.models.QuoteDBModel
import com.example.currencyapi.viewmodel.QuoteViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViewQuteFragment : Fragment(R.layout.fragment_view_qute) {

    private lateinit var binding: FragmentViewQuteBinding
    lateinit var viewModel: QuoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(QuoteViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewQuteBinding.inflate(inflater, container, false)

        val navigation = findNavController()
        val db = QuoteDatabase.getQuoteDb(binding.root.context)

        viewModel.liveQuote.observe(viewLifecycleOwner, {
            binding.twContent.text = it.content
            binding.twAuthor.text = "By ${it.originator.name}"
        })

        initQuote()

        binding.btnNext.setOnClickListener {
            initQuote()
        }

        binding.btnSave.setOnClickListener {
            Toast.makeText(it.context, "Saved", Toast.LENGTH_LONG).show()
            val quote = viewModel.liveQuote.value
            val quoteDBModel: QuoteDBModel = quote?.originator?.name?.let { it1 ->
                QuoteDBModel(
                    quote.quoteId,
                    null,
                    quote.content,
                    null,
                    it1
                )
            }!!
            db?.quoteDao()?.insert(quoteDBModel)
        }


        binding.btnList.setOnClickListener {
            Log.d("DBINFO", "DB: Clicked")
            navigation.navigate(R.id.action_viewQuteFragment_to_quoteListFragment)
            val list = db?.quoteDao()?.getAllQuote()


            list?.forEach {
                Log.d("DBINFO", "DB: ${it.content} by ${it.author}")
            }
        }


        return binding.root
    }

    private fun initQuote() {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getQuote()
        }
    }
}