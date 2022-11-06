package ru.synergy.kotlinpracticeoop

class Car: Movable {

    override var speed: Int = 60

    override fun move() {
        println("car go with speed 60 km/h")
    }
}

class Aeroplane: Movable {

    override var speed: Int = 600

    override fun move() {
        println("aeroplane go with speed 600 km/h")
    }

    override fun stop() {
        println("stopping")
    }
}