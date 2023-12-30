package com.androidtechguru.kotlinpractice.oops.classes

class Test(): A(1){
    companion object{
        val test = ""
    }
    override fun run() {
        TODO("Not yet implemented")
    }

    override fun b() {
        TODO("Not yet implemented")
    }

    override fun c() {
        TODO("Not yet implemented")
    }
}
abstract class A(rum:Int): B(){

    val data=""
    abstract fun run()
}

abstract class B: C() {

    abstract fun b()
}

abstract class C{
    abstract fun c()
}