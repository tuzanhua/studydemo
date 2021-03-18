package com.tzh.java.design.factory

class OperationSub : IOperation {
    override fun operate(a: Float, b: Float): Float {
        return a - b
    }
}