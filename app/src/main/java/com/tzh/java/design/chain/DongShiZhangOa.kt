package com.tzh.java.design.chain

class DongShiZhangOa : OAApply() {

    override fun chain(request: Request) {
        if (request.day > 30){
            println("董事长看不下去了 你可以离职了")
        }else{
            println("请假${request.day} 董事长审批了")
        }
    }
}