package com.example.broadcastreceiverproject

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.util.Log

class MyBroadcastReceiverClass : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val b = intent.extras
        try {
            if (b != null) {
                val pdusObj = b["pdus"] as Array<Any>?
                var message = ""
                for (i in pdusObj!!.indices) {
                    val currentMessage = SmsMessage
                        .createFromPdu(pdusObj[i] as ByteArray)
                    val phoneNumber = currentMessage
                        .displayOriginatingAddress
                    message = currentMessage.displayMessageBody
                    Log.e("TAG", "onReceive: SMS$phoneNumber====> $message")
                }
                val intent1 = Intent("SendOtpTOMainActivity")
                intent1.putExtra("otp", message)
                context.sendBroadcast(intent1)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}