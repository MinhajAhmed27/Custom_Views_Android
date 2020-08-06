package com.example.customviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var blurView:BlurView=BlurView(this)
        root_layout.addView(blurView)

        val myCustomLoadingView:CustomLoadingView= CustomLoadingView(this)

        /*  Handler().postDelayed(Runnable {
              myCustomLoadingView.showLoading()
          },1000)*/
        myCustomLoadingView.showLoading()
        root_layout.addView(myCustomLoadingView)

//        myCustomLoadingView.setOnClickListener {
//            myCustomLoadingView.animate().apply{
//                duration=1000
//                rotationYBy(360f)
//            }.start()
//
//        }
    }
}

