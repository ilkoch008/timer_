package com.example.timer_

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.net.sip.SipErrorCode.TIME_OUT
import android.content.Intent
import android.os.Handler
import android.support.v4.os.HandlerCompat.postDelayed
import android.widget.Button
import android.widget.TextView
var i: Long = 0


class SecondActivity : AppCompatActivity() {
    val por1 = listOf("", "один ", "два ", "три ", "четыре ", "пять ", "шесть ", "семь ", "восемь ", "девять ")
    val por2 = listOf("", "один", "двадцать ", "тридцать ", "сорок ", "пятьдесят ", "шестьдесят ", "семьдесят ", "восемьдесят ", "девяносто ")
    val por1_5 = listOf("десять", "одиннадцать ", "двеннадцать ", "тринадцать ", "четырнадцать ", "пятнадцать ",
            "шестнадцать ", "семнадцать ", "восемнадцать ", "девятнадцать ")
    val por3 = listOf("", "сто ", "двести ", "триста ", "четыреста ", "пятьсот ", "шестьсот ", "семьсот", "восемь", "девять")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timer_layout)
        val textView1: TextView = findViewById(R.id.text_view_id)
        val button : Button = findViewById(R.id.button_id)
        val intent1 = Intent(this, Dark_Activity::class.java)
        Handler().postDelayed({
            startActivity(intent1)
            object : CountDownTimer(1000000, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                    textView1.text = remake(i)
                }

                override fun onFinish() {
                    textView1.text = "бдумс"
                }
            }.start()
        }, 2000)
        //finish()
    }

    fun remake(i : Long): String {
        var i_str: String
        if ((i%100 /10).toInt() == 1){
            i_str = por1_5[(i%10).toInt()]
        } else {
            i_str = por3[(i/100).toInt()]
            i_str = i_str.plus(por2[((i%100)/10).toInt()])
            i_str = i_str.plus(por1[(i%10).toInt()])
        }
        return i_str
    }

}