package com.example.customviewexample.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.use
import com.example.customviewexample.R

class CustomButtonView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var textView: TextView
    private var icon: ImageView

    private var clickCallback: (() -> Unit)? = null

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_custom_button, this, true)

        textView = view.findViewById(R.id.button_text)
        icon = view.findViewById(R.id.custom_button_icon)

        context.obtainStyledAttributes(attrs, R.styleable.CustomButtonView).use {
            textView.text = it.getString(R.styleable.CustomButtonView_text)
            icon.setImageDrawable(it.getDrawable(R.styleable.CustomButtonView_src))
        }

        // Обрабатываем клик на рутовый лейаут и вызываем лямбду clickCallback
        val root: ViewGroup = view.findViewById(R.id.root)
        root.setOnClickListener {
            clickCallback?.invoke()
        }
    }

    fun setText(text: String) {
        textView.text = text
    }

    fun addOnClickListener(callback: () -> Unit) {
        clickCallback = callback
    }
}