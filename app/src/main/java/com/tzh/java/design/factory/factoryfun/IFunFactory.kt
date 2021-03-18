package com.tzh.java.design.factory.factoryfun

import com.tzh.java.design.factory.IOperation

/**
 * 工厂方法优缺点:
 *  优点 :
 *    1.隐藏产品具体实现细节,用户只需要关注工厂,不需要关注细节
 *    2.新增加产品时不用修改现有代码,只需要新郑对应的工厂类就行,符合开闭原则
 *    3.创建产品对象的细节完全封装在工厂内部,而且有了抽象工厂类,定义了生成的规则,体现了多态
 *  缺点:
 *    1.新增产品的时候就要新增对应的工厂, 类爆炸问题
 *    2.抽象工厂层,抽象产品层 理解难度问题
 */

interface IFunFactory {

    fun createOperation(): IOperation
}