package by.itacademy.examples.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.itacademy.examples.R
import by.itacademy.examples.databinding.ActivityMainBinding
import by.itacademy.examples.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)

        println(intent.getStringExtra("firstName"))
        println(intent.getStringExtra("lastName"))
    }
}