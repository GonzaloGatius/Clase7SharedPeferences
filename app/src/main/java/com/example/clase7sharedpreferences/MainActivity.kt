package com.example.clase7sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var buttonToAction: Button
    private lateinit var textViewName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToAction = findViewById(R.id.buttonLogin)
        textViewName = findViewById(R.id.textViewNombre)

        val preferences = getSharedPreferences("LoginPref", MODE_PRIVATE)
        val userName = preferences.getString("name", "")

        if (userName != null) {
            if (userName.isEmpty()) {
                buttonToAction.text = "Registrar"
                buttonToAction.setOnClickListener {
                    val intent = Intent(this, RegisterActivity::class.java)
                    startActivity(intent)
                }
            } else {
                buttonToAction.text = "Continuar"
                textViewName.text = userName

                buttonToAction.setOnClickListener {
                    val intent = Intent(this, FinalActivity::class.java)
                    startActivity(intent)
                }
            }


        }
    }
}