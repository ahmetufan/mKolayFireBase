package com.ahmet.mkolay.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.ahmet.mkolay.R
import com.ahmet.mkolay.databinding.ActivityAlisverisGecmisBinding
import com.ahmet.mkolay.databinding.ActivityCardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlisverisGecmisActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlisverisGecmisBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlisverisGecmisBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        window.statusBarColor = ContextCompat.getColor(this, R.color.gecmisrenk)

        binding.myToolbar2.setNavigationOnClickListener {
            onBackPressed()
        }




    }
}