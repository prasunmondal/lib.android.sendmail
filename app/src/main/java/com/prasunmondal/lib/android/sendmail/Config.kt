package com.prasunmondal.lib.android.sendmail

class Config {

    var o =  MailProfile(
        "prsn.online@gmail.com",
        "bpuxonmqiwokunaf",
        listOf("prasun.mondal02@gmail.com").toTypedArray(),
        "SubjectTest",
        false,
        { print("Success")},
        {},
        {},
        {},
        {}
    )
    object Singleton {
        var instance = Config()
    }
}