package com.simple.motionlayouthp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.utils.widget.ImageFilterView

class MainActivity : AppCompatActivity() {
    private var isTouched: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container: ImageFilterView = findViewById(R.id.container_message)
        container.setOnTouchListener { _, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_UP) {
                toggleContainer(motionEvent)
                true
            }
            false
        }
    }

    private fun showSecret() {
        Toast.makeText(this, "Congrats, You found the secret", Toast.LENGTH_SHORT).show()
    }

    private fun toggleContainer(event: MotionEvent) {
        isTouched = !isTouched
        if (isTouched) {
            Log.d("MainActivity", event.x.toString())
            showSecret()
        }
    }
}