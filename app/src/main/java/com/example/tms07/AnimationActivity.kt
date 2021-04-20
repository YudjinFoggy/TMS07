package com.example.tms07

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
    }

    lateinit var catAnim: AnimationDrawable

    override fun onStart() {
        super.onStart()
        findViewById<ImageView>(R.id.animation).apply {
            setBackgroundResource(R.drawable.cat)
            catAnim = background as AnimationDrawable
            catAnim.start()
        }
    }
}