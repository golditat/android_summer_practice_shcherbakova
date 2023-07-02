package com.example.secondproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.secondproject.databinding.ActivityContainerBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ContainerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
        val controller = (supportFragmentManager.findFragmentById(R.id.fcv) as NavHostFragment).navController
        findViewById<BottomNavigationView>(R.id.bnv).apply{
            setupWithNavController(controller)
        }
        var binding = ActivityContainerBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        if(savedInstanceState !=null) {
            return
        }
        supportFragmentManager.beginTransaction()
    }
}