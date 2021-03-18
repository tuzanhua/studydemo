package com.tzh.java.design.adapter

class TAdapterTest {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var recyclerview  = TRecyclerview()
            recyclerview.setAdapter(object : WindowAdapter(){
                override fun getItemView(): String {
                    return "view 设置数据"
                }

                override fun getItemCount(): Int {
                    return 20
                }

                override fun bindView(position: Int) {
                    println("第 $position 位置设置数据了")
                }
            })
        }
    }
}