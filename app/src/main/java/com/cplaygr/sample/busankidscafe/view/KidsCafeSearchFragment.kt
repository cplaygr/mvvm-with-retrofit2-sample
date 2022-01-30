package com.cplaygr.sample.busankidscafe.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cplaygr.sample.busankidscafe.databinding.FragmentKidscafeSearchBinding
import com.cplaygr.sample.busankidscafe.viewmodel.KidsCafeSearchViewModel
import com.google.gson.GsonBuilder

class KidsCafeSearchFragment : Fragment() {

    companion object {
        private const val TAG = "KidsCafeSearchFragment"
    }

    private var _binding: FragmentKidscafeSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: KidsCafeSearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(KidsCafeSearchViewModel::class.java)
        viewModel.getKidsCafeInfoResponseLiveData().observe(this, Observer { response ->
            if (response != null) {
                binding.kidsCafeResultTextView.text = GsonBuilder().setPrettyPrinting().create().toJson(response)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKidscafeSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initListeners() {
        binding.searchBtn.setOnClickListener {
            viewModel.searchKidsCafe()
        }
    }
}