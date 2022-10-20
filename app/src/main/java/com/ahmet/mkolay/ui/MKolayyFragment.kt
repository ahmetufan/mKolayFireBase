package com.ahmet.mkolay.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmet.mkolay.R
import com.ahmet.mkolay.databinding.FragmentMKolayyBinding
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MKolayyFragment : Fragment() {
    private var _binding: FragmentMKolayyBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMKolayyBinding.inflate(inflater, container, false)
        val view = binding.root
        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myToolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }



        binding.cardView.setOnClickListener {
            val intent=Intent(context,QrActivity::class.java)
            startActivity(intent)
        }

        binding.cardView2.setOnClickListener {
            val intent=Intent(context,QrActivity::class.java)
            startActivity(intent)
        }


    }


}