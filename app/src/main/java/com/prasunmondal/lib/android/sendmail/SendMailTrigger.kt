package com.prasunmondal.lib.android.sendmail

import android.view.View

class SendMailTrigger {

    private lateinit var viewStore: View
    private var initialMessage: String = "Sending Mail..."
    private var finalMessage: String = "Mail Sent."

    fun sendMessage(fromEmail: String, fromEmailKey: String, recipients: Array<String>, subject: String, body: String, view: View, initialMessage: String, finalMessage: String, isHTML: Boolean) {
        this.viewStore = view
        this.initialMessage = initialMessage
        this.finalMessage = finalMessage
        whileSending()
        val email =
            SendEmailAsyncTask()
        email.activity = this
        email.m = Mail(
            fromEmail,
            fromEmailKey
        )
        email.m!!.set_from(fromEmail)
        email.m!!.body = body
        email.m!!.set_to(recipients)
        email.m!!.set_subject(subject)
        email.m!!.setIsHTML(isHTML)
        email.execute()
    }

    fun onSuccess() {

    }

    fun onFailBadAccountDetails() {

    }

    fun onFailFailedSending() {

    }

    fun onFailGenericError() {

    }

    private fun whileSending() {

    }
}