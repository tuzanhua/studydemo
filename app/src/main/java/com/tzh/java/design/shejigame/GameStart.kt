package com.tzh.java.design.shejigame

class GameStart {

    fun startGame(){
        selectedMap()

    }

    fun selectedMap() : IMapFactory{
       return ShaMoMapFactory()
    }

    fun createPlayer() : Player{

        return Player("小明")
    }
}