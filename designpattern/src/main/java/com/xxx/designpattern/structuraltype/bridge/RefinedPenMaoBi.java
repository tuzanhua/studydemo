package com.xxx.designpattern.structuraltype.bridge;

public class RefinedPenMaoBi extends Pen {

    @Override
    public void paint(String content) {
        penPointTypeImp.getType();

        System.out.println(penPointTypeImp.getType() + "毛笔绘制的:" + content);
    }
}
