package ru.alexbox.arch_gb_l.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.alexbox.arch_gb_l.R

// app -
// buildSrc - ready
// core - ready
// historyScreen - ready
// model - ready
// repository - ready
// utils - ready
// gradle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
    }
}