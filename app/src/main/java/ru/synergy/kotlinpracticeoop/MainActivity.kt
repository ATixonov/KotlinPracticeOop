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

//        var hello: String = "hello world"
//        println(hello.wordCount('l'))  // 3 l in helloworld
//        println(hello.wordCount('o'))  // 2 o in helloworld
//        println(4.square())     // 4*4
//        println(6.square())     // 6*6

//        val hello: String? = "hello kotlin"
//        val message: String = hello as String
//        println(message)
//
//        val tom = Person("Tom")
//        if (tom.phone is SmartPhone){
//            println("smartphone : ${tom.phone.name}, os: ${tom.phone.os}")
//        } else {
//            println("Phone: ${tom.phone.name}")
//        }

//        val tom = Person("tom", "1234")
//        if (tom is Person) println("tom person")
//        else println("tom not person")

//        val s: String = "12"
//        try {
//            val d: Int = s.toInt()
//            println(d)
//        } catch (e: Exception){
//            println(e.message)
//        }
//        val c: Int = "12".toInt()

//        var tom: Person? = Person("tom", "12345")
//        val tomName: String? = tom?.username?.uppercase() ?: "Undefined"
//        println(tomName)  // TOM
//
//        var bob: Person? = null
//        val bobName: String? = bob?.username?.uppercase() ?: "Undefined"
//        println(bobName)  // null
//
//        try {
//            val name: String? = "Tom"
//            val id: Int = name!!.length
//            println(id)
//        } catch (e: Exception){
//            println(e.message)
//        }

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

//    open class Phone(val name: String)
//    class SmartPhone(name: String, val os: String): Phone(name)
//
//    open class Person(val name: String){
//        val phone: Phone = SmartPhone("Pixel 6", "android")
//    }

//    private fun String.wordCount(c: Char): Int {
//        var count = 0
//        for (n in this){
//            if (n == c) count++
//        }
//        return count
//    }
//    private fun Int.square(): Int {
//        return this * this
//    }

}


