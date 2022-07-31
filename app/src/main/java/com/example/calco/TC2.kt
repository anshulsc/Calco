package com.example.calco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class TC2 : AppCompatActivity() {
    companion object {
        const val c = "Celsius"
        const val f = "Fahrenheit"
        const val k = "Kelvin"
//        const val r = "Reaumur"
    }

   lateinit var btTemp1: Button
    lateinit var btTemp2: Button
    lateinit var btn: Button
    lateinit var etTemp1: EditText
    lateinit var tvTempValue: TextView
    private var temp1 = c
    private var temp2 = f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tc2)
          btTemp1 = findViewById(R.id.btTemp1)
          btTemp2 = findViewById(R.id.btTemp2)
          btn = findViewById(R.id.button)
          etTemp1 = findViewById(R.id.etTemp1)
        tvTempValue = findViewById(R.id.tvTempValue)
        initView()
        btTempClick()
    }
    private fun initView() {
        btTemp1.text = temp1
        btTemp2.text = temp2
        btn.setOnClickListener {
            if (etTemp1.text!!.isNotEmpty())
                countTemp()
            else {
                etTemp1.error = "Wrong"
                Toast.makeText(this, "Choose From the List", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun btTempClick() {
        btTemp1.setOnClickListener {
            buildDialog(1)
        }

        btTemp2.setOnClickListener {
            buildDialog(2)
        }
    }
    private fun buildDialog(tempNum : Int) {
        val singleItems = arrayOf(c, f, k)

        MaterialAlertDialogBuilder(this@TC2)
            .setTitle("Select")
            .setItems(singleItems) { dialog, which ->
                if (tempNum == 1) {
                    temp1 = singleItems[which]
                    btTemp1.text = temp1
                } else {
                    temp2 = singleItems[which]
                    btTemp2.text = temp2
                }
            }
            .show()
    }


    private fun countTemp() {
        when {
            temp1 == c && temp2 == f -> {
                val value = ctof(etTemp1.text.toString().toDouble()).toString()
                tvTempValue.text = value
            }
//            temp1 == c && temp2 == r -> {
//                val value = ctor(etTemp1.text.toString().toDouble()).toString()
//                tvTempValue.text = value
//            }
            temp1 == c && temp2 == k -> {
                val value = ctok(etTemp1.text.toString().toDouble()).toString()
                tvTempValue.text = value
            }
            temp1 == f && temp2 == c -> {
                val value = ftoc(etTemp1.text.toString().toDouble()).toString()
                tvTempValue.text = value
            }
//            temp1 == f && temp2 == r -> {
//                val value = ftor(etTemp1.text.toString().toDouble()).toString()
//                tvTempValue.text = value
//            }
            temp1 == f && temp2 == k -> {
                val value = ftok(etTemp1.text.toString().toDouble()).toString()
                tvTempValue.text = value
            }
//            temp1 == r && temp2 == c -> {
//                val value = rtoc(etTemp1.text.toString().toDouble()).toString()
//                tvTempValue.text = value
//            }
//            temp1 == r && temp2 == f -> {
//                val value = rtof(etTemp1.text.toString().toDouble()).toString()
//                tvTempValue.text = value
//            }
//            temp1 == r && temp2 == k -> {
//                val value = rtok(etTemp1.text.toString().toDouble()).toString()
//                tvTempValue.text = value
//            }
            temp1 == k && temp2 == c -> {
                val value = ktoc(etTemp1.text.toString().toDouble()).toString()
                tvTempValue.text = value
            }
            temp1 == k && temp2 == f -> {
                val value = ktof(etTemp1.text.toString().toDouble()).toString()
                tvTempValue.text = value
            }
//            temp1 == k && temp2 == r -> {
//                val value = ktor(etTemp1.text.toString().toDouble()).toString()
//                tvTempValue.text = value
//            }
            else -> Toast.makeText(this, "The Types are same", Toast.LENGTH_LONG).show()
        }
    }

    private fun ctof(c: Double): Double {
        return c * (9.0 / 5.0) + 32.0
    }

//    private fun ctor(c: Double): Double {
//        return c * (4.0 / 5.0)
//    }

    private fun ctok(c: Double): Double {
        return c + 273.15
    }

    private fun ftoc(f: Double): Double {
        return (f - 32.0) * (5.0 / 9.0)
    }

//    private fun ftor(f: Double): Double {
//        return (f - 32.0) * (4.0 / 9.0)
//    }

    private fun ftok(f: Double): Double {
        return ((f - 32.0) * (5.0 / 9.0)) - 273.15
    }

//    private fun rtoc(r: Double): Double {
//        return r * (5.0 / 4.0)
//    }

//    private fun rtof(r: Double): Double {
//        return r * (9.0 / 4.0) + 32.0
//    }

//    private fun rtok(r: Double): Double {
//        return r * (5.0 / 4.0) + 273.15
//    }

    private fun ktoc(k: Double): Double {
        return k - 273.15
    }

    private fun ktof(k: Double): Double {
        return (k - 273.15) * (9.0 / 5.0) + 32.0
    }

//    private fun ktor(k: Double): Double {
//        return (k - 273.15) * (4.0 / 5.0)
//    }
}
