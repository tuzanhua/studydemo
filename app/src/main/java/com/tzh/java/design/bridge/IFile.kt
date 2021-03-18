package com.tzh.java.design.bridge

abstract class IFile {

    var mdatabase: IDatabase? = null

    abstract fun setDataBase(database: IDatabase)

    abstract fun fileType(): String
}