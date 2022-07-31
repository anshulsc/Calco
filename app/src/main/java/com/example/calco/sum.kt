package com.example.calco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class sum : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sum)
        val valueofn  = findViewById<TextView>(R.id.sumn)
        val ntext = findViewById<EditText>(R.id.etsum)
        val Calculatebutton = findViewById<Button>(R.id.btnCalco)

        Calculatebutton.setOnClickListener(){
            val n=ntext.text.toString()

            if(validateInput(n)){
             val sumofn=(n.toInt()) * ((n).toInt()+1)/2
                val index = findViewById<TextView>(R.id.tvIndex)
                val sum=findViewById<TextView>(R.id.tvsum)
                index.text="The sum of first $n numbers is"
                sum.text="$sumofn"

            }
        }
    }
    private fun validateInput(n:String?): Boolean{
        return when{
            n.isNullOrEmpty()->{
                Toast.makeText(this,"Please Enter In The Input Field", Toast.LENGTH_LONG).show()
                return false
            }

            else-> {
                return true
            }
        }
    }


}