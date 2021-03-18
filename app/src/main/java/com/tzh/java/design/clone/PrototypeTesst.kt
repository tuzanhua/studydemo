package com.tzh.java.design.clone

class PrototypeTesst {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var stu = Student()
            println("stu : ${stu.name +" " + stu.age+"   " + stu.person.country}")
           var stu2 = stu.copy()

            println("stucopy : ${stu.name +" " + stu.age +"   " + stu.person.country}")
        }
    }
}