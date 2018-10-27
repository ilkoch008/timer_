package com.example.timer_

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView


class SecondActivity : AppCompatActivity() {
    val por1 = listOf("", "один ", "два ", "три ", "четыре ", "пять ", "шесть ", "семь ", "восемь ", "девять ")
    val por2 = listOf("", "один", "двадцать ", "тридцать ", "сорок ", "пятьдесят ", "шестьдесят ", "семьдесят ", "восемьдесят ", "девяносто ")
    val por1_5 = listOf("десять", "одиннадцать ", "двеннадцать ", "тринадцать ", "четырнадцать ", "пятнадцать ",
            "шестнадцать ", "семнадцать ", "восемнадцать ", "девятнадцать ")
    val por3 = listOf("", "сто ", "двести ", "триста ", "четыреста ", "пятьсот ", "шестьсот ", "семьсот ", "восемьсот ", "девятьсот ")


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timer_layout)
        if (back_press) finish()
        Counter(1000000, 100).start()
        val textView1: TextView = findViewById(R.id.text_view_id)
        val button: Button = findViewById(R.id.button_id)
        val timer = MyCounter(1000000, 1000)
        if (!counting)
            button.text = "START"
        //val intent = Intent(this, SecondActivity::class.java)

        button.setOnClickListener {
            if (counting) {
                counting = false
                seconds = 0
                button.text = "START"
                textView1.text = ""
                //timer.cancel()
            } else {
                counting = true
                button.text = "STOP"
                val timer_thread = Thread(Runnable {
                    timer.start()
                })
                timer_thread.start()
            }
        }


    }


    fun remake(i: Long): String {
        var i_str: String
        if (i.toInt() == 0) {
            i_str = "ноль"
        } else if ((i % 100 / 10).toInt() == 1) {
            i_str = por3[(i / 100).toInt()]
            i_str = i_str.plus(por1_5[(i % 10).toInt()])
        } else {
            i_str = por3[(i / 100).toInt()]
            i_str = i_str.plus(por2[((i % 100) / 10).toInt()])
            i_str = i_str.plus(por1[(i % 10).toInt()])
        }
        return i_str
    }

    inner class Counter(millisInFuture: Long, countDownInterval: Long) : CountDownTimer(millisInFuture, countDownInterval) {

        private val textView1: TextView = findViewById(R.id.text_view_id)
        override fun onFinish() {
            textView1.text = "бдумс"
        }

        override fun onTick(millisUntilFinished: Long) {
            if(counting) {
                textView1.text = remake(seconds)
            }
        }

    }


}

class MyCounter(millisInFuture: Long, countDownInterval: Long) : CountDownTimer(millisInFuture, countDownInterval) {

    override fun onFinish() {
        //val textView1: TextView = findViewById(R.id.text_view_id)
        //textView1.text = "бдумс"
    }

    override fun onTick(millisUntilFinished: Long) {
        if (!counting) {
            seconds = 0
            cancel()
        } else {
            seconds++
        }
    }


}
