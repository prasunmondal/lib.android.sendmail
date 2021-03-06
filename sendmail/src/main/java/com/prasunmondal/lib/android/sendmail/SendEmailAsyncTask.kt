package com.prasunmondal.lib.android.sendmail

import android.os.AsyncTask
import android.util.Log
import javax.mail.AuthenticationFailedException
import javax.mail.MessagingException

internal class SendEmailAsyncTask :
    AsyncTask<Void?, Void?, Boolean>() {
    var m: MailSender? = null
    var activity: SendMailTrigger? = null

    override fun doInBackground(vararg params: Void?): Boolean {
        return try {
            if (m!!.send()) {
                Log.e(SendEmailAsyncTask::class.java.name, "Email sent.")
                activity!!.onSuccess()
            } else {
                Log.e(SendEmailAsyncTask::class.java.name, "Email failed to send.")
                activity!!.onFailFailedSending()
            }
            true
        } catch (e: AuthenticationFailedException) {
            Log.e(SendEmailAsyncTask::class.java.name, "Bad account details")
            e.printStackTrace()
            activity?.onFailBadAccountDetails()
            false
        } catch (e: MessagingException) {
            Log.e(SendEmailAsyncTask::class.java.name, "Email failed")
            e.printStackTrace()
            activity?.onFailFailedSending()
            false
        } catch (e: Exception) {
            e.printStackTrace()
            activity?.onFailGenericError()
            false
        }
    }
}
