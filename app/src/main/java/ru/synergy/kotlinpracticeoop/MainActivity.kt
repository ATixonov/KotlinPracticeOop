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

//        val tom = createPerson("tom", "jetbread")
//        tom.sayHello()

//        hello(object : Person("sam", "1234567"){
//            val company = "jetbrains"
//            override fun sayHello() {
//                println("hi my name is $username i work in $company")
//            }
//        })

//        val tom = object: Person("tom", "123456") {
//            val company = "jetbrains"
//            val age = 37
//            fun sayHello() {
//                println("hi my name is $username")
//            }
//        }
//        println("name: ${tom.username} age: ${tom.age}")
//        tom.sayHello()

//        val userAcc: Person = Person("qwerty", "1234")
//        userAcc.showDetails()
//
//        val acc = BankAccount(100000)
//        acc.Transaction(2400).pay()

//        val kitty: Human = Human("kitty", 19)
//        var (username, userage) = kitty

        val mMessage = emailMessage("hello kotlin")
        sendEmail(mMessage, "test@gmail.com")
        val mSms = smsMessage("hello sms kotlin")
        sendSms(mSms, "+777")
    }

//    fun hello (person: Person){
//        person.sayHello()
//    }

//    private fun createPerson(_name: String, _company: String) = object {
//        val name = _name
//        val company = _company
//        fun sayHello() = println("hi my name is $name i work in $company")
//    }

}