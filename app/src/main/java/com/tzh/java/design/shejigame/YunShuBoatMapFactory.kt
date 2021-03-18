package com.tzh.java.design.shejigame

class YunShuBoatMapFactory : IMapFactory {
    override fun createMusic(): String {
        return "运输船 music"
    }

    override fun createWeather(): String {
        return "运输船 天气 下着小雨"
    }

    override fun createLandForm(): String {
        return "地形是运输船"
    }
}