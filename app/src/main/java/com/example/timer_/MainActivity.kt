package com.example.timer_

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.net.sip.SipErrorCode.TIME_OUT
import android.content.Intent
import android.os.Handler
import android.support.v4.os.HandlerCompat.postDelayed
import java.util.*


class MainActivity : AppCompatActivity() {
    private val TIME_OUT = 4000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, SecondActivity::class.java)
        val intent1 = Intent(this, Dark_Activity::class.java)
        Handler().postDelayed({
            startActivity(intent)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
