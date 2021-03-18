package com.tzh.java.design.clone

data class Student(var name: String = "张三", var age: Int = 22) {
    var person = Person()

  data class Person(var country : String = "中国")
}