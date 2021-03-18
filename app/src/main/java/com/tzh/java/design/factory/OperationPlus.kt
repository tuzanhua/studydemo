package com.tzh.java.design.factory

class OperationPlus : IOperation {

    override fun operate(a: Float, b: Float): Float {
        return a + b
    }
}