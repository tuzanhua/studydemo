package com.tzh.java.design.adapter

class TRecyclerview {

    fun setAdapter(adapter: WindowAdapter){
       adapter.attachToRecyclerview(this)
    }
}