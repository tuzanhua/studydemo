package com.tzh.java.design.bridge

class TxtFile : IFile() {

    override fun setDataBase(database: IDatabase) {
        mdatabase = database
    }

    override fun fileType(): String {
        return "txt".plus(mdatabase?.dataBaseType())
    }
}