package com.example.android.bmi

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android.bmi.databinding.ActivityFemaleBinding



class ActivityFemale : AppCompatActivity() {

    private lateinit var binding: ActivityFemaleBinding
    lateinit var calculatef : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFemaleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculatef = findViewById(R.id.calculatef)



        binding.weightPickerf.minValue = 30
        binding.weightPickerf.maxValue = 200

        binding.heightPickerf.minValue = 100
        binding.heightPickerf.maxValue = 250

        binding.weightPickerf.setOnValueChangedListener{_,_,_->
            calculateBMIF()

        }
        binding.heightPickerf.setOnValueChangedListener{_,_,_->
            calculateBMIF()

        }

    }

    private fun calculateBMIF() {
        val heigthF = binding.heightPickerf.value
        val doubleHeigthF = heigthF.toDouble() / 100

        val weigthF = binding.weightPickerf.value

        val bmiF = weigthF.toDouble() / (doubleHeigthF * doubleHeigthF)

        calculatef.setOnClickListener(View.OnClickListener {
            val nameF = intent.getStringExtra("name_key")
            val nameTextView: TextView = findViewById(R.id.messagef)
            nameTextView.text = nameF
            binding.resultf.text = String.format("Your BMI: %.2f", bmiF)
            binding.messagef.text = String.format("Dear ,," + nameF + "''. %s", message(bmiF))
        })

    }

    private fun message(bmiF: Double): Any? {
        if (bmiF < 20 )
            return "Unfortunately your weight is too low!"
        if (bmiF > 20 && bmiF < 25)
            return "Congratulation, you are Healthy!"
        if (bmiF > 25 && bmiF < 30)
            return "Unfortunately your weight is high!"
        if (bmiF > 30 && bmiF < 40)
            return "Unfortunately your weight is too high!"
        if (bmiF > 40)
            return "Warning! Your weight is extremely high!"

        return "Error"
    }
}