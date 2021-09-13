package com.ateam.myintentpractice_loka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToBtn.setOnClickListener {
//
        // 다은 화면으로 이돟 OtherActivity
            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent)

        }
    }
}