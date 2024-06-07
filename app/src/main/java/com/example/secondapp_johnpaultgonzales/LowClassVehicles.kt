package com.example.secondapp_johnpaultgonzales

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupWindow
import androidx.fragment.app.Fragment

class LowClassVehicles : Fragment() {

    private lateinit var car1Button: ImageButton
    private lateinit var car2Button: ImageButton
    private lateinit var car3Button: ImageButton
    private lateinit var car4Button: ImageButton
    private lateinit var popup: PopupWindow
    private lateinit var popup2: PopupWindow
    private lateinit var popup3: PopupWindow
    private lateinit var popup4: PopupWindow

    @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_low_class_vehicles, container, false)

        car1Button = view.findViewById(R.id.low1)
        car2Button = view.findViewById(R.id.low2)
        car3Button = view.findViewById(R.id.low3)
        car4Button = view.findViewById(R.id.low4)

        car1Button.setOnClickListener {
            low1Popup(inflater)
            popup.showAtLocation(view, Gravity.CENTER, 0, 0)
        }

        car2Button.setOnClickListener {
            low2Popup(inflater)
            popup2.showAtLocation(view, Gravity.CENTER, 0, 0)
        }

        car3Button.setOnClickListener {
            low3Popup(inflater)
            popup3.showAtLocation(view, Gravity.CENTER, 0, 0)
        }

        car4Button.setOnClickListener {
            low4Popup(inflater)
            popup4.showAtLocation(view, Gravity.CENTER, 0, 0)
        }

        return view
    }

    private fun low1Popup(inflater: LayoutInflater) {
        val popupView = inflater.inflate(R.layout.activity_low_class_popup1, null)
        popup = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        popup.setBackgroundDrawable(requireContext().getDrawable(R.drawable.popupbg))
        popup.isOutsideTouchable = false

        val closeButton = popupView.findViewById<Button>(R.id.closeButton1)
        closeButton.setOnClickListener{
            popup.dismiss()
        }
    }

    private fun low2Popup(inflater: LayoutInflater) {
        val popupView = inflater.inflate(R.layout.activity_low_class_popup2, null)
        popup2 = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        popup2.setBackgroundDrawable(requireContext().getDrawable(R.drawable.popupbg))
        popup2.isOutsideTouchable = false

        val closeButton = popupView.findViewById<Button>(R.id.closeButton2)
        closeButton.setOnClickListener{
            popup2.dismiss()
        }
    }

    private fun low3Popup(inflater: LayoutInflater) {
        val popupView = inflater.inflate(R.layout.activity_low_class_popup3, null)
        popup3 = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        popup3.setBackgroundDrawable(requireContext().getDrawable(R.drawable.popupbg))
        popup3.isOutsideTouchable = false

        val closeButton = popupView.findViewById<Button>(R.id.closeButton3)
        closeButton.setOnClickListener{
            popup3.dismiss()
        }
    }

    private fun low4Popup(inflater: LayoutInflater) {
        val popupView = inflater.inflate(R.layout.activity_low_class_popup4, null)
        popup4 = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        popup4.setBackgroundDrawable(requireContext().getDrawable(R.drawable.popupbg))
        popup4.isOutsideTouchable = false

        val closeButton = popupView.findViewById<Button>(R.id.closeButton4)
        closeButton.setOnClickListener{
            popup4.dismiss()
        }
    }
}