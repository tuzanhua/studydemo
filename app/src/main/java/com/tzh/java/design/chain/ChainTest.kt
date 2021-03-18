package com.tzh.java.design.chain

class ChainTest {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var zhuRenOA  = ZhuRenOA()
            var jingLiOa = JingLiOa()
            var dongShiZhangOa = DongShiZhangOa()
            zhuRenOA.setNextProcess(jingLiOa)
            jingLiOa.setNextProcess(dongShiZhangOa)

            var request = Request(20)
           zhuRenOA.chain(request)
        }
    }
}