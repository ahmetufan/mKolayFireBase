package com.ahmet.mkolay.ui

import android.content.Intent
import android.os.Bundle
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ahmet.mkolay.R
import com.ahmet.mkolay.databinding.ActivityQrBinding
import com.ahmet.mkolay.models.Code
import com.google.firebase.database.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QrActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQrBinding
    private lateinit var getdata: ValueEventListener
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQrBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.myToolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        window.statusBarColor = ContextCompat.getColor(this, R.color.kantincolor)

        //Alışveriş Geçmişi ve Yeni Kart
        binding.cardView3.setOnClickListener {
            val intent2 = Intent(this@QrActivity, CardActivity::class.java)
            startActivity(intent2)
        }
        binding.cardalisveris.setOnClickListener {
            val intent3 = Intent(this@QrActivity, AlisverisGecmisActivity::class.java)
            startActivity(intent3)
        }


        database = FirebaseDatabase.getInstance().reference.child("data")


        database.setValue(Code("101", "Test"))

        val text = binding.resulttext.text.toString()
        var encoder = QRGEncoder(text, null, QRGContents.Type.TEXT, 800)
        binding.ivQrCode.setImageBitmap(encoder.bitmap)

        //Veri Okuma
        getdata = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val sb = StringBuilder()
                for (i in snapshot.children) {
                    sb.append("${i.key} \n")
                }

                val code = snapshot.getValue(Code::class.java)
                if (code != null) {
                    when (code.status) {
                        "1" -> {
                            // Route another screen
                            val intent = Intent(this@QrActivity, AlisverisActivity::class.java)
                            startActivity(intent)

                        }
                        "101" -> {

                            var random = (0..1000).random().toString()
                            encoder = QRGEncoder(random, null, QRGContents.Type.TEXT, 800)
                            binding.ivQrCode.setImageBitmap(encoder.bitmap)
                            database.setValue(Code("-1", random))
                        }
                        "1001" -> {
                            // Crash

                            throw RuntimeException("Test Crash")
                        }
                    }
                }

                binding.resulttext.setText(sb)
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }


    }

    override fun onStart() {
        database.addValueEventListener(getdata)
        database.child("status").setValue("-1")

        super.onStart()

    }

    override fun onStop() {
        database.removeEventListener(getdata)
        super.onStop()
    }

}