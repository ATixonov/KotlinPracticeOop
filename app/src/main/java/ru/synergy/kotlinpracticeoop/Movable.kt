package ru.synergy.kotlinpracticeoop

interface Movable {
    var speed: Int
    fun move()
    fun stop(){
        println("Stop")
    }
}