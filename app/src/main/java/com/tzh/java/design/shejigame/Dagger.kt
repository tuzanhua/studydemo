package com.tzh.java.design.shejigame

class Dagger : IWeapon {

    override fun name(): String {
        return "匕首"
    }

    override fun harm(): Int {
        return 5
    }

    override fun attack() {
       println("${name()} 造成 ${harm()} 伤害")
    }
}