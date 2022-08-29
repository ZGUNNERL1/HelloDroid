package com.example.hellodroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class HelloDroidActivity : AppCompatActivity() {
    private lateinit var message: TextView
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        message = findViewById(R.id.clickCounter)
        val droid: ImageView = findViewById(R.id.droidImage)

        // Define and attach click listener
        droid.setOnClickListener { tapDroid(); }

        // Note that the above is the lambda equivalent of the following:
        // droid.setOnClickListener(object: View.OnClickListener {
        //    override fun onClick(view: View?) {
        //        tapDroid();
        //    }
        // })
    }

    private fun tapDroid() {
        counter++
        /*
         * In real applications you should not write switch like the one below.
         * Use resource of type "Quantity strings (plurals)" instead.
         * See https://developer.android.com/guide/topics/resources/string-resource#Plurals
         */
        val countAsText: String = when (counter) {
            1 -> "once"
            2 -> "twice"
            else -> String.format("%d times", counter)
        }
        message.text = String.format("You touched the droid %s", countAsText)
    }
}