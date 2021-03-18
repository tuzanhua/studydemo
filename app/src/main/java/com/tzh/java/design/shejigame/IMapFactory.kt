package com.tzh.java.design.shejigame

interface IMapFactory {

    fun createMusic() : String

    fun createWeather() : String

    fun createLandForm() : String
}