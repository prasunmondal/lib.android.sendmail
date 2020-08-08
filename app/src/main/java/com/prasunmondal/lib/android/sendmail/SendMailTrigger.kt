package com.prasunmondal.lib.android.sendmail

class SendMailTrigger {

    private var initialMessage: String = "Sending Mail..."
    private var finalMessage: String = "Mail Sent."

    private lateinit var onSuccessMethod: () -> Unit
    private lateinit var onFailBadAccountDetailsMethod: () -> Unit
    private lateinit var onFailFailedSendingMethod: () -> Unit
    private lateinit var onFailGenericErrorMethod: () -> Unit


    fun sendMessage(fromEmail: String, fromEmailKey: String, recipients: Array<String>, subject: String, body: String, initialMessage: String, finalMessage: String, isHTML: Boolean,
                    onSuccess: () -> Unit, onFailBadAccountDetails: () -> Unit, onFailFailedSending: () -> Unit, onFailGenericError: () -> Unit, whileSending: () -> Unit) {
        onSuccessMethod = onSuccess
        onFailBadAccountDetailsMethod = onFailBadAccountDetails
        onFailFailedSendingMethod = onFailFailedSending
        onFailGenericErrorMethod = onFailGenericError

        this.initialMessage = initialMessage
        this.finalMessage = finalMessage
        whileSending.invoke()
        val email =
            SendEmailAsyncTask()
        email.activity = this
        email.m = MailSender(
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
        onSuccessMethod.invoke()
    }

    fun onFailBadAccountDetails() {
        onFailBadAccountDetailsMethod.invoke()
    }

    fun onFailFailedSending() {
        onFailFailedSendingMethod.invoke()
    }

    fun onFailGenericError() {
        onFailGenericErrorMethod.invoke()
    }
}