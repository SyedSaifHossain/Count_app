package com.example.count_app

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.count_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.display.text = "00"
        binding.plus.setOnClickListener {

            var increase = binding.display.text.toString().toInt()
            binding.display.text = (increase + 1).toString()
        }
        binding.minus.setOnClickListener {
            var dicrease = binding.display.text.toString().toInt()
            binding.display.text = (dicrease - 1).toString()
        }

        binding.reset.setOnClickListener {
            binding.display.text = "00"
        }
    }
}