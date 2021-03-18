package com.tzh.java.design.factory.abstractfactory

import com.tzh.java.design.factory.IOperation
/**
 *  抽象工厂是针对产品族这种概念设计的
 *  举例 : 冰箱
 *     一级制冷 冰箱    二级制冷冰箱
 *
 *   产品族  功能相同 但是具体实现不相同
 */
interface IAbFactory {

    fun createOperatePlus() : IOperation

    fun createOperateSub() : IOperation
}