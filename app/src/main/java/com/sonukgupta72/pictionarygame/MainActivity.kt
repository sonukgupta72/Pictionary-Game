package com.sonukgupta72.pictionarygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start_game.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PictionaryActivity::class.java)
            startActivity(intent)
        })
    }

}

