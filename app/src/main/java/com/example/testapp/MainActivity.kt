package com.example.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateUi()

        binding.btnClick.setOnClickListener {
            counter++
            updateUi()
        }

        binding.btnReset.setOnClickListener {
            counter = 0
            updateUi()
        }
    }

    private fun updateUi() {
        binding.tvCounter.text = counter.toString()
        binding.tvStatus.text = when {
            counter == 0 -> "Tap the button to test"
            counter in 1..5 -> "Great! App is responding fast 🚀"
            counter in 6..15 -> "Cloud build pipeline works seamlessly! 🔥"
            else -> "Super active! $counter taps recorded ⭐"
        }
    }
}
