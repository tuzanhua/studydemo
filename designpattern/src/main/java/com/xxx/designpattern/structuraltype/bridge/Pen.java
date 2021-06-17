package com.xxx.designpattern.structuraltype.bridge;

abstract class Pen {

   protected PenPointTypeImp penPointTypeImp;
   public void setPenPointTypeImp(PenPointTypeImp penPointTypeImp){
       this.penPointTypeImp = penPointTypeImp;
   }

   public abstract void paint(String content);
}
