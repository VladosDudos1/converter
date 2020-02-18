package com.example.currencyconverter.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.currencyconverter.R
import com.example.currencyconverter.activities.TutorialActivity
import kotlinx.android.synthetic.main.settings_fragment.*

class SettingsFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.settings_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        info_Mbtn.setOnClickListener{
            error()
        }
        info_btn.setOnClickListener{
            error()
        }
        translate_Mbtn.setOnClickListener{
            error()
        }
        translate_btn.setOnClickListener{
            error()
        }

        openTutorial_Mbtn.setOnClickListener {
            openTutorial()
        }
        openTutorial_btn.setOnClickListener {
            openTutorial()
        }
    }

    fun error(){
        Toast.makeText(activity, "Doesn't work now", Toast.LENGTH_LONG).show()
    }

    fun openTutorial(){
        startActivity(Intent(activity, TutorialActivity::class.java))
    }
}