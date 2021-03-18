package com.tzh.java.design.adapter

abstract class WindowAdapter : IWindowShow {

    constructor() {

    }

    fun attachToRecyclerview(view: TRecyclerview) {
        if (getItemCount() > 0) {
            for (index in 0..getItemCount()) {
                var itemView = getItemView()
                bindView(index)
            }
        }
    }
}