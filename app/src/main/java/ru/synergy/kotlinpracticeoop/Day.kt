package ru.synergy.kotlinpracticeoop

enum class Operation {
    ADD, SUBTRACT, MULTIPLY
}

fun operate(n1: Int, n2: Int, op: Operation): Int {
    return when (op) {
        Operation.ADD -> n1 + n2
        Operation.SUBTRACT -> n1 - n2
        Operation.MULTIPLY -> n1 * n2
    }
}

interface Base {
    fun someFun()
}
class BaseImpl(): Base{
    override fun someFun() {
        TODO("Not yet implemented")
    }
}
class Derived(someBase: Base): Base by someBase




interface Messenger{
    fun send(message: String)
}
class InstantMessenger(val programName: String): Messenger{
    override fun send(message: String) {
        println("Messenger '$message' has been sent")
    }
}

class SmartPhone(val name: String, m: Messenger): Messenger by m

fun test(){
    val telegram = InstantMessenger("telegram")
    val whatsapp = InstantMessenger("whatsapp")
    val pixel = SmartPhone("Pixel 5", telegram)
    val iphone = SmartPhone("Iphone 8", whatsapp)
    pixel.send("hello from kotlin")
    iphone.send("bye from kotlin")
}