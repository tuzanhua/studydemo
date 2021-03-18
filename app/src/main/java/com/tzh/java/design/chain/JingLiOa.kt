package com.tzh.java.design.chain

class JingLiOa : OAApply() {
    override fun chain(request: Request) {
        if (request.day > 10){
            processor?.chain(request)
        }else{
            println("才请${request.day} 假 我作为经理给你审批了")
        }
    }
}