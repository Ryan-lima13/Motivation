package com.rlds.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.rlds.motivation.databinding.ActivityMainBinding
import data.Mock

class MainActivity : AppCompatActivity(), View.OnClickListener {
   private  lateinit var binding: ActivityMainBinding
   private  var categoryId = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonFrases.setOnClickListener(this)
        handelUserName()
        // eventos
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
        handelFilter(R.id.image_all)
        handelNextPhrase()

    }

    override fun onClick(view: View) {
        if (view.id == R.id.buttonFrases){
            handelNextPhrase()
        }else if (view.id in listOf(R.id.image_all, R.id.imageHappy, R.id.imageSunny)){
            handelFilter(view.id)


        }
    }
    private fun  handelNextPhrase(){
        val phrase = Mock().getPhrase(categoryId)
        binding.textPhrase.text = phrase

    }

    private  fun handelFilter(id:Int){
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.light_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.light_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.light_purple))
        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = 1
            }
            R.id.imageHappy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId= 2

            }
            R.id.imageSunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = 3
            }
        }
    }
    // mostra nome usuario
    private fun handelUserName(){
        val name = SecurityPreferences(this).getString("USER_NAME")
        binding.textUser.text = "Olá, $name!"
    }
}