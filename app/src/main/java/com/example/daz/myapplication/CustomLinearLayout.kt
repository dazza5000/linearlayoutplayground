package com.example.daz.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class CustomLinearLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        orientation = VERTICAL
        for (i in 1..20) {
            val view = LayoutInflater.from(context).inflate(R.layout.item_text_view, this, false)
            view.findViewById<TextView>(R.id.text_view_woo_woo).text = i.toString()
            addView(view)
        }
        val button = Button(context)
        button.setOnClickListener { for (i in 17 downTo 7) {
            removeView(getChildAt(i))
        }
        }
        addView(button)
    }
}