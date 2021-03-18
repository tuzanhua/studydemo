package com.tzh.java.design.chain

class ZhuRenOA : OAApply() {

    override fun chain(request: Request) {
      if (request.day > 3){
          processor?.chain(request)
      }else{
          println("才请两天假 作为主人的我给你批了")
      }
    }
}