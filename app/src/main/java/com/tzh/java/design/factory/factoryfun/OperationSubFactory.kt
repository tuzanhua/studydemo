package com.tzh.java.design.factory.factoryfun

import com.tzh.java.design.factory.IOperation
import com.tzh.java.design.factory.OperationSub

class OperationSubFactory : IFunFactory{
    override fun createOperation(): IOperation {

        return OperationSub()
    }
}