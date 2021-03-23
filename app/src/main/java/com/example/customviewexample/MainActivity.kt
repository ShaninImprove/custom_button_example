package com.example.customviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.customviewexample.view.CustomButtonView

class MainActivity : AppCompatActivity() {

    private lateinit var firstButton: CustomButtonView
    private lateinit var secondButton: CustomButtonView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initListeners()
    }

    private fun initViews() {
        firstButton = findViewById(R.id.button_test_1)
        secondButton = findViewById(R.id.button_test_2)

        // Можно воспользоваться методом для изменения текста, который описан в CustomButtonView
        secondButton.setText("Новый текст кнопки")
    }

    private fun initListeners() {
        firstButton.addOnClickListener {
            Toast.makeText(this, "Нажата первая кнопка", Toast.LENGTH_SHORT).show()
        }

        secondButton.addOnClickListener {
            Toast.makeText(this, "Нажата вторая кнопка", Toast.LENGTH_SHORT).show()
        }
    }
}