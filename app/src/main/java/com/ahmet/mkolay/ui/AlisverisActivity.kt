package com.ahmet.mkolay.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.ahmet.mkolay.R
import com.ahmet.mkolay.databinding.ActivityAlisverisBinding
import com.ahmet.mkolay.databinding.ActivityMainBinding
import com.ahmet.mkolay.models.Code
import com.ahmet.mkolay.models.Code2
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlisverisActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlisverisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlisverisBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.myToolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        window.statusBarColor = ContextCompat.getColor(this, R.color.kantincolor)


        val database= FirebaseDatabase.getInstance().reference.child("alisveris")

        database.setValue(Code2("1"))

        val getData= object :ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val code = snapshot.getValue(Code2::class.java)
                if (code != null) {
                    when (code.status) {
                        "2" -> {
                            //Route another
                            val intent=Intent(this@AlisverisActivity,SepetActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }
        database.addValueEventListener(getData)
        database.addListenerForSingleValueEvent(getData)


    }
}