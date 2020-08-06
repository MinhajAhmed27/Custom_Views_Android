package com.example.customviews

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CustomLoadingView(context: Context):RelativeLayout(context){
    var center_pos = 0f
    var animator: ObjectAnimator?=null
    var sizeLoaded=false

    init {
        initailizeView()
    }

    private fun initailizeView() {
        View.inflate(context,R.layout.loading_view_layout,this)
        this.elevation=80f
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val parent_height=(this.parent as View).height
        center_pos=(parent_height/2).toFloat() - (this.height/2)
        this.y=center_pos
        sizeLoaded=true
    }

    fun showLoading(){
        (context as AppCompatActivity).lifecycleScope.launch {
            waitForViewToGetLoaded()
            showLoadedView()
        }

    }

    private suspend fun waitForViewToGetLoaded(){
        withContext(Dispatchers.IO) {
            while(!sizeLoaded){
                //wait for size load
            }
        }
    }

    private suspend fun showLoadedView(){

        val scaleDown: ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(
            this@CustomLoadingView,
            PropertyValuesHolder.ofFloat("scaleX", 1.2f),
            PropertyValuesHolder.ofFloat("scaleY", 1.2f)
        )
        scaleDown.duration = 1000
        scaleDown.repeatCount = ObjectAnimator.INFINITE
        scaleDown.repeatMode = ObjectAnimator.REVERSE

        scaleDown.start()
    }

}