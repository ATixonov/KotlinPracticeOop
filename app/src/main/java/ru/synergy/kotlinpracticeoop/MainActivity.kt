package ru.synergy.kotlinpracticeoop


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import email.Message as emailMessage
import email.send as sendEmail
import sms.Message as smsMessage
import sms.send as sendSms

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val kitty: Human = Human("kitty", 19)
//        var (username, userage) = kitty

        val mMessage = emailMessage("hello kotlin")
        sendEmail(mMessage, "test@gmail.com")
        val mSms = smsMessage("hello sms kotlin")
        sendSms(mSms, "+777")
    }
}