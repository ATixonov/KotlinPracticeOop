package ru.synergy.kotlinpracticeoop

open class Person(val name: String) {

    fun printName(){
        print(name)
    }
}

class Employee (empName: String, private var company: String): Person(empName) {

    private var age: Int = 10
    set(value: Int){
        if ((value>0) and (value<110))
            field = value        // field=age
    }


    val fullInformation: String
    get() = "$name $age $company"


    fun printCompany() {
        println(company)


    }

}

