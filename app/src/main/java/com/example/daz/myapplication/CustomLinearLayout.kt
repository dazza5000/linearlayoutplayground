package com.example.daz.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class CustomLinearLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        for (i in 1..20) {
            val text = TextView(context)
            text.text = i.toString()
            addView(text)
        }
    }
}