package com.example.rvpersistent_calculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tv:TextView

    var num1=0.0
    var num2=0f
    var result = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv= findViewById(R.id.tv)

        val deNum1 = findViewById<EditText>(R.id.edNum1)
        val deNum2 = findViewById<EditText>(R.id.edNum2)

        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener {
             num1 = deNum1.text.toString().toDouble()
             num2 = deNum2.text.toString().toFloat()
             result= num1*num2
             tv.text=result.toString()

        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("myNumber1", num1)
        outState.putFloat("myNumber2", num2)
        outState.putString("result", tv.text as String?)


    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        num1= savedInstanceState.getDouble("myNumber1", num1)
        num2 = savedInstanceState.getFloat("myMessage2", num2)

        tv.text= savedInstanceState.getString("result", tv.text as String?)


    }
}