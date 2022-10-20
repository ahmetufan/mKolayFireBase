package com.ahmet.mkolay.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmet.mkolay.R
import com.ahmet.mkolay.adaptery.Adaptery
import com.ahmet.mkolay.databinding.ActivitySepetBinding
import com.ahmet.mkolay.viewmodel.SepetViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySepetBinding

    private lateinit var adaptery: Adaptery

    private val viewModel: SepetViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySepetBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        window.statusBarColor = ContextCompat.getColor(this, R.color.kantincolor)

        binding.button.setOnClickListener {
            val intent = Intent(this@SepetActivity, MainActivity::class.java)
            startActivity(intent)       }



        viewModel.getLiveData()

        initRecycler()

        observeLiveData()


    }

    private fun observeLiveData() {
        viewModel.sepetLiveData.observe(this, Observer { livedata ->

            livedata?.let {
                adaptery.updateSepetList(livedata)
            }
        })
    }

    private fun initRecycler() {
        binding.recyclerSepet.layoutManager = LinearLayoutManager(this@SepetActivity)
        adaptery = Adaptery(arrayListOf())
        binding.recyclerSepet.adapter = adaptery
    }
}