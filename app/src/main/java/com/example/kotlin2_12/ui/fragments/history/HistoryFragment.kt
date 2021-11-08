package com.example.kotlin2_12.ui.fragments.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.kotlin2_12.databinding.FragmentHistoryBinding
import com.example.kotlin2_12.ui.MainViewModel


class HistoryFragment : Fragment() {

    private var binding: FragmentHistoryBinding? = null
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initObservers()
    }

    private fun initListeners() {
        binding?.btnIncrement?.setOnClickListener {
            viewModel.setCount()
        }
    }

    private fun initObservers() {
        viewModel.getCount().observe(viewLifecycleOwner) {
            binding?.tvResult?.text = it.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}