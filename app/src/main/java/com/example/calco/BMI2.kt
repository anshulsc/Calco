package com.example.calco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class BMI2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi2)
        val weightText = findViewById<EditText>(R.id.etWeight)
        val heightText = findViewById<EditText>(R.id.etHeight)
        val Calculatebtn = findViewById<Button>(R.id.btnCalc)

        Calculatebtn.setOnClickListener {
            val weight = weightText.text.toString()
            val height = heightText.text.toString()
            if(validateInput(weight,height)) {
                val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))

                val bmitwo = String.format("%.2f", bmi).toFloat()
                displayResult(bmitwo)
            }

        }
    }

    private fun validateInput(weight:String? , height:String?): Boolean{
        return when{
            weight.isNullOrEmpty()->{
                Toast.makeText(this,"Weight is Empty", Toast.LENGTH_LONG).show()
                return false
            }
            height.isNullOrEmpty()->{
                Toast.makeText(this,"Height is Empty", Toast.LENGTH_LONG).show()
                return false
            }
            else-> {
                return true
            }
        }
    }
    private fun displayResult(bmi:Float){
        val index = findViewById<TextView>(R.id.tvIndex)
        val descp = findViewById<TextView>(R.id.tvDescp)
        val info =  findViewById<TextView>(R.id.tvInfo)

        index.text = bmi.toString()
        info.text = "(Normal Range of BMI is 18-24.9) "

        var resultText = ""
        var color = 0

        when{
            bmi<18.5 ->{
                resultText = "You are Underweight"
                color = R.color.underweight
            }
            bmi in 18.5..24.9 ->{
                resultText = "You are Normal"
                color = R.color.normal
            }
            bmi in 25.00..29.99 ->{
                resultText = "You are Overweight"
                color = R.color.overweight
            }
            bmi > 30.00 ->{
                resultText = "You are Obese"
                color = R.color.obese
            }
        }
        descp.setTextColor(ContextCompat.getColor(this,color))
        descp.text = resultText

    }
}