package ru.synergy.kotlinpracticeoop


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.CoroutineContext
import email.Message as emailMessage
import email.send as sendEmail
import sms.Message as smsMessage
import sms.send as sendSms

class MainActivity : AppCompatActivity() {

//    fun CoroutineScope.getUsers(): ReceiveChannel<String> = produce {
//        val users = listOf("tom", "bob", "sam")
//        for (user in users) {
//            send(user)
//        }
//    }

//    private lateinit var mJob: Job
//    override val coroutineContext: CoroutineContext   // without lifecycle, needs CoroutineScope
//    get() = mJob + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch{
            getUsers().collect {
                user -> Toast.makeText(applicationContext, user, Toast.LENGTH_SHORT).show()
            }
        }

//        var channel = Channel<Int>()

//        var job: Job = lifecycleScope.launch(start = CoroutineStart.LAZY) {
//            launch {
//                doWork()
//            }
//            for (n in 1..5){
//                channel.send(n)
//            }

//            try {
//                doWork()
//            } catch (e: CancellationException){
//                println("on breakable")
//            } finally {
//
//            }
//            print(Thread.currentThread().name)
//            val deferred: Deferred<Int> = async(Dispatchers.Default){
//                10+10
//            }
//            print(deferred.await())

//            val users = getUsers()
//            users.consumeEach { users -> println(users) }

//            repeat(5){
//                val number = channel.receive()
//                println(number)
//            }

//            launch {
//                doWork()
//            }
//        }
//        job.start()
//        job.cancel()
//        println("im finished")
//
////        channel.close()
//        lifecycleScope.launch{
//            doWork()
//        }

//        mJob = Job()
//        launch { print(Thread.currentThread().name)
//        val deferred = async (Dispatchers.Default){    // this:CoroutineScope
//            10+10
//        }
//        print(deferred.await())
//        }



//        val countries: Map<String, Int> = mapOf("Usa" to 300, "france" to 60, "germany" to 30)
//        println(countries["Usa"])  // 300
//        for (country in countries){
//            println("${country.key} - ${country.value}")
//        }

//        val numbers: MutableSet<Int> = mutableSetOf(35,54,58)
//        val numbers1: HashSet<Int> = hashSetOf(5,6,7)
//        val numbers2: LinkedHashSet<Int> = linkedSetOf(25,10,17)

//        var number: Set<Int> = setOf(5,6,7)
//        number.minus(6)  // 5,7
//        number.plus(8)  // 5,6,7,8

//        var numbers: ArrayList<Int> = arrayListOf(1,2,3,4,5,6)
//        var numbers2: MutableList<Int> = mutableListOf(1,2,3,4,5,6)
//
//        numbers.add(4)
//        numbers2.addAll(mutableListOf(1,2,3,4,5,5))

//        var numbers = listOf(1,2,3,4,5,null)
//        var numbers2: List<Int> = listOf(1,2,3,3)
//        numbers.get(1)
//        numbers.elementAtOrNull(1)
//        numbers.first()
//        numbers.last()

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

    fun getUsers(): Flow<String> = flow {
        val database = listOf("tom", "bob", "sam")  // uslovnaya baza dannyh
        var i = 1
        for (item in database){
            delay(400L)   // wait, wait...
            println("emit $i item")
            emit(item)   // emitiruem znacheniya
            i++
        }
    }

//    suspend fun doWork(){
//        for (i in 0..5){
//            delay(400L)
//            println(i)
//        }
//        println("hello coroutines")
//    }
//    override fun onDestroy() {    // needs for CoroutineScope
//        super.onDestroy()
//        mJob.cancel()
//    }

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


