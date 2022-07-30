package com.codemitamir.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.codemitamir.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener{

            val totalAmount = binding.totalAmount.text.toString().toDouble()

            val split = Integer.parseInt(binding.split.text.toString())

            val tipPercent = binding.percent.value.toDouble()


            if(totalAmount != 0.0 && split != 0 && tipPercent != 0.0) {

                val tipAmount = (totalAmount / 100) * tipPercent
                val totalPerPerson = (totalAmount + tipAmount )/ split

                binding.result.text = "Total amount per person is " + totalPerPerson.toString()


            } else {
                Toast.makeText(applicationContext, "All fields are required", Toast.LENGTH_LONG).show()
            }

        }


    }
}