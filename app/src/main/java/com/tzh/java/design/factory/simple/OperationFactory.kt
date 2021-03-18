package com.tzh.java.design.factory.simple

import com.tzh.java.design.factory.IOperation
import com.tzh.java.design.factory.OperationPlus
import com.tzh.java.design.factory.OperationSub
/**
 *  简单工厂 :
 *  优点:
 *     1. 简单工厂包含必要的判断逻辑,简单工厂实现了对象的创建和使用分离
 *     2. 客户端无需知道所创建的具体的产品的类名,只需要具体产品类对应的参数即可
 *     3. 在不修改任何客户端代码的情况下更换和增加新的具体产品类,在一定程度上提高了系统的灵活性
 *  缺点:
 *      1. 工厂类的职责过重,一旦这个类出现问题 整个系统都会出问题
 *      2. 在添加新的类的时候,就必须修改产品工厂类,违反了 设计原则的开闭原则,不利于系统的扩展维护
 *      3.简单工厂的静态方法,使得工厂角色无法形成继承的等级结构
 *
 */
object  OperationFactory {

    @JvmStatic
    fun createOperate(type: String): IOperation {
        var iOperation: IOperation = OperationSub()
        if ("plus" == type) {
            iOperation = OperationPlus()
        } else if ("sub" == type) {
            iOperation = OperationSub()
        }
        return iOperation
    }
}