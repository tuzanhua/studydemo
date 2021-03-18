package com.tzh.java.design.faced

class FacedPattern : IParttern{

   private  var subSysOne : SubSysOne
   private  var subSysTwo : SubSysTwo

    constructor() {
        subSysOne = SubSysOne()
        subSysTwo = SubSysTwo()
    }

    override fun subOne(){
        subSysOne.displayOne()
    }

    override fun subTwo(){
        subSysTwo.displayTwo()
    }


    inner class SubSysOne{
        fun displayOne(){}
    }

    inner class SubSysTwo{
        fun displayTwo(){}
    }
}