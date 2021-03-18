package com.tzh.java.design.factory

import com.tzh.java.design.factory.abstractfactory.ProductAFactory
import com.tzh.java.design.factory.factoryfun.OperationPlusFactory
import com.tzh.java.design.factory.simple.OperationFactory

class OperationTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var iOperation = OperationFactory.createOperate("plus")
            iOperation.operate(1f, 2f)

            var funa = OperationPlusFactory()
            var operationPlus = funa.createOperation()
            var result = operationPlus.operate(3f, 8f)
            println("result : $result")

            var iAbFactory = ProductAFactory()
            var result1 = iAbFactory.createOperatePlus().operate(11f, 1.5f)

            println("result1 : $result1")
        }
    }
}