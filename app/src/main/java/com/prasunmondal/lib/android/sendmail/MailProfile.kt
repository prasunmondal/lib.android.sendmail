package com.prasunmondal.lib.android.sendmail

import android.annotation.SuppressLint
import android.content.Context
import java.text.SimpleDateFormat
import java.util.*

public class MailProfile(
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

    @SuppressLint("SimpleDateFormat")
    fun send(recipients: Array<String>, subject: String, body: String) {
        sendMain(fromEmail, fromEmailKey, recipients, subject, body, isHTML,
            onSuccess, onFailBadAccountDetails, onFailFailedSending, onFailGenericError, whileSending)
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

    private fun sendMain(fromEmail: String, fromEmailKey: String, recipients: Array<String>, subject: String, body: String, isHTML: Boolean,
                         onSuccess: () -> Unit, onFailBadAccountDetails: () -> Unit, onFailFailedSending: () -> Unit, onFailGenericError: () -> Unit, whileSending: () -> Unit) {
        SendMailTrigger().sendMessage(fromEmail,
            fromEmailKey,
            recipients,
            subject,
            body,
            "Sending Bill...",
            "Bill Sent.",
            isHTML,
            onSuccess,onFailBadAccountDetails,onFailFailedSending,onFailGenericError,whileSending)
    }
}