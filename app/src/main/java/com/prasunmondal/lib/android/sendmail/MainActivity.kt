package com.prasunmondal.lib.android.sendmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MailConfig.Singleton.instance.o.send("prasun.mondal02@gmail.com", "Hi", "Good Night!")
    }

    fun a() {
        println("a")
    }

    fun b() {
        println("b")
    }

    fun c() {
        println("c")
    }

    fun d() {
        println("d")
    }

    fun e() {
        println("e")
    }
}
