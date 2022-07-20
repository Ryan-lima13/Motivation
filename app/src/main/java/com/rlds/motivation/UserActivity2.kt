package com.rlds.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rlds.motivation.databinding.ActivityUser2Binding

class UserActivity2 : AppCompatActivity(), View.OnClickListener {
    private  lateinit var binding: ActivityUser2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUser2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonSalvar.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.buttonSalvar){

        }

    }
}