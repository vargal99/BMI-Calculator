package com.example.android.bmi

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityChoose : AppCompatActivity() {

    lateinit var nickName: EditText
    lateinit var buttonContinue : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)

        val radButtM = findViewById<RadioButton>(R.id.radioButtonMale)
        val radButtF = findViewById<RadioButton>(R.id.radioButtonFemale)
        buttonContinue = findViewById(R.id.continueButton)
        nickName = findViewById(R.id.nickname)



        buttonContinue.setOnClickListener(View.OnClickListener {
            if(TextUtils.isEmpty(nickName.text.toString())){
                Toast.makeText(this, "Please enter your nickname.", Toast.LENGTH_SHORT).show()
            }else {
                if (radButtM.isChecked) {
                    val intent = Intent(this@ActivityChoose, ActivityMale::class.java)
                    val name = nickName.text.toString()
                    intent.putExtra("name_key", name)
                    startActivity(intent)
                } else if (radButtF.isChecked) {
                    val intent = Intent(this@ActivityChoose, ActivityFemale::class.java)
                    val name = nickName.text.toString()
                    intent.putExtra("name_key", name)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Please select your gender.", Toast.LENGTH_SHORT).show()
                }
            }
        })

    }

}






