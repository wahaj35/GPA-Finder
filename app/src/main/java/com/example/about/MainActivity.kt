package com.example.about

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.about.databinding.ActivityMainBinding


open class MainActivity : AppCompatActivity() {
    private lateinit var bindActivity: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindActivity = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

}

