package com.tzh.java.design.chain

abstract class OAApply {

    var processor : OAApply? = null

    fun setNextProcess(oaApply: OAApply){
        this.processor = oaApply
    }

   abstract fun chain(request: Request)
}