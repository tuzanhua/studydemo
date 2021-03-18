package com.tzh.java.design.factory.factoryfun

import com.tzh.java.design.factory.IOperation
import com.tzh.java.design.factory.OperationPlus

class OperationPlusFactory : IFunFactory {
    override fun createOperation(): IOperation {
        return OperationPlus()
    }
}