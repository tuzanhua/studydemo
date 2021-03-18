package com.tzh.java.design.shejigame

data class Player(var nick : String,var state : Int = STATE_NORMAL,var weapon : IWeapon = Dagger()) {

    companion object{
        const val STATE_NORMAL = 1
        const val STATE_DIED = -1
    }
}