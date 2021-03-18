package com.tzh.java.design.shejigame

class AKGun : IWeapon {

    override fun name() : String {
        return "AK gun "
    }

    override fun harm(): Int {
        return 20
    }

    override fun attack() {
        println("${name()} 造成 ${harm()} 点伤害")
    }
}