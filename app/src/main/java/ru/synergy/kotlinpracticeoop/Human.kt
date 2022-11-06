package ru.synergy.kotlinpracticeoop

data class Human(val name: String, val age: Int) {

    override fun toString(): String {
        return "Name $name, age $age"
    }
}
