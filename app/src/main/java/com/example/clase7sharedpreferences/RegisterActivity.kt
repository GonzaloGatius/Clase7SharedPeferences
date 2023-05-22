package com.example.clase7sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    private lateinit var buttonContinueToLogin : Button
    private lateinit var editTextEnterName : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        buttonContinueToLogin = findViewById(R.id.buttonToLogin)
        editTextEnterName = findViewById(R.id.editTextName)

        buttonContinueToLogin.setOnClickListener {
            if (editTextEnterName.text.isNullOrEmpty()) {
                Toast.makeText(this,"Ingrese un nombre válido", Toast.LENGTH_SHORT).show()
            }
            else{
                val userName = editTextEnterName.text.toString()
                val preferences = getSharedPreferences("LoginPref", MODE_PRIVATE)
                val editor = preferences.edit().putString("name", userName)
                editor.apply()
                val intent = Intent (this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}