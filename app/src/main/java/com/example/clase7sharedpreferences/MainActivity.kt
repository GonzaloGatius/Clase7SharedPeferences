package com.example.clase7sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var buttonToAction: Button
    private lateinit var textViewName: TextView
    private lateinit var editTextUserNameLogin: EditText
    private lateinit var editTextPasswordLogin: EditText
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToAction = findViewById(R.id.buttonLogin)
        textViewName = findViewById(R.id.textViewNombre)
        editTextPasswordLogin = findViewById(R.id.editTextPasswordLogin)
        editTextUserNameLogin = findViewById(R.id.editTextNameLogin)
        imageView = findViewById(R.id.imageView)

        val preferences = getSharedPreferences("LoginPref", MODE_PRIVATE)
        val userNamePref = preferences.getString("name", "")
        val passwordPref = preferences.getString("pass", "")

        if (userNamePref != null && passwordPref != null) {
            if (userNamePref.isEmpty()) {
                buttonToAction.text = "Registrar"
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
        buttonToAction.setOnClickListener {
            if (editTextUserNameLogin.text.isNullOrEmpty() && editTextPasswordLogin.text.isNullOrEmpty()) {
                Toast.makeText(this, "Ingrese user y password", Toast.LENGTH_SHORT).show()
            } else {
                val name = editTextUserNameLogin.text.toString()
                val pass = editTextPasswordLogin.text.toString()

                if (name == userNamePref && pass == passwordPref) {
                    val intent = Intent(this, FinalActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "usuario o contraseña no valida", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
}
