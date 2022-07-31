package com.example.calco

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         var bmiCard = findViewById<CardView>(R.id.bmi)
        var tcCard = findViewById<CardView>(R.id.tc2)
        var devCard = findViewById<CardView>(R.id.dev)
        var prCard = findViewById<CardView>(R.id.pr)
        var dsCard = findViewById<CardView>(R.id.ds)

        bmiCard.setOnClickListener{
            val intent = Intent(this,BMI2::class.java)
            startActivity(intent)
        }
        tcCard.setOnClickListener{
            val intent = Intent(this,TC2::class.java)
            startActivity(intent)
        }
        devCard.setOnClickListener{
            val intent = Intent(this,Dev2::class.java)
            startActivity(intent)
        }
        prCard.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://docs.google.com/document/d/1OXNaMSC239c7SSsOvoFz0xmi0OCvt-S-IGLSUPOrCuQ/edit?usp=sharing")
            startActivity(intent)
        }
        dsCard.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.desmos.com/calculator")
            startActivity(intent)
        }
    }
}