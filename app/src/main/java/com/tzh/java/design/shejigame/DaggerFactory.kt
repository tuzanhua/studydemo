package com.tzh.java.design.shejigame

class DaggerFactory : WeaponFactory {
    override fun createWeapon(): IWeapon {
        return Dagger()
    }
}