package ru.synergy.kotlinpracticeoop

open class Person(val username: String, val password: String) {

    private val account: Account = Account(username, password)

    private class Account(val username: String, val password: String){

    }
    fun showDetails(){
        println("username: $username password: $password")
    }

    open fun sayHello() {
        println("hi my name is $username")
    }
}

/*class Employee (empName: String, private var company: String): Person(empName) {
    private var age: Int = 10
    set(value: Int){
        if ((value>0) and (value<110))
            field = value        // field=age
    }
    val fullInformation: String
    get() = "$age $company"
    fun printCompany() {
        println(company)
    }*/

class BankAccount(private var sum: Int){
    fun display(){
        println("sum = $sum")
    }
    inner class Transaction(private val sum: Int) {
        fun pay() {
            this@BankAccount.sum -= this@Transaction.sum
            display()
        }
    }
}

