package com.tzh.java.design.shejigame

class AKGunFactory : WeaponFactory {
    override fun createWeapon(): IWeapon {
        return AKGun()
    }
}