package com.example.daz.myapplication

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class CustomLinearLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var scrollView: ScrollView

    init {
        orientation = VERTICAL
        for (i in 1..20) {
            val view = LayoutInflater.from(context).inflate(R.layout.item_text_view, this, false)
            view.findViewById<TextView>(R.id.text_view_woo_woo).text = i.toString()
            addView(view)
        }
        val button = Button(context)
        button.setOnClickListener {
            removeViews()
        }
        addView(button)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    private var removing: Boolean = false

    private fun removeViews() {
        removing = true
        scrollView = parent.parent as ScrollView
        for (i in 17 downTo 7) {
            var view = getChildAt(i)
            view?.run {
                Log.e("woot", "height of the view is:" + view.height)
                scrollView.post {scrollView.scrollBy(0, -view.height)}
            }
            removeView(getChildAt(i))
        }
        removing = false
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
//        scrollView = parent.parent as ScrollView
//        if (removing) {
//            scrollView.post {scrollView.scrollBy(0, h - oldh)}
//        }
    }
}