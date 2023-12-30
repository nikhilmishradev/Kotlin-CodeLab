package com.androidtechguru.kotlinpractice.oops

fun main() {
    Shape().area()
    val circle: Shape = Circle(2.0)
    val square: Shape = Square(4.0)
    val triangle: Shape = Triangle(3.0, 4.0)
//    println(circle.area())
//    println(square.area())

    val shapes = arrayOf(circle, square, triangle,Shape())
    printAreas(shapes)
}

fun printAreas(shapes: Array<Shape>) {
    for (shape in shapes) {
        println(shape.area())
    }
}

open class Shape {
    open fun area(): Double {
        println(this.javaClass.simpleName + " : area(0.0)...")
        return 0.0
    }
}

class Circle(private val radius: Double) : Shape() {
    override fun area(): Double {
        return Math.PI * radius
    }

}

class Square(private val side: Double) : Shape() {
    override fun area(): Double {
        return side * side
    }
}

class Triangle(private val base: Double, private val height: Double) : Shape() {
    override fun area(): Double {
        return 0.5 * base * height
    }
}