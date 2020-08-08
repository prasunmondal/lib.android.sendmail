package com.prasunmondal.lib.android.sendmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SendMailTrigger().sendMessage("prsn.online@gmail.com",
            "bpuxonmqiwokunaf",
            listOf<String>("prasun.mondal02@gmail.com").toTypedArray(),
            "SubjectTest",
            "Content",
            findViewById(R.id.textview),
            "Sending Bill...",
            "Bill Sent.",
            false)

        SendMailTrigger().sendMessage("prsn.online@gmail.com",
            "bpuxonmqiwokunaf",
            listOf("prasun.mondal02@gmail.com").toTypedArray(),
            "SubjectTest",
            "<h1>Content</h1>",
            findViewById(R.id.textview),
            "Sending Bill...",
            "Bill Sent.",
            true)
    }
}
