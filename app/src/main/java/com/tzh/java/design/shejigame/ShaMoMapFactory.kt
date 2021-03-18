package com.tzh.java.design.shejigame

class ShaMoMapFactory : IMapFactory {
    override fun createMusic(): String {
        return "沙漠之星music"
    }

    override fun createWeather(): String {
        return "沙漠 艳阳高照"
    }

    override fun createLandForm(): String {
        return "沙漠地带"
    }
}