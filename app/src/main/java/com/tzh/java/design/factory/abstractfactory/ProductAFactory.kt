package com.tzh.java.design.factory.abstractfactory

import com.tzh.java.design.factory.IOperation
import com.tzh.java.design.factory.OperationPlus
import com.tzh.java.design.factory.OperationSub

class ProductAFactory : IAbFactory {
    override fun createOperatePlus(): IOperation {
        return OperationPlus()
    }

    override fun createOperateSub(): IOperation {
        return OperationSub()
    }
}