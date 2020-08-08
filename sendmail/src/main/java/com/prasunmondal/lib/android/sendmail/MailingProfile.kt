package com.prasunmondal.lib.android.sendmail

class MailingProfile(
    private var fromEmail: String,
    private var fromEmailKey: String,
    private var recipients: Array<String>,
    private var subject: String,
    private var isHTML: Boolean,
    private var onSuccess: () -> Unit,
    private var onFailBadAccountDetails: () -> Unit,
    private var onFailFailedSending: () -> Unit,
    private var onFailGenericError: () -> Unit,
    private var whileSending: () -> Unit) {

    fun send(recipients: List<String>, subject: String, body: String) {
        sendMain(this.fromEmail, this.fromEmailKey, recipients, subject, body, this.isHTML,
            this.onSuccess, this.onFailBadAccountDetails,
            this.onFailFailedSending, this.onFailGenericError, this.whileSending)
    }

    fun send(recipient: String, subject: String, body: String) {
        sendMain(this.fromEmail, this.fromEmailKey, listOf(recipient), subject, body, this.isHTML,
            this.onSuccess, this.onFailBadAccountDetails,
            this.onFailFailedSending, this.onFailGenericError, this.whileSending)
    }

    fun updatefromEmail(fromEmail: String) {
        this.fromEmail = fromEmail
    }

    fun updatefromEmailKey(fromEmailKey: String) {
        this.fromEmailKey = fromEmailKey
    }

    fun updateRecipients(recipients: Array<String>) {
        this.recipients = recipients
    }

    fun updateSubject(subject: String) {
        this.subject = subject
    }

    fun updateIsHTML(isHTML: Boolean) {
        this.isHTML = isHTML
    }

    fun updateOnSuccess(method: () -> Unit) {
        this.onSuccess = method
    }

    fun updateOnFailBadAccountDetails(method: () -> Unit) {
        this.onFailBadAccountDetails = method
    }

    fun updateOnFailFailedSending(method: () -> Unit) {
        this.onFailFailedSending = method
    }

    fun updateOnFailGenericError(method: () -> Unit) {
        this.onFailGenericError = method
    }

    fun updateWhileSending(method: () -> Unit) {
        this.whileSending = method
    }

    private fun sendMain(fromEmail: String, fromEmailKey: String, recipients: List<String>, subject: String, body: String, isHTML: Boolean,
                         onSuccess1: () -> Unit, onFailBadAccountDetails1: () -> Unit, onFailFailedSending1: () -> Unit, onFailGenericError1: () -> Unit, whileSending1: () -> Unit) {
        SendMailTrigger().sendMessage(fromEmail,
            fromEmailKey,
            recipients.toTypedArray(),
            subject,
            body,
            "Sending Bill...",
            "Bill Sent.",
            isHTML,
            onSuccess1,onFailBadAccountDetails1,onFailFailedSending1,onFailGenericError1,whileSending1)
    }
}