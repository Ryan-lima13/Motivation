package com.rlds.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
            handelSave()

        }

    }
    private  fun handelSave(){
        val nome = binding.textNome.text.toString()
        if (nome!= ""){

            SecurityPreferences(this).storeString("USER_NAME", nome )

            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }else{
            Toast.makeText(
                this,
                "Preencha seu nome!",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}