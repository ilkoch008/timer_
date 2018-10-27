package com.example.timer_

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.net.sip.SipErrorCode.TIME_OUT
import android.content.Intent
import android.os.Handler
import android.support.v4.os.HandlerCompat.postDelayed
import java.util.*
var seconds: Long = 0
var counting : Boolean = false
var back_press : Boolean = false
var first_start : Boolean = false


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, SecondActivity::class.java)
        if(!first_start) {
            first_start = true
            Handler().postDelayed({
                if (!back_press) startActivity(intent)
                back_press = false
                finish()
            }, 2000)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        back_press = true
    }
}
