package com.example.timer_

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.net.sip.SipErrorCode.TIME_OUT
import android.content.Intent
import android.os.Handler
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.os.HandlerCompat.postDelayed
import android.widget.TextView
var i: Long = 0

class Dark_Activity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //super.onCreate(savedInstanceState)
        object : CountDownTimer(1000000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                i++
                if (i > 1000){
                    finish()
                }
            }

            override fun onFinish() {
            }
        }.start()

    }
}