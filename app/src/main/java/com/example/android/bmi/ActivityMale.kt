package com.example.android.bmi

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android.bmi.databinding.ActivityMaleBinding

class ActivityMale : AppCompatActivity() {

    private lateinit var binding: ActivityMaleBinding
    lateinit var calculatem : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculatem = findViewById(R.id.calculatem)


        binding.weightPickerm.minValue = 30
        binding.weightPickerm.maxValue = 200

        binding.heightPickerm.minValue = 100
        binding.heightPickerm.maxValue = 250

        binding.weightPickerm.setOnValueChangedListener{_,_,_->
            calculateBMIM()

        }
        binding.heightPickerm.setOnValueChangedListener{_,_,_->
            calculateBMIM()

        }


    }
    private fun calculateBMIM(){
        val heigth = binding.heightPickerm.value
        val doubleHeigth = heigth.toDouble() / 100

        val weigth = binding.weightPickerm.value

        val bmi = weigth.toDouble() / (doubleHeigth * doubleHeigth)



        calculatem.setOnClickListener(View.OnClickListener {
            val nameM = intent.getStringExtra("name_key")
            val nameTextView: TextView = findViewById(R.id.messagem)
            nameTextView.text = nameM
            binding.resultm.text = String.format("Your BMI: %.2f", bmi)
            binding.messagem.text = String.format("Dear ,," + nameM + "''. %s", message(bmi))
        })

    }

    private fun message(bmi: Double): String {
        if (bmi < 20.5)
            return "Unfortunately your weight is too low!"
        if( bmi > 20.5 && bmi < 26.5 )
            return "Congratulation, you are Healthy!"
        if (bmi > 26.5 && bmi < 32)
            return "Unfortunately your weight is high!"
        if (bmi > 32 && bmi < 42)
            return "Unfortunately your weight is too high!"
        if (bmi > 42)
            return "Warning! Your weight is extremely high!"

        return "Error"

    }



    }
