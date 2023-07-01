package com.example.secondproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding : ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val newbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(newbinding.root)
        binding = newbinding
    }
}