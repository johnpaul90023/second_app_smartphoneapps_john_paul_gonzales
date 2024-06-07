package com.example.secondapp_johnpaultgonzales

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class Profile_screen : Fragment() {

    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var returnButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_profile_screen, container, false)

        textView = view.findViewById(R.id.textView)
        textView2 = view.findViewById(R.id.textView2)
        returnButton = view.findViewById(R.id.editPassword)

        sharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val text = sharedPreferences.getString("text", "")
        val text1 = sharedPreferences.getString("text2", "")

        textView.text = text
        textView2.text = text1

        returnButton.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}
