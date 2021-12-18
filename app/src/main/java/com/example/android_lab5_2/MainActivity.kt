package com.example.android_lab5_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_lab5_2.databinding.ActivityMainBinding
import androidx.activity.viewModels


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.downloadImageTask()
        viewModel.bitmapData.observe(this, {
            it?.let {
                binding.imageView.setImageBitmap(it)
            }
        })

    }
}