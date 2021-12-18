package com.example.android_lab5_2

import android.app.Application
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import java.net.URL
import java.util.concurrent.ExecutorService


class MainViewModel(application: Application): AndroidViewModel(application) {
    val bitmapData = MutableLiveData<Bitmap>()
    private val executor: ExecutorService = getApplication<MyApplication>().executorService

    fun downloadImageTask() {
        executor.execute {
            val newurl = URL("https://hurrytolove.ru/wp-content/uploads/2018/12/18245676.jpg")
            val mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream())
            bitmapData.postValue(mIcon_val)
        }
    }
}