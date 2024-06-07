package com.example.secondapp_johnpaultgonzales

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nameLogin: EditText
    private lateinit var passwordLogin: EditText
    private lateinit var loginButton: Button
    private lateinit var clearButton: Button
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var instructionButton: ImageButton
    private lateinit var instructpopup: PopupWindow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameLogin = findViewById(R.id.nameLogin)
        passwordLogin = findViewById(R.id.passwordLogin)
        loginButton = findViewById(R.id.loginButton)
        clearButton = findViewById(R.id.clearButton)
        instructionButton = findViewById(R.id.instructionButton)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        loginButton.setOnClickListener{
            val inputText = nameLogin.text.toString()
            val inputText1 = passwordLogin.text.toString()
            val editor = sharedPreferences.edit()
            editor.putString("text", inputText)
            editor.putString("text2", inputText1)
            editor.apply()
            val intent = Intent(this, mainScreen::class.java) // Use CamelCase for class names
            startActivity(intent)
        }

        clearButton.setOnClickListener{
            nameLogin.text.clear()
            passwordLogin.text.clear()
        }

        instructionButton.setOnClickListener{
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            instructionPopup(inflater)
        }
    }

    private fun instructionPopup(inflater: LayoutInflater) {
        val popupView = inflater.inflate(R.layout.activity_instructions_popup, null)
        instructpopup = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        instructpopup.setBackgroundDrawable(getDrawable(R.drawable.popupbg)) // Corrected this line
        instructpopup.isOutsideTouchable = false

        val closeButton = popupView.findViewById<Button>(R.id.closeButton1)
        closeButton.setOnClickListener{
            instructpopup.dismiss()
        }

        // Show the popup window at the center
        instructpopup.showAtLocation(findViewById(android.R.id.content), Gravity.CENTER, 0, 0)
    }
}
