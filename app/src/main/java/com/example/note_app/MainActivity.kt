package com.example.note_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = name.text.toString()
        val description = description.text.toString()
        val word_letters =  word_letters.text.toString()

        btn_add.setOnClickListener{

        }
    }
}