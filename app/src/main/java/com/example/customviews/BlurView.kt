package com.example.customviews


import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout

class BlurView : RelativeLayout {
    constructor(context:Context,color:String="#000000"):super(context){
        init(color)

    }

    private fun init(color: String) {
        View.inflate(context,R.layout.blur_layout,this)
        this.elevation=70f
        this.setBackgroundColor(Color.parseColor(color))
        background.alpha=150
        this.isClickable=true
        this.isFocusable=true

    }
    constructor(context: Context,attributeSet: AttributeSet) : super(context,attributeSet){

    }
}
